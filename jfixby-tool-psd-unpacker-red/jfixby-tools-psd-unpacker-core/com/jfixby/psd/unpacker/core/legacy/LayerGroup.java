
package com.jfixby.psd.unpacker.core.legacy;

import java.util.ArrayList;

public class LayerGroup extends Layer {

	final ArrayList<Layer> sublayers = new ArrayList<Layer>();

	public ArrayList<Layer> getSublayers () {
		return this.sublayers;
	}

	@Override
	public boolean isLayerGroup () {
		return true;
	}

}
