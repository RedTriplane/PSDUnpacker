
package com.jfixby.psd.unpacker.core.legacy;

import java.util.ArrayList;

public class FileContent {

	FileContent () {
		super();
		// TODO Auto-generated constructor stub
	}

	final LayersStructure layers_structure = new LayersStructure();
	final ArrayList<RasterLayer> raster_layers_list = new ArrayList<RasterLayer>();
	final ArrayList<Layer> all_layers_list = new ArrayList<Layer>();

	private String filename;

	public int getRasterLayersListSize () {
		return this.raster_layers_list.size();
	}

	public RasterLayer getRasterLayer (final int i) {
		return this.raster_layers_list.get(i);
	}

	public LayerGroup getRootLayer () {
		return this.layers_structure.getRoot();
	}

	public String getFileName () {
		return this.filename;
	}

	public void setFileName (final String filename) {
		this.filename = filename;
	}

	public int getLayersListSize () {
		return this.all_layers_list.size();
	}

	public Layer getLayer (final int i) {
		return this.all_layers_list.get(i);
	}
}
