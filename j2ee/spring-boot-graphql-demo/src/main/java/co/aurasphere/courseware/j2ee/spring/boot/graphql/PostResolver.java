package co.aurasphere.courseware.j2ee.spring.boot.graphql;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

@Component
public class PostResolver implements GraphQLResolver<Post> {
 
    public Author getAuthor(Post post) {
        return new Author(post.getAuthorId(), "name");
    }
}