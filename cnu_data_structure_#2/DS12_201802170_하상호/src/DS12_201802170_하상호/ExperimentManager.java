package DS12_201802170_�ϻ�ȣ;

public class ExperimentManager {
	// Constants for the parameters:
	private static final int DEFAULT_NUMBER_OF_SIZE_INCREASING_STEPS = 10;
	private static final int DEFAULT_INCREMENT_SIZE = 1000;
	private static final int DEFAULT_STARTING_SIZE = DEFAULT_INCREMENT_SIZE;
	// Constants: ���迡�� ����� ���ĵ��� ��� ��ü�� ����
	private static final InsertionSort<Integer> INSERTION_SORT = new InsertionSort<Integer>();
	private static final QuickSort<Integer> QUICK_SORT = new QuickSort<Integer>();

	// Private instance variables
	private Experiment _experiment; // ���� ������ �ǽ��� ��ü
	private ParameterSet _parameterSet; // ���� ���迡 ����� �Ű����� ����
	private Integer[] _ascendingOrderList; // �������� ���Ŀ� ����� �������� ������ ����Ʈ
	private Integer[] _descendingOrderList; // �������� ���Ŀ� ����� �������� ������ ����Ʈ
	private Integer[] _randomOrderList; // �������� ���Ŀ� ����� ������ ������ ����Ʈ
	private long[] _measuredResultForInsertionSort; // ���� ������ ���� ��� ������ ��
	private long[] _measuredResultForQuickSort; // �� ������ ���� ��� ������ ��

	// Getter/Setter

	private Experiment experiment() {
		return this._experiment;
	}

	private void setExperiment(Experiment newExperiment) {
		this._experiment = newExperiment;
	}

	public ParameterSet parameterSet() {
		return this._parameterSet;
	}

	private void setParameterSet(ParameterSet newParameterSet) {
		this._parameterSet = newParameterSet;
	}

	private Integer[] ascendingOrderList() {
		return this._ascendingOrderList;
	}

	private void setAscendingOrderList(Integer[] newAscendingOrderList) {
		this._ascendingOrderList = newAscendingOrderList;
	}

	private Integer[] descendingOrderList() {
		return this._descendingOrderList;
	}

	private void setDescendingOrderList(Integer[] newDescendingOrderList) {
		this._descendingOrderList = newDescendingOrderList;
	}

	private Integer[] randomOrderList() {
		return this._randomOrderList;
	}

	private void setRandomOrderList(Integer[] newRandomOrderList) {
		this._randomOrderList = newRandomOrderList;
	}

	private long[] measuredResultForInsertionSort() {
		return this._measuredResultForInsertionSort;
	}

	private void setMeasuredResultForInsertionSort(long[] newMeasuredResultForInsertionSort) {
		this._measuredResultForInsertionSort = newMeasuredResultForInsertionSort;
	}

	private long[] measuredResultForQuickSort() {
		return this._measuredResultForQuickSort;
	}

	private void setMeasuredResultForQuickSort(long[] newMeasuredResultForQuickSort) {
		this._measuredResultForQuickSort = newMeasuredResultForQuickSort;
	}

	// Constructor
	public ExperimentManager() {
		this.setParameterSetWithDefaults(); // �⺻ ������ �Ű����� ������ �ʱ�ȭ�Ѵ�
	}

	// private methods
	private void prepareExperimentLists() {
		int maxDataSize = this.parameterSet().maxDataSize();
		this.setAscendingOrderList(DataGenerator.ascendingOrderList(maxDataSize));
		this.setDescendingOrderList(DataGenerator.descendingOrderList(maxDataSize));
		this.setRandomOrderList(DataGenerator.randomOrderList(maxDataSize));
	}

	private void setParameterSetWithDefaults() {
		this.setParameterSet(new ParameterSet(DEFAULT_STARTING_SIZE, DEFAULT_NUMBER_OF_SIZE_INCREASING_STEPS,
				DEFAULT_INCREMENT_SIZE));
	}

	private Integer[] experimentListOfOrder(ListOrder anOrder) {
		// �־��� anOrder �� �ش��ϴ� ����Ʈ�� �����ش�.
		switch (anOrder) {
		case Ascending:
			return this.ascendingOrderList();
		case Descending:
			return this.ascendingOrderList();
		default:
			return this.randomOrderList();
		}
	}

	public void prepareExperiment(ParameterSet aParameterSet) {
		// ������ �غ��Ѵ�.
		if (aParameterSet != null) {
			// ��ü ������ ��, �Ű����� ������ �⺻ ������ �����Ǿ� �ִ�.
			// ���� �غ� �ܰ迡��, �̷��� ���ο� �Ű����� ������ �־� ������ �� �ִ�.
			this.setParameterSet(aParameterSet);
		}
		this.setExperiment(new Experiment(this.parameterSet()));
		// ���� ������ �Ű����� ������ ����Ͽ� Experiment ��ü�� �����Ѵ�.
		this.prepareExperimentLists();
		// ���� ���迡�� ���Ŀ� ����� ������ ����Ʈ�� �����Ͽ� �����Ѵ�.
		// ������ ������ ���� ������, ���������δ� �ǹ̰� ���� �����̴�.
		// ���� ���� ���� ����� ����ȭ��Ű�� ���� ������ ���̴�.
		this.performExperiment(ListOrder.Random);
		this.performExperiment(ListOrder.Random);
	}

	public long measuredResultForInsertionSortAt(int sizeStep) {
		return this.measuredResultForInsertionSort()[sizeStep];
	}

	public long measuredResultForQuickSortAt(int sizeStep) {
		return this.measuredResultForQuickSort()[sizeStep];
	}

	public void performExperiment(ListOrder anOrder) {
		// ���� ������ �����Ѵ�.
		// �־��� anOrder �� ���� ����Ʈ�� ��´�.
		Integer[] experimentList = this.experimentListOfOrder(anOrder);
		// �� ���� ����Ʈ�� ���԰� �� ������ ������ ������ �����ؼ�, �� ����� ��´�.
		this.setMeasuredResultForInsertionSort(this.experiment().durationsOfSort(INSERTION_SORT, experimentList));
		this.setMeasuredResultForQuickSort(this.experiment().durationsOfSort(QUICK_SORT, experimentList));
	}
}
