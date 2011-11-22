package controllers;

import is.ru.honn.rumblr.general.UserDTO;
import is.ru.honn.rumblr.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import play.data.validation.Validation;
import play.mvc.Controller;
import play.mvc.Scope;

/**
 * Created by IntelliJ IDEA.
 * User: Binni
 * Date: 19.11.2011
 * Time: 22:10
 * To change this template use File | Settings | File Templates.
 */
public class User extends Controller
{
    public static void login()
    {
        render();
    }

    public static void loginUser(String username, String password)
    {
        // check for valid input
        Validation.required("username", username);
        Validation.required("password", password);
        if (Validation.hasErrors())
        {
            params.flash();
            Validation.keep();
            login();
        }
        ApplicationContext ctx = new FileSystemXmlApplicationContext("/conf/applicationContext.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        UserDTO user = null;    // create a new user data transfer object.
        user = userService.login(username, password);
        if (user == null)
        {
            Validation.addError("error", "Username of password is incorrect.");
            params.flash();
            Validation.keep();
            login();                                             // User is now logged in.
        }
        Scope.Session.current().put("user", user.getUsername());
        Dashboard.dashboard();
    }
}
