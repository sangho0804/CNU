package DS13_201802170_�ϻ�ȣ;
public class Student implements Comparable<Student> {
	private static final int DEFAULT_SCORE = 0; // ���

	private int _score; // �ν��Ͻ� ����
	private String _id;

	public int score() { // getter
		return this._score;
	}

	public void setScore(int newScore) { // setter
		this._score = newScore;
	}
	
	public String id(){
		return this._id;
	}
	
	public void setId(String newId) {
		this._id = newId;
	}

	public Student() { // �л��� ������ DEFAULT_SCORE�� �ʱ�ȭ�Ͽ� ��ü ����
		this.setScore(DEFAULT_SCORE);
		this.setId(null);
	}

	public Student(int givenScore, String givenId) { // �л��� ������ givenScore�� �ʱ�ȭ�Ͽ� ��ü ����
		this.setScore(givenScore);
		this.setId(givenId);
	}

	@Override
	public int compareTo(Student other) {
		if (this.score() < other.score()) { // other���� �� ũ�� -1 
			return -1;
		} else if (this.score() == other.score()) { // other���� ������ 0
			return 0;
		} else { // other���� �� ������ 1
			return +1;
		}
	}
	
	public char Grade() {
		if (this.score() >= 90) {
			return 'A';
		} else if (this.score() >= 80) {
			return 'B';
		} else if (this.score() >= 70) {
			return 'C';
		} else if (this.score() >= 60) {
			return 'D';
		} else
			return 'F';
	}// �־��� aScore �� �ش��ϴ� ������ ��´�.



}
