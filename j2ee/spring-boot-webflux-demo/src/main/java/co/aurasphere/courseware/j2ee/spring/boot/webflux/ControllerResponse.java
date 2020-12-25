package co.aurasphere.courseware.j2ee.spring.boot.webflux;

public class ControllerResponse {

	private String content;

	public ControllerResponse() {
		this.content = "some content";
	}

	public ControllerResponse(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "BenchmarkResponse [content=" + content + "]";
	}

}