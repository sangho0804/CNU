package DS10_2_201802170_�ϻ�ȣ;

public interface Queue<E> {
	//�ݵ�� �ʿ��� method
	public int size();
	public boolean isFull();
	public boolean isEmpty();
	
	public E front();
	public E rear();
	
	public boolean enQueue(E anElement);
	public E deQueue();
	
	public void clear();
	
	//���Ǽ��� ���� method
	public E elementAt(int anOrder);
	public Iterator<E> iterator();
}
