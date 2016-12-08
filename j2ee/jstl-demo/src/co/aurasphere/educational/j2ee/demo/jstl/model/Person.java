package co.aurasphere.educational.j2ee.demo.jstl.model;

/**
 * Model class for Person object
 * 
 * @author Donato Rimenti
 */
public class Person {

	private String firstName;

	private String lastName;

	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
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

}
