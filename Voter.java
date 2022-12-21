package votingsystem;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Voter {

	private Integer id;

	private String firstName;

	private String lastName;

	private LocalDate dateofbirth;

	private Gender gender;

	private String username;

	private String password;

	boolean hasvoted;

	public Voter() {
		super();
	}

	public Voter(Integer voterid, String firstName2, String lastName2, Date dob, Gender g, String username2,
			String password2, Object hasvoted2, Integer id, String firstName, String lastName, Gender gender,
			String username, String password, boolean hasvoted, LocalDate dateofbirth) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateofbirth = dateofbirth;
		this.username = username;
		this.password = password;
		this.hasvoted = hasvoted;
		
	}

	public Voter(String firstName, String lastName, Gender gender, String username, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.username = username;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public LocalDate getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(LocalDate dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isHasvoted() {
		return hasvoted;
	}

	public boolean setHasvoted(boolean hasvoted) {
		return this.hasvoted = hasvoted;
	}

	@Override
	public String toString() {
		return "Voter [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dateofbirth="
				+ dateofbirth + ", gender=" + gender + ", username=" + username + ", password=" + password
				+ ", hasvoted=" + hasvoted + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateofbirth, firstName, gender, hasvoted, id, lastName, password, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voter other = (Voter) obj;
		return Objects.equals(dateofbirth, other.dateofbirth) && Objects.equals(firstName, other.firstName)
				&& gender == other.gender && hasvoted == other.hasvoted && Objects.equals(id, other.id)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password)
				&& Objects.equals(username, other.username);
	}

}
