package controllers;

import is.ru.honn.rumblr.domain.LinkPost;
import is.ru.honn.rumblr.domain.QuotePost;
import is.ru.honn.rumblr.domain.RegularPost;
import is.ru.honn.rumblr.factory.PostFactory;
import is.ru.honn.rumblr.general.AbstractRumblrPost;
import is.ru.honn.rumblr.general.PostDTO;
import is.ru.honn.rumblr.general.PostDetailDTO;
import is.ru.honn.rumblr.service.PostService;
import is.ru.honn.rumblr.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import play.mvc.Controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Binni
 * Date: 21.11.2011
 * Time: 16:36
 * To change this template use File | Settings | File Templates.
 */
public class Post extends Controller
{
    public static void link()
    {
        render();
    }

    public static void regular()
    {
        render();
    }


    public static void quote()
    {
        render();
    }


    public static void linkPost(String linktext, String linkurl)
    {

        ApplicationContext ctx = new FileSystemXmlApplicationContext("/conf/applicationContext.xml");

        AbstractRumblrPost post = new LinkPost();

        Date date = new Date();          // get the current date

        UserService userService = (UserService) ctx.getBean("userService");
        PostService postService = (PostService) ctx.getBean("postService");

        PostDTO postDTO = new PostDTO(0, date, "link", session.get("user"));
        //Created a new post data transfer object
        PostDetailDTO PDurl = new PostDetailDTO(0, "link-url", linkurl, session.get("user"));
        PostDetailDTO PDtext = new PostDetailDTO(0, "link-text", linktext, session.get("user"));

        Collection<PostDetailDTO> collect = new ArrayList<PostDetailDTO>();
        collect.add(PDtext);
        collect.add(PDurl);
        // now we have added the details
        post = PostFactory.createPostFromDTO(postDTO, collect);
        postService.addPost(post, session.get("user"));
        // the linkpost has been recoreded in the database.
        Dashboard.dashboard();

    }


    public static void quotePost(String quotetext, String quotesource)
    {
        ApplicationContext ctx = new FileSystemXmlApplicationContext("/conf/applicationContext.xml");

                AbstractRumblrPost post = new QuotePost();

                Date date = new Date();          // get the current date

                UserService userService = (UserService) ctx.getBean("userService");
                PostService postService = (PostService) ctx.getBean("postService");

                PostDTO postDTO = new PostDTO(0, date, "quote", session.get("user"));
                //Created a new post data transfer object
                PostDetailDTO PDtext = new PostDetailDTO(0, "quote-text", quotetext, session.get("user"));
                PostDetailDTO PDsourse = new PostDetailDTO(0, "quote-source",quotesource , session.get("user"));

                Collection<PostDetailDTO> collect = new ArrayList<PostDetailDTO>();
                collect.add(PDsourse);
                collect.add(PDtext);


                // now we have added the details
                post = PostFactory.createPostFromDTO(postDTO, collect);
                postService.addPost(post, session.get("user"));
                // the quotepost has been recoreded in the database.
                Dashboard.dashboard();

    }

    public static void regularPost(String regulartitle, String regularbody)
    {
                ApplicationContext ctx = new FileSystemXmlApplicationContext("/conf/applicationContext.xml");

                AbstractRumblrPost post = new RegularPost();

                Date date = new Date();          // get the current date

                UserService userService = (UserService) ctx.getBean("userService");
                PostService postService = (PostService) ctx.getBean("postService");

                PostDTO postDTO = new PostDTO(0, date, "regular", session.get("user"));
                //Created a new post data transfer object
                PostDetailDTO PDtitle = new PostDetailDTO(0, "regular-title", regulartitle, session.get("user"));
                PostDetailDTO PDbody = new PostDetailDTO(0, "regular-body",regularbody, session.get("user"));

                Collection<PostDetailDTO> collect = new ArrayList<PostDetailDTO>();
                collect.add(PDtitle);
                collect.add(PDbody);


                // now we have added the details
                post = PostFactory.createPostFromDTO(postDTO, collect);
                postService.addPost(post, session.get("user"));
                // the regularpost has been recoreded in the database.
                Dashboard.dashboard();
    }

}
