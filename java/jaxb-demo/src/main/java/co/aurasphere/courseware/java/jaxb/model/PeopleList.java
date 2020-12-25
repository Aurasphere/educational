package co.aurasphere.courseware.java.jaxb.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="people")
@XmlAccessorType(XmlAccessType.FIELD)
public class PeopleList {

	@XmlElement(name="person")
	private List<Person> peopleList;
	
	public List<Person> getPeopleList() {
		return peopleList;
	}

	public void setPeopleList(List<Person> peopleList) {
		this.peopleList = peopleList;
	}

	@Override
	public String toString() {
		return "PeopleList [peopleList=" + peopleList + "]";
	}

}