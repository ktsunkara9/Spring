package inc.skt.reactivespring.json;

public class JokeResponse {
	
	private String type;
	private Value value;
	
	public JokeResponse() {	}

	public JokeResponse(String type, Value value) {
		super();
		this.type = type;
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Value getValue() {
		return value;
	}

	public void setValue(Value value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "JokeResponse [type=" + type + ", value=" + value + "]";
	}
	
}
