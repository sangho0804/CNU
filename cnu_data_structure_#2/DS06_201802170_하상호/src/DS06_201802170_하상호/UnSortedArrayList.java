package DS06_201802170_�ϻ�ȣ;

//UnSortedArrayList Class
public class UnSortedArrayList<E extends Comparable<E>> {
	// Constants
	private static final int DEFAULT_CAPACITY = 100;

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
	public UnSortedArrayList(int givenCapacity) {
		this.setCapacity(givenCapacity);
		this.setElemnets((E[]) new Comparable[this.capacity()]);
	}

	public UnSortedArrayList() {
		this(UnSortedArrayList.DEFAULT_CAPACITY);
	}
	// public methods

	public boolean addTo(E anElement, int anOrder) {
		if (this.size() == this.capacity()) { // ���� ������ ���� ��� false
			return false;
		} else if (anOrder < 0 || anOrder > this.size()) { //������ ��� ��� false
			return false;
		} else { //����
			this.elements()[anOrder] = anElement;
			this.setSize(this.size() + 1);
			return true;
		}
	}
	
	public boolean add(E anElement) { // ������ �ڸ� ����
		return this.addTo(anElement , this.size());

	}

	public E max() {
		if (this.size() == 0)
			return null; // �迭�� ����ִ� ���
		else {
			E maxElement = this.elements()[0];// �迭�� ó������ max�� ����
			for (int i = 1; i < this.size(); i++) { // ���������� ��
				if (maxElement.compareTo(this.elements()[i]) < 0)
					maxElement = this.elements()[i];// max���� ū���� max�� ���Ҵ�
			}
			return maxElement;
		}
	}

} // End Of Class "UnSortedArrayList"
