package com.jfixby.psd.unpacker.core;

import com.jfixby.psd.unpacker.api.PSDUnpackingParameters;
import com.jfixby.scarabei.api.file.File;

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
