#include "Calculator.hpp"
#include "LinkedListStack.hpp"
#include "CalculatorError.hpp"

double Calculator::Calculate(char* postfixExpression) {
	LinkedListStack stack;
	CalculatorError se;


	char* value = (char*)malloc(strlen(postfixExpression) + 1);
	unsigned int position = 0;
	unsigned int length = (unsigned int)strlen(postfixExpression) + 1;

	int type = -1;
	int Errorcode;
	double result = 0;
	char strResult[32];
	bool NoExpression = false;


	while (length > position) {

		position += GetNextValue(&postfixExpression[position], value, &type);
		if (type == SPACE || type == -1 || type == '\0') continue;
		if (type == OPERAND) {
			stack.Push(stack.CreateNode(value));
		}
		else {
			NoExpression = true;
			Node* op2 = stack.Pop();
			Node* op1 = stack.Pop();

			if (op2 != NULL && op1 == NULL && type != LEFT_PARENTHESES) //ok
			{
				Errorcode = CalculatorError::Error_TooManyValues;
				se.setCalculatorError(Errorcode);
				throw CalculatorError(se);
				break;
			}



			double tempResult = 0;
			memset(strResult, 0, 32);

			switch (type) {
			case MULTIPLY:
				tempResult = atof(op1->Data) * atof(op2->Data);
				break;
			case DIVIDE: //ok
				if (atof(op2->Data) == 0)
				{
					Errorcode = CalculatorError::Error_DivideByZero;
					se.setCalculatorError(Errorcode);
					throw CalculatorError(se);
					break;
				}
				tempResult = atof(op1->Data) / atof(op2->Data);
				break;
			case PLUS:
				tempResult = atof(op1->Data) + atof(op2->Data);
				break;
			case MINUS:
				tempResult = atof(op1->Data) - atof(op2->Data);
				break;
			case LEFT_PARENTHESES:
				Errorcode = CalculatorError::InfixError_MissingRightParen;
				se.setCalculatorError(Errorcode);
				throw CalculatorError(se);
				break;
			default: //ok
				Errorcode = CalculatorError::Error_UnknownOperator;
				se.setCalculatorError(Errorcode);
				throw CalculatorError(se);
				break;
			}



			_gcvt(tempResult, 10, strResult);
			stack.Push(stack.CreateNode(strResult));

			stack.DestroyNode(op1);
			stack.DestroyNode(op2);
		}
	}
	if (!NoExpression) //ok
	{
		Errorcode = CalculatorError::Error_NoExpression;
		se.setCalculatorError(Errorcode);
		throw CalculatorError(se);
	}



	result = atof(stack.Pop()->Data);

	free(value);
	stack.DestroyStack();

	return result;
}

void Calculator::GetPostfix(char* infixExpression, char* postfixExpression) {
	LinkedListStack stack;
	Node* popNode = NULL;
	CalculatorError se;

	char* value = (char*)malloc(strlen(infixExpression) + 1);
	unsigned int length = (unsigned int)strlen(infixExpression) + 1;
	unsigned int position = 0;
	int type = -1;
	int parentheseesCheck = false;
	int Errorcode;

	while (length > position) {


		position += GetNextValue(&infixExpression[position], value, &type);
		if (type == SPACE || type == -1 || type == '\0') continue;
		if (type == OPERAND) {
			strcat(postfixExpression, value);
			strcat(postfixExpression, " ");
		}
		else if (type == RIGHT_PARENTHESES) {
			while (stack.GetTop()->Data[0] != LEFT_PARENTHESES) {
				popNode = stack.Pop();
				strcat(postfixExpression, popNode->Data);
				strcat(postfixExpression, " ");
				stack.DestroyNode(popNode);

				if (stack.isEmpty() && !parentheseesCheck) {
					Errorcode = CalculatorError::InfixError_MissingLeftParen;
					se.setCalculatorError(Errorcode);
					throw CalculatorError(se);
					break;
				}


			}

			popNode = stack.Pop();
			stack.DestroyNode(popNode);

			popNode = NULL;
		}
		else {
			while (!stack.isEmpty() && isPrior(stack.GetTop()->Data[0], value[0])) {
				popNode = stack.Pop();
				strcat(postfixExpression, popNode->Data);
				strcat(postfixExpression, " ");
				stack.DestroyNode(popNode);
			}
			stack.Push(stack.CreateNode(value));
			popNode = NULL;
		}

		memset(value, 0, strlen(infixExpression) + 1);
		type = -1;
	}

	while (!stack.isEmpty()) {
		popNode = stack.Pop();
		strcat(postfixExpression, popNode->Data);
		strcat(postfixExpression, " ");
		stack.DestroyNode(popNode);
	}

	stack.DestroyStack();
	free(value);
}

unsigned int Calculator::GetNextValue(char* expression, char* value, int* type) {
	unsigned int index = 0;

	for (index = 0; expression[index] != 0; index++) {
		if (isNum(expression[index])) {
			*type = OPERAND;
			value[index] = expression[index];
			if (!isNum(expression[index + 1])) break;
		}
		else {
			*type = expression[index];
			value[index] = expression[index];
			break;
		}
	}

	value[++index] = '\0';
	return index;
}

unsigned int Calculator::GetPriority(char op, int inStack) {
	unsigned int priority = -1;
	switch (op) {
	case LEFT_PARENTHESES:
		if (inStack) priority = 3;
		else priority = 0;
		break;
	case MULTIPLY:
	case DIVIDE:
		priority = 1;
		break;
	case PLUS:
	case MINUS:
		priority = 2;
		break;
	}

	return priority;
}

bool Calculator::isPrior(char op1, char op2) {
	return (GetPriority(op1, 1) < GetPriority(op2, 0));
}

bool Calculator::isNum(char c) {
	for (int i = 0; i < 18; i++) {
		if (NUM[i] == c) return true;
	}
	return false;
}


