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
		print.outputLine("잘못된 입력입니다. ");
		break;

	case InfixError_MissingLeftParen:
		print.outputLine("[오류] 왼쪽 괄호가 빠졌습니다. ");
		break;

	case InfixError_MissingRightParen:
		print.outputLine("[오류] 오른쪽 괄호가 빠졌습니다. ");
		break;

	case Error_NoExpression:
		print.outputLine("[오류] 연산자가 주어지지 않았습니다. ");
		break;

	case Error_TooManyValues:
		print.outputLine("[오류] 연산자에 비해 연산값의 수가 많습니다. ");
		break;

	case Error_DivideByZero:
		print.outputLine("[오류] 나눗셉의 분모가 0 입니다. ");
		break;

	case Error_UnknownOperator:
		print.outputLine("[오류] 계산식에 알 수 없는 연산자가 있습니다. ");
		break;


	}
}