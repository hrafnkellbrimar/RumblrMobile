package is.ru.honn.rumblr.client;

import is.ru.honn.rumblr.general.AbstractRumblrPost;
import is.ru.honn.rumblr.service.PostService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Collection;

public class ReadAllPosts
{
  public static void main(String[] args)
  {
    new ReadAllPosts();
  }

  public ReadAllPosts()
  {
    ApplicationContext ctx = new FileSystemXmlApplicationContext("applicationContext.xml");
    PostService postService = (PostService)ctx.getBean("postService");

    Collection<AbstractRumblrPost> postlist = postService.getPosts("ru-honn");
    for(AbstractRumblrPost arp : postlist)
    {
      System.out.println(arp.render());
    }
  }
}

