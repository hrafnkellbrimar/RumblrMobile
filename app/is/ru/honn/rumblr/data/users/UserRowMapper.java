package is.ru.honn.rumblr.data.users;

import is.ru.honn.rumblr.general.UserDTO;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements ParameterizedRowMapper<UserDTO>
{
  public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException
  {
    return  new UserDTO(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));
  }
}
