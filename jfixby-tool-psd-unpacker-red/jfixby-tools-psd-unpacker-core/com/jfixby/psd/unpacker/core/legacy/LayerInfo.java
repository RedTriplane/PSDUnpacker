
package com.jfixby.psd.unpacker.core.legacy;

public class LayerInfo {
	int x, y, w, h;
	boolean visible;
	private final int index;

	public LayerInfo (final int i) {
		this.index = i;
	}

	@Override
	public String toString () {
		return "LayerInfo [name=" + this.name + ", x=" + this.x + ", y=" + this.y + ", w=" + this.w + ", h=" + this.h + ", visible="
			+ this.visible + ", index=" + this.index + ", channels=" + this.channels + ", layerTransparency="
			+ this.layerTransparency + ", mask_data=" + this.mask_data + ", blending_ranges_data=" + this.blending_ranges_data + "]";
	}

	final Channels channels = new Channels();

	public int getX () {
		return this.x;
	}

	public void setX (final int x) {
		this.x = x;
	}

	public int getY () {
		return this.y;
	}

	public void setY (final int y) {
		this.y = y;
	}

	public int getW () {
		return this.w;
	}

	public void setW (final int w) {
		this.w = w;
	}

	public int getH () {
		return this.h;
	}

	public void setH (final int h) {
		this.h = h;
	}

	public boolean isVisible () {
		return this.visible;
	}

	public void setVisible (final boolean visible) {
		this.visible = visible;
	}

	public int getLayerTransparency () {
		return this.layerTransparency;
	}

	public void setLayerTransparency (final int layerTransparency) {
		this.layerTransparency = layerTransparency;
	}

	public String getName () {
		return this.name;
	}

	public void setName (final String name) {
		this.name = name;
	}

	public Channels getChannels () {
		return this.channels;
	}

	private int layerTransparency;

	private String name;
	private MaskData mask_data;
	private BlendingRanges blending_ranges_data;
	private int blend_mode;

	public void setMaskData (final MaskData mask_data) {
		this.mask_data = mask_data;
	}

	public void setBlendingRanges (final BlendingRanges blending_ranges_data) {
		this.blending_ranges_data = blending_ranges_data;
	}

	public MaskData getMaskData () {
		return this.mask_data;
	}

	public BlendingRanges getBlendingRanges () {
		return this.blending_ranges_data;
	}

	public static final long BLEND_NORMAL = 1852797549;
	public static final long BLEND_MULTIPLY = 1836411936;
	public static final long BLEND_HUE = 1752524064;

	public int getBlendMode () {
		return this.blend_mode;
	}

	public void setBlendMode (final int blend_mode) {
		this.blend_mode = blend_mode;
	}
}
