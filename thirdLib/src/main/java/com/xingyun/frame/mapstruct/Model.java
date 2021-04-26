package com.xingyun.frame.mapstruct;

public class Model {
	private String modelName;
	private int modelCount;

	public Model(String modelName, int modelCount) {
		this.modelName = modelName;
		this.modelCount = modelCount;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public int getModelCount() {
		return modelCount;
	}

	public void setModelCount(int modelCount) {
		this.modelCount = modelCount;
	}
}
