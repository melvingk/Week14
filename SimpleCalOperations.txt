package com.melvin.CalEngine;

public class MathEquation {
	
private double leftVal;
private double rightVal;
private char OpCode;
private double result;

public double getLeftVal() {
	return leftVal;
}
public void setLeftVal(double leftVal) {
	this.leftVal = leftVal;
}
public double getRightVal() {
	return rightVal;
}
public void setRightVal(double rightVal) {
	this.rightVal = rightVal;
}
public char getOpCode() {
	return OpCode;
}
public void setOpCode(char opCode) {
	OpCode = opCode;
}
public double getResult() {
	return result;
}

public MathEquation () {
}
public MathEquation (char opCode) {
	this.OpCode= opCode;
}
public MathEquation (char opCode, double leftVal, double rightVal) {
	this(opCode);
	this.rightVal = rightVal;
	this.leftVal = leftVal;
}

public void execute(double leftVal, double rightVal) {
	this.leftVal= leftVal;
	this.rightVal= rightVal;
	
	execute();
}

public void execute(int leftVal, int rightVal) {
	this.leftVal= leftVal;
	this.rightVal= rightVal;
	
	execute();
	
//	result= (int)result; -will trunkate the value of the result to an integer
}

public void execute() {
	switch(OpCode) {
	case 'a':
		result = leftVal + rightVal;
		break;
	case 's':
		result = leftVal - rightVal;
		break;
	case 'd':
		result = rightVal != 0.0d ? leftVal/rightVal : 0.0d;
		break;
	case 'm':
		result = leftVal * rightVal;
		break;
	default:
		System.out.println("Error - invlaid OpCode");
		result = 0.0d;
		break; 
	}
}
	

}
