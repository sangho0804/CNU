package DS07_201802170_�ϻ�ȣ;
// AppController

public class AppController {
	//constant
	private static final int VALID_MAX_SCORE = 100;
	private static final int VALID_MIN_SCORE = 0;
	
	private static final int BAN_CAPACITY = 10;
	
	//�Է��� ������ ������ ����� �ʴ��� Ȯ��
	private static boolean scoreIsValid(int aSocre) {
		return ( aSocre >= AppController.VALID_MIN_SCORE && 
				aSocre <= AppController.VALID_MAX_SCORE);
	}
	//���� �Է�
	private static Student inputStudent() {
		int score = AppView.inputScore();
		while(! AppController.scoreIsValid(score)) {
			AppView.outputLine("[����] " + 
			AppController.VALID_MIN_SCORE + " ���� �۰ų� " + 
					AppController.VALID_MAX_SCORE + " ���� Ŀ��, �������� ������ �ƴմϴ�.");
			score = AppView.inputScore();
		}
		Student student = new Student();
		student.setScore(score);
		return student;
	}
	// private instance variable
	private Ban _ban;
	private GradeCounter _gradeCounter;
	

	// Getters / Setters
	private Ban ban() {
		return this._ban;
	}
	private void setBan (Ban newBan) {
		this._ban = newBan;
	}
	private GradeCounter gradeCounter() {
		return this._gradeCounter;
	}
	private void setGradeCounter (GradeCounter newGradeCounter) {
		this._gradeCounter = newGradeCounter;
	}

	// constructor
	public AppController() {
	}

	// private method
	//������ ban ��ü�� ����
	private void inputAndStroeStudent() {
		AppView.outputLine("");
		boolean storingAStudentWasSuccessful = true;
		while(storingAStudentWasSuccessful && AppView.doesContinueToInputStudent()) {
			Student student = AppController.inputStudent();
			if(! this.ban().add(student)) {
				AppView.outputLine("(���) �Է¿� ������ �ֽ��ϴ�. �б޿� ���̻� �л��� ���� ������ �����ϴ�.");
				storingAStudentWasSuccessful = false;
			}
		}
		AppView.outputLine("! ���� �Է��� ��Ĩ�ϴ�.");
	}
	//���� ��� ���
	//�л��� , �ְ� ����, ���� ����, ��� ����. ����̻��� �л���
	private void showStatistics() {
		AppView.outputLine("");
		AppView.outputLine("[�б� ���� ���]");
		
		AppView.outputNumberOfStudents(this.ban().size());
		AppView.outputHighestScore(this.ban().highest().score());
		AppView.outputLowestScore(this.ban().lowest().score());
		AppView.outputAverageScore(this.ban().average());
		AppView.outputNumberOfStudentsAboveAverage(this.ban().numberOfStudentsAboveAverage());
	}
	//������ �л��� ���
	private void showGradeCounts() {
		AppView.outputLine("");
		AppView.outputLine("[������ �л���]");
		
		this.setGradeCounter(this.ban().countGrades());
		AppView.outputNumberOfStudentsForGrade('A', this.gradeCounter().numberOfA());
		AppView.outputNumberOfStudentsForGrade('B', this.gradeCounter().numberOfB());
		AppView.outputNumberOfStudentsForGrade('C', this.gradeCounter().numberOfC());
		AppView.outputNumberOfStudentsForGrade('D', this.gradeCounter().numberOfD());
		AppView.outputNumberOfStudentsForGrade('F', this.gradeCounter().numberOfF());
	}
	//������ ��� ���
	private void showStudentsSortedByScore() {
		AppView.outputLine("");
		AppView.outputLine("[�л����� ������ ���]");
		
		this.ban().sortByScore();
		
		Iterator<Student> iterator = this.ban().iterator();
		Student student = null;
		while (iterator.hasNext()) {
			student = iterator.next();
			AppView.outputScore(student.score());
		}
	}
	
	
	// public method
	public void run() {
		AppView.outputLine("");
		AppView.outputLine("<<<�б� ���� ó���� �����մϴ� >>>");
		
		this.setBan(new Ban(AppController.BAN_CAPACITY));
		this.inputAndStroeStudent();
		if(this.ban().isEmpty()) {
			AppView.outputLine("");
			AppView.outputLine("(���) �Էµ� ������ �����ϴ�.");
		}
		else {
			this.showStatistics();
			this.showGradeCounts();
			this.showStudentsSortedByScore();
		}
		AppView.outputLine("");
		AppView.outputLine("<<< �б� ���� ó���� �����մϴ�. >>>");
	
	}

}// End of class "AppController"
