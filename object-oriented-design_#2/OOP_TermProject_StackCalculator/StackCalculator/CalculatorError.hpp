#ifndef CalculatorError_hpp
#define CalculatorError_hpp
#include <stdio.h>
#include <string>

using namespace std;

class CalculatorError {
public:

	enum Error
	{


		InfixError_MissingLeftParen, //ok
		InfixError_MissingRightParen, //ok
		Error_NoExpression, //ok
		Error_TooManyValues, //ok
		Error_DivideByZero, //ok
		Error_UnknownOperator, //ok
		Error_Hexadecimal //ok


	};

public:
	CalculatorError();
	CalculatorError(int errormessage);
	void setCalculatorError(int newError);
	int getCalculatorError();
	void outErrorMessage(int errormessage);
	int errorMessage;

};




#endif
