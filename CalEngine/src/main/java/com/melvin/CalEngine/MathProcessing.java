package com.melvin.CalEngine;

public interface MathProcessing {
	String SEPARATOR = " ";
	String getKeyword();  // e.g add or divide
	char getSymbol();
	double doCalculation(double leftVal, double rightVal);
}
