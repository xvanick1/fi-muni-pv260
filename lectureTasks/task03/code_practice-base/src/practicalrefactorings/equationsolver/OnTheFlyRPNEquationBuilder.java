/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicalrefactorings.equationsolver;

import org.apache.commons.lang3.StringUtils;

import java.util.Stack;

public class OnTheFlyRPNEquationBuilder implements RPNEquationBuilder {

	private Stack<Evaluable> stack = new Stack<>();

	@Override
	public RPNEquationBuilder push(String token) {
		if(isNumericTokenCheck(token)){
			int value = Integer.parseInt(token);
			NumericNode number = new NumericNode(value);
			stack.push(number);

		} else if (isOperatorTokenCheck(token)) {
			OperatorNode operator = new OperatorNode(token.charAt(0));
			operator.setRight(stackPop(stack));
			operator.setLeft(stackPop(stack));

			stack.push(operator);
		} else {
			throw new IllegalArgumentException("Dont understand token: " + token);
		}


		return this;
	}

	private boolean isNumericTokenCheck(String token) {
		return StringUtils.isNumeric(token);
	}

	private Evaluable stackPop(Stack<Evaluable> stack) {
		if (stack.isEmpty()) {
			throw new IllegalStateException("Nothing left on the stack.");
		}
		return stack.pop();
	}

	private boolean isOperatorTokenCheck(String token) {
		return token.length() == 1;
	}

	@Override
	public Evaluable build() {
		if (stack.size() != 1) {
			throw new IllegalStateException("More than one token left on the stack, unbalanced input.");
		}
		return stack.pop();
	}


}
