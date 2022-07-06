package DS11_201802170_�ϻ�ȣ;

public enum ListOrder {

	Ascending, // �������� ������ ����Ʈ�� ������ ǥ��
	Descending, // �������� ������ ����Ʈ�� ������ ǥ��
	Random; // ������ ������ ����Ʈ�� ������ ǥ��

	public static final String[] ORDER_NAMES = { "��������", "��������", "������" };

	// ���� �Ʒ��� ���� member method ���� ������ �� �ִ�.
	// ��, Enum �ȿ� ����� ������ Enum �� ��ü �ν��Ͻ��� �νĵȴ�.
	// Ascending, Descending, Random ������ ��ü �ν��Ͻ��̴�.
	public String orderName() {
		return ListOrder.ORDER_NAMES[this.ordinal()];
		// "ordinal()"�� ��� Enum �� �̸� ���ǵǾ� �ִ� �Լ���,
		// ����� ���� Enum �ȿ����� ������ ������ ���� �� �ִ�.
		// ��. Ascending.ordinal() �� 0, Descending.ordinal() �� 1,
		// Random.ordinal() �� 2 �� ��´�.
	}

}// end of ListOrder
