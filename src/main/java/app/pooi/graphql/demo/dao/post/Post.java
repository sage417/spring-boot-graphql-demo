package app.pooi.graphql.demo.dao.post;

import lombok.Data;

import java.util.List;

@Data
public class Post {
    private String id;
    private String title;
    private String category;
    private String authorId;
    private String text;
}
