package DS13_201802170_�ϻ�ȣ;
public class QuickSort<E extends Comparable<E>> extends Sort<E> {
	public QuickSort() {
	}

	private int pivot(E[] aList, int left, int right) { // ������ pivot
		return left; // left ����
	}

	private int partition(E[] aList, int left, int right) {
		int pivot = this.pivot(aList, left, right); // ������
		int toRight = left; // �������� �ű� ����
		int toLeft = right + 1; // �������� �ű� ����
		do {
			do {
				toRight++;
			} while (aList[toRight].compareTo(aList[pivot]) < 0); // aList[toRight] < aList[pivot]�̸� toRight++
			do {
				toLeft--;
			} while (aList[toLeft].compareTo(aList[pivot]) > 0); // aList[toLeft] > aList[pivot]�̸� toLeft--
			if (toRight < toLeft) { // toRight�� toleft���� ������
				this.swap(aList, toRight, toLeft); // ��ġ ����
			}
		} while (toRight < toLeft); // toRight < toLeft�̸� �ݺ�
		this.swap(aList, left, toLeft); // left�� toLeft�� �¹ٲ۴�
		return toLeft; // toLeft�� ����
	}

	private void quickSortRecursively(E[] aList, int left, int right) {
		if (left < right) {
			int mid = partition(aList, left, right);
			quickSortRecursively(aList, left, mid - 1);
			quickSortRecursively(aList, mid + 1, right);
		}
	}

	@Override
	public boolean sort(E[] aList, int aSize) {
		if ((aSize < 1) || (aSize > aList.length)) { // aSize�� ��ȿ������ �ƴϸ�
			return false;
		}
		int maxLoc = 0; // �ʱ� ��ġ
		for (int i = 1; i < aSize; i++) {
			if (aList[i].compareTo(aList[maxLoc]) > 0) { // aList[i]�� �� ũ��
				maxLoc = i; // maxLoc = i
			}
		}
		this.swap(aList, maxLoc, aSize - 1); // �� �� ���ҿ� �¹ٲ�
		this.quickSortRecursively(aList, 0, aSize - 2); // �� �� ���Ҹ� �����ϰ� �ݺ�
		return true;
	}
}
