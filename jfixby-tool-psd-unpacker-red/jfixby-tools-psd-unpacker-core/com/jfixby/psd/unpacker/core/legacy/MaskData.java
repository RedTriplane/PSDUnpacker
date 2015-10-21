package com.jfixby.psd.unpacker.core.legacy;

public class MaskData {

	int bytes = 0;
	public int y;
	public int x;
	public int w;
	public int h;

	public MaskData(int len) {
		bytes = len;
	}

	public void addByte(int b) {
		bytes++;
	}

	@Override
	public String toString() {
		if (bytes > 0)
			return "MaskData [x=" + x + ", y=" + y + ", w=" + w + ", h=" + h
					+ ", bytes=" + bytes + "]";

		return "";
	}

}
