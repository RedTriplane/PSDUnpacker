package com.jfixby.psd.unpacker.core.legacy;

public enum Depth {
	Depth1, Depth8, Depth16, Depth32, Unsupported;

	public static Depth valueOf(int depth) {
		if (depth == 1) {
			return Depth1;
		}
		if (depth == 8) {
			return Depth8;
		}
		if (depth == 16) {
			return Depth16;
		}
		if (depth == 32) {
			return Depth32;
		}
		

		return Unsupported;
	}

}
