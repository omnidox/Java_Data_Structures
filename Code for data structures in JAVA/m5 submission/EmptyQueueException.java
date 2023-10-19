//Rafael Hidalgo

public class EmptyQueueException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmptyQueueException() {
		this(null);
	} // end default constructor

	public EmptyQueueException(String message) {
		super(message);
	} // end constructor
} // end EmptyQueueException
