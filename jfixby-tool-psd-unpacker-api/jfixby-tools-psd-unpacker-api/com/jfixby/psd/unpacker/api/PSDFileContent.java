package com.jfixby.psd.unpacker.api;

import com.jfixby.cmns.api.collections.Collection;
import com.jfixby.cmns.api.path.MountPoint;

public interface PSDFileContent extends MountPoint {

	void print();

	PSDRootLayer getRootlayer();

	Collection<PSDLayer> getRasterLayers();

	Collection<PSDLayer> getRasterLayerGroups();

	void dropRaster();

}
