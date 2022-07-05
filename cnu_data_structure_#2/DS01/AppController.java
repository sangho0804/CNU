package DS01_201802170_�ϻ�ȣ;
//Controller
public class AppController {
	// ���� ���
	public static final int MIN_ORDER = 3;
	public static final int MAX_ORDER = 99;

	// ����� ������
	private MagicSquare _magicSquare;
	
	//������
	public AppController()
	{
		this._magicSquare = new MagicSquare(AppController.MAX_ORDER);
		
	}
	//������Լ� ����
	//3���� ũ�ų� ���� ������ �ƴ� ���� �޾����� ���� ���
	private void showOrderValidityErrorMessage(OrderValidity orderValidity) 
	{
		switch (orderValidity) {
			case TooSmall:
			AppView.outputLine(
					"[����] ������ �ʹ� �۽��ϴ�." + AppController.MIN_ORDER+
					"���� ũ�ų� ���ƾ� �մϴ�.");
				break;
			case TooLarge:
				AppView.outputLine(
						"[����] ������ �ʹ� Ů�ϴ�." + AppController.MAX_ORDER +
						"���� �۰ų� ���ƾ� �մϴ�.");
				break;
			case NotOddNumber:
				AppView.outputLine("[����] ������ ¦���Դϴ�. Ȧ���̾�� �մϴ�.");
				break;
			default:
				break;
		}
	}
	//showTitleForColumnlndexes
	private void showTitleForColumnlndexes(int order) {
		AppView.output("      ");
		for(int col = 0; col < order; col++) {
			AppView.output(String.format(" [%3d]", col));
		}
		AppView.outputLine("");
	}
	//����� �Լ�
	//������ ���
	private void showBoard(Board board)
	{
		CellLocation currentLoc = new CellLocation();
		this.showTitleForColumnlndexes(board.order());
		for(int row = 0; row < board.order(); row++) {
			AppView.outputRowNomber(row);
			for(int col = 0; col < board.order(); col++) {
				currentLoc.setRow(row);
				currentLoc.setCol(col);
				AppView.outputCellValue(board.cellValue(currentLoc));
			}
			AppView.outputLine("");
		}
	}
	//�����Լ� ����
	public void run() {
		AppView.outputLine("<<< ������ Ǯ�̸� �����մϴ� >>>");
		AppView.outputLine("");
		
		int currentOrder = AppView.inputOrder(); //�޽����� �������� ������ �Է¹���
		OrderValidity currentValidity = OrderValidity.valididtyOf(currentOrder);
		while(currentValidity != OrderValidity.EndOfRun) { // ������ �����̸� ���α׷� ����
			if (currentValidity == OrderValidity.Valid) { // ������ ��ȿ���� �˻�
				AppView.outputTitleWithOrder(currentOrder);
				Board solvedBoard = this._magicSquare.solve(currentOrder);
				//_magicSquare ��ü���� �־��� ������ �������� Ǯ���� ��Ų��.
				//����� ������ ���� ��´�.
				this.showBoard(solvedBoard); //�������� ȭ�鿡 �����ش�.
			}
			else {
				//����ó��
				this.showOrderValidityErrorMessage(currentValidity);
			
			}
			
		currentOrder = AppView.inputOrder(); //���� �������� ���� ������ �Է¹���
		currentValidity = OrderValidity.valididtyOf(currentOrder);
		}
		AppView.outputLine("");
		AppView.outputLine("<<<������ Ǯ�̸� �����մϴ�>>>");
	}
}//End of Class "AppController"
