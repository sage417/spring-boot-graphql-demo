package app.pooi.graphql.demo.dao.author;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AuthorDao {

    @Select("select * from author where id = #{id}")
    Author getAuthorById(String authorId);
}
