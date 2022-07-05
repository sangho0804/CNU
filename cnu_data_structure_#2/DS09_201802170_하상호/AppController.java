package DS09_201802170_�ϻ�ȣ;

public class AppController {
	private static final char END_OF_CALCULATION = '!';
	private static final boolean DEBUG_MODE = true;

	private Calculator _calculator;

	//getter / setter
	private Calculator calculator() {
		return this._calculator;
	}

	private void setCalculator(Calculator newCalculator) {
		this._calculator = newCalculator;
	}


	//constructor
	public AppController() {
		this.setCalculator(new Calculator());
		AppView.setDebugMode(AppController.DEBUG_MODE);// DebugMode�� true�϶��� ���
	}

	//private methods
	private String inputExpression() {
		// ������ �Է¹���
		AppView.outputLine("");
		AppView.output("? ����� ������ �Է��Ͻÿ� (�����Ϸ��� " + END_OF_CALCULATION + " �� �Է��Ͻÿ�) : ");
		return AppView.inputLine();
	}

	private void showCalculatorErrorMessage(CalculatorError anError) {
		// Error�ڵ忡 �´� �޽��� ���
		switch (anError) {
		case InfixError_NoExpression:
			AppView.outputLine("[����] ���� ������ �־����� �ʾҽ��ϴ�.");
			break;
		case InfixError_TooLongExpression:
			AppView.outputLine("[����] ���� ������ �ʹ� ��� ó���� �� �����ϴ�.");
			break;
		case InfixError_MissingLeftParen:
			AppView.outputLine("[����] ���� ��ȣ�� �������ϴ�.");
			break;
		case InfixError_MissingRightParen:
			AppView.outputLine("[����] ������ ��ȣ�� �������ϴ�.");
			break;
		case InfixError_UnknownOperator:
			AppView.outputLine("[����] ���� ���Ŀ� �� �� ���� �����ڰ� �ֽ��ϴ�.");
			break;
		case PostfixError_NoExpression:
			AppView.outputLine("[����] ���� ������ �־����� �ʾҽ��ϴ�.");
			break;
		case PostfixError_TooLongExpression:
			AppView.outputLine("[����] ���� ������ �ʹ� ��� ó���� �� �����ϴ�.");
			break;
		case PostfixError_TooFewValues:
			AppView.outputLine("[����] �����ڿ� ���� ���갪�� ���� �����ϴ�.");
			break;
		case PostfixError_TooManyValues:
			AppView.outputLine("[����] �����ڿ� ���� ���갪�� ���� �����ϴ�.");
			break;
		case PostfixError_DivideByZero:
			AppView.outputLine("[����] �������� �и� 0 �Դϴ�.");
			break;
		case PostfixError_UnknownOperator:
			AppView.outputLine("[����] ���� ���Ŀ� �� �� ���� �����ڰ� �ֽ��ϴ�.");
			break;
		default:
			;//Nothing to do.
		}
	}

	public void run() {
		AppView.outputLine("<<< ���� ���α׷��� �����մϴ� >>>");

		String infixExpression = this.inputExpression();
		while (infixExpression.charAt(0) != AppController.END_OF_CALCULATION) {
			try {
				int result = this.calculator().evaluate(infixExpression);
				AppView.outputLine("> ��갪 : " + result);
			} catch (CalculatorException exception) {
				this.showCalculatorErrorMessage(exception.error());
			}
			infixExpression = this.inputExpression();
		} // end of while

		AppView.outputLine("");
		AppView.outputLine("<<< ���� ���α׷��� �����մϴ� >>>");
	}

}// end of AppController
