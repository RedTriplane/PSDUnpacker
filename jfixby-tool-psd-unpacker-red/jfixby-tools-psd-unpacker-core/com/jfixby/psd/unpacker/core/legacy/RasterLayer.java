
package com.jfixby.psd.unpacker.core.legacy;

import java.awt.image.BufferedImage;

import com.jfixby.cmns.api.floatn.Float2;
import com.jfixby.cmns.api.geometry.Geometry;

public class RasterLayer extends Layer {
	final Float2 offset = Geometry.newFloat2();
	BufferedImage raster;

	public BufferedImage getRaster () {
		return this.raster;
	}

	public void setRaster (final BufferedImage raster) {
		this.raster = raster;
	}

	public Float2 getOffset () {
		return this.offset;
	}

	@Override
	public boolean isLayerGroup () {
		// TODO Auto-generated method stub
		return false;
	}

}
