package DS06_201802170_�ϻ�ȣ;
//Coin class
public class Coin implements Comparable<Coin> {
	//Constants
	private static final int DEFAUT_VALUE = 0;
	
	//Private instance variables
	//������ �ݾ�
	private int _value;
	
	//������
	public Coin() {
		this._value = this.DEFAUT_VALUE;
	}
	public Coin(int givenValue) { 
		this._value = givenValue;
	}
	
	//���� �Լ�
	public int value() {
		return this._value;
	}
	public void setValue(int newValue) {
		this._value = newValue;
	}
	//���Ұ� ���� ���� ��
	public boolean equals (Object otherCoin) {
		if(otherCoin.getClass() != Coin.class) {
			return false;
		}
		else {
			return (this.value() == ((Coin) otherCoin).value() );
		}
	}
	//���Ұ��� ��Ұ��� ��
	public int compareTo(Coin aCoin) {
		if (this.value() < aCoin.value()) {
			return -1;
		}
		else if(this.value() > aCoin.value()) {
			return 1;
		}
		else {
			return 0;
		}
	}
}//end of "Coin"
