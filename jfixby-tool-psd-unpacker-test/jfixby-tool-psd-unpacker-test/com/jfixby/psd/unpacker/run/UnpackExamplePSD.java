package com.jfixby.psd.unpacker.run;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import com.jfixby.cmns.api.filesystem.File;
import com.jfixby.cmns.api.filesystem.FileOutputStream;
import com.jfixby.cmns.api.filesystem.LocalFileSystem;
import com.jfixby.cmns.api.log.L;
import com.jfixby.psd.unpacker.api.PSDFileContent;
import com.jfixby.psd.unpacker.api.PSDLayer;
import com.jfixby.psd.unpacker.api.PSDRaster;
import com.jfixby.psd.unpacker.api.PSDRootLayer;
import com.jfixby.psd.unpacker.api.PSDUnpacker;
import com.jfixby.psd.unpacker.api.PSDUnpackingParameters;

public class UnpackExamplePSD {

	public static void main(String[] args) throws IOException {

		Setup.setup();
		File home = LocalFileSystem.ApplicationHome();

		File examples_folder = home.child("unpacker-input");

		File example_psd_file = examples_folder.child("example1.psd");

		PSDUnpackingParameters specs = PSDUnpacker.newUnpackingSpecs();
		specs.setPSDFile(example_psd_file);

		File output_folder = home.child("unpacker-output");
		// specs.setOutputFolderPath(output_path);

		output_folder.makeFolder();
		// output_folder.clearFolder();

		PSDFileContent result = PSDUnpacker.unpack(specs);

		result.print();

		PSDRootLayer root = result.getRootlayer();

		for (int i = 0; i < root.numberOfChildren(); i++) {
			PSDLayer child = root.getChild(i);
			process_child(child, output_folder);
		}

	}

	static int k = 0;

	private static void process_folder(PSDLayer root, File output_path)
			throws IOException {
		for (int i = 0; i < root.numberOfChildren(); i++) {
			PSDLayer child = root.getChild(i);
			process_child(child, output_path);
		}
	}

	private static void process_child(PSDLayer child, File output_path)
			throws IOException {
		if (child.isVisible()) {
			if (child.isFolder()) {
				process_folder(child, output_path);
			} else {
				PSDRaster raster = child.getRaster();
				BufferedImage java_image = raster.getBufferedImage();
				String raster_name = child.getName();
				File output_file = output_path.child(raster_name + ".png");

				k++;
				L.d("writing", output_file);
				FileOutputStream os = output_file.newOutputStream();
				OutputStream java_stream = os.toJavaOutputStream();
				ImageIO.write(java_image, "png", java_stream);
				java_stream.close();
			}
		}
	}
}
