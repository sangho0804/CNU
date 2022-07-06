#include "Calculator.hpp"
#include "StringConvert.hpp"
#include "CalculatorError.hpp"
#include <string>
#include <iostream>

using namespace std;

const string StringConvert::actionStringConvert(const string& inputText)
{
	Calculator cal;
	CalculatorError se;
	int Errorcode;
	string text[100];
	text[0] = "\0";
	text[1] = '0';

	//convert
	for (int i = 0; i < inputText.length(); i++)
	{

		if (inputText[i] == '0' && inputText[i + 1] == 'x' || inputText[i] == '0' && inputText[i + 1] == 'b') {
			if (inputText[i + 1] == 'x') {
				int inputTextIndex16 = 0;
				text[1] = text[1] + 'x';




				for (int k = i + 2; k < inputText.length(); k++) {


					if (cal.isNum(inputText[k])) {
						text[1] = text[1] + inputText[k];


						inputTextIndex16 = k;
					}


					if (!cal.isNum(inputText[k]))
					{
						if (!this->ex_check(inputText[k]))
						{
							if (inputText[k] > '9' || inputText[k] < '0')
							{
								if (inputText[k] > 'f' || inputText[k] < 'a')
								{
									Errorcode = CalculatorError::Error_Hexadecimal;
									se.setCalculatorError(Errorcode);
									throw CalculatorError(se);
								}
							}
						}
						break;

					}
				}
				int _16number = stoi(text[1], nullptr, 16);
				text[0] = text[0] + to_string(_16number);


				text[1] = "0";
				i = inputTextIndex16;

			}

			else if (inputText[i + 1] == 'b') {
				int inputTextIndex2 = 0;

				for (int j = i + 2; j < inputText.length(); j++) {
					if (inputText[j] == '0' || inputText[j] == '1') {
						text[2] = text[2] + inputText[j];

						inputTextIndex2 = j;
					}
					if (!this->ex_check(inputText[j]))
					{

						if (inputText[j] != '0' && inputText[j] != '1')
						{
							Errorcode = CalculatorError::Error_Hexadecimal;
							se.setCalculatorError(Errorcode);
							throw CalculatorError(se);
						}


					}
					if (!cal.isNum(inputText[j])) {
						break;
					}

				}

				int _2number = stoi(text[2], nullptr, 2);
				text[0] = text[0] + to_string(_2number);


				text[2] = "0";
				i = inputTextIndex2;
			}

		}
		else {
			text[0] = text[0] + inputText[i];

		}
	}

	return text[0];

}
bool StringConvert::ex_check(char c) {
	for (int i = 0; i < 4; i++) {
		if (ex[i] == c) return true;
	}
	return false;
}





