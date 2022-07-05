package DS07_201802170_�ϻ�ȣ;

//Ban class
public class Ban extends UnSortedArrayList<Student> {

	// Static method
	private static char scoreToGrade(int aScore) {
		if (aScore >= 90) {
			return 'A';
		}
		else if(aScore >= 80) {
			return 'B';
		}
		else if(aScore >= 70) {
			return 'C';
		}
		else if(aScore >= 60) {
			return 'D';
		}
		else return 'F';
	}// �־��� aScore �� �ش��ϴ� ������ ��´�.
	
	//Constructor
	public Ban() {
		super();
	}
	public Ban(int givenCapacity) {
		super(givenCapacity);
	}
	
	// Public Instance methods /private Instance methods
	//�ּڰ��� �޴� methods
	public Student lowest() {
		if(this.isEmpty()) {
			return null;
		}
		else {
			return this.lowestRecursively(0, this.size()-1);
		}
	}
	//�ּڰ��� ã�� private method
	private Student lowestRecursively(int left, int right) {
		if(left == right) return this.elementAt(left);
		else {
			Student lowestFromRights = lowestRecursively(left +1, right);
			if(lowestFromRights.compareTo(this.elementAt(left)) <= 0) {
				return lowestFromRights;
			}
			else {
				return this.elementAt(left);
			}
		}
	}// ������ ���� ���� �л��� ��´�.

	//�ִ밪�� �޴� methods
	public Student highest() {
		if(this.isEmpty()) {
			return null;
		}
		else {
			return this.highestRecursively(0, this.size()-1);
		}
	}
	//�ִ밪�� ã�� private method
	private Student highestRecursively(int left, int right) {
		if(left == right) return this.elementAt(left);
		else {
			Student highestFromRights = highestRecursively(left +1, right);
			if(highestFromRights.compareTo(this.elementAt(left)) >= 0) {
				return highestFromRights;
			}
			else {
				return this.elementAt(left);
			}
		}
	}// ������ ���� ���� �л��� ��´�.
	
	//������ �հ�
	public int sum() {
		if(this.isEmpty()) {
			return 0;
		}
		else {
			return this.sumOfScoresRecursively(0, this.size() -1);
		}
	}
	//������ �հ踦 ��ȯ�ϴ� private method
	private int sumOfScoresRecursively(int left, int right) {
		int mid = (left + right) / 2;
		if(left == right) return this.elementAt(left).score();
		else {
			int leftSum = this.sumOfScoresRecursively(left, mid);
			int rightSum = this.sumOfScoresRecursively(mid +1, right);
			return (leftSum + rightSum);
		}
	}// �б��� �л����� ������ �հ踦 ��´�.
	
	//��հ��� ��ȯ
	public double average() {
		if(this.isEmpty()) return 0;
		else return (((double) this.sum()) / ((double)this.size()));
	}
	//��պ��� ū �л����� ��ȯ
	public int numberOfStudentsAboveAverage() {
		double average = this.average();
		int numberOfStudentsAboveAverage = 0;
		Iterator<Student> iterator = this.iterator();
		while (iterator.hasNext()) {
			Student student = iterator.next();
			if(student.score() >= average) {
				numberOfStudentsAboveAverage++;
			}
		}
		return numberOfStudentsAboveAverage;
	}
	
	private void swap(int p, int q) {
		Student temp = this.elementAt(p);
		this.setElementAt(p, this.elementAt(q));
		this.setElementAt(q, temp);
	}
	
	private int partition(int left, int right) {
		int pivot = left;
		int toRight = left;
		int toLeft = right+1;
		do {
			do {toRight++;} while(this.elementAt(toRight).score() < this.elementAt(pivot).score());
			do {toLeft--;} while(this.elementAt(toLeft).score() > this.elementAt(pivot).score());
			if(toRight < toLeft) {
				this.swap(toRight, toLeft);
			}
		}while(toRight < toLeft);
		this.swap(left, toLeft);
		return toLeft;
	}
	
	private void quicksortRecursively(int left, int right) {
		if(left < right) {
			int mid = this.partition(left, right);
			this.quicksortRecursively(left, mid-1);
			this.quicksortRecursively(mid+1, right);
		}
	}
	
	public void sortByScore() {
		if(this.size() > 1) {
			int maxLoc = 0;
			for(int i = 1; i < this.size(); i++) {
				if(this.elementAt(i).score() > this.elementAt(maxLoc).score()) {
					maxLoc = i;
				}
			}
			this.swap(maxLoc, this.size()-1);
			this.quicksortRecursively(0, this.size()-2);
			}
		
	}// �б��� �л����� ���� ������ �����Ѵ�.
	

	public GradeCounter countGrades() {
		 GradeCounter gradeCounter = new GradeCounter();
	        Iterator<Student> iterator = this.iterator();
	        while( iterator.hasNext()){
	            Student student = iterator.next();
	            char grade = Ban.scoreToGrade(student.score());
	            gradeCounter.count(grade);
	        }
	        return gradeCounter;
	}// �б��� ������ �л����� ���� �ϰ�, �� ����� ������ �ִ� GradeCounter ��ü�� ��´�.
	
}//End of Ban class
