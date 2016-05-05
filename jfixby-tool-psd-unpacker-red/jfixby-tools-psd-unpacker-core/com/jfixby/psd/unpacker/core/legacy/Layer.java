
package com.jfixby.psd.unpacker.core.legacy;

public abstract class Layer {
	String name;
	boolean visible = true;
	private int blend_mode;
	double opacity = 1d;

	public String getName () {
		return this.name;
	}

	public void setOpacity (final float opacity) {
		this.opacity = opacity;
	}

	public void setMode (final int blendMode) {
		this.blend_mode = blendMode;
	}

	public void setName (final String name) {
		this.name = name;
	}

	public boolean isVisible () {
		return this.visible;
	}

	public void setVisible (final boolean visible) {
		this.visible = visible;
	}

	public abstract boolean isLayerGroup ();

	public int getBlendMode () {
		return this.blend_mode;
	}

	public double getOpacity () {
		return this.opacity;
	}
}
