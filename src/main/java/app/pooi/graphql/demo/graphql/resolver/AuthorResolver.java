package app.pooi.graphql.demo.graphql.resolver;

import app.pooi.graphql.demo.dao.author.Author;
import app.pooi.graphql.demo.dao.post.Post;
import app.pooi.graphql.demo.dao.post.PostDao;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorResolver implements GraphQLResolver<Author> {

    private PostDao postDao;

    public AuthorResolver(PostDao postDao) {
        this.postDao = postDao;
    }

    public List<Post> getPosts(Author author) {
        return postDao.getPostsByAuthorId(author.getId());
    }
}
