package controllers;

import is.ru.honn.rumblr.general.AbstractRumblrPost;
import is.ru.honn.rumblr.service.PostService;
import is.ru.honn.rumblr.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import play.mvc.Controller;

import java.util.Collection;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Binni
 * Date: 20.11.2011
 * Time: 10:21
 * To change this template use File | Settings | File Templates.
 */
public class Dashboard extends Controller
{
    public static void dashboard()
    {
        ApplicationContext ctx = new FileSystemXmlApplicationContext("/conf/applicationContext.xml");
        PostService postService = (PostService) ctx.getBean("postService"); // get the post data

        UserService userService = (UserService) ctx.getBean("userService"); // gte the user data

        Collection<AbstractRumblrPost> contentList = postService.getPosts(session.get("user"));
                                                       // get the information about the user that is logged in currently
        List<String> followers = userService.getFollowers(session.get("user"));
        // Get followers for each user:
        for (String user : followers)
        {
            contentList.addAll(postService.getPosts(user));
        }
        render(contentList);


    }

}
