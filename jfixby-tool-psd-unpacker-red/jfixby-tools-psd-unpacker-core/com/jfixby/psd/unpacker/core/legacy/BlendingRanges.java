package com.jfixby.psd.unpacker.core.legacy;

public class BlendingRanges {


	int bytes = 0;

	public void addByte(int b) {
		bytes++;
	}

	@Override
	public String toString() {
		return "BlendingRanges [bytes=" + bytes + "]";
	}
}
