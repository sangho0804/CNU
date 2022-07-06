package DS14_201802170_�ϻ�ȣ;

import java.util.Scanner;

public class AppView {

	private static Scanner scanner = new Scanner(System.in);
	
	//������
	private AppView() {
		
	}

	public static void output(String aString) {
		System.out.print(aString);
	}

	public static void outputLine(String aString) {
		System.out.println(aString);
	}

	public static void outputTotalNumberOfStudents(int numberOfStudents) {
		System.out.println("��ü �л� �� : " + numberOfStudents);
	}

	public static void outputHighestScore(int aScore) {
		System.out.println("�б� �ְ� ���� : " + aScore);
	}

	public static void outputLowestScore(int aScore) {
		System.out.println("�б� ���� ���� : " + aScore);
	}

	public static void outputAverageScore(double average) {
		System.out.println("�б� ��� ���� : " + average);
	}

	public static void outputNumberOfStudentsAboveAverage(int numberOfStudents) {
		System.out.println("��� �̻��� �л� �� : " + numberOfStudents);
	}

	public static void outputNumberOfStudentsForGrade(char aGrade, int numberOfStudents) {
		System.out.println(aGrade + " ������ ��� " + numberOfStudents + "�� �Դϴ�.");
	}

	public static void outputStudentInfo(String aStudentID, int aScore, char aGrade) {
		System.out.println("�й� : " + aStudentID + ", ���� : " + aScore + ", ���� : " + aGrade);
	}

	public static void outputScore(int aScore) { // �л��� ���� ���
		System.out.println("���� : " + aScore);
	}

	public static boolean doesContinueToInputStudent() {
		AppView.output("? �л� ������ �Է��Ϸ��� 'Y' �Ǵ� 'y'��, ��ġ���� �ٸ� �ƹ�Ű�� ġ�ÿ� : ");
		String line;
		do {
			line = AppView.scanner.nextLine();
		} while (line.equals(""));
		char answer = line.charAt(0);
		return ((answer == 'Y') || (answer == 'y'));
	}

	public static String inputId() {
		AppView.output("-�й��� �Է��Ͻÿ� : ");
		String id = AppView.scanner.nextLine();
		return id;
	}

	public static int inputScore() {
		AppView.output("-������ �Է��Ͻÿ� : ");
		int score = AppView.scanner.nextInt();
		return score;
	}
}