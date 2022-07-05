package DS01_201802170_�ϻ�ȣ;

public class CellLocation {
	//Constant
	private static final int UNDEFINED_INDEX = -1;
	
	//Private instance variables
	private int _row;
	private int _col;
	
	//Getter / Setter
	public void setRow(int newRow) {
		this._row = newRow;
	}
	public int row() {
		return this._row;
	}
	public void setCol(int newCol) {
		this._col = newCol;
	}
	public int col() {
		return this._col;
	}
	
	//�⺻ ������ : Cell ��ǥ�� �־����� �ʴ´�.
	public CellLocation() {
		
		//Cell ��ǥ�� �־����� ������ (-1, -1)�� �����ϱ�� �Ѵ�.
		this.setRow(UNDEFINED_INDEX);
		this.setCol(UNDEFINED_INDEX);
	}
	//Cell ��ǥ�� �־����� ������
	public CellLocation(int givenRow , int givenCol) {
		this.setRow(givenRow);
		this.setCol(givenCol);
	}
	

} //End of class "CellLocation"
