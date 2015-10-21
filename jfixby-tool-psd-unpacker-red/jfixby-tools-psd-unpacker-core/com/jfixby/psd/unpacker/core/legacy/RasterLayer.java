package com.jfixby.psd.unpacker.core.legacy;

import java.awt.image.BufferedImage;

public class RasterLayer extends Layer {
	final Offset offset = new Offset();
	BufferedImage raster;

	public BufferedImage getRaster() {
		return raster;
	}

	public void setRaster(BufferedImage raster) {
		this.raster = raster;
	}

	public Offset getOffset() {
		return offset;
	}

	@Override
	public boolean isLayerGroup() {
		// TODO Auto-generated method stub
		return false;
	}

}
