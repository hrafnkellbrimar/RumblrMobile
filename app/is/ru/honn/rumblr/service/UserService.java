package is.ru.honn.rumblr.service;


import is.ru.honn.rumblr.general.UserDTO;
import is.ru.honn.rumblr.data.users.UserDataGateway;

public interface UserService
{
  public int signup(UserDTO user);
  public UserDTO login(String username, String password);
  public void setUserDataGateway(UserDataGateway userDataGateway);
}
