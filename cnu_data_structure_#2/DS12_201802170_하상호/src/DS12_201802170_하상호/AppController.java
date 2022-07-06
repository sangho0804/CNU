package DS12_201802170_�ϻ�ȣ;

public class AppController {

	private ExperimentManager _manager;

	private ExperimentManager manager() {
		return this._manager;
	}

	private void setManager(ExperimentManager newManager) {
		this._manager = newManager;
	}

	public AppController() {
		this.setManager(new ExperimentManager());
	}

	private void showTableTitle(ListOrder anOrder) {
		AppView.outputLine("> " + anOrder.orderName() + " �����͸� ����Ͽ� ������ ����:");
	}

	private void showTableHead() {
		AppView.outputLine(String.format("%8s", " ") + String.format("%16s", "<Insertion Sort>")
				+ String.format("%16s", "<Quick Sort>"));
	}

	private void showTableContent() {
		int startingSize = this.manager().parameterSet().startingSize();
		int incrementSize = this.manager().parameterSet().incrementSize();
		int numberOfSteps = this.manager().parameterSet().numberOfSizeIncreasingSteps();
		for (int step = 0; step < numberOfSteps; step++) {
			int sortingSize = startingSize + (incrementSize * step);
			AppView.outputLine("[" + String.format("%5d", sortingSize) + "]"
					+ String.format("%16d", this.manager().measuredResultForInsertionSortAt(step))
					+ String.format("%16d", this.manager().measuredResultForQuickSortAt(step)));
		}
	}

	private void showResultTable(ListOrder anOrder) {
		// �־��� anOrder �� ���Ͽ�, ���� ���� ����� �����ش�.
		this.showTableTitle(anOrder);
		this.showTableHead();
		this.showTableContent();
		AppView.outputLine("");
	}

	private void measureAndShowFor(ListOrder anOrder) {
		this.manager().performExperiment(anOrder);
		this.showResultTable(anOrder);
	}

	public void run() {
		AppView.outputLine("<<<���� ���� �� ���α׷��� �����մϴ� >>>");
		AppView.outputLine("");
		{
			AppView.outputLine(">> 2 ���� ������ ���� ��: ����, �� <<");
			this.manager().prepareExperiment(null);
			// ExperimentManager ��ü���� ������ �غ��Ų��.
			// �̹� ���迡���� �Ű����� ������ �⺻ ���� ���� ����Ѵ�.
			// �⺻ ���� ���� Class "ExperimentManager" �� �����Ǿ� �ִ�.
			this.measureAndShowFor(ListOrder.Ascending);
			this.measureAndShowFor(ListOrder.Descending);
			this.measureAndShowFor(ListOrder.Random);
		}
		AppView.outputLine("<<< ���� ���� �� ���α׷��� �����մϴ� >>>");

	}
}