package telran.numbers.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.BinaryOperator;

import org.junit.jupiter.api.Test;

import telran.numbers.CalcData;
import telran.numbers.Calculator;

class CalculatorTest {

	@Test
	void test() {
		BinaryOperator<Double> bo = (a,b) -> a + b;
		assertEquals(30,bo.apply(10.0, 20.0));
		DoubleBinaryOperator[] operators = {
				(a, b) -> a + b,
				(a, b) -> a - b,
				(a, b) -> a * b,
				(a, b) -> a / b
		};
		double[] results = {30, 10, 200, 2};
		double op1 = 20;
		double op2 = 10;
		for(int i = 0; i < operators.length; i++) {
			assertEquals(results[i], operators[i].apply(op1, op2));
		}
	}
@Test
void calculateTest() {
	assertEquals(60, Calculator.calculate(new CalcData(40, 20, '+')));
	assertEquals(20, Calculator.calculate(new CalcData(40, 20, '-')));
	assertEquals(800, Calculator.calculate(new CalcData(40, 20, '*')));
	assertEquals(2, Calculator.calculate(new CalcData(40, 20, '/')));
	assertEquals(0, Calculator.calculate(new CalcData(40, 20, '%')));
}
}

interface DoubleBinaryOperator extends BinaryOperator<Double> {
	
}