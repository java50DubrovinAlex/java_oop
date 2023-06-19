package telran.numbers;

import java.util.function.BinaryOperator;

public class Calculator {
	static public double calculate(CalcData cd) {
		Operator operators = new Operator();
		
        BinaryOperator<Double> calc = operators.getOperator(cd.getOperation());
		Double res = calc.apply(cd.getOp1(), cd.getOp2());
				
		return res;
	}
}