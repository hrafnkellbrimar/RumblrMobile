package is.ru.honn.rumblr.service;


import is.ru.honn.rumblr.general.UserDTO;
import is.ru.honn.rumblr.data.users.UserDataGateway;

import java.util.List;

public interface UserService
{
  public int signup(UserDTO user);
  public UserDTO login(String username, String password);
  public void setUserDataGateway(UserDataGateway userDataGateway);
  public List<String> getFollowers(String username);
}
