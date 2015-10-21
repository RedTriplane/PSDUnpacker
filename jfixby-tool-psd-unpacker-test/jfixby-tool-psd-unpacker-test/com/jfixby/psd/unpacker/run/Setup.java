package com.jfixby.psd.unpacker.run;

import com.jfixby.cmns.api.collections.JUtils;
import com.jfixby.cmns.api.filesystem.LocalFileSystem;
import com.jfixby.cmns.api.log.L;
import com.jfixby.cmns.api.sys.Sys;
import com.jfixby.cmns.jutils.desktop.DesktopUtils;
import com.jfixby.psd.unpacker.api.PSDUnpacker;
import com.jfixby.psd.unpacker.core.RedPSDUnpacker;
import com.jfixby.red.desktop.filesystem.win.WinFileSystem;
import com.jfixby.red.desktop.log.DesktopLogger;
import com.jfixby.red.desktop.sys.DesktopSystem;

public class Setup {

	public static void setup() {
		L.installComponent(new DesktopLogger());
		JUtils.installComponent(new DesktopUtils());

		Sys.installComponent(new DesktopSystem());

		LocalFileSystem.installComponent(new WinFileSystem());
//		 LocalFileSystem.installComponent(new UnixFileSystem());
		PSDUnpacker.installComponent(new RedPSDUnpacker());

	}
}
