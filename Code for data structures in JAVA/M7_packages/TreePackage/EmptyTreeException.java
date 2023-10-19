package TreePackage;

public class EmptyTreeException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmptyTreeException() {
		this(null);
	} // end default constructor

	public EmptyTreeException(String message) {
		super(message);
	} // end constructor

}
