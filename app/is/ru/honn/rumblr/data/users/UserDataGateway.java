package is.ru.honn.rumblr.data.users;

import is.ru.honn.rumblr.general.UserDTO;

import java.util.List;

public interface UserDataGateway
{
  public UserDTO getUserById(int id);
  public UserDTO getUserByUsername(String username);
  public int addUser(UserDTO user);
  public void follow(String username, String usernameToFollow);
  List<String> getFollowers(String username);
}
