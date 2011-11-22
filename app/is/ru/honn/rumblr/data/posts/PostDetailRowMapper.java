package is.ru.honn.rumblr.data.posts;

import is.ru.honn.rumblr.general.PostDetailDTO;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PostDetailRowMapper implements ParameterizedRowMapper<PostDetailDTO>
{
  public PostDetailDTO mapRow(ResultSet rs, int rowNum) throws SQLException
  {
    return new PostDetailDTO(rs.getInt("postid"),
                             rs.getString("name"),
                             rs.getString("value"),
                             rs.getString("username"));
  }
}

