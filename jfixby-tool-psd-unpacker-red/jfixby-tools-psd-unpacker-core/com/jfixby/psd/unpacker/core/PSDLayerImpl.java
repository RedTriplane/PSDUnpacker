package com.jfixby.psd.unpacker.core;

import java.awt.image.BufferedImage;

import com.jfixby.cmns.api.collections.JUtils;
import com.jfixby.cmns.api.collections.List;
import com.jfixby.cmns.api.collections.Map;
import com.jfixby.cmns.api.log.L;
import com.jfixby.cmns.api.path.AbsolutePath;
import com.jfixby.psd.unpacker.api.PSDFileContent;
import com.jfixby.psd.unpacker.api.PSDLayer;
import com.jfixby.psd.unpacker.api.PSDRaster;
import com.jfixby.psd.unpacker.api.PSDRootLayer;
import com.jfixby.psd.unpacker.core.legacy.Layer;
import com.jfixby.psd.unpacker.core.legacy.LayerGroup;
import com.jfixby.psd.unpacker.core.legacy.RasterLayer;

public class PSDLayerImpl implements PSDLayer, PSDRootLayer {

	final private List<PSDLayer> children_list;
	final private Map<String, PSDLayer> children_map;
	private boolean visible = false;
	private final String name;
	private final AbsolutePath<PSDFileContent> my_path;

	private final PSDRaster raster;
	private PSDFileContentImpl master;

	public PSDLayerImpl(PSDFileContentImpl master, Layer element,
			AbsolutePath<PSDFileContent> root_path) {
		this.master = master;
		visible = element.isVisible();
		name = element.getName();

		my_path = root_path;
		if (element.isLayerGroup()) {
			master.reportGroup(this);
			children_list = JUtils.newList();
			children_map = JUtils.newMap();
			LayerGroup group = (LayerGroup) element;
			for (int i = 0; i < group.getSublayers().size(); i++) {
				Layer child = group.getSublayers().get(i);

				PSDLayerImpl layer = new PSDLayerImpl(master, child,
						my_path.child(child.getName()));

				// path_string
				// + PSDPathImpl.SEPARATOR + child.getName());
				children_list.add(layer);
				children_map.put(layer.getName(), layer);
			}

			raster = null;
		} else {
			master.reportRaster(this);
			RasterLayer raster = (RasterLayer) element;

			BufferedImage buffered_image = raster.getRaster();

			this.raster = new PSDRasterImpl(buffered_image, raster.getOffset()
					.getX(), raster.getOffset().getY());

			children_list = null;
			children_map = null;
		}

	}

	@Override
	public boolean isVisible() {
		return visible;
	}

	@Override
	public boolean isFolder() {
		return children_list != null;
	}

	@Override
	public boolean isRaster() {
		return !isFolder();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public PSDLayer findChildByNamePrefix(String child_name) {
		if (this.isFolder()) {
			PSDLayer value = this.children_map.get(child_name);
			if (value != null) {
				return value;
			} else {
				for (int i = 0; i < this.children_list.size(); i++) {
					PSDLayer child = children_list.getElementAt(i);
					if (child.getName().startsWith(child_name)) {
						return child;
					}
				}
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public PSDLayer findChildByName(String child_name) {
		if (this.isFolder()) {
			PSDLayer value = this.children_map.get(child_name);
			if (value != null) {
				return value;
			} else {
				for (int i = 0; i < this.children_list.size(); i++) {
					PSDLayer child = children_list.getElementAt(i);
					if (child.getName().equals(child_name)) {
						return child;
					}
				}
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public int numberOfChildren() {
		return this.children_list.size();
	}

	@Override
	public PSDLayer getChild(int i) {
		return this.children_list.getElementAt(i);
	}

	@Override
	public AbsolutePath<PSDFileContent> getPath() {
		return my_path;
	}

	@Override
	public void printChildren() {
		L.d(this.getPath().toString(), this.children_map);
	}

	@Override
	public String toString() {
		return "PSDLayer[visible=" + visible + ", name=" + name + ", my_path="
				+ my_path + "]";
	}

	@Override
	public PSDRaster getRaster() {
		return raster;
	}

	@Override
	public void dropRaster() {
		this.raster.drop();
	}

}
