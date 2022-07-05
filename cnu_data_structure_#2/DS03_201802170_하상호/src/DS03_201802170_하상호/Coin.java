package DS03_201802170_�ϻ�ȣ;
//Coin class
public class Coin {
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
	//otherCoin �� ���� class ���� Ȯ��
	//Coin �� �ƴϸ� false
	//Coin �� �´ٸ� value() ��
	//������ ���� ��� true �ƴҰ�� false
	/* Object Ÿ�� Ȯ��
	 * �� ������ CoinBag �̰�, Coin ���� �񱳸� �Ѵ�. 
	 * �ٸ� ��ü���� ��ü���� �񱳸� ���ؼ� ���� Ŭ������ Object Ÿ���� ����Ѵ�.
	 *  ��� calss �� Object �� ����Ѵ�.
	 */ 
	public boolean equals (Object otherCoin) {
		if(otherCoin.getClass() != Coin.class) {
			return false;
		}
		else {
			return (this.value() == ((Coin) otherCoin).value() );
		}
	}
}//end of "Coin"
