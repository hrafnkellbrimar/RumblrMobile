package is.ru.honn.rumblr.domain;

import is.ru.honn.rumblr.general.UserDTO;
import is.ru.honn.rumblr.data.users.UserDataGateway;
import is.ru.honn.rumblr.service.UserService;

public class UserActions implements UserService
{
  UserDataGateway userDataGateway;

  public UserActions()
  {
  }

  public void setUserDataGateway(UserDataGateway UserDataGateway)
  {
    this.userDataGateway = UserDataGateway;
  }

  public int signup(UserDTO user)
  {
    return this.userDataGateway.addUser(user);
  }

  public UserDTO login(String username, String password)
  {
    UserDTO user = this.userDataGateway.getUserByUsername(username);
    if (user == null)
      return null;
    if (!user.getPassword().equals(password))
      return null;
    return user;
  }
}
