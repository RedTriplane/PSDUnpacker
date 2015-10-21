package com.jfixby.psd.unpacker.api;

import java.io.IOException;

import com.jfixby.cmns.api.components.ComponentInstaller;

public class PSDUnpacker {

	static private ComponentInstaller<PSDUnpackerComponent> componentInstaller = new ComponentInstaller<PSDUnpackerComponent>(
			"PSDUnpacker");

	public static final void installComponent(
			PSDUnpackerComponent component_to_install) {
		componentInstaller.installComponent(component_to_install);
	}

	public static final PSDUnpackerComponent invoke() {
		return componentInstaller.invokeComponent();
	}

	public static final PSDUnpackerComponent component() {
		return componentInstaller.getComponent();
	}

	public static PSDUnpackingParameters newUnpackingSpecs() {
		return invoke().newUnpackingSpecs();
	}

	public static final PSDFileContent unpack(PSDUnpackingParameters params) throws IOException {
		return invoke().unpack(params);
	}

}
