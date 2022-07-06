package DS14_201802170_�ϻ�ȣ;

public class LinkedNode<E> {
	private E _element; // �ν��Ͻ� ����
	private LinkedNode<E> _next;

	public LinkedNode() { // ������
		this._element = null;
		this._next = null;
	}

	public LinkedNode(E givenElement, LinkedNode<E> givenNext) { // ������
		this._element = givenElement;
		this._next = givenNext;
	}

	public E element() { // getter
		return this._element;
	}

	public LinkedNode<E> next() { // getter
		return this._next;
	}

	public void setElement(E newElement) { // setter
		this._element = newElement;
	}

	public void setNext(LinkedNode<E> newNext) { // setter
		this._next = newNext;
	}
}