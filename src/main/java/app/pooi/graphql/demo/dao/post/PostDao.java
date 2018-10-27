package app.pooi.graphql.demo.dao.post;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PostDao {

    @Select("select * from post where authorId = #{id} limit 10")
    List<Post> getPostsByAuthorId(Integer id);

    @Select("select * from post limit #{param2}, #{param1}")
    List<Post> getRecentPosts(int count, int offset);
}
