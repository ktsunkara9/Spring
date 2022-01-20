package inc.skt.demo.json;

import java.util.List;

public class Spaceonauts {

	private String message;
	private int number;
	private List<People> people;

	public Spaceonauts() {
	}

	public Spaceonauts(String message, int number, List<People> people) {
		this.message = message;
		this.number = number;
		this.people = people;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public List<People> getPeople() {
		return people;
	}

	public void setPeople(List<People> people) {
		this.people = people;
	}

	@Override
	public String toString() {
		return "Spaceonauts [message=" + message + ", number=" + number + ", people=" + people + "]";
	}

}
