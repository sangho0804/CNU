package DS13_201802170_�ϻ�ȣ;

public class AppController {
	private static final int VALID_MAX_SCORE = 100;
	private static final int VALID_MIN_SCORE = 0;
	private static final int VALID_MAX_LENGTH = 9;

	private Ban _ban; // ����� �ν��Ͻ� ����

	private Ban ban() { // getter
		return this._ban;
	}

	private void setBan(Ban newBan) {	// setter
		this._ban = newBan;
	}

	public AppController() { // ������
	}

	private static boolean scoreIsValid(int aScore) {	// ���� ��ȿ����
		return (aScore <= AppController.VALID_MAX_SCORE && aScore >= AppController.VALID_MIN_SCORE);
	}

	private static boolean studentIdIsValid(String id) {	// �й� ��ȿ����
		return ((id.length() >= VALID_MIN_SCORE) && (id.length() <= VALID_MAX_LENGTH));
	}

	private static DictionaryElement<String, Student> inputStudent() {	// �й��� ������ �Է¹޴� �޼ҵ�
		//id score �Ǻ�
		boolean idCheck = false;
		boolean scoreCheck = false;
		//��ü ����
		Student student = new Student();
		DictionaryElement<String, Student> studentInfo = new DictionaryElement<String, Student>();
		
		//id �Է�
		String id = AppView.inputId();
	
		if(!AppController.studentIdIsValid(id)) {
			idCheck = true;
		}
		//score �Է�
		int score = AppView.inputScore();
		if(!AppController.scoreIsValid(score)) {
			scoreCheck = true;
		}
		
		//���� ó��
		if(idCheck)
			AppView.outputLine("(����) �й��� ���̰� �ʹ� ��ϴ�. �ִ� " + AppController.VALID_MAX_LENGTH + "�Դϴ�.");
		if(scoreCheck)
			AppView.outputLine("(����) ������ " + VALID_MIN_SCORE + "���� �۰ų� " + AppController.VALID_MAX_SCORE
					+ "���� Ŀ��, �������� ������ �ƴմϴ�.");
		
		//��ȯ��
		if(idCheck || scoreCheck) {
			return null;
		}
		else
			student.setScore(score);
			student.setId(id);
			studentInfo.setKey(id);
			studentInfo.setObject(student);	
			return studentInfo;
	}

	private void inputAndStoreStudents() {	// ������ �й� ����
		AppView.outputLine("");
		boolean storingAStudentWasSuccessful = true;
		while (storingAStudentWasSuccessful && AppView.doesContinueToInputStudent()) {	
			DictionaryElement<String, Student> studentInfo = AppController.inputStudent();	// 
			if (studentInfo != null) {	// ���� �ԷµǸ�
				this.ban().addKeyAndObject(studentInfo.key(), studentInfo.object());	// studentInfo�� key���� object���� Ʈ���� �־��ش�.
			}
			AppView.outputLine("");	// �ٹٲ�
		}
		AppView.outputLine("! ���� �Է��� ��Ĩ�ϴ�.");
	}

	private void showStatistics() {
		AppView.outputLine("");
		AppView.outputLine("[�л� ���]");
		Iterator<DictionaryElement<String, Student>> iterator = this.ban().iterator();	// DictionaryElement�� Iterator
		DictionaryElement<String, Student> student = null;
		while (iterator.hasNext()) {
			student = iterator.next();
			AppView.outputLine("�й� : " + student.object().id() + ", ���� : " + student.object().score());	// �й��� ���� ���
		}
	}

	private void showGradeCounts() {
		AppView.outputLine("");
		AppView.outputLine("[�н� ���� ó�� ���]");

		AppView.outputTotalNumberOfStudents(this.ban().size());	// ��ü �л� ��
		AppView.outputAverageScore(this.ban().average());	// ��� ��
		AppView.outputNumberOfStudentsAboveAverage(this.ban().numberOfStudentsAboveAverage());	// ��� �̻��� �л� ��
		AppView.outputHighestScore(this.ban().highest().score());	// �ְ� ����
		AppView.outputLowestScore(this.ban().lowest().score());	// ���� ����
	}

	private void showStudentsSortedByScore() {
		AppView.outputLine("");
		AppView.outputLine("[�л����� ������ ���]");
		Student[] student = new Student[this.ban().size()];	// Student ��ü�� ����
		char[] grade = new char[this.ban().size()];	// ������ ���� ban ��ü ����
		student = this.ban().studentsSortedByScore(); // ���� ����
		for (int i = this.ban().size() - 1; i >= 0; i--) {
			this.ban();
			grade[i] = Ban.scoreToGrade(student[i].score());
			AppView.outputStudentInfo(student[i].id(), student[i].score(), grade[i]);
		}
	}

	public void run() {
		AppView.outputLine("");
		AppView.outputLine("<<< �б� ���� ó���� �����մϴ�. >>>");

		this.setBan(new Ban());
		this.inputAndStoreStudents();
		if (this.ban().isEmpty()) {
			AppView.outputLine("");
			AppView.outputLine("(����) �Էµ� ������ �����ϴ�.");
		} else {
			this.showStatistics();
			this.showGradeCounts();
			this.showStudentsSortedByScore();
			
		}
		AppView.outputLine("");
		AppView.outputLine("<<< �б� ���� ó���� �����մϴ�. >>>");
	}
}
