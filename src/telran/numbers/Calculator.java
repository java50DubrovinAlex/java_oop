package telran.numbers;

import java.util.function.BinaryOperator;

public class Calculator {
	static public double calculate(CalcData cd) {
		Double a = cd.getOp1();
		Double b = cd.getOp2();
		Character operation = cd.getOperation();
		
		BinaryOperator<Double>[] operators = new BinaryOperator[48];
		
        operators['+'] = (op1, op2) -> op1 + op2;
        operators['-'] = (op1, op2) -> op1 - op2;
        operators['*'] = (op1, op2) -> op1 * op2;
        operators['/'] = (op1, op2) -> op1 / op2;
        operators['%'] = (op1, op2) -> op1 % op2;
		
        BinaryOperator<Double> calc = operators[operation];
		Double res = calc.apply(a, b);
				
		return res;
	}
}