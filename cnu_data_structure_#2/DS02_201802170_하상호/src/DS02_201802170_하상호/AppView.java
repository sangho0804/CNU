package DS02_201802170_�ϻ�ȣ;

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
	
	public static void output(String message) {
		System.out.print(message);
	}
	
	public static void outputLine(String message) {
		System.out.println(message);
	}
	//box 
	//inputMenuNumber of user
	public static int inputMenuNumber() {
		System.out.print("? �����Ϸ��� �ϴ� �޴� ��ȣ�� �����Ͻÿ�(add:1, remove:2, search:3, frequency:4., exit:9 :");
		int menuNumber = scanner.nextInt();
		return menuNumber;
	} 
	//box
	//inputCapacityOfCoinBag of user
	public static int inputCapacityOfCoinBag() {
		System.out.print("?���� ������ ũ��, �� ���濡 �� ������ �ִ� ������ �Է��Ͻÿ� :");
		int inputCapacityOfCoinBag  = scanner.nextInt();
		return inputCapacityOfCoinBag;
	}
	//box
	//inputCoinValue of user
	public static int inputCoinValue() {
		System.out.print("?�������� �Է��Ͻÿ�:");
		int inputCoinValue  = scanner.nextInt();
		return inputCoinValue;
	}
	
}//End of Class"AppView"
