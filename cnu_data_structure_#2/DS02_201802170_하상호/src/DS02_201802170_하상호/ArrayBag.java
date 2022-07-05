package DS02_201802170_�ϻ�ȣ;

//Generic Calss

public class ArrayBag<E> {
	//��� ArrayBag ��ü���� �������� ���
	private static final int DEFAULT_CAPACITY = 100;
	//����� �ν��ϼ� ����
	private int _capacity;
	private int _size;
	private E[] _element; // ArrayBag�� ���ҵ��� ���� java �迭
	
	//�ν��Ͻ� ������ Getter / Setter
	//����� �Լ�
	//class ���ο����� ���
	
	private int capacity() {
		return this._capacity;
	}
	private void setCapacity(int newCapacity) {
		this._capacity = newCapacity;
	}
	private void setSize(int newSize) {
		this._size = newSize;
	}
	private E[] elements() {
		return this._element;
	}
	private void setElements(E[] newElements) {
		this._element = newElements;
	}
	
	   
	//������
	//generic type �� ����ϱ⿡ E �� Object �� �´��� �����.
	//������ Overiding "unchecked" �Ͽ� �Ѿ������
	@SuppressWarnings("unchecked")
	public ArrayBag() {
		this.setCapacity(ArrayBag.DEFAULT_CAPACITY);
		this.setElements((E[]) new Object [this.capacity()] );
		this.setSize(0);	
	}
	
	@SuppressWarnings("unchecked")
	public ArrayBag(int givenCapacity) {
		this.setCapacity(givenCapacity);
		this.setElements((E[]) new Object [this.capacity()] );
		this.setSize(0);
	} 
	
	//�����Լ�
	public int size() {
		return this._size;
		//_size�� ��ȯ
	}
	public boolean isEmpty() {
		return (this._size == 0);
		//_size �� 0���� Ȯ��
		//������ ����ִ��� Ȯ��
	}
	public boolean isFull() {
		return (this._size == this.capacity());
	//_size �� _capacity �� ������ Ȯ��
	//������ ���� �ִ��� Ȯ��
	}
	
	public boolean doesContain(E anElement) {
		boolean found = false;
		  for (int i = 0; i < _size; i++) {
	            if (this._element[i].equals(anElement)) 
	            	return true;
	        }
		return found;
		//anElement �� _element �� ������ ������ Ȯ��
	}
	public int frequencyOf(E anElement) {
		int frequencyCount = 0;
			for(int i = 0; i < this._size; i++){
				if(this._element[i].equals(anElement))
                frequencyCount++;
		}
		return frequencyCount;
		//anElement �� _element �� ������ ������ Ȯ��
		//���ٸ� frequenyCount ++
	}
	public boolean add(E anElemnet) {
		if(this.isFull() == true) {
			return false;
		}
		else {
			this.elements()[this.size()] = anElemnet;
			this.setSize(this.size()+1);
			return true;
		}//�迭 �߰�
		
	}
	public boolean remove(E anElement) {
		int removeCount = 0;
		//����ִ� ���
		if(this.isEmpty()) {
			return false;
		}
		else
		//�ش簪�� �������� ���� ���
		if(! this.doesContain(anElement)) {
			return false;
		}
		//�ش� ���� ���� �������� �迭�� ��ġ ����
			for(int count = 0; count < this._size; count++) {
				if(this._element[count].equals(anElement)) {
					removeCount= count;
					break;
				}
			}
			//����
			while(removeCount == this._size -1) {
				this.elements()[removeCount] = this.elements()[removeCount+1];
				removeCount ++;
			}
			//���� �� ó��
			this._size --;
			this._element[this._size] = null;
			return true;
		//�迭 ����
	}
	public void clear() {
		this._size = 0;
	//_size �ʱ�ȭ
	}
	public E elementAt (int order) {
		if((0 <= order) && (order < this.size())) {
			return this.elements()[order];
		}
		else {
			return null;
		}
		//�ش� ��ġ�� ���� ���Ҹ� ���
	}
}	//End of "ArrayBag"
