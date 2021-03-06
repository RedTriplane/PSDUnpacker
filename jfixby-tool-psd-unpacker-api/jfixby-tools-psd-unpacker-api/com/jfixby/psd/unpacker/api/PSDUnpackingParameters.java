package com.jfixby.psd.unpacker.api;

import com.jfixby.scarabei.api.file.File;

public interface PSDUnpackingParameters {

	void setPSDFile(File psd_file);

	File getPSDFile();

	boolean getCrashOnMask();

	void setCrashOnMask(boolean value);

}
