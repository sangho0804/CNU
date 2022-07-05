package DS09_201802170_�ϻ�ȣ;

import java.util.Scanner;

//View class
public class AppView {
	// private constant / intance values
	private static Scanner scanner = new Scanner(System.in);
	private static boolean debugMode = false;

	// ������ : ��ü�� ������ ���� ����
	// ��ü�� ������ ���� ��� �Ϲ� �����ڸ� ǥ������
	private AppView() {
	}

	// �����Լ��� ����
	public static boolean debugMode() {
		return debugMode;
	}

	public static void setDebugMode(boolean newDebugMode) {
		debugMode = newDebugMode;
	}

	public static void outputDebugMessage(String aMessage) {
		if (AppView.debugMode()) {
			System.out.print(aMessage);
		}
	}

	public static void outputLineDebugMessage(String aMessage) {
		if (AppView.debugMode()) {
			System.out.println(aMessage);
		}
	}

	public static void output(String message) {
		System.out.print(message);
	}

	public static void outputLine(String message) {
		System.out.println(message);
	}

	public static String inputLine() {
		String line = AppView.scanner.nextLine().trim();
		while (line.equals("")) {
			line = AppView.scanner.nextLine().trim();
		}
		return line;
	}

}// End of Class"AppView"
