package com.jfixby.psd.unpacker.core;

import com.jfixby.cmns.api.filesystem.File;
import com.jfixby.psd.unpacker.api.PSDUnpackingParameters;

public class PSDUnpackingParametersImpl implements PSDUnpackingParameters {
	private File PSDFilePath;
	private boolean CrashOnMask = true;

	@Override
	public File getPSDFile() {
		return PSDFilePath;
	}
	@Override
	public void setPSDFile(File pSDFilePath) {
		PSDFilePath = pSDFilePath;
	}
	@Override
	public boolean getCrashOnMask() {
		return CrashOnMask;
	}
	@Override
	public void setCrashOnMask(boolean crashOnMask) {
		CrashOnMask = crashOnMask;
	}

}
