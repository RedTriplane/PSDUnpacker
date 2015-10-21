package com.jfixby.psd.unpacker.core.legacy;

public enum Status {
	STATUS_OK(false), STATUS_FORMAT_ERROR(true), STATUS_OPEN_ERROR(true), STATUS_UNSUPPORTED(
			true), NEW(false);

	private boolean print_stack;

	Status(boolean print_stack) {
		this.print_stack = print_stack;

	}

	public boolean printStack() {
		return print_stack;
	}
}
