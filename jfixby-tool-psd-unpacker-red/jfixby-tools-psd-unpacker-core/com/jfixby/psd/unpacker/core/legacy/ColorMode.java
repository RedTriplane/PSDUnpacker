package com.jfixby.psd.unpacker.core.legacy;

public enum ColorMode {
	Bitmap, Grayscale, Indexed, RGB, CMYK, Multichannel, Duotone, Lab, Unsupported;

	public static ColorMode valueOf(int depth) {
		if (depth < ColorMode.values().length) {
			return ColorMode.values()[depth];
		}

		return Unsupported;
	}

}
