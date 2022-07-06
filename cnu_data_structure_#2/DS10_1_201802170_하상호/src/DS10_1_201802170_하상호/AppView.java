package DS10_1_201802170_�ϻ�ȣ;

import java.util.Scanner;

//View class
public class AppView {
	// private constant / intance values
	private static Scanner scanner = new Scanner(System.in);

	// ������ : ��ü�� ������ ���� ����
	// ��ü�� ������ ���� ��� �Ϲ� �����ڸ� ǥ������
	private AppView() {
	}

	// �����Լ��� ����

	public static void output(String message) {
		System.out.print(message);
	}

	public static void outputLine(String message) {
		System.out.println(message);
	}

	public static char inputChar() { // ���ڿ� �Է�
		String line = AppView.scanner.nextLine().trim();
		while (line.equals("")) {
			line = AppView.scanner.nextLine().trim();
		}
		return line.charAt(0);
	}

}// End of Class"AppView"
