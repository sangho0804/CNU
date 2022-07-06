package DS10_1_201802170_�ϻ�ȣ;

public class AppController {
	// ���
	private static final int QUEUE_CAPACITY = 5;
	// ����� ������
	private Queue<Character> _queue;
	private int _inputChars; // �Էµ� ������ ����
	private int _pushedChars; // ���Ե� ������ ����
	private int _ignoredChars; // ���õ� ������ ����

	// Getters/Setters
	private Queue<Character> queue() {
		return this._queue;
	}

	private void setQueue(Queue<Character> newQueue) {
		this._queue = newQueue;
	}

	private int inputChars() {
		return this._inputChars;
	}

	private void setInputChars(int newInputChars) {
		this._inputChars = newInputChars;
	}

	private int pushedChars() {
		return this._pushedChars;
	}

	private void setPushedChars(int newPushedChars) {
		this._pushedChars = newPushedChars;
	}

	private int ignoredChars() {
		return this._ignoredChars;
	}

	private void setIgnoredChars(int newIgnoredChars) {
		this._ignoredChars = newIgnoredChars;
	}

	// ������
	public AppController() {
		this.setQueue(new CircularArrayQueue<Character>(AppController.QUEUE_CAPACITY));
		this.setInputChars(0);
		this.setPushedChars(0);
		this.setIgnoredChars(0);
	}

	// ����� �Լ�
	// Ƚ�� ���
	private void countInputChar() {
		this.setInputChars(this.inputChars() + 1);
	}

	private void countIgnoredChar() {
		this.setIgnoredChars(this.ignoredChars() + 1);
	}

	private void countAddedChar() {
		this.setPushedChars(this.pushedChars() + 1);
	}

	//ť ���� ����
	private void addToQueue(char aCharForAdd) {
		if (this.queue().isFull())
			AppView.outputLine("[EnQ.Empty] ť�� �� ���� �� �̻� ���� ���� �����ϴ�.");
		else {
			this.queue().enQueue(Character.valueOf(aCharForAdd));
			AppView.outputLine("[EnQ] ���Ե� ���Ҵ� '" + aCharForAdd + "' �Դϴ�.");
		}
	}

	private void removeOne() {
		if (this.queue().isEmpty())
			AppView.outputLine("[DeQ.Empty] ť�� ������ ���Ұ� �����ϴ�.");
		else {
			Character removedChar = this.queue().deQueue();
			if (removedChar == null)
				AppView.outputLine("(����) ť���� �����ϴ� ���ȿ� ������ �߻��߽��ϴ�.");
			else
				AppView.outputLine("[DeQ] ������ ���Ҵ� '" + removedChar + "' �Դϴ�.");
		}
	}

	private void removeN(int numberOfCharsToBeRemoved) {
		if (numberOfCharsToBeRemoved == 0)
			AppView.outputLine("[DeQs] ������ ������ ������ 0�� �Դϴ�.");

		for (int i = 0; i < numberOfCharsToBeRemoved; i++) {
			if (this.queue().isEmpty()) {
				AppView.outputLine("[DeQ.Empty] ť�� ������ ���Ұ� �����ϴ�.");
				break;
			} else {
				Character removedChar = this.queue().deQueue();
				if (removedChar == null)
					AppView.outputLine("(����) ť���� �����ϴ� ���ȿ� ������ �߻��߽��ϴ�.");
				else
					AppView.outputLine("[DeQ] ������ ���Ҵ� '" + removedChar + "' �Դϴ�.");
			}
		} // end of for
	}

	private void quitQueueProcessing() {
		// ���α׷� �����
		AppView.outputLine("< ť�� ���� ����� �����մϴ� >");
		showAllFromFront();
		removeN(this.queue().size());
	}


	//��� ����
	private void showAllFromFront() {
		// ť�� ��� ���Ҹ� Front���� Rear���� ���
		AppView.output("[Queue] <Front> ");
		Iterator<Character> queueIterator = this.queue().iterator();
		while (queueIterator.hasNext()) {
			Character element = queueIterator.next();
			AppView.output(element.toString() + " ");
		}
		AppView.outputLine("<Rear>");
	}

	private void showAllFromRear() {
		// ť�� ��� ���Ҹ� Rear���� Front���� ���
		AppView.output("[Queue] <Rear> ");
		for (int order = this.queue().size() - 1; order >= 0; order--) {
			AppView.output(this.queue().elementAt(order).toString() + " ");
		}
		AppView.outputLine("<Front>");
	}

	private void showFrontElement() {
		// Front ���� ���
		if (this.queue().isEmpty())
			AppView.outputLine("[Front.Empty] ť�� �� �� �� ���Ұ� �������� �ʽ��ϴ�.");
		else
			AppView.outputLine("[Front] ť�� �� �� ���Ҵ� '" + this.queue().front() + "' �Դϴ�.");
	}

	private void showRearElement() {
		// Rear ���� ���
		if (this.queue().isEmpty())
			AppView.outputLine("[Rear.Empty] ť�� �� �� �� ���Ұ� �������� �ʽ��ϴ�.");
		else
			AppView.outputLine("[Rear] ť�� �� �� ���Ҵ� '" + this.queue().rear() + "' �Դϴ�.");
	}

	private void showQueueSize() {
		// ť�� ũ�� ���
		AppView.outputLine("[Size] ť���� ���� " + this.queue().size() + "���� ���Ұ� �ֽ��ϴ�.");
	}

	private void showStatistics() {
		AppView.outputLine("");
		AppView.outputLine("<ť ��� ���>");
		AppView.outputLine("- �Էµ� ���ڴ� " + this.inputChars() + " �� �Դϴ�.");
		AppView.outputLine("- ���� ó���� ���ڴ� " + (this.inputChars() - this.ignoredChars()) + " �� �Դϴ�.");
		AppView.outputLine("- ���õ� ���ڴ� " + this.ignoredChars() + "�� �Դϴ�.");
		AppView.outputLine("- ���Ե� ���ڴ� " + this.pushedChars() + "�� �Դϴ�.");
	}

	// �Է� ����
	// ���� �Է�
	private char inputChar() {
		AppView.output("? ���ڸ� �Է��Ͻÿ�: ");
		return AppView.inputChar();
	}

	public void run() {
		AppView.outputLine("<<< ť ��� Ȯ�� ���α׷��� �����մϴ� >>>");
		AppView.outputLine("");

		char input = this.inputChar();
		while (input != '!') {
			this.countInputChar();
			if (Character.isAlphabetic(input)) {
				this.addToQueue(input);
				this.countAddedChar();
			} else if (Character.isDigit(input))
				this.removeN(Character.getNumericValue(input));
			else if (input == '-')
				this.removeOne();
			else if (input == '#')
				this.showQueueSize();
			else if (input == '/')
				this.showAllFromFront();
			else if (input == '\\')
				this.showAllFromRear();
			else if (input == '<')
				this.showFrontElement();
			else if (input == '>')
				this.showRearElement();
			else {
				AppView.outputLine("[Ignore] �ǹ� ���� ���ڰ� �ԷµǾ����ϴ�.");
				this.countIgnoredChar();
			}
			input = this.inputChar();
		}
		this.quitQueueProcessing();

		this.showStatistics();
		AppView.outputLine("");
		AppView.outputLine("<<< ť ��� Ȯ�� ���α׷��� �����մϴ� >>>");
	}

}// end of AppController
