package DS02_201802170_�ϻ�ȣ;
//Controller
public class AppController {
	//���
	private static final int MENU_ADD = 1 ;
	private static final int MENU_REMOVE = 2 ;
	private static final int MENU_SEARCH = 3 ;
	private static final int MENU_FREQUENCY = 4 ;
	private static final int MENU_END_OF_RUN = 9 ;
	
	//����� �ν��Ͻ� ������
	private ArrayBag<Coin> _coinBag;
	//������
	private ArrayBag<Coin>coinBag() {
		return this._coinBag;
	}
	private void setCoinBag(ArrayBag<Coin> newCoinBag) {
		this._coinBag = newCoinBag;
	}
	
	//�����Լ�
	//run
	public void run() {
		AppView.outputLine("<<< ���� ���� ���α׷��� �����մϴ�. >>>>");
		AppView.outputLine("");
		
		int coinBagSize = AppView.inputCapacityOfCoinBag();
		this.setCoinBag(new ArrayBag<Coin> (coinBagSize));
		
		int menuNumber = AppView.inputMenuNumber();
		while( menuNumber != MENU_END_OF_RUN) {
			switch(menuNumber) {
			case MENU_ADD:
				this.addCoin();
				break;
			case MENU_REMOVE:
				this.removeCoin();
				break;
			case MENU_SEARCH:
				this.searchForCoin();
				break;
			case MENU_FREQUENCY:
				this.frequencyOfCoin();
				break;
			default:
				this.undefinedMenuNumber(menuNumber);
				
			}
			menuNumber = AppView.inputMenuNumber();
		}
		this.showStatistics();
		AppView.outputLine("<<< ���� ���� ���α׷��� �����մϴ�. >>>");
	}
	
	// ����� �Լ��� ����
	//Appview �� �̿��� �����
	private void addCoin() {
		if ( this.coinBag().isFull()){
			AppView.outputLine("- ���� ������ �� ���� ������ ���� �� �����ϴ�.") ;
			}
			else {
			int coinValue = AppView.inputCoinValue();
			if ( this.coinBag().add(new Coin(coinValue))) {
			AppView.outputLine("- �־��� ���� ���� ������ ���濡 ���������� �־����ϴ�.") ;
			}
			else {
			AppView.outputLine("- �־��� ���� ���� ������ ���濡 �ִµ� �����Ͽ����ϴ�.") ;
			}
		}
	}//remove
	private void removeCoin () {
		int coinValue = AppView.inputCoinValue();
		if (!this.coinBag().remove(new Coin(coinValue))) {
		AppView.outputLine("- �־��� ���� ���� ������ ���� �ȿ� �������� �ʽ��ϴ�.");
		}
		else {
		AppView.outputLine("- �־��� ���� ���� ���� �ϳ��� ���濡�� ���������� �����Ǿ����ϴ�.");
		}
	}
	//Search
	private void searchForCoin () {
		int coinValue = AppView.inputCoinValue();
		if(this.coinBag().doesContain (new Coin(coinValue))) {
		AppView.outputLine("- �־��� ���� ���� ������ ���� �ȿ� �����մϴ�.");
		}
		else {
		AppView.outputLine("- �־��� ���� ���� ������ ���� �ȿ� �������� �ʽ��ϴ�.");
		}
	}
	//Frequency
	private void frequencyOfCoin() {
		int coinValue = AppView.inputCoinValue();
		int frequency = this.coinBag().frequencyOf(new Coin(coinValue));
		AppView.outputLine("- �־��� ���� ���� ������ ������ " + frequency + " �� �Դϴ�.") ;
	}
	//����ó��
	private void undefinedMenuNumber (int menuNumber) {
		AppView.outputLine("- ���õ� �޴� ��ȣ " + menuNumber + " �� �߸��� ��ȣ�Դϴ�." );
	}
	//������ ��, ����ū�� ����
	private int sumOfCoinValues() {
		int sum = 0;
		for (int i = 0; i < this.coinBag().size(); i++) {
		sum += this.coinBag().elementAt(i).value();
		}
		return sum;
		}
		private int maxCoinValue() {
		int maxValue = 0;
		for (int i = 0; i < this.coinBag().size(); i++) {
		if (maxValue < this.coinBag().elementAt(i).value()) {
		maxValue = this.coinBag().elementAt(i).value();
			}
		}
		return maxValue;
		}
	private void showStatistics() {
		AppView.outputLine("���濡 ��� �ִ� ������ ����: " + this.coinBag().size());
		AppView.outputLine("���� �� ���� ū ��: " + this.maxCoinValue());
		AppView.outputLine("��� ���� ���� ��:" + this.sumOfCoinValues());
	}
	

}//End of class "APPController"
