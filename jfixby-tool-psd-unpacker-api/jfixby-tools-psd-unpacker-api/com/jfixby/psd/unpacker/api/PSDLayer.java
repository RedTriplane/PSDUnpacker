
package com.jfixby.psd.unpacker.api;

import com.jfixby.scarabei.api.util.path.AbsolutePath;

public interface PSDLayer {

	boolean isVisible ();

	boolean isFolder ();

	String getName ();

	PSDLayer findChildByNamePrefix (String child_name);

	PSDLayer findChildByName (String child_name);

	int numberOfChildren ();

	PSDLayer getChild (int i);

	// PSDPath getPath();

	void printChildren ();

	boolean isRaster ();

	PSDRaster getRaster ();

	AbsolutePath<PSDFileContent> getPath ();

	void dropRaster ();

	PSD_BLEND_MODE getMode ();

	double getOpacity ();

}
