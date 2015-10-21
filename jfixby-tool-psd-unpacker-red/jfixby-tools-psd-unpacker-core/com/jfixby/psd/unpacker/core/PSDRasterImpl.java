package com.jfixby.psd.unpacker.core;

import java.awt.image.BufferedImage;

import com.jfixby.psd.unpacker.api.PSDRaster;
import com.jfixby.psd.unpacker.api.PSDRasterDimentions;
import com.jfixby.psd.unpacker.api.PSDRasterPosition;

public class PSDRasterImpl implements PSDRaster, PSDRasterPosition,
		PSDRasterDimentions {

	@Override
	public String toString() {
		return "PSDRaster [" + raster_width + "x" + raster_height + "] at ("
				+ raster_position_x + "," + raster_position_y + ")";
	}

	private BufferedImage buffered_image;
	private final double raster_position_x;
	private final double raster_position_y;
	private final double raster_width;
	private final double raster_height;

	public PSDRasterImpl(BufferedImage buffered_image,
			double raster_position_x, double raster_position_y) {
		this.buffered_image = buffered_image;
		this.raster_width = this.buffered_image.getWidth();
		this.raster_height = this.buffered_image.getHeight();
		this.raster_position_x = raster_position_x;
		this.raster_position_y = raster_position_y;

	}

	@Override
	public double getX() {
		return raster_position_x;
	}

	@Override
	public double getY() {
		return raster_position_y;
	}

	@Override
	public PSDRasterPosition getPosition() {

		return this;
	}

	@Override
	public BufferedImage getBufferedImage() {

		return this.buffered_image;
	}

	@Override
	public void drop() {
		buffered_image = null;
	}

	@Override
	public PSDRasterDimentions getDimentions() {
		return this;
	}

	@Override
	public double getWidth() {
		return this.raster_width;
	}

	@Override
	public double getHeight() {
		return this.raster_height;
	}

}
