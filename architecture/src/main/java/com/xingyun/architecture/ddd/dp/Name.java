package com.xingyun.architecture.ddd.dp;

import com.xingyun.architecture.ddd.ValidationException;

public class Name {
	private final String name;

	public Name(String name) {
		this.name = name;
		if (name == null) {
			throw new ValidationException("name不能为空");
		}
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Name{" +
				"name='" + name + '\'' +
				'}';
	}
}
