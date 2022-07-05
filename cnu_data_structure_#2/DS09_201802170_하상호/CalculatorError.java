package DS09_201802170_�ϻ�ȣ;
//enum CalculatorError
public enum CalculatorError {
	
	//Error �߻��� ���·� �ʱ�ȭ�ϴ� �������� ���
    Undefined,

    //Infix ������ ����ϴ� ���� �߻��� �� �ִ� ���� �ڵ�
    //<Calculator>
    InfixError_None,
    InfixError_NoExpression,
    InfixError_TooLongExpression,
    InfixError_MissingLeftParen,
    InfixError_MissingRightParen,
    InfixError_UnknownOperator,

    //Postfix ������ ����ϴ� ���� �߻��� �� �ִ� ���� �ڵ�
    //<Postfix Calculator>
    PostfixError_None,
    PostfixError_NoExpression,
    PostfixError_TooLongExpression,
    PostfixError_TooFewValues,
    PostfixError_TooManyValues,
    PostfixError_DivideByZero,
    PostfixError_UnknownOperator,


}//end of CalculatorError
