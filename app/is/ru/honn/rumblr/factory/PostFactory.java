package is.ru.honn.rumblr.factory;

import is.ru.honn.rumblr.general.PostDTO;
import is.ru.honn.rumblr.general.PostDetailDTO;
import is.ru.honn.rumblr.general.AbstractRumblrPost;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.ArrayList;
import java.util.Collection;

abstract public class PostFactory
{
  public static ArrayList<PostDetailDTO> createPostDetailsFromPost(AbstractRumblrPost post, String username)
  {
    ApplicationContext ctx = new FileSystemXmlApplicationContext("applicationContext.xml");
    PostFactory postFactory = (PostFactory)ctx.getBean(post.getType());
    return postFactory.createSubPostDetailsFromPost(post, username);
  }

  abstract public ArrayList<PostDetailDTO> createSubPostDetailsFromPost(AbstractRumblrPost post, String username);

  public static AbstractRumblrPost createPostFromDTO(PostDTO post, Collection<PostDetailDTO> postDetails)
  {
    ApplicationContext ctx = new FileSystemXmlApplicationContext("applicationContext.xml");
    PostFactory postFactory = (PostFactory)ctx.getBean(post.getType());
    return postFactory.createSubPostFromDTO(post, postDetails);
  }

  abstract public AbstractRumblrPost createSubPostFromDTO(PostDTO post, Collection<PostDetailDTO> postDetails);
}
