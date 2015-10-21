package com.jfixby.psd.unpacker.api;

import java.awt.image.BufferedImage;

public interface PSDRaster {

	PSDRasterPosition getPosition();

	PSDRasterDimentions getDimentions();

	BufferedImage getBufferedImage();

	void drop();

}
