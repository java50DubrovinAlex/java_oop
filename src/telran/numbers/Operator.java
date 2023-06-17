package telran.numbers;

import java.util.function.BinaryOperator;

class Operator {
    private BinaryOperator<Double>[] operators;

    @SuppressWarnings("unchecked")
	public Operator() {
        operators = new BinaryOperator[48];
        operators['+'] = (op1, op2) -> op1 + op2;
        operators['-'] = (op1, op2) -> op1 - op2;
        operators['*'] = (op1, op2) -> op1 * op2;
        operators['/'] = (op1, op2) -> op1 / op2;
        operators['%'] = (op1, op2) -> op1 % op2;
    }

    public BinaryOperator<Double> getOperator(Character operation) {
        BinaryOperator<Double> operator = operators[operation];
        return operator;
    }
}








