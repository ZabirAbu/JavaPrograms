//exception class that is used by the constructors of Run and Swim classes for unsuitable parameters

@SuppressWarnings("serial")

class InvalidActivityException extends Exception {
	
	public InvalidActivityException () {
		super();
		}
	//this will display a message when an exception is thrown from the Activity subclasses
	public InvalidActivityException (String msg) { 
		super(msg);
	}
}
