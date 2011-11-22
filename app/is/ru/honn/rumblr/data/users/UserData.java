package is.ru.honn.rumblr.data.users;

import is.ru.honn.rumblr.general.UserDTO;
import is.ruframework.data.RuData;
import is.ruframework.data.RuDuplicateDataException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserData extends RuData implements UserDataGateway
{
  public UserDTO getUserById(int id)
  {
    Collection<String> users;
    SimpleJdbcTemplate simpleJdbcTemplate = new SimpleJdbcTemplate(getDataSource());
    UserDTO user = (UserDTO) simpleJdbcTemplate.queryForObject(
        "select * from ru_users where id=?", new UserRowMapper(), id);
    return user;
  }

  public UserDTO getUserByUsername(String username)
  {
    Collection<String> users;
    SimpleJdbcTemplate simpleJdbcTemplate = new SimpleJdbcTemplate(getDataSource());
    UserDTO user = null;
    try
    {
      user = (UserDTO) simpleJdbcTemplate.queryForObject(
          "select * from ru_users where username=?", new UserRowMapper(), username);
    } catch (EmptyResultDataAccessException erdae)
    {
      return null;
    }
    return user;
  }

  public int addUser(UserDTO user)
  {
    SimpleJdbcInsert insertContent =
        new SimpleJdbcInsert(getDataSource())
            .withTableName("ru_users")
            .usingGeneratedKeyColumns("id");
    Map<String, Object> parameters = new HashMap<String, Object>(4);
    parameters.put("name", user.getName());
    parameters.put("username", user.getUsername());
    parameters.put("password", user.getPassword());
    parameters.put("email", user.getEmail());
    int returnValue = 0;
    try
    {
      returnValue = insertContent.executeAndReturnKey(parameters).intValue();
    }
    catch (DataIntegrityViolationException divex)
    {
      String message = "User already exists";
      log.info(message);
      throw new RuDuplicateDataException(message, divex);
    }
    return returnValue;
  }

  public List<String> getFollowers(String username)
  {
    SimpleJdbcTemplate simpleJdbcTemplate = new SimpleJdbcTemplate(getDataSource());
    return simpleJdbcTemplate.query("select * from ru_follows where username=?", new FollowRowMapper(), username);
  }

  public void follow(String username, String usernameToFollow)
  {
    SimpleJdbcInsert insertContent =
        new SimpleJdbcInsert(getDataSource())
            .withTableName("ru_follows");
    Map<String, Object> parameters = new HashMap<String, Object>(2);
    parameters.put("username", username);
    parameters.put("follows", usernameToFollow);
    insertContent.execute(parameters);
  }
}
