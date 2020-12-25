package co.aurasphere.courseware.j2ee.spring.boot.graphql;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class Query implements GraphQLQueryResolver {

	public List<Post> getRecentPosts(int count, int offset) {
		List<Post> posts = new ArrayList<Post>();
		for (int i = 0; i < count; i++) {
			Post post = new Post(offset + i, "title" + i, "category" + i, i);
			posts.add(post);
		}
		return posts;
	}
}