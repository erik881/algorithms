package by.ek.algorithm.stings;

import java.util.Stack;

/**
 * @author Evgeni Kisel
 */
public class Calculator {

	public static void main(String[] args) {
		calculate("2+2");
		calculate("2+2+5");
		calculate("2+2+5+10");
	}

	private static void calculate(String expression) {
		StringBuilder number = new StringBuilder();

		Stack<Double> values = new Stack<>();
		char lastOperation;
		for (int i = 0; i < expression.length(); i++) {
			if (isExpression(expression.charAt(i))) {
				lastOperation = expression.charAt(i);
				values.push(Double.parseDouble(number.toString()));
				number = new StringBuilder();
				if (values.size() == 2) {
					values.push(values.pop() + values.pop());
				}
			} else {
				number.append(expression.charAt(i));
			}
		}

		values.push(Double.parseDouble(number.toString()));
		values.push(values.pop() + values.pop());

		System.out.println(values.pop());
	}

	private static boolean isExpression(char v) {
		return v == '+';
	}
}
