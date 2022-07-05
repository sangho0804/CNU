package DS05_201802170_�ϻ�ȣ;

import java.util.Scanner;

//View class
public class AppView {
	// ����� ���/������
	private static Scanner scanner = new Scanner(System.in);

	// ������ : ��ü�� ������ ���� ����
	// ��ü�� ������ ���� ��� �Ϲ� �����ڸ� ǥ������
	private AppView() {

	}

	// �����Լ��� ����
	public static void outputDebugMessage(String message) {
		System.out.print(message);
	}

	public static void output(String message) {
		System.out.print(message);
	}

	public static void outputLine(String message) {
		System.out.println(message);
	}

	public static int inputInteger() throws NumberFormatException {
		// ������ �ƴ� ����� ���� ó���� �����Ұ� : exception throws
		return Integer.parseInt(AppView.scanner.next());
	}

}// End of Class"AppView"
