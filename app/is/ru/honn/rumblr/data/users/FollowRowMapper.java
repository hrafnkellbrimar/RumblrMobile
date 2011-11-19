package is.ru.honn.rumblr.data.users;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FollowRowMapper implements ParameterizedRowMapper<String>
{
  public String mapRow(ResultSet resultSet, int i) throws SQLException
  {
    return resultSet.getString("follows");
  }
}
