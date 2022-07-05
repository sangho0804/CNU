package DS09_201802170_�ϻ�ȣ;
//CalculatorException class
public class CalculatorException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// private Instance variables
	// �����ڵ带 ������ intance variable
	private CalculatorError _error;

	// Getter / Setter
	public CalculatorError error() {
		return this._error;
	}

	public void setError(CalculatorError newError) {
		this._error = newError;
	}

	// Constructors
	public CalculatorException() {
		this.setError(CalculatorError.Undefined);
	}

	public CalculatorException(CalculatorError givenError) {
		this.setError(givenError);
	}

}//end of CalculatorException
