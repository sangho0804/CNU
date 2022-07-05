package DS01_201802170_�ϻ�ȣ;

import java.util.Scanner;
//View
public class AppView {
	//����� ���/������
	private static Scanner scanner = new Scanner(System.in);
	
	//������ : ��ü�� ������ ���� ����
	//��ü�� ������ ���� ��� �Ϲ� �����ڸ� ǥ������
	private AppView() {
		
	}
	//�����Լ��� ����
	//User inputOrder
	public static int inputOrder() { //box
		System.out.print("? ������ ������ �Է��Ͻÿ�(������ �Է��ϸ� �����մϴ�) :");
		int inputOrder = scanner.nextInt();
		return inputOrder;
	}
	
	
	public static void output(String message) {
		System.out.print(message);
	}
	public static void outputLine(String message) {
		System.out.println(message);
	}
	public static void outputTitleWithOrder(int order) {//box / usuer �� �Է��� Order���� ���
		System.out.println("! Magic Square Board : Order "+ order);
		
	}
	public static void outputRowNomber(int number) {
		System.out.printf("[%3d]",number);
	}
	public static void outputCellValue(int value) {
		System.out.printf("   %3d" , value);
	}

}//End of Class"AppView"
