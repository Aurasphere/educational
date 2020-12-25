package co.aurasphere.courseware.j2ee.spring.boot.graphql;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Main class for this application.
 * 
 * @author Donato Rimenti
 */
@SpringBootApplication
public class CoursewareGraphQLApplication {

	/**
	 * Starts the application.
	 * 
	 * @param args null
	 */
	public static void main(String[] args) {
		new SpringApplicationBuilder(CoursewareGraphQLApplication.class).run(args);
	}

}