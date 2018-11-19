package com.melvin.CalEngine;

public class Adder extends CalculateBase implements MathProcessing  {

	public Adder() {}
	public Adder (double leftVal, double rightVal) {
		super (leftVal, rightVal);
	}
	
	@Override
	public void calculate() {
	 double value = getLeftVal() + getRightVal();
	 setResult(value);
	}
	public String getKeyword() { 
		return "add";
	}
	public char getSymbol() {
		return '+';
	}
	public double doCalculation(double leftVal, double rightVal) {
		setLeftVal(leftVal);
		setRightVal(rightVal);
		calculate();
		
		return getResult();
	}

}
