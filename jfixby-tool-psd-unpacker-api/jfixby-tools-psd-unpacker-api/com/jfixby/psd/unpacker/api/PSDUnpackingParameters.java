package com.jfixby.psd.unpacker.api;

import com.jfixby.cmns.api.filesystem.File;

public interface PSDUnpackingParameters {

	void setPSDFile(File psd_file);

	File getPSDFile();

	boolean getCrashOnMask();

	void setCrashOnMask(boolean value);

}
