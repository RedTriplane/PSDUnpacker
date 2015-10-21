package com.jfixby.psd.unpacker.core.legacy;

import java.util.Vector;

public class Channels {

	@Override
	public String toString() {
		return "Channels" + list + "";
	}

	final Vector<ChannelInfo> list = new Vector<ChannelInfo>();

	public void add(ChannelInfo channelInfo) {
		list.add(channelInfo);
	}

	public int size() {
		return list.size();
	}

	public ChannelInfo get(int j) {
		return list.get(j);
	}

}
