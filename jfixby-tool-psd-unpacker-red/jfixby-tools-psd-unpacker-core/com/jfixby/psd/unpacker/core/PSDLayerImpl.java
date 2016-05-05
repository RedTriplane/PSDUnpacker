
package com.jfixby.psd.unpacker.core;

import java.awt.image.BufferedImage;

import com.jfixby.cmns.api.collections.Collections;
import com.jfixby.cmns.api.collections.List;
import com.jfixby.cmns.api.collections.Map;
import com.jfixby.cmns.api.log.L;
import com.jfixby.cmns.api.util.path.AbsolutePath;
import com.jfixby.psd.unpacker.api.PSDFileContent;
import com.jfixby.psd.unpacker.api.PSDLayer;
import com.jfixby.psd.unpacker.api.PSDRaster;
import com.jfixby.psd.unpacker.api.PSDRootLayer;
import com.jfixby.psd.unpacker.api.PSD_BLEND_MODE;
import com.jfixby.psd.unpacker.core.legacy.Layer;
import com.jfixby.psd.unpacker.core.legacy.LayerGroup;
import com.jfixby.psd.unpacker.core.legacy.LayerInfo;
import com.jfixby.psd.unpacker.core.legacy.RasterLayer;

public class PSDLayerImpl implements PSDLayer, PSDRootLayer {

	final private List<PSDLayer> children_list;
	final private Map<String, PSDLayer> children_map;
	private boolean visible = false;
	private final String name;
	private final AbsolutePath<PSDFileContent> my_path;

	private final PSDRaster raster;
	private final PSDFileContentImpl master;
	private PSD_BLEND_MODE blend_mode = PSD_BLEND_MODE.UNKNOWN;
	private final double opacity;

	@Override
	public double getOpacity () {
		return this.opacity;
	}

	public PSDLayerImpl (final PSDFileContentImpl master, final Layer element, final AbsolutePath<PSDFileContent> root_path) {
		this.master = master;
		this.visible = element.isVisible();
		this.name = element.getName();
		this.opacity = element.getOpacity();
		this.blend_mode = modeOf(element.getBlendMode());

		this.my_path = root_path;
		if (element.isLayerGroup()) {
			master.reportGroup(this);
			this.children_list = Collections.newList();
			this.children_map = Collections.newMap();
			final LayerGroup group = (LayerGroup)element;
			for (int i = 0; i < group.getSublayers().size(); i++) {
				final Layer child = group.getSublayers().get(i);

				final PSDLayerImpl layer = new PSDLayerImpl(master, child, this.my_path.child(child.getName()));

				// path_string
				// + PSDPathImpl.SEPARATOR + child.getName());
				this.children_list.add(layer);
				this.children_map.put(layer.getName(), layer);
			}

			this.raster = null;
		} else {
			master.reportRaster(this);
			final RasterLayer raster = (RasterLayer)element;

			final BufferedImage buffered_image = raster.getRaster();

			this.raster = new PSDRasterImpl(buffered_image, raster.getOffset().getX(), raster.getOffset().getY());

			this.children_list = null;
			this.children_map = null;
		}

	}

	public static final PSD_BLEND_MODE modeOf (final int blend) {

		if (blend == LayerInfo.BLEND_NORMAL) {
			return PSD_BLEND_MODE.NORMAL;
		}
		if (blend == LayerInfo.BLEND_MULTIPLY) {
			return PSD_BLEND_MODE.MULTIPLY;
		}
		if (blend == LayerInfo.BLEND_HUE) {
			return PSD_BLEND_MODE.HUE;
		}
		return PSD_BLEND_MODE.UNKNOWN;
	}

	@Override
	public boolean isVisible () {
		return this.visible;
	}

	@Override
	public boolean isFolder () {
		return this.children_list != null;
	}

	@Override
	public boolean isRaster () {
		return !this.isFolder();
	}

	@Override
	public String getName () {
		return this.name;
	}

	@Override
	public PSDLayer findChildByNamePrefix (final String child_name) {
		if (this.isFolder()) {
			final PSDLayer value = this.children_map.get(child_name);
			if (value != null) {
				return value;
			} else {
				for (int i = 0; i < this.children_list.size(); i++) {
					final PSDLayer child = this.children_list.getElementAt(i);
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
	public PSDLayer findChildByName (final String child_name) {
		if (this.isFolder()) {
			final PSDLayer value = this.children_map.get(child_name);
			if (value != null) {
				return value;
			} else {
				for (int i = 0; i < this.children_list.size(); i++) {
					final PSDLayer child = this.children_list.getElementAt(i);
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
	public int numberOfChildren () {
		return this.children_list.size();
	}

	@Override
	public PSDLayer getChild (final int i) {
		return this.children_list.getElementAt(i);
	}

	@Override
	public AbsolutePath<PSDFileContent> getPath () {
		return this.my_path;
	}

	@Override
	public void printChildren () {
		L.d(this.getPath().toString(), this.children_map);
	}

// @Override
// public String toString() {
// return "PSDLayer[visible=" + visible + ", name=" + name + ", my_path=" + my_path + "]";
// }

	@Override
	public PSDRaster getRaster () {
		return this.raster;
	}

	@Override
	public String toString () {
		return "PSDLayer(" + this.name + ") @=" + this.my_path + " visible=" + this.visible + "";
	}

	@Override
	public void dropRaster () {
		this.raster.drop();
	}

	@Override
	public PSD_BLEND_MODE getMode () {
		return this.blend_mode;
	}

}
