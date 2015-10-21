package com.jfixby.psd.unpacker.run;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import com.jfixby.cmns.api.filesystem.File;
import com.jfixby.cmns.api.filesystem.FileOutputStream;
import com.jfixby.cmns.api.filesystem.LocalFileSystem;
import com.jfixby.cmns.api.log.L;
import com.jfixby.cmns.api.path.ChildrenList;
import com.jfixby.cmns.api.path.FileFilter;
import com.jfixby.cmns.api.sys.Sys;
import com.jfixby.psd.unpacker.api.PSDFileContent;
import com.jfixby.psd.unpacker.api.PSDLayer;
import com.jfixby.psd.unpacker.api.PSDRaster;
import com.jfixby.psd.unpacker.api.PSDRootLayer;
import com.jfixby.psd.unpacker.api.PSDUnpacker;
import com.jfixby.psd.unpacker.api.PSDUnpackingParameters;

public class UnpackAll {

	private static final FileFilter filter = new FileFilter() {

		@Override
		public boolean fits(File child) {
			return child.getName().toLowerCase().endsWith(".psd");
		}
	};

	public static void main(String[] args) throws IOException {

		Setup.setup();
		File home = LocalFileSystem.ApplicationHome();

		File input_folder = home.child("unpacker-input");
		if (!input_folder.exists()) {
			L.d("Folder not found", input_folder);
			Sys.exit();
		}
		if (!input_folder.isFolder()) {
			L.d("Folder not found", input_folder);
			Sys.exit();
		}

		ChildrenList input_files = input_folder.listChildren();
		input_files = input_files.filter(filter);

		File output_folder = home.child("unpacker-output");
		output_folder.makeFolder();

		for (int i = 0; i < input_files.size(); i++) {
			File psd_file_i = input_files.getElementAt(i);
			unpack(psd_file_i, output_folder);
		}

	}

	private static void unpack(File psd_file_i, File output_folder)
			throws IOException {

		PSDUnpackingParameters specs = PSDUnpacker.newUnpackingSpecs();
		specs.setPSDFile(psd_file_i);

		String psd_name = psd_file_i.nameWithoutExtension();

		PSDFileContent result = PSDUnpacker.unpack(specs);

		result.print();

		PSDRootLayer root = result.getRootlayer();

		for (int i = 0; i < root.numberOfChildren(); i++) {
			PSDLayer child = root.getChild(i);
			process_child(psd_name, child, output_folder);
		}
	}

	private static void process_folder(String psd_name, PSDLayer root,
			File output_path) throws IOException {
		for (int i = 0; i < root.numberOfChildren(); i++) {
			PSDLayer child = root.getChild(i);
			process_child(psd_name, child, output_path);
		}
	}

	private static void process_child(String psd_name, PSDLayer child,
			File output_path) throws IOException {
		if (child.isVisible()) {
			if (child.isFolder()) {
				process_folder(psd_name, child, output_path);
			} else {
				PSDRaster raster = child.getRaster();
				BufferedImage java_image = raster.getBufferedImage();
				String raster_name = child.getName();
				File output_file = output_path.child(psd_name + "."
						+ raster_name + ".png");

				L.d("writing", output_file);
				FileOutputStream os = output_file.newOutputStream();
				OutputStream java_stream = os.toJavaOutputStream();
				ImageIO.write(java_image, "png", java_stream);
				java_stream.close();
			}
		}
	}
}
