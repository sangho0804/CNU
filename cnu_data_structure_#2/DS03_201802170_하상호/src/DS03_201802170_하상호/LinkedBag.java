package DS03_201802170_�ϻ�ȣ;

//LinkedBag Class
public class LinkedBag<E> {
	//����� �ν��Ͻ� ����
	private int _size; //������ ������ �ִ� ������ ����
	private LinkedNode<E> _head; //���� ü���� �� �� ��带 �����Ѵ�.
	
	//���� Getter / Setter
	public int size() {
		return this._size;	
	}
	private void setSize(int newSize) {
		this._size = newSize;
	}
	private LinkedNode<E> head(){
		return this._head;
	}
	private void setHead(LinkedNode<E> newHead) {
		this._head = newHead;
	}
	
	//������
	public LinkedBag() {
		this.setSize(0);
		this.setHead(null);
	}
	//������ ����ִ��� Ȯ��
	public boolean isEmpty() {
		return (this.size() == 0);
	}
	//����ȿ� �־��� ���Ұ� �����ϴ��� Ȯ��
	public boolean doesContain(E anElement) {
		LinkedNode<E> currentNode = this.head();
		while(currentNode != null ) {
			if(currentNode.element().equals(anElement)) {
				return true;
			}
			else {
			currentNode = currentNode.next();
				}
			}
		return false;
	}
	//����ȿ� �־��� ���Ұ� �� �� �ִ��� Ȯ��
	public int frequencyOf(E anElement) {
		int frequenctCount = 0;
		LinkedNode <E> currentNode = this._head;
		while(currentNode != null) {
			if(currentNode.element().equals(anElement)) {
				frequenctCount ++;
			}
			currentNode = currentNode.next();
		}
		return frequenctCount;
	}
	//����ȿ� �־��� ������ ���Ҹ� ����
	public E elementAt(int anOrder) {
		if( (anOrder < 0) || (anOrder >= this.size())) {
			return null; //anOrder �� ���� ������ ��� ����
		}
		else { //anOrder�� ���� �ȿ� ����
			LinkedNode<E> currNode = this.head();
			for(int i = 0 ; i < anOrder ; i ++) {
				currNode = currNode.next();
			}
			return currNode.element();
			
		}
	}
	//���濡 ���Ҹ� �߰�
	public boolean add(E anElement) {
		LinkedNode<E> newNode = new LinkedNode<E>();
		newNode.setElement(anElement);
		newNode.setNext(this._head);
		this.setHead(newNode);
		this.setSize(this.size() + 1);
		return true;
	}
	//���濡�� ���Ҹ� ����
	public boolean remove(E anElement) {
		if(this.isEmpty()) {
			return false;
		}
		else {
			LinkedNode <E> previousNode = null;
			LinkedNode <E> currentNode = this._head;
			boolean found = false;
			//������ ��ġ ã��
			while(currentNode != null &&!found) {
				if(currentNode.element().equals(anElement)) {
					found = true;
				}
				else {
					previousNode = currentNode;
					currentNode = currentNode.next();
				}
			}
			//����
			if(!found) {
				return false;
			}
			else {
				if(currentNode == this.head()) {
					this.setHead(this.head().next());
				}
				else {
					previousNode.setNext(currentNode.next());
					
				}
				this.setSize(this.size() - 1);
				return true;
			}
		}

	}
	//���� �ϳ��� �������� ����
	//�� ���� ����
	public E removeAny() {
		if(this.isEmpty()) {
			return null;
		}
		else {
			E remvedElement = this.head().element();
			this.setHead(this.head().next());
			this.setSize(this.size() - 1);
			return remvedElement;
		}
	}
	//���� �ʱ�ȭ
	public void clear() {
		this.setSize(0);
		this.setHead(null);
	}
	
}//end of LinkedBag
