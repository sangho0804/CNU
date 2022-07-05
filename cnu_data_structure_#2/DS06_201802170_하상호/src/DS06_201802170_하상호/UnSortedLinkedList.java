package DS06_201802170_�ϻ�ȣ;
//UnSortedLinkedList Class
public class UnSortedLinkedList<E extends Comparable<E>> {
	//constant
	private static final int DEFAULT_CAPACITY = 100;
	// private values
	private int _capacity;
	private int _size;
	private LinkedNode<E> _head;

	//Constructors
	public UnSortedLinkedList() {
		this(UnSortedLinkedList.DEFAULT_CAPACITY);
		this.setHead(null);
		this.setSize(0);
	}

	public UnSortedLinkedList(int givenCapapcity) {
		// TODO Auto-generated constructor stub
		this.setCapacity(givenCapapcity);
		this.setHead(null);
		this.setSize(0);
	}
	
	//Getter / Setter
	public int capacity() {
		return this._capacity;
	}

	private void setCapacity(int setCapacity) {
		this._capacity = setCapacity;
	}

	public int size() {
		return this._size;
	}

	private void setSize(int newSize) {
		this._size = newSize;
	}

	private LinkedNode<E> head() {
		return _head;
	}

	private void setHead(LinkedNode<E> newHead) {
		this._head = newHead;
	}

	// public methods

	public boolean addTo(E anElement, int Order) {
		// Order ������ anElement�� ������ �ϴ� ��� ����
		if ((0 > Order) || (Order > this.size())) {
			// Order�� ��ȿ���� Ȯ��
			return false;
		}
		LinkedNode<E> nodeForAdd = new LinkedNode<E>(anElement, null);
		if (Order == 0) { // Node ������ �� ���� ��, previous ��尡 ���� ���
			nodeForAdd.setNext(this.head());
			setHead(nodeForAdd);
		} else { // previous ��尡 �ִ� ���
			LinkedNode<E> previous = this.head();
			for (int i = 1; i < Order; i++) {
				previous = previous.next();
			}
			nodeForAdd.setNext(previous.next());
			previous.setNext(nodeForAdd);
		}
		this.setSize(this.size() + 1);
		return true;
	}

	public boolean add(E anElement) {
		// ó���� �ִ� ���� :for���� �ȵ��Ƶ� ��
		return this.addTo(anElement, 0);
	}

	public E max() {
		if (this.size() == 0)
			return null; // ����Ʈ�� ����� ������
		else {
			LinkedNode<E> current = this.head();
			E max = this.head().element(); // ù��° ����� ����
			while (current != null) {// ����Ʈ�� ���������� ���� ���ؼ�
				if (max.compareTo(current.element()) < 0)// �����̸�, max�� �۱� ������, ���Ҵ�
					max = current.element();// max���� current�� ���Ҹ� ��ȯ
				current = current.next();
			}
			return max;
		}
	}
}//End of UnSortedLinkedList
