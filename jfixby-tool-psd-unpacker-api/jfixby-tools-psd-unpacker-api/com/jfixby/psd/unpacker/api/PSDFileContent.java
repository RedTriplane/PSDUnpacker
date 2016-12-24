package com.jfixby.psd.unpacker.api;

import com.jfixby.scarabei.api.collections.Collection;
import com.jfixby.scarabei.api.util.path.MountPoint;

public interface PSDFileContent extends MountPoint {

	void print();

	PSDRootLayer getRootlayer();

	Collection<PSDLayer> getRasterLayers();

	Collection<PSDLayer> getRasterLayerGroups();

	void dropRaster();

}
