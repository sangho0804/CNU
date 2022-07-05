package DS09_201802170_�ϻ�ȣ;

//ArrayList class
public class ArrayList<E extends Comparable<E>> implements Stack<E> {
	// Constants
	private static final int DEFAULT_CAPACITY = 5;

	// Private Instance Variables
	private int _capacity;
	private int _size;
	private E[] _elements;

	// Getters / Setters
	public int capacity() {
		return this._capacity;
	}

	public void setCapacity(int newCapapcity) {
		this._capacity = newCapapcity;
	}

	@Override
	public int size() {
		return this._size;
	}

	private void setSize(int newSize) {
		this._size = newSize;
	}

	private E[] elements() {
		return this._elements;
	}

	private void setElemnets(E[] newElements) {
		this._elements = newElements;
	}

	// Constructor
	@SuppressWarnings("unchecked")
	public ArrayList(int givenCapacity) {
		this.setCapacity(givenCapacity);
		this.setElemnets((E[]) new Comparable[this.capacity()]);
	}

	public ArrayList() {
		this(ArrayList.DEFAULT_CAPACITY);
	}

	// private methods
	private void makeRoomAt(int aPosition) {
		for (int i = this.size(); i > aPosition; i--) {
			this.elements()[i] = this.elements()[i - 1];
		}
	}

	private void removeGapAt(int aPosition) {
		for (int i = aPosition + 1; i < this.size(); i++) {
			this.elements()[i - 1] = this.elements()[i];
		}
		this.elements()[this.size() - 1] = null;
	}

	// public methods
	// ����
	@Override
	public boolean isEmpty() {
		return (this.size() == 0);
	}

	@Override
	public boolean isFull() {
		return (this.size() == this._capacity);
	}

	// ������ ���� Ȯ��
	public boolean doesContain(E anElement) {
		return (this.orderOf(anElement) >= 0);
	}

	// ���Ҹ� ���� index ��ȯ
	public int orderOf(E anElement) {
		// ������ ����ִٸ� return -1;
		// ������� �ʴٸ� �迭�� index���� ��ȯ
		int order = -1;
		for (int index = 0; index < this.size() && order < 0; index++) {
			if (this.elements()[index].equals(anElement)) {
				order = index;
			}
		}
		return order;
	}

	// �迭�� �߻�ȭ
	public E elementAt(int anOrder) {
		if (anOrder < 0 || anOrder >= this.size()) {
			return null;
		} else {
			return this.elements()[anOrder];
		}
	}

	// calss ���� �� ��� class �� ��밡��
	protected void setElementAt(int anOrder, E anElement) {
		if (anOrder < 0 || anOrder >= this.size()) {
			return;
		} else {
			this.elements()[anOrder] = anElement;
		}
	}

	// ����
	public boolean addToFirst(E anElement) {
		if (this.isFull()) {
			return false;
		} else {
			this.makeRoomAt(0);
			this.elements()[0] = anElement;
			this.setSize(this.size() + 1);
			return true;
		}
	}

	public boolean addToLast(E anelement) {
		if (this.isFull()) {
			return false;
		} else {
			this.elements()[this.size()] = anelement;
			this.setSize(this.size() + 1);
			return true;
		}
	}

	public boolean add(E anElement) { // ������ �ڸ� ����
		return this.addToLast(anElement);
	}

	// ����
	public E removeFirst() {
		if (this.isEmpty()) {
			return null;
		} else {
			E removedElement = this.elements()[0];
			this.removeGapAt(0);
			this.setSize(this.size() - 1);
			return removedElement;
		}
	}

	public E removeLast() {
		if (this.isEmpty()) {
			return null;
		} else {
			E removedElement = this.elements()[this.size() - 1];
			this.setSize(this.size() - 1);
			return removedElement;
		}
	}

	public E removeAny() {
		return this.removeLast();
	}

	public boolean remove(E anelement) {
		// ��ġ ã��
		int foundIndex = this.orderOf(anelement);
		// �����ϸ� ����
		if (foundIndex < 0) {
			return false; // not found.
		} else {
			// ���� �� �迭 ����
			this.removeGapAt(foundIndex);
			this.setSize(this.size() - 1);
			this.elements()[this.size()] = null;
			return true;
		}
	}

	@Override
	public boolean push(E anElement) {
		// TODO Auto-generated method stub
		return this.addToLast(anElement);
	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		return this.removeLast();
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return this.elementAt(this.size() - 1);
	}

	@Override
	public void clear() {
		for (int i = 0; i < this.size(); i++) {
			this.elements()[i] = null;
		}
		this.setSize(0);
	}

}// end of ArrayList
