package co.aurasphere.courseware.j2ee.spring.boot.graphql;

import java.util.List;

public class Author {

	private int id;

	private String name;
	
	private List<Post> posts;
	
	public Author(int id, String name) {
		this.id = id;
		this.name = name;
	}
}