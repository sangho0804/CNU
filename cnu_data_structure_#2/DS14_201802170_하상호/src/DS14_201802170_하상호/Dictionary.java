package DS14_201802170_�ϻ�ȣ;

public abstract class Dictionary<Key, Obj> {
	// Instance variable
	private VisitDelegate<Key, Obj> _visitDelegate;
	private int _size; // "private" �ӿ� ����. ��� �޴� class ������ getter/setter �� ���ؼ��� �����Ѵ�.
	// Getter/Setter

	public int size() {
		return this._size;
	}

	protected void setSize(int newSize) {
		this._size = newSize;
	}

	public VisitDelegate<Key, Obj> visitDelegate() {
		return this._visitDelegate;
	}

	public void setVisitDelegate(VisitDelegate<Key, Obj> newVisitDelegate) {
		this._visitDelegate = newVisitDelegate;
	}

	// Constructors
	public Dictionary() {
		this.setSize(0); // ��ӹ޴� class �� �����ڴ� �Ϲ������� ���� class�� �����ڸ� call �Ѵٴ� ���� ���� �� ��!
	}

	// Public non-abstract method: �� class ���� �����Ǿ�� �Ѵ�.
	public boolean isEmpty() {
		return (this._size == 0);
	}

	// Public abstract methods
	public abstract boolean isFull();

	public abstract boolean keyDoesExist(Key aKey);

	public abstract Obj objectForKey(Key aKey);

	public abstract boolean addKeyAndObject(Key aKey, Obj anObject);

	public abstract Obj removeObjectForKey(Key aKey);

	public abstract void clear();

	public abstract Iterator<DictionaryElement<Key, Obj>> iterator();

	public abstract void scanInSortedOrder();

	public abstract void scanInReverseOfSortedOrder();

} // End of class "Dictionary"
