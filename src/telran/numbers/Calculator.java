package telran.numbers;

import java.util.function.BinaryOperator;

public class Calculator {
	static public double calculate(CalcData cd) {
		Double a = cd.getOp1();
		Double b = cd.getOp2();
		Character operation = cd.getOperation();
		
		Operator operators = new Operator();
		
        BinaryOperator<Double> calc = operators.getOperator(operation);
		Double res = calc.apply(a, b);
				
		return res;
	}
}