package DS06_201802170_�ϻ�ȣ;

//View class
public class AppView {

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
	
	public static void outputResults(int size, long durationForAdd, long durationForMax)
	{
		AppView.outputLine(
			"[ũ��: " + String.format("%5d", size) + "] " +
			"����:  " + String.format("%8d", durationForAdd) + ", " +
			"�ִ밪: " + String.format("%8d", durationForMax)		
				);
	}
}// End of Class"AppView"
