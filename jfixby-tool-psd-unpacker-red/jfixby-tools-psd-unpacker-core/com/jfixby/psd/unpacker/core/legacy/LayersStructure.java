package com.jfixby.psd.unpacker.core.legacy;

public class LayersStructure {

	public LayersStructure() {
		super();
		layers.setName("root");
	}

	public LayerGroup getRoot() {
		return layers;
	}

	private final LayerGroup layers = new LayerGroup();

	public void clear() {
		layers.sublayers.clear();

	}
}
