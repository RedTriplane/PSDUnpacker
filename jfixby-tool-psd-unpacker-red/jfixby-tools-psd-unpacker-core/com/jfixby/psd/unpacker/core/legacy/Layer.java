package com.jfixby.psd.unpacker.core.legacy;

public abstract class Layer {
	String name;
	boolean visible = true;
	private int blend_mode;

	public String getName() {
		return name;
	}

	public void setMode(int blendMode) {
		this.blend_mode = blendMode;
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

	public int getBlendMode() {
		return blend_mode;
	}
}
