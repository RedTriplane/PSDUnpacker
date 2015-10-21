package com.jfixby.psd.unpacker.core.legacy;

import java.util.Vector;

public class FileContent {

	FileContent() {
		super();
		// TODO Auto-generated constructor stub
	}

	final LayersStructure layers_structure = new LayersStructure();
	final Vector<RasterLayer> raster_layers_list = new Vector<RasterLayer>();
	final Vector<Layer> all_layers_list = new Vector<Layer>();

	private String filename;

	public int getRasterLayersListSize() {
		return this.raster_layers_list.size();
	}

	public RasterLayer getRasterLayer(int i) {
		return this.raster_layers_list.get(i);
	}

	public LayerGroup getRootLayer() {
		return layers_structure.getRoot();
	}

	public String getFileName() {
		return this.filename;
	}

	public void setFileName(String filename) {
		this.filename = filename;
	}

	public int getLayersListSize() {
		return this.all_layers_list.size();
	}

	public Layer getLayer(int i) {
		return this.all_layers_list.get(i);
	}
}
