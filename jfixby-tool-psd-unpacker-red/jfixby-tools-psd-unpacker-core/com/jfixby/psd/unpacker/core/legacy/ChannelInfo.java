package com.jfixby.psd.unpacker.core.legacy;


public
class ChannelInfo {

	public ChannelID getChannelID() {
		return channelID;
	}

	public void setChannelID(ChannelID channelID) {
		this.channelID = channelID;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	private ChannelID channelID;
	private  int size;

	@Override
	public String toString() {
		return channelID + "(" + size + ")";
	}

}
