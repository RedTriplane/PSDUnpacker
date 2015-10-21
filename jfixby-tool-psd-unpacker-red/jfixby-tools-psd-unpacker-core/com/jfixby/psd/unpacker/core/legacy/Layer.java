package com.jfixby.psd.unpacker.core.legacy;


public
abstract class Layer {
	String name;
	boolean visible = true;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public abstract boolean isLayerGroup();
}
