package com.jfixby.psd.unpacker.core.legacy;

public enum ImageResourceID {
	IPTC_NAA, Unsupported;

	public static ImageResourceID valueOf(int depth) {
		if (depth == 1028) {
			return IPTC_NAA;
		}

		return Unsupported;
	}

}
