package com.jfixby.psd.unpacker.core.legacy;

public enum ChannelID {
	RED, GREEN, BLUE, ALPHA, ERR, USER_MASK, USER_LAYER_MASK;
	;

	public static ChannelID valueOfInt(int id) {
		if (id == 0) {
			return RED;
		}
		if (id == 1) {
			return GREEN;
		}
		if (id == 2) {
			return BLUE;
		}
		if (id == -1) {
			return ALPHA;
		}
		if (id == -2) {
			return USER_MASK;
		}
		if (id == -3) {
			return USER_LAYER_MASK;
		}
		if (id == 3) {
			return ALPHA;
		}
		throw new Error("ChannelID:" + id);

//		return ERR;
	}

	public boolean isOK() {
		if (this == RED) {
			return true;
		}
		if (this == BLUE) {
			return true;
		}
		if (this == GREEN) {
			return true;
		}
		if (this == ALPHA) {
			return true;
		}

		return false;
	}

}
