package DS05_201802170_�ϻ�ȣ;
//enum MainMenu
public enum MainMenu {
	//constant
	Error,
	
	DoeseContain,
	ElemnetAt,
	First,
	Last,
	OrderOf,
	
	AddTo,
	AddToFirst,
	AddToLast,
	Add,
	
	RemoveFrom,
	RemoveFirst,
	RemoveLast,
	RemoveAny,
	
	ReplaceAt,
	
	EndOfRun;
	
	public static final int END_OF_RUN = 99;
	// ����ó�� , ����� �ε������� ��ȯ
	public static MainMenu value(int menuNumber) {
		if (menuNumber == END_OF_RUN) {
			return MainMenu.EndOfRun;
		} else if (menuNumber < DoeseContain.ordinal() || menuNumber > ReplaceAt.ordinal()) {
			return MainMenu.Error;
		} else {
			return MainMenu.values()[menuNumber];
		}
	}
} //end of MainMenu
