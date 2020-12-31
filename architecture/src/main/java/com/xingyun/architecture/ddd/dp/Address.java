package com.xingyun.architecture.ddd.dp;

import com.xingyun.architecture.ddd.ValidationException;

public class Address {
	private final String address;

	public Address(String address) {
		if (address == null) {
			throw new ValidationException("address不能为空");
		}
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "Address{" +
				"address='" + address + '\'' +
				'}';
	}
}
