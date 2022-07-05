package DS09_201802170_�ϻ�ȣ;

//Calculator class
public class Calculator {
	// Constants
	private static final int MAX_EXPRESSION_lENGTH = 10;

	// private instance variables
	private Stack<Character> _operatorStack;
	private String _infixExpression;
	private String _postfixExpression;
	private PostfixCalculator _postfixCalculator;

	// Getters / Setters
	private String infixExpression() {
		return this._infixExpression;
	}

	private void setInfixExpression(String newInfixExpression) {
		this._infixExpression = newInfixExpression;
	}

	private String postfixExpression() {
		return this._postfixExpression;
	}

	private void setPostfixExpression(String newPostfixExpression) {
		this._postfixExpression = newPostfixExpression;
	}

	private PostfixCalculator postfixCalculator() {
		return this._postfixCalculator;
	}

	private void setPostfixCalculator(PostfixCalculator newPostfixCalculator) {
		this._postfixCalculator = newPostfixCalculator;
	}

	private Stack<Character> operatorStack() {
		return this._operatorStack;
	}

	private void setOperatorStack(Stack<Character> newOperatorStack) {
		this._operatorStack = newOperatorStack;
	}
	
	//CONSTRUCTOR
	public Calculator() {
		this.setOperatorStack(new ArrayList<Character>(Calculator.MAX_EXPRESSION_lENGTH));
		this.setPostfixCalculator(new PostfixCalculator(Calculator.MAX_EXPRESSION_lENGTH));
	}
	

	private void showOperatorStack(String anOperationLabel) {
		// ������ ���¸� ���
		AppView.outputDebugMessage("  : " + anOperationLabel + " OperatorStack <Bottom> ");
		for (int i = 0; i < this.operatorStack().size(); i++)
			AppView.outputDebugMessage(((ArrayList<Character>) this.operatorStack()).elementAt(i).charValue() + " ");
		AppView.outputLineDebugMessage("<Top>");
	}

	private void showTokenAndPostfixExpression(char aToken, char[] aPostfixExpressionArray) {
		// postfix �������� ��µ� ��ū�� ������� �ϼ��� postfix ������ ���
		AppView.outputDebugMessage(aToken + " : (Postfix �������� ���) ");
		AppView.outputLineDebugMessage(new String(aPostfixExpressionArray));
	}

	private void showTokenAndMessage(char aToken, String aMessage) {
		// Token�� Message ���
		AppView.outputLineDebugMessage(aToken + " : (" + aMessage + ") ");
	}

	private int inComingPrecedence(Character aToken) {
		// ���� ���ÿ� �����ϴ� ������ aToken�� �켱���� ���� ������
		// '('�� ������, ������ ���ÿ� ���� = ���� ���� �켱����
		switch (aToken.charValue()) {
		case '(':
			return 20;// inStack���� 0
		case ')':
			return 19;
		case '^':
			return 17;// inStack���� 16
		case '*':
			return 13;
		case '/':
			return 13;
		case '%':
			return 13;
		case '+':
			return 12;
		case '-':
			return 12;
		default:
			return -1;
		}
	}

	private int inStackPrecedence(Character aToken) {
		//���� �ȿ� ���� �ϴ� ������ ������ aToken �� �켱 ���� ���� ������
		// ���� �ȿ���, ��ȣ ������ �����ڵ��� ������
		// '(' ���� ���� = ���� ���� �켱����, ')' �� ������, �� �ȿ� �켱������ ��� pop()
		// ������ �켱 ���չ�Ģ
		// '^' �Է���ū�� 17, ���þ��� 16�� ����, ���ÿ� ���ԵǱ� ���ؼ�
		switch (aToken.charValue()) {
		case '(':
			return 0; // inComing���� 20
		case ')':
			return 19;
		case '^':
			return 16;// inComing���� 17
		case '*':
			return 13;
		case '/':
			return 13;
		case '%':
			return 13;
		case '+':
			return 12;
		case '-':
			return 12;
		default:
			return -1;
		}
	}

	private CalculatorError infixToPostfix() {
		// infixExpression�� postfixExpression���� ����
		char[] postfixExpressionArray = new char[this.infixExpression().length()];// char�迭����
		java.util.Arrays.fill(postfixExpressionArray, ' ');// char�迭�� ��� ĭ�� �������� ä��

		Character currentToken, poppedToken, topToken;
		int p = 0;
		// post���Ŀ� token�� ����� ��ġ

		this.operatorStack().clear();

		for (int i = 0; i < this.infixExpression().length(); i++) {
			currentToken = this.infixExpression().charAt(i);

			if (Character.isDigit(currentToken.charValue())) {
				// currentToken�� �ǿ�����(����)
				postfixExpressionArray[p++] = currentToken;// currentToken�� �迭�� ����
				this.showTokenAndPostfixExpression(currentToken, postfixExpressionArray);// postfix �������� ���
			} else {
				// currentToken�� ������
				if (currentToken == ')') {
					// currentToken�� ������ ��ȣ
					this.showTokenAndMessage(currentToken, "���� ��ȣ�� ��Ÿ�� ������ ���ÿ��� ������ ���");
					poppedToken = this.operatorStack().pop();

					while ((poppedToken != null) && (poppedToken.charValue() != '(')) {
						// �� || '('�� ���ö����� pop()
						postfixExpressionArray[p++] = poppedToken.charValue();// poppedToken�� �迭�� ����
						this.showOperatorStack("Popped");// ������ ���� ���
						this.showTokenAndPostfixExpression(poppedToken, postfixExpressionArray);// postfix �������� ���

						poppedToken = this.operatorStack().pop();
					}

					// [����] while���� '(' �� ã�� �������� ��
					if (poppedToken == null)
						return CalculatorError.InfixError_MissingLeftParen;

					this.showOperatorStack("Popped");// ������ ���� ���
				} else {
					// currentToken�� �Ϲݿ�����
					int inComingPrecedence = this.inComingPrecedence(currentToken.charValue());// ���ڿ� ���� �켱���� �޾ƿ���

					// [����] default, �˼� ���� ������
					if (inComingPrecedence < 0) {
						AppView.outputLineDebugMessage(currentToken + " : (Unknown Operator)");
						return CalculatorError.InfixError_UnknownOperator;
					}

					this.showTokenAndMessage(currentToken, "�Է� ������ �������� ������ ���� ���� �����ڸ� ���ÿ��� ������ ���");

					topToken = this.operatorStack().peek();
					while ((topToken != null) && (this.inStackPrecedence(topToken) >= inComingPrecedence)) {
						// �� || topToken�� �켱������ �� ������ ����
						poppedToken = this.operatorStack().pop();
						postfixExpressionArray[p++] = poppedToken;
						this.showOperatorStack("Popped");
						this.showTokenAndPostfixExpression(poppedToken, postfixExpressionArray);
						topToken = this.operatorStack().peek();
					}

					// [����] ���� ũ�⸦ ���� ����
					if (this.operatorStack().isFull()) {
						this.showOperatorStack("Fulled");
						return CalculatorError.InfixError_TooLongExpression;
					}

					// topToken�� �켱���� < inComingPrecedence
					this.operatorStack().push(currentToken);
					this.showOperatorStack("Pushed");
				}

			}
		} //for �� ����

		AppView.outputLineDebugMessage("(End of infix expression : ���ÿ��� ��� �����ڸ� ������ ���)");

		while (!this.operatorStack().isEmpty()) {
			// ������ ������ �� �� ����, ������ �����ڸ� ���ʷ� ������ postfix �������� ������
			poppedToken = this.operatorStack().pop();
			this.showOperatorStack("Popped");
			// [����]')'�� ���� �� ����
			if (poppedToken == '(')
				return CalculatorError.InfixError_MissingRightParen;
			postfixExpressionArray[p++] = poppedToken;// poppedToken�� �迭�� ����
			this.showTokenAndPostfixExpression(poppedToken, postfixExpressionArray);// postfix �������� ���
		} // end of while

		this.setPostfixExpression(new String(postfixExpressionArray).trim());
		// Array�� �̿��� postfixExpression ����

		return CalculatorError.InfixError_None;
	}

	public int evaluate(String anInfixExpression) throws CalculatorException {
		// infix ������ ����Ͽ� ����� ����
		// ���� �߻���, CalculatorException throw
		this.setInfixExpression(anInfixExpression);
		AppView.outputLineDebugMessage("[Infix to Postfix] " + anInfixExpression);

		if ((this.infixExpression() == null) || (this.infixExpression().length() == 0))
			throw new CalculatorException(CalculatorError.InfixError_NoExpression);

		CalculatorError infixError = this.infixToPostfix();
		// infix���� postfix�� ��ȯ
		// postExpression ����

		if (infixError == CalculatorError.InfixError_None) {
			AppView.outputLine("");
			AppView.outputLineDebugMessage("[Evaluate Postfix] " + this.postfixExpression());
			return this.postfixCalculator().evaluate(this.postfixExpression());
			// AppController�� result ��ȯ
		} else
			throw new CalculatorException(infixError);
	}
}// end of Calculator
