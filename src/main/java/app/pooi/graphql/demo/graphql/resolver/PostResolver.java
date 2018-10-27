package app.pooi.graphql.demo.graphql.resolver;

import app.pooi.graphql.demo.dao.author.Author;
import app.pooi.graphql.demo.dao.author.AuthorDao;
import app.pooi.graphql.demo.dao.post.Post;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

@Component
public class PostResolver implements GraphQLResolver<Post> {

    private AuthorDao authorDao;

    public PostResolver(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    public Author getAuthor(Post post) {
        return authorDao.getAuthorById(post.getAuthorId());
    }
}
