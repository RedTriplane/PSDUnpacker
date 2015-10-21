package com.jfixby.psd.unpacker.core.legacy;


public class Header {
	private int numberOfChannels;

	private int width;

	private int height;

	@Override
	public String toString() {
		return "Header [ver=" + ver + ", width=" + width + ", height=" + height
				+ ", fileSignature=" + fileSignature + ", numberOfChannels="
				+ numberOfChannels + ", numberOfBitsPerChannel="
				+ numberOfBitsPerChannel + ", colorMode=" + colorMode + "]";
	}

	private String fileSignature;

	private Depth numberOfBitsPerChannel;

	private ColorMode colorMode;

	private int ver;

	public int getNumberOfChannels() {
		return numberOfChannels;
	}

	public void setNumberOfChannels(int numberOfChannels) {
		this.numberOfChannels = numberOfChannels;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getFileSignature() {
		return fileSignature;
	}

	public void setFileSignature(String fileSignature) {
		this.fileSignature = fileSignature;
	}

	public Depth getNumberOfBitsPerChannel() {
		return numberOfBitsPerChannel;
	}

	public void setNumberOfBitsPerChannel(Depth numberOfBitsPerChannel) {
		this.numberOfBitsPerChannel = numberOfBitsPerChannel;
	}

	public ColorMode getColorMode() {
		return colorMode;
	}

	public void setColorMode(ColorMode colorMode) {
		this.colorMode = colorMode;
	}

	public void setVersion(int ver) {
		this.ver = ver;
	}

	public String getVersion() {
		return "ver." + ver;
	}

}
