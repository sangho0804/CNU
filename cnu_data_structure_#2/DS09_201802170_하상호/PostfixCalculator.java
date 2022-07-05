package DS09_201802170_�ϻ�ȣ;

//postfixCalculator class
public class PostfixCalculator {

	// Constant
	private static final int DEFAULT_MAX_EXPRESSION_LENGTH = 100;

	// �ν��Ͻ� ����
	private int _maxExpressionLength;
	private Stack<Integer> _valueStack;

	// Getter/Setter
	public int maxExpressionLength() {
		return this._maxExpressionLength;
	}

	private void setMaxExpressionLength(int newMaxExpressionLength) {
		this._maxExpressionLength = newMaxExpressionLength;
	}

	private Stack<Integer> valueStack() {
		return this._valueStack;
	}

	private void setValueStack(Stack<Integer> newValueStack) {
		this._valueStack = newValueStack;
	}

	// constructors
	public PostfixCalculator() {
		this(PostfixCalculator.DEFAULT_MAX_EXPRESSION_LENGTH);
	}

	public PostfixCalculator(int givenMaxExpressionLength) {
		this.setMaxExpressionLength(givenMaxExpressionLength);
		this.setValueStack(new ArrayList<Integer>(this.maxExpressionLength()));
	}
	// public methods

	// Stack �� �̿��Ͽ� postfix ������ ����Ͽ�, �� ����� ��´�.
	// ��� �ϴ� ���ȿ� ������ �߻��ϸ�, CalculatorException ��ü�� throws �Ѵ�
	public int evaluate(String aPostfixExpression) throws CalculatorException {
		if (aPostfixExpression == null || aPostfixExpression.length() == 0) {
			throw new CalculatorException(CalculatorError.PostfixError_NoExpression);
		}
		this.valueStack().clear();
		char token;
		for (int current = 0; current < aPostfixExpression.length(); current++) {
			token = aPostfixExpression.charAt(current);
			if (Character.isDigit(token)) {
				int tokenValue = Character.getNumericValue(token);
				if (this.valueStack().isFull()) {
					// [����] ������ �ʹ� ��� ó���� �Ұ����մϴ�.
					throw new CalculatorException(CalculatorError.PostfixError_TooLongExpression);
				} else {
					this.valueStack().push(Integer.valueOf(tokenValue));
				}
			} else { // ������
				CalculatorError error = this.executeBinaryOperator(token);
				if (error != CalculatorError.PostfixError_None) {
					throw new CalculatorException(error);
				}

			}
			this.showTokenAndValueStack(token);
		} // end of for
		if (this.valueStack().size() == 1) {
			return (this.valueStack().pop().intValue());
		} else {
			throw new CalculatorException(CalculatorError.PostfixError_TooManyValues);
		}

	}

	// private methods
	// Binary �����ڸ� �����Ѵ�.
	// �����ڸ� �����ϴ� ���ȿ� ������ �߻��ϸ� �ش� ���� �ڵ带 ��´�.
	private CalculatorError executeBinaryOperator(char anOperator) {
		if (this.valueStack().size() < 2) {
			return CalculatorError.PostfixError_TooFewValues;
		}
		// Binary operator �� ó�� �����ϴ�.
		int operand1 = this.valueStack().pop().intValue();
		int operand2 = this.valueStack().pop().intValue();
		int calculated = 0;
		switch (anOperator) {
		case '^':
			calculated = (int) Math.pow((double) operand2, (double) operand1);
			break;
		case '*':
			calculated = operand2 * operand1;
			break;
		case '/':
			if (operand1 == 0) {
				AppView.outputLineDebugMessage(
						anOperator + " : (DivideByZero) " + operand2 + " " + anOperator + " " + operand1);
				return CalculatorError.PostfixError_DivideByZero;
			} else {
				calculated = operand2 / operand1;
			}
			break;
		case '%':
			if (operand1 == 0) {
				AppView.outputLineDebugMessage(
						anOperator + " : (DivideByZero) " + operand2 + " " + anOperator + " " + operand1);
				return CalculatorError.PostfixError_DivideByZero;
			} else {
				calculated = operand2 % operand1;
			}
			break;
		case '+':
			calculated = operand2 + operand1;
			break;
		case '-':
			calculated = operand2 - operand1;
			break;
		default:
			return CalculatorError.PostfixError_UnknownOperator;
		}
		this.valueStack().push(Integer.valueOf(calculated));
		// isFull() �˻� ���ʿ� : 2�� pop �����Ƿ�, ���ÿ� �� ���� push �� ���� ����.
		return CalculatorError.PostfixError_None;
	}

	// ����� ����.
	// �־��� ��ū�� ������ ������ �����ش�.
	private void showTokenAndValueStack(char aToken) {
		AppView.outputDebugMessage(aToken + " : ValueStack <Bottom> ");
		for (int i = 0; i < this.valueStack().size(); i++) {
			AppView.outputDebugMessage(((ArrayList<Integer>) this.valueStack()).elementAt(i).intValue() + " ");
		}
		AppView.outputLineDebugMessage("<Top>");
	}

}//end of PostfixCalculator
