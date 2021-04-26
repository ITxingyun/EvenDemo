package com.xingyun.frame.mapstruct;

public class Domain {
	private String doMainName;
	private int count;

	public Domain(String doMainName, int count) {
		this.doMainName = doMainName;
		this.count = count;
	}

	public String getDoMainName() {
		return doMainName;
	}

	public void setDoMainName(String doMainName) {
		this.doMainName = doMainName;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Domain{" +
				"doMainName='" + doMainName + '\'' +
				", count=" + count +
				'}';
	}
}
