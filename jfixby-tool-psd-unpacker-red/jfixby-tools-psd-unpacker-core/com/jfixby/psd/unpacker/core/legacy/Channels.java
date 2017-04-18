
package com.jfixby.psd.unpacker.core.legacy;

import java.util.ArrayList;

public class Channels {

	@Override
	public String toString () {
		return "Channels" + this.list + "";
	}

	final ArrayList<ChannelInfo> list = new ArrayList<ChannelInfo>();

	public void add (final ChannelInfo channelInfo) {
		this.list.add(channelInfo);
	}

	public int size () {
		return this.list.size();
	}

	public ChannelInfo get (final int j) {
		return this.list.get(j);
	}

}
