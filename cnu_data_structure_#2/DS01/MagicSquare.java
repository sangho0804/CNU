package DS01_201802170_�ϻ�ȣ;

public class MagicSquare {
	private static final int DEFFAULT_MAX_ORDER = 99;
	
	private int _maxOrder;
	
	//Getters / Setters
	public int maxOrder() {
		return this._maxOrder;
	}
	private void setMaxOrder(int newMaxOrder) {
		this._maxOrder = newMaxOrder;
	}
	//�⺻ ������
	public MagicSquare() {
		this.setMaxOrder(MagicSquare.DEFFAULT_MAX_ORDER);
	}
	
	//�ִ� ������ ����ڰ� �����ϴ� ������
	public MagicSquare(int givenMaxOrder) {
		this.setMaxOrder(givenMaxOrder);
	}
	public Board solve(int anOrder) {
		if (OrderValidity.valididtyOf(anOrder) != OrderValidity.Valid) {
			return null;
		}
		else {
			Board board = new Board(anOrder);
			//������ �Բ� Board ��ü �����ڸ� call �Ͽ� , Board ��ü�� �����Ѵ�.
			CellLocation currentLoc = new CellLocation(0, anOrder/2);
			//��� ��ġ(������ �� ���� �� ���)�� ������ ��ġ�� �����Ѵ�.
			CellLocation nextLoc = new CellLocation();
			board.setCellValue(currentLoc, 1); //������ <�����ġ> �� 1�� ä���
			
			int lastValue = anOrder * anOrder;
			for(int cellValue = 2; cellValue <= lastValue; cellValue++) {
				//1�ܰ� <������ġ>�κ��� <������ġ>�� "������ ��"��ġ�� ����Ѵ�.
				int nextRow = (currentLoc.row() + anOrder - 1 ) % anOrder;
				int	nextCol = (currentLoc.col() + 1) % anOrder ;
				nextLoc = new CellLocation(nextRow, nextCol);
				//�ܰ�2 <������ġ>�� ä���� ������
				//<������ġ>�� <������ġ>�� �ٷ� �� �� �Ʒ� ĭ ��ġ�� �����Ѵ�.
				
				if(!board.cellsEmpty(nextLoc)) {
					nextLoc.setRow((currentLoc.row() + anOrder + 1 ) % anOrder);
					nextLoc.setCol(currentLoc.col());
				}
				//3�ܰ�<������ġ>�� ���ο� <���� ��ġ>�� �Ѵ�.
				currentLoc.setRow(nextLoc.row());
				currentLoc.setCol(nextLoc.col());
				//4�ܰ� ���ο� <���� ��ġ>��  number ���� �ִ´�.
				board.setCellValue(currentLoc, cellValue);
			}
			return board;
		}
	}//End of solve()
	
}//End of Class "MagicSquare"
