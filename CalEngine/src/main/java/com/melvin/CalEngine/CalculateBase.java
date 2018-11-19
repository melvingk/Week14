package com.melvin.CalEngine;

public abstract class CalculateBase {
//implements MathProcessing 
	private double leftVal;
	private double rightVal;
	private double result;
	public double getLeftVal() {
		return leftVal;
	}
	public void setLeftVal(double leftVal) {
		this.leftVal = leftVal;
	}
	public double getResult() {
		return result;
	}
	public void setResult(double result) {
		this.result = result;
	}
	public double getRightVal() {
		return rightVal;
	}
	public void setRightVal(double rightVal) {
		this.rightVal = rightVal;
	}
	

	public CalculateBase() {}
	public CalculateBase(double leftVal, double rightVal) {
		this.leftVal = leftVal;
		this.rightVal = rightVal;
	}

	public abstract void calculate(); 
}
