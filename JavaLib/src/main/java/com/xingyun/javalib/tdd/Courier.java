package com.xingyun.javalib.tdd;

/**
 * 快递员
 */
public class Courier {
	private String name;
	//交通工具
	private String transportation;

	public Courier(String name, String transportation) {
		this.name = name;
		this.transportation = transportation;
	}

	public String deliver(String thing) {
		return name + transportation + thing;
	}
}
