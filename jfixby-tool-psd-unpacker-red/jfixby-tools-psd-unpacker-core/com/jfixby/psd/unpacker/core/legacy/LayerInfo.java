package com.jfixby.psd.unpacker.core.legacy;


public class LayerInfo {
	int x, y, w, h;
	boolean visible;

	@Override
	public String toString() {
		return "LayerInfo [name=" + name + ", w=" + w + ", h=" + h
				+ ", visible=" + visible + ", x=" + x + ", y=" + y
				+ ", channels=" + channels + ", layerTransparency="
				+ layerTransparency + "]";
	}

	final Channels channels = new Channels();

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public int getLayerTransparency() {
		return layerTransparency;
	}

	public void setLayerTransparency(int layerTransparency) {
		this.layerTransparency = layerTransparency;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Channels getChannels() {
		return channels;
	}

	int layerTransparency;

	private String name;
	private MaskData mask_data;
	private BlendingRanges blending_ranges_data;

	public void setMaskData(MaskData mask_data) {
		this.mask_data = mask_data;
	}

	public void setBlendingRanges(BlendingRanges blending_ranges_data) {
		this.blending_ranges_data = blending_ranges_data;
	}

	public MaskData getMaskData() {
		return mask_data;
	}
	
	public BlendingRanges getBlendingRanges() {
		return blending_ranges_data;
	}
}