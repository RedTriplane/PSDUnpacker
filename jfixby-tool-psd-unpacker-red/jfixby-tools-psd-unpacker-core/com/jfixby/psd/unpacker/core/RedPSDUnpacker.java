package com.jfixby.psd.unpacker.core;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import com.jfixby.psd.unpacker.api.PSDFileContent;
import com.jfixby.psd.unpacker.api.PSDUnpackerComponent;
import com.jfixby.psd.unpacker.api.PSDUnpackingParameters;
import com.jfixby.psd.unpacker.core.legacy.PSDReader;
import com.jfixby.scarabei.api.file.File;
import com.jfixby.scarabei.api.log.L;

public class RedPSDUnpacker implements PSDUnpackerComponent {

    @Override
    public PSDUnpackingParameters newUnpackingSpecs() {
	return new PSDUnpackingParametersImpl();
    }

    @Override
    public PSDFileContent unpack(PSDUnpackingParameters params) throws IOException {
	boolean crash_on_mask = params.getCrashOnMask();

	File file = params.getPSDFile();

	L.d("unpacking", file);

	if (!file.exists()) {
	    throw new IOException("File not found: " + file);
	}

	if (!file.isFile()) {
	    throw new IOException("This is not a file: " + file);
	}

	PSDReader unpacker = new PSDReader();
	unpacker.setCrashOnMask(crash_on_mask);

	byte[] bytes = file.readBytes().toArray();

	com.jfixby.psd.unpacker.core.legacy.FileContent result = unpacker.readFromStream(file.getName(),
		new ByteArrayInputStream(bytes));

	return new PSDFileContentImpl(result);
    }

}
