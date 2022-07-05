package DS06_201802170_�ϻ�ȣ;
// AppController

public class AppController {
	// private instance variable
	private Experiment _experiment;

	// Getters / Setters
	private Experiment experiment() {
		return this._experiment;
	}

	private void setExperiment(Experiment newExperiment) {
		this._experiment = newExperiment;
	}

	// constructor
	public AppController() {
		this.setExperiment(new Experiment());
		// ���� ��ü���� ���� ������ ����� �����͸� �����ϰ� �Ѵ�.
		this.experiment().generateData();
	}

	// private method
	private void showExperimentResults() {
		MeasuredResult[] results = this.experiment().measuredResults();
		for (int i = 0; i < this.experiment().numberOfIteration(); i++) {
			AppView.outputResults(results[i].size(), results[i].durationForAdd() / 1000, // Nano �� Micro �� ��ȯ
					results[i].durationForMax() / 1000 // Nano �� Micro �� ��ȯ
			);
		}
	}

	// public method
	public void run() {
		AppView.outputLine("<<<����Ʈ ���� ���� ���α׷��� �����մϴ�.>>>");
		AppView.outputLine("! ����Ʈ�� ������ ���� �ð��� ���̸� �˾ƺ��ϴ�: (���� : Micro Second)");

		// UnSorted Array List �� ���� ����
		AppView.outputLine("");
		AppView.outputLine("<UnSorted Array List>");
		// ���� ��ü���� "UnSortedArrayList" �� ���� ���� ������ �����ϰ� �Ѵ�.
		this.experiment().measureForUnSortedArrayList();
		// ���� ��� ���
		this.showExperimentResults();

		// Sorted Array List �� ���� ����
		AppView.outputLine("");
		AppView.outputLine("<Sorted Array List>");
		// ���� ��ü���� "SortedArrayList" �� ���� ���� ������ �����ϰ� �Ѵ�.
		this.experiment().measureForSortedArrayList();
		// ���� ��� ���
		this.showExperimentResults();

		// UnSorted Linked List �� ���� ����
		AppView.outputLine("");
		AppView.outputLine("<UnSorted Linked List>");
		// ���� ��ü���� "UnSortedLinkedList" �� ���� ���� ������ �����ϰ� �Ѵ�.
		this.experiment().measureForUnSortedLinkedList();
		// ���� ��� ���
		this.showExperimentResults();

		// Sorted Array List �� ���� ����
		AppView.outputLine("");
		AppView.outputLine("<Sorted Linked List>");
		// ���� ��ü���� "SortedLinkedList" �� ���� ���� ������ �����ϰ� �Ѵ�.
		this.experiment().measureForSortedLinkedList();
		// ���� ��� ���
		this.showExperimentResults();

		AppView.outputLine("<<<����Ʈ ���� ���� ���α׷��� �����մϴ�.>>>");

	}

}// End of class "AppController"
