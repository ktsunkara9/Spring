package inc.skt.reactivespring.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Officer {

	@Id
	private String id;
	private Rank rank;
	private String firstName;
	private String lastName;

	public Officer() {
	}

	public Officer(Rank rank, String firstName, String lastName) {
		this.rank = rank;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Officer(String id, Rank rank, String firstName, String lastName) {
		this.id = id;
		this.rank = rank;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Officers [id=" + id + ", rank=" + rank + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
