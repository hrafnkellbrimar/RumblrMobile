package is.ru.honn.rumblr.data.posts;

import is.ru.honn.rumblr.general.PostDTO;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PostRowMapper implements ParameterizedRowMapper<PostDTO>
{
  public PostDTO mapRow(ResultSet rs, int rowNum) throws SQLException
  {
    PostDTO post = new PostDTO();
    post.setId(rs.getInt("id"));
    post.setType(rs.getString("type"));
    post.setDate(rs.getDate("date"));
    post.setUsername(rs.getString("username"));
    return post;
  }
}

