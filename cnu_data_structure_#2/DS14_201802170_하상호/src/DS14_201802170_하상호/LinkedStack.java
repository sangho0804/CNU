package DS14_201802170_�ϻ�ȣ;
public class LinkedStack<E> implements Stack<E> {

	private int _size; // ������ ����
	private LinkedNode<E> _head; // �� �� ���

	private boolean anElementDoesExistAt(int anOrder) { // anOrder�� ��ȿ���� �Ǵ��ϱ� ���� �޼ҵ�
		return ((anOrder >= 0) && (anOrder < this._size));
	}

	public LinkedStack() { // ������
		this._head = null;
		this._size = 0;
	}

	public boolean isEmpty() { // �� ��� �Ǵ�
		return (this._head == null);
	}

	public boolean isFull() { // ���� ��� �Ǵ�
		return false;
	}

	public int size() { // getter
		return this._size;
	}

	public E elementAt(int anOrder) {
		if (this.anElementDoesExistAt(anOrder)) {
			LinkedNode<E> currentNode = this._head;
			int nodeCount = 0;
			while (nodeCount < anOrder) {
				currentNode = currentNode.next();
				nodeCount++;
			}
			return currentNode.element();
		} else {
			return null;
		}
	}

	public E first() {
		if (this.isEmpty()) { // ����Ʈ�� ���������
			return null;
		} else {
			return elementAt(0); // �� �� �� return
		}
	}

	public E last() {
		if (this.isEmpty()) { // ����Ʈ�� ���������
			return null;
		} else {
			return elementAt(this._size - 1); // (������ ���� -1)�� ��ġ
		}
	}

	public int orderOf(E anElement) {
		int order = 0;
		LinkedNode<E> currentNode = this._head;
		while (currentNode != null && (!currentNode.element().equals(anElement))) { // anElement�� ���� ���� ��� ��带 ã����
																					// while�� Ż��
			order++;
			currentNode = currentNode.next(); // ����� �̵�
		}
		if (currentNode == null) { // ��忡 ��� ���� ���� ��
			return -1; // -1 return
		} else {
			return order; // order�� return
		}
	}

	public boolean doesContain(E anElement) {
		return (orderOf(anElement) != -1);
	}

	public boolean addTo(E anElement, int anOrder) {
		if ((anOrder < 0) || (anOrder > this._size)) { // anOrder�� ��ȿ �Ǵ�
			return false;
		} else if (this.isFull()) {
			return false;
		} else {
			LinkedNode<E> nodeForAdd = new LinkedNode<E>(anElement, null);
			if (anOrder == 0) { // �� �� ������ ����
				nodeForAdd.setNext(this._head);
				this._head = nodeForAdd;
			} else { // previous ��尡 �����Ѵ�
				LinkedNode<E> previous = this._head;
				for (int i = 1; i < anOrder; i++) {
					previous = previous.next(); // ������ ��ġ�� �� ��带 ã�´�
				}
				nodeForAdd.setNext(previous.next());
				previous.setNext(nodeForAdd);
			}
			this._size++;
			return true;
		}
	}

	public boolean addToFirst(E anElement) { // �� �� ����
		return this.addTo(anElement, 0);
	}

	public boolean addToLast(E anElement) { // �� �� ����
		return this.addTo(anElement, this._size);
	}

	public boolean add(E anElement) {
		return this.addToFirst(anElement); // addToLast�� �ϰ� �Ǹ� ������ ������ �д� ������ �ʿ��ϴ�.
	}

	public E removeFrom(int anOrder) {
		if (!anElementDoesExistAt(anOrder)) { // ��ȿ �Ǵ�
			return null;
		} else { // ������ ���Ұ� �ִٸ�
			LinkedNode<E> removed = null;
			if (anOrder == 0) { // ������ ���Ұ� �� �� ����
				removed = this._head;
				this._head = this._head.next();
			} else { // ���Ұ� �� �� �̻�
				LinkedNode<E> previous = this._head;
				for (int i = 0; i < anOrder - 1; i++) {
					previous = previous.next();
				}
				removed = previous.next(); // anOrder�� �� ��� ���� previous�̹Ƿ� ������ anOrder�� ���� previous.next
				previous.setNext(removed.next()); // ������ ����� ���� ��带 previous.next�� ����
			}
			this._size--; // �ϳ��� �����Ǿ����Ƿ� -1
			return removed.element(); // ������ ���� ����
		}
	}

	public E removeLast() {
		return (this.removeFrom(this._size - 1)); // ���� ������ ��带 ���� (element�� ����Ǿ��ִ� ������ ���� size-1��° ���)
	}

	public boolean replaceAt(E anElement, int anOrder) {
		if (!this.anElementDoesExistAt(anOrder)) {
			return false;
		} else {
			LinkedNode<E> current = this._head;
			for (int i = 0; i < anOrder; i++) {
				current = current.next();
			}
			current.setElement(anElement);
			return true;
		}
	}

	public void clear() { // clear
		this._head = null;
		this._size = 0;
	}

	@Override
	public boolean push(E anElement) { // Top�� ���� �߰�
		return this.addToLast(anElement);
	}

	@Override
	public E pop() { // Top ���� ����
		return this.removeLast();
	}

	@Override
	public E peek() { // Top ����
		if (this.isEmpty()) { // ���������
			return null;
		} else {
			return this.elementAt(this.size() - 1);
		}
	}

}