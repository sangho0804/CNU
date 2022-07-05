package DS06_201802170_�ϻ�ȣ;

//Experiment Class

import java.util.*;

public class Experiment {
	// Constants
	private static final int DEFAULT_NUMVER_OF_ITRATION = 5;
	private static final int DEFAULT_FIRST_SIZE = 10000; // ù ��° ���� ������ ũ��
	private static final int DEFAULT_SIZE_INCREMENT = 10000; // ���� ������ ũ�� ������

	// private instances
	private int _numberOfIteration;
	private int _firstSize;
	private int _sizeIncrement;
	private Coin[] _data;
	private MeasuredResult[] _measuredResults;

	// Getters / Setters
	public int numberOfIteration() {
		return this._numberOfIteration;
	}

	public void setNumberOfIteration(int newNumberOfIteration) {
		this._numberOfIteration = newNumberOfIteration;
	}

	public int firstSize() {
		return this._firstSize;
	}

	public void setFirstSize(int newFirstSize) {
		this._firstSize = newFirstSize;
	}

	public int sizeIncrement() {
		return this._sizeIncrement;
	}

	public void setSizeIncrement(int newSizeIncrement) {
		this._sizeIncrement = newSizeIncrement;
	}

	public int maxSize() { //�ִ�ũ��
		return (this.firstSize() + this.sizeIncrement() * (this.numberOfIteration() - 1));
	}

	public Coin[] data() {
		return this._data;
	}

	public void setData(Coin[] newData) {
		this._data = newData;
	}

	public MeasuredResult[] measuredResults() {
		return this._measuredResults;
	}

	public void setMeasuredResults(MeasuredResult[] newMeasuredResults) {
		this._measuredResults = newMeasuredResults;
	}

	// Constructor
	public Experiment() {
		this(DEFAULT_NUMVER_OF_ITRATION, DEFAULT_FIRST_SIZE, DEFAULT_SIZE_INCREMENT);
	}

	public Experiment(int givenNumberOfIteration, int givenFirstSize, int givenSizeIncrement) {
		this.setNumberOfIteration(givenNumberOfIteration);
		this.setFirstSize(givenFirstSize);
		this.setSizeIncrement(givenSizeIncrement);
		// �����͸� ���� �迭 ���� Ȯ��
		this.setData(new Coin[this.maxSize()]);
		// ����� ������ �迭 ���� ȹ��
		this.setMeasuredResults(new MeasuredResult[this.numberOfIteration()]);
	}

	// public methods

	public void generateData() { //���� ����
		Random random = new Random();
		for (int i = 0; i < this.maxSize(); i++) {
			int randomCoinValue = random.nextInt(this.maxSize());
			this.data()[i] = new Coin(randomCoinValue);
		}

	}
	// ���� methods
	
	public void measureForUnSortedArrayList() {
		// UnSorted Array�� ������ List �� ������ �����Ѵ�.
		
		@SuppressWarnings("unused")
		Coin maxCoin;
		
		long durationForAdd = 0, durationForMax = 0;
		long start, stop;
		
		int dataSize = this.firstSize(); //10000 ����
		for (int iteration = 0; iteration < this.numberOfIteration(); iteration++) {
			UnSortedArrayList<Coin> list = new UnSortedArrayList<Coin>(dataSize);
			for (int i = 0; i < dataSize; i++) { //5�� ����
				//���� ����
				start = System.nanoTime();
				list.add(this.data()[i]);
				stop = System.nanoTime();
				durationForAdd += (stop - start);
				//�ִ밪 ����
				start = System.nanoTime();
				maxCoin = list.max();
				stop = System.nanoTime();
				durationForMax += (stop - start);
			}
			this.measuredResults()[iteration] = new MeasuredResult(dataSize, durationForAdd, durationForMax);
			dataSize += this.sizeIncrement();
		}
	}

	public void measureForSortedArrayList() {
		// Sorted Array�� ������ List �� ������ �����Ѵ�.
		
		@SuppressWarnings("unused")
		Coin maxCoin;
		
		long durationForAdd =0, durationForMax = 0;
		long start, stop;
		
		int dataSize = this.firstSize();
		for (int iteration = 0; iteration < this.numberOfIteration(); iteration++) {
			SortedArrayList<Coin> list = new SortedArrayList<Coin>(dataSize);
			for (int i = 0; i < dataSize; i++) {
				start = System.nanoTime();
				list.add(this.data()[i]);
				stop = System.nanoTime();
				durationForAdd += (stop - start);
				
				start = System.nanoTime();
				maxCoin = list.max();
				stop = System.nanoTime();
				durationForMax += (stop - start);
			}
			this.measuredResults()[iteration] = new MeasuredResult(dataSize, durationForAdd, durationForMax);
			dataSize += this.sizeIncrement();
		}
	}
	
	
	public void measureForUnSortedLinkedList() {
		// UnSorted Linked�� ������ List �� ������ �����Ѵ�.
		
		@SuppressWarnings("unused")
		Coin maxCoin;
		
		long durationForAdd =0, durationForMax = 0;
		long start, stop;
		
		int dataSize = this.firstSize();
		for (int iteration = 0; iteration < this.numberOfIteration(); iteration++) {
			UnSortedLinkedList<Coin> list = new UnSortedLinkedList<Coin>();
			for (int i = 0; i < dataSize; i++) {
				start = System.nanoTime();
				list.add(this.data()[i]);
				stop = System.nanoTime();
				durationForAdd += (stop - start);
				
				start = System.nanoTime();
				maxCoin = list.max();
				stop = System.nanoTime();
				durationForMax += (stop - start);
			}
			this.measuredResults()[iteration] = new MeasuredResult(dataSize, durationForAdd, durationForMax);
			dataSize += this.sizeIncrement();
		}
	}
	
	public void measureForSortedLinkedList() {
		// Sorted Linked�� ������ List �� ������ �����Ѵ�.
		
		@SuppressWarnings("unused")
		Coin maxCoin;
		
		long durationForAdd =0, durationForMax = 0;
		long start, stop;
		
		int dataSize = this.firstSize();
		for (int iteration = 0; iteration < this.numberOfIteration(); iteration++) {
			SortedLinkedList<Coin> list = new SortedLinkedList<Coin>();
			for (int i = 0; i < dataSize; i++) {
				start = System.nanoTime();
				list.add(this.data()[i]);
				stop = System.nanoTime();
				durationForAdd += (stop - start);
				
				start = System.nanoTime();
				maxCoin = list.max();
				stop = System.nanoTime();
				durationForMax += (stop - start);
			}
			this.measuredResults()[iteration] = new MeasuredResult(dataSize, durationForAdd, durationForMax);
			dataSize += this.sizeIncrement();
		}
	}
	

} // end of  Class "Experiment"
