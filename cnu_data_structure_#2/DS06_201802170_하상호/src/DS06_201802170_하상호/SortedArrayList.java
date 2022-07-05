package DS06_201802170_�ϻ�ȣ;

//SortedArrayList Class
public class SortedArrayList<E extends Comparable<E>> {

	// constants
	private static final int DEFAULT_CAPACITY = 100;

	// Private Instances
	private int _capacity;
	private int _size;
	private E[] _elements;

	// Getter / Setters
	public int capacity() {
		return this._capacity;
	}

	public void setCapacity(int newCapacity) {
		this._capacity = newCapacity;
	}

	public int size() {
		return this._size;
	}

	public void setSize(int newSize) {
		this._size = newSize;
	}

	public E[] elements() {
		return this._elements;
	}

	public void setElements(E[] newElements) {
		this._elements = newElements;
	}

	// Constructors
	public SortedArrayList() {
		this (SortedArrayList.DEFAULT_CAPACITY);
	}

	@SuppressWarnings("unchecked")
	public SortedArrayList(int givenCapacity) {
		this.setCapacity(givenCapacity);
		this.setElements((E[]) new Comparable[this.capacity()]);
	}

	// public methods

	public boolean add(E addForData) {
		if (this.size() == this.capacity()) {
			return false; // ����Ұ� �� �� �ִٸ� false
		} else {
			//��ġ ã��
			int _position;
			for (_position = 0; _position < this.size(); _position++) {
				if (addForData.compareTo(this.elements()[_position]) == -1) break;
			}
			if (_position >= 0 && _position <= this.size()) {
				// _Position �� ���Թ����� ����ٸ� false
				for (int i = this.size(); i > _position; i--) {
					this.elements()[i] = this.elements()[i - 1];
				}
				//����
				this.elements()[_position] = addForData;
				this.setSize(this.size() + 1);
				return true;
			}
			else return false;
		}
	}

	public E max() { //������ �� ��ȯ
		if (this.size() == 0)
			return null;
		else
			return this.elements()[this.size() - 1];

	}
}//End of class "SortedArrayList"
