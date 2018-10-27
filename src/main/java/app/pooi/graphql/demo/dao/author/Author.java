package app.pooi.graphql.demo.dao.author;

import app.pooi.graphql.demo.dao.post.Post;
import lombok.Data;

import java.util.List;

@Data
public class Author {

    private Integer id;

    private String name;

    private String thumbnail;

    private List<Post> posts;

}
