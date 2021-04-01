/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicalrefactorings.equationsolver;

import java.util.Stack;

public class OnTheFlyRPNEquationBuilder implements RPNEquationBuilder {

	private Stack<Evaluable> stack = new Stack<>();

	@Override
	public RPNEquationBuilder push(String token) {
			if(token.getClass().equals(NumericNode.class)) {
				int value = Integer.parseInt(token);
				NumericNode number = new NumericNode(value);
				stack.push(number);
			}
			else if(token.getClass().equals(OperatorNode.class))
			{

				if (token.length() == 1) {
					OperatorNode operator = new OperatorNode(token.charAt(0));
					if (stack.isEmpty()) {
						throw new IllegalStateException("Nothing left on the stack for operand");
					}
					NumericNode right =new NumericNode( Integer.parseInt(stack.pop().representation()));
					if (stack.isEmpty()) {
						throw new IllegalStateException("Nothing left on the stack for operand");
					}
					NumericNode left = new NumericNode( Integer.parseInt(stack.pop().representation()));

					operator.setLeft(left);
					operator.setRight(right);
					stack.push(operator);
				}
			}
			else{
				throw new IllegalArgumentException("Dont understand token: " + token);
			}



		return this;
	}

	@Override
	public Evaluable build() {
		if (stack.size() != 1) {
			throw new IllegalStateException("More than one token left on the stack, unbalanced input.");
		}
		return stack.pop();
	}

}
