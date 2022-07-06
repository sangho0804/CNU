#include <iostream>
#include <string>

#include "Calculator.hpp"
#include "Controller.hpp"
#include "View.hpp"
#include "StringConvert.hpp"
#include "CalculatorError.hpp"


using namespace std;


void Controller::run()
{
	Calculator cal;
	View view;
	StringConvert sc;

	char postfix[100];
	char buffer[100];
	double result;
	string inputText = "\0";


	while (inputText != END_OF_CALCULATION)
	{
		try
		{
			view.output("계산할 수식을 입력하시오 (종료하려면 " + END_OF_CALCULATION + " 를 입력하시오) : ");

			inputText = view.input();

			if (inputText == END_OF_CALCULATION)
			{
				break;
			}

			inputText = sc.actionStringConvert(inputText);
			strcpy(buffer, inputText.c_str());

			memset(postfix, 0, 100);

			cal.GetPostfix(buffer, postfix);
			view.output("postfix : ");
			view.outputLine(postfix);

			result = cal.Calculate(postfix);
			view.outputDouble("result : ", result);


			for (int i = 0; i < inputText.length(); i++)
			{
				buffer[0] = 0;

			}

		}
		catch (CalculatorError e)
		{
			e.outErrorMessage(e.getCalculatorError());
		}
	


	}

	std::cout << "계산기가 종료되었습니다." << std::endl;


};