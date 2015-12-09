package com.jfixby.psd.unpacker.core;

import java.awt.image.BufferedImage;

import com.jfixby.cmns.api.collections.Collection;
import com.jfixby.cmns.api.collections.JUtils;
import com.jfixby.cmns.api.collections.List;
import com.jfixby.cmns.api.log.L;
import com.jfixby.cmns.api.path.AbsolutePath;
import com.jfixby.psd.unpacker.api.PSDFileContent;
import com.jfixby.psd.unpacker.api.PSDLayer;
import com.jfixby.psd.unpacker.api.PSDRootLayer;
import com.jfixby.psd.unpacker.core.legacy.Layer;
import com.jfixby.psd.unpacker.core.legacy.LayerGroup;
import com.jfixby.psd.unpacker.core.legacy.RasterLayer;

public class PSDFileContentImpl implements PSDFileContent {

	private com.jfixby.psd.unpacker.core.legacy.FileContent result;
	private PSDRootLayer root;
	final List<PSDLayer> rasters = JUtils.newList();
	final List<PSDLayer> groups = JUtils.newList();
	private AbsolutePath<PSDFileContent> root_path;

	@Override
	public String toString() {
		return result.getFileName();
	}

	public PSDFileContentImpl(
			com.jfixby.psd.unpacker.core.legacy.FileContent result) {
		this.result = result;
		root_path = JUtils.newAbsolutePath(this);
		root = new PSDLayerImpl(this, this.result.getRootLayer(), root_path);

	}

	@Override
	public void print() {

		LayerGroup root = result.getRootLayer();

		L.d("---PSDFileContent[" + result.getFileName() + "]------------");

		for (int i = 0; i < root.getSublayers().size(); i++) {
			Layer layer = root.getSublayers().get(i);
			print(3, layer);

		}

		L.d("---PSDFileContent", "END------------");

	}

	private static void print(int indent, Layer layer) {
		if (layer.isLayerGroup()) {
			LayerGroup group = (LayerGroup) layer;
			boolean is_visible = group.isVisible();

			L.d(prefix(indent) + "group",
					isHidden(is_visible) + group.getName());
			for (int i = 0; i < group.getSublayers().size(); i++) {
				Layer sub_layer = group.getSublayers().get(i);
				print(indent + 1, sub_layer);
			}
		} else {
			RasterLayer raster = (RasterLayer) layer;
			boolean is_visible = raster.isVisible();
			L.d(prefix(indent) + "raster",
					isHidden(is_visible) + "[" + raster.getName() + "]" + " "
							+ raster.getOffset() + " "
							+ print(raster.getRaster()));
		}

	}

	private static String isHidden(boolean is_visible) {
		if (is_visible) {
			return "( )";
		} else {
			return "(X)";
		}

	}

	private static String print(BufferedImage raster) {
		int w = raster.getWidth();
		int h = raster.getHeight();
		return "[" + w + "x" + h + "]";
	}

	private static String prefix(int prefix) {
		String result = "";
		for (int i = 0; i < prefix; i++) {
			result = result + "   ";
		}

		return result;
	}

	@Override
	public PSDRootLayer getRootlayer() {
		return root;
	}

	@Override
	public Collection<PSDLayer> getRasterLayers() {
		return rasters;
	}

	@Override
	public Collection<PSDLayer> getRasterLayerGroups() {
		return groups;
	}

	public void reportGroup(PSDLayerImpl psdLayerImpl) {
		this.groups.add(psdLayerImpl);
	}

	public void reportRaster(PSDLayerImpl psdLayerImpl) {
		rasters.add(psdLayerImpl);
	}

	@Override
	public void dropRaster() {
		for (int i = 0; i < rasters.size(); i++) {
			rasters.getElementAt(i).dropRaster();
		}
		System.gc();
	}

}
