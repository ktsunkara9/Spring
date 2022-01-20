package inc.skt.demo.json;

public class People {
	
	private String name;
	private String craft;
	
	public People() {}

	public People(String name, String craft) {
		this.name = name;
		this.craft = craft;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCraft() {
		return craft;
	}

	public void setCraft(String craft) {
		this.craft = craft;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", craft=" + craft + "]";
	}
	
}
