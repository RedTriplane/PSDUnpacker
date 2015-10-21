package com.jfixby.psd.unpacker.api;


public interface PSDRootLayer extends PSDLayer{

	PSDLayer findChildByNamePrefix(String child_name);

	int numberOfChildren();

	PSDLayer getChild(int i);

}
