package DS06_201802170_�ϻ�ȣ;

//SortedLinkedList Class
public class SortedLinkedList <E extends Comparable<E>> {
	//constant
	private static final int DEFAULT_CAPACITY = 100;
	//private variables
	private int _capacity;
	private int _size;
	private LinkedNode<E> _head;
	//Constructors
	public SortedLinkedList() {
		this(SortedLinkedList.DEFAULT_CAPACITY);
		this.setHead(null);
		this.setSize(0);
	}
	public SortedLinkedList(int givenCapapcity) {
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
	
	//public methods
	public boolean add (E anElement) {
		// ���� ���� anElement�� �迭�� sort ������ �´� ��ġ�� ã�� ����
		if(this.size() == this.capacity())
			return false;
		else {
			LinkedNode<E> nodeForAdd = new LinkedNode<E>(anElement, null) ;
				if ( this.size() == 0 ) {
					this.setHead(nodeForAdd);
				}
		else { // ����Ʈ���� ��� �ϳ��� ��尡 �ִ�.
			LinkedNode<E> current = this.head(); // ���� ���ϴ� ���
			LinkedNode<E> previous = null; // current �� �� ���. ������ �Ϸ���, �� ��带 �˾ƾ� �Ѵ�. 
				while ( current != null ) { // ����Ʈ�� ���� ������ �� ���� �� �˻��Ѵ�.
					if (current.element().compareTo(anElement) > 0) { 
						// ������ ���Ұ� ������ anElement ���� ũ��
						break; // ������ ��ġ�� ã�� ���̹Ƿ� �� �˻� ����
					}
					previous = current ; // �ƴ� ��� previous�� current �� ����
					current = current.next() ; // current �� ���� ���� �̵�
				}
				if ( previous == null ) { // anElement �� ���� �۴�. �� �տ� �����Ѵ�
					nodeForAdd.setNext(this.head()) ;
					this.setHead(nodeForAdd) ;
					}
				else {
					nodeForAdd.setNext(current) ; 
					previous.setNext(nodeForAdd) ;
				}
		}
		this.setSize(this.size()+1) ; // ũ�⸦ �ϳ� ������Ų��. 
		return true ;
		}
		
	}

	
	 public E max(){
	        if(this.size() == 0) return null; //����Ʈ�� ����� ������
	        else {
	            LinkedNode<E> current = this.head();
	            E max = this.head().element(); //ù��° ����� ����
	            while(current != null){//����Ʈ�� ���������� ���� ���ؼ�
	                if(max.compareTo(current.element()) < 0)//�����̸�, max�� �۱� ������, ���Ҵ�
	                    max = current.element();//max���� current�� ���Ҹ� ��ȯ
	                current = current.next();
	            }
	            return max;
	        }
	    }
}//End of SortedLinkedList

