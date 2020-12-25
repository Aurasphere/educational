package co.aurasphere.courseware.j2ee.spring.boot.graphql;

public class Post {

	private int id;
    
	private String title;
    
	private String category;
    
	private int authorId;
    
    public Post(int id, String title, String category, int authorId) {
    	this.id = id;
    	this.title = title;
    	this.category = category;
    	this.authorId = authorId;
    }

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public int getAuthorId() {
		return authorId;
	}
}