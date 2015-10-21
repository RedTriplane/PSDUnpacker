package com.jfixby.psd.unpacker.core.legacy;

import java.util.Vector;

public class LayerGroup extends Layer {

	final Vector<Layer> sublayers = new Vector<Layer>();

	public Vector<Layer> getSublayers() {
		return sublayers;
	}

	@Override
	public boolean isLayerGroup() {
		return true;
	}

}
