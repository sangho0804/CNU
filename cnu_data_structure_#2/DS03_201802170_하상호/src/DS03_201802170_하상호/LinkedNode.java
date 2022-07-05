package DS03_201802170_�ϻ�ȣ;

//LinkedNode Class
public class LinkedNode<E> {
	//����� �ν��Ͻ� ����
	private E _element; //���� ��忡 �ִ� ����
	private LinkedNode<E> _next; //���� ���
	
	//������
	public LinkedNode() {
		this._element = null;
		this._next = null;
	}
	
	public LinkedNode(E givenElement) {
		this._element = givenElement;
		this._next = null;
	}
	
	public LinkedNode(E givenElement, LinkedNode<E> givenNext) {
		this._element = givenElement;
		this._next = givenNext;
	}
	
	//Getter / Setter
	public E element() {
		return this._element;
	}
	public void setElement(E newElement) {
		this._element = newElement;
	}
	public LinkedNode<E>next(){
		return this._next;
	}
	public void setNext(LinkedNode<E> newNext) {
		this._next = newNext;
	}

	

}//end of LinkedNode
