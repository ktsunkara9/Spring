package inc.skt.demo.json;


public class Greeting {
	private String message;
	
	public Greeting() { //We need to have a default constructor for the tests to run as Junit uses Reflection Mechanism
	}

	public Greeting(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Greeting [message=" + message + "]";
	}

}
