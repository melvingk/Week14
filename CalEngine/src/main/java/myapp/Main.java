package myapp;

import com.melvin.CalEngine.Adder;
import com.melvin.CalEngine.CalculateBase;
import com.melvin.CalEngine.CalculateHelper;
import com.melvin.CalEngine.Divider;
import com.melvin.CalEngine.DynamicHelper;
import com.melvin.CalEngine.InvalidStatementException;
import com.melvin.CalEngine.MathEquation;
import com.melvin.CalEngine.MathProcessing;
import com.melvin.CalEngine.Multiplier;
import com.melvin.CalEngine.PowerOf;
import com.melvin.CalEngine.Subtracter;

public class Main {

	
	public static void main(String[] args) {
		
//		useMathEquation();
//		useCalculateBase();
//		useCalculatorHelper();
		useDynamicHelper();
	
	}
// Using interfaces and various classes created abstract methods(not literally abstract) to 		
	
	static void useDynamicHelper() {
	String[] statements = {
			"add 25.0 92.0",  // 25.0 + 92.0 = 117.0
			"power 5.0 2.0"   // 5.0 ^ 2.0 =25.0
	};		
	
	DynamicHelper helper = new DynamicHelper (new MathProcessing[] {
			new Adder(),
			new PowerOf()
	});
			
	for (String statement:statements)
			{
				String output = helper.process(statement);
				System.out.println(output);
			}
	
	
	}
	
	
//Using for the string manipulation with the classes CalculateHelper,InvalidStatementException,	
//MathCommand(an enum) 
	static void useCalculatorHelper() {	
		String [] statements = {
				
				"add 1.0",
				"add xx 25.0",
				"addX 0.0 0.0",
				"divide 100.0 50.0",
				"add 25.0 92.0",
				"subtract 225.0 17.0",
				"multiply 11.0 3.0"
		};
		
		CalculateHelper helper = new CalculateHelper();
		for(String statement:statements) {
			try {									// put the try block inside the for loop so as to try each statement instead of all of them at the same time
			helper.process(statement); 
			System.out.println();
			System.out.println("Using String Manipulation");
			System.out.println(helper.toString());
			System.out.println();}
			catch(InvalidStatementException e) {
				System.out.println(e.getMessage());
				if(e.getCause() != null)
					System.out.println("Original excpetion " + e.getCause().getMessage());
			}
			
		}
	}
	// Using a encapsulation, a constructor and switch statement using the MathEquation class.
	static void useMathEquation() {
	MathEquation [] equations = new MathEquation[4];
	equations[0] = new MathEquation('d',100.0d,50.0d);
	equations[1] = new MathEquation('a',25.0d,92.0d);
	equations[2] = new MathEquation('s',225.0d,17.0d);
	equations[3] = new MathEquation('m',11.0d,3.0d);
	
	for (MathEquation equation : equations) {
		equation.execute();
		System.out.println();
		System.out.println("Using Basic Calculator");
		System.out.print("result = ");
		System.out.println(equation.getResult());
	}
	
	
	// Using overloading, multiple constructors and a switch statement, the class MathEquation was used.
	System.out.println();
	System.out.println("Using Overload");
	System.out.println();
	
	
	double leftDouble = 9.0d;
	double rightDouble = 4.0d;
	int leftInt= 9;
	int rightInt= 4;		
	
	MathEquation equationOverload = new MathEquation('d');
	equationOverload.execute(leftInt, rightInt);
	System.out.print("RESULT = ");
	System.out.println(equationOverload.getResult() );
	
	}
	static void useCalculateBase() {
	//Using Inheritance, abstraction, a constructor and the classes CalcualteBase, Adder, Subtracter, Multiplier and Divider.
	System.out.println();
	System.out.println("Using Inheritance");
	System.out.println();
	
	CalculateBase[] calculators = {
			new Divider(100.0d, 50.0d),
			new Adder (25.0d,92.0d),
			new Subtracter(225.0d, 17.0d),
			new Multiplier(11.0d, 3.0d)
	};
	
	for (CalculateBase calculator:calculators) {
		calculator.calculate();
		System.out.print("RESULT = ");
		System.out.println(calculator.getResult() );
		
	}
	}
	
	}

	
	

