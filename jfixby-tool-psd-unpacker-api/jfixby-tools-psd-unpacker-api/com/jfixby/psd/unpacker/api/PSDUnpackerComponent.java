package com.jfixby.psd.unpacker.api;

import java.io.IOException;

public interface PSDUnpackerComponent {

	PSDFileContent unpack(PSDUnpackingParameters params) throws IOException;

	PSDUnpackingParameters newUnpackingSpecs();

	

}
