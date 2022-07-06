#include "CalculatorError.hpp"
#include "View.hpp"


CalculatorError::CalculatorError() {

}

CalculatorError::CalculatorError(int errormessage) {
	this->setCalculatorError(errormessage);
}
void CalculatorError::setCalculatorError(int newError) {
	this->errorMessage = newError;

}
int CalculatorError::getCalculatorError() {
	return this->errorMessage;
}

void CalculatorError::outErrorMessage(int Error) {
	
	Error = this->getCalculatorError();

	View print;
	switch (Error)
	{
	case Error_Hexadecimal:
		print.outputLine("�߸��� �Է��Դϴ�. ");
		break;

	case InfixError_MissingLeftParen:
		print.outputLine("[����] ���� ��ȣ�� �������ϴ�. ");
		break;

	case InfixError_MissingRightParen:
		print.outputLine("[����] ������ ��ȣ�� �������ϴ�. ");
		break;

	case Error_NoExpression:
		print.outputLine("[����] �����ڰ� �־����� �ʾҽ��ϴ�. ");
		break;

	case Error_TooManyValues:
		print.outputLine("[����] �����ڿ� ���� ���갪�� ���� �����ϴ�. ");
		break;

	case Error_DivideByZero:
		print.outputLine("[����] �������� �и� 0 �Դϴ�. ");
		break;

	case Error_UnknownOperator:
		print.outputLine("[����] ���Ŀ� �� �� ���� �����ڰ� �ֽ��ϴ�. ");
		break;


	}
}