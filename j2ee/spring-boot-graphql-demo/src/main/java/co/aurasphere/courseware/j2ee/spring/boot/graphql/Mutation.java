package co.aurasphere.courseware.j2ee.spring.boot.graphql;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

@Component
public class Mutation implements GraphQLMutationResolver {
 
    public Post writePost(String title, String text, String category) {
    	// Save post in dao and return it...
    	Post savedPost = new Post(1, title, category, 1);
    	return savedPost;
    }
}