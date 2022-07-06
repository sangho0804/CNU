package DS11_201802170_�ϻ�ȣ;

public class AppController {
	// ���
	private static final int TEST_SIZE = 10000;
	private static final int FIRST_PART_SIZE = 5;
	private static final InsertionSort<Integer> INSERTION_SORT = new InsertionSort<Integer>();
	private static final QuickSort<Integer> QUICK_SORT = new QuickSort<Integer>();
	// ����� ������
	private Integer[] _list;
	private ListOrder _listOrder;

	// Getters/Setters
	private Integer[] list() {
		return this._list;
	}

	private void setList(Integer[] newList) {
		this._list = newList;
	}

	private ListOrder listOrder() {
		return this._listOrder;
	}

	private void setListOrder(ListOrder newListOrder) {
		this._listOrder = newListOrder;
	}

	// ������
	public AppController() {
	}

	// ������Լ��� ����
	private void validateWithAscendingOrderList() {
		this.setListOrder(ListOrder.Ascending);
		this.setList(DataGenerator.ascendingOrderList(AppController.TEST_SIZE));
		this.showFirstPartOfDataList();
		this.validateSortsAndShowResult();
	}

	private void validateWithDescendingOrderList() {
		this.setListOrder(ListOrder.Descending);
		this.setList(DataGenerator.descendingOrderList(AppController.TEST_SIZE));
		this.showFirstPartOfDataList();
		this.validateSortsAndShowResult();
	}

	private void validateWithRandomOrderList() {
		this.setListOrder(ListOrder.Random);
		this.setList(DataGenerator.randomOrderList(AppController.TEST_SIZE));
		this.showFirstPartOfDataList();
		this.validateSortsAndShowResult();
	}

	// box
	private void showFirstPartOfDataList() {
		AppView.output("[" + this.listOrder().orderName() + " ����Ʈ] �� �� �κ�: ");
		for (int i = 0; i < 5; i++) {
			AppView.output(this.list()[i] + " ");
		}
		AppView.outputLine("");
	}

	private void validateSortsAndShowResult() {
		this.validateSort(AppController.INSERTION_SORT);
		this.validateSort(AppController.QUICK_SORT);
		AppView.outputLine("");
	}

	private void validateSort(Sort<Integer> aSort) {
		Integer[] list = this.copyList(this._list);
		// ������ ����Ʈ�� ���� �� (�����δ� 2 ��) �����ϰ� �ȴ�.
		// �Ź� ���� ����Ʈ�� �����Ͽ� �����Ѵ�.
		aSort.sort(list, list.length);
		this.showValidationMessage(aSort, list);
	}

	private Integer[] copyList(Integer[] aList) {
		// �־��� �迭 ��ü aList[] �� ���纻�� ����� �����ش�.
		// aList[] ��ü�� ����������,
		// �迭�� ���� ��ü ��ü�� �������� �ʰ� �����Ѵ�.
		Integer[] copiedList = new Integer[aList.length];
		copiedList = aList;

		return copiedList;
	}

	private boolean sortedListIsValid(Integer[] aList) {
		// �־��� aList �� ���ҵ��� ������������ �Ǿ� ������ true �� �����ش�.
		for (int i = 0; i < (aList.length - 1); i++) {
			if (aList[i].compareTo(aList[i + 1]) > 0) {
				return false; // ���������� �ƴ� ������ �߰�
			}
		}
		return true; // ����Ʈ ��ü�� ������������ �Ǿ� �ִ�.
	}

	private void showValidationMessage(Sort<Integer> aSort, Integer[] aList) {
		AppView.output("[" + this.listOrder().orderName() + " ����Ʈ]�� [" + aSort.getClass().getSimpleName() + "] �� ����� ");
		if (this.sortedListIsValid(aList)) {
			AppView.outputLine("�ùٸ��ϴ�.");
		} else {
			AppView.outputLine("�ùٸ����ʽ��ϴ�.");
		}
	}

	// �����Լ��� ����
	public void run() {
		AppView.outputLine("<<< ���� �˰����� ���� ����� �����ϴ� ���α׷��� �����մϴ� >>>");
		AppView.outputLine("");
		AppView.outputLine("> ���� ����� ����:");
		AppView.outputLine("");
		this.validateWithAscendingOrderList();
		this.validateWithDescendingOrderList();
		this.validateWithRandomOrderList();
		AppView.outputLine("<<< ���� �˰����� ���� ����� �����ϴ� ���α׷��� �����մϴ� >>>");
	}

} // End of class ��AppController��
