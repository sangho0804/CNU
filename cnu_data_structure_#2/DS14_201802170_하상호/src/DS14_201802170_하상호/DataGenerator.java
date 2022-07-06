package DS14_201802170_�ϻ�ȣ;

import java.util.Random;

public final class DataGenerator {

	// ��ü �ν��Ͻ��� ������ �� ���� ���� ���´�.
	private DataGenerator() {
	}

	// ��� ���� �Լ��� static

	public static Integer[] ascendingOrderList(int aSize) {
		Integer[] list = null;
		if (aSize > 0) {
			list = new Integer[aSize];
			for (int i = 0; i < aSize; i++) {
				list[i] = i;
			}
		}
		return list;
	}

	// box
	public static Integer[] descendingOrderList(int aSize) {
		Integer[] list = null;
		if (aSize > 0) {
			list = new Integer[aSize];
			for (int i = 0; i < aSize; i++) {
				list[i] = (aSize - i) - 1;
			}
		}
		return list;
	}

	public static Integer[] randomOrderList(int aSize) {
		// ��ġ�� ���Ұ� ���� ������ ����Ʈ�� �����Ͽ�, �����ش�.
		Integer[] list = null;
		if (aSize > 0) {
			// �ϴ� Ascending order list �� �����
			list = new Integer[aSize];
			for (int i = 0; i < aSize; i++) {
				list[i] = i;
			}
			// �� ���� list[i] �� ���� ������ ��ġ r �� �����Ͽ� list[i] �� list[r] �� �¹ٲ۴�.
			Random random = new Random();
			for (int i = 0; i < aSize; i++) {
				int r = random.nextInt(aSize);
				Integer temp = list[i];
				list[i] = list[r];
				list[r] = temp;
			}
		}
		return list;
	}

	public static Integer[] randomListWithoutDuplication(int aSize) {
		// ��ġ�� ���Ұ� ���� ������ ����Ʈ�� �����Ͽ�, �����ش�.
		Integer[] list = null;
		if (aSize > 0) {
			// �ϴ� Ascending order list �� �����
			list = DataGenerator.ascendingOrderList(aSize);
			// �� ���� list[i] �� ���� ������ ��ġ r �� �����Ͽ� list[i] �� list[r] �� �¹ٲ۴�.
			Random random = new Random();
			for (int i = 0; i < aSize; i++) {
				int randomIndex = random.nextInt(aSize);
				Integer temp = list[i];
				list[i] = list[randomIndex];
				list[randomIndex] = temp;
			}
		}
		return list;
	}

}// end of DataGenerator
