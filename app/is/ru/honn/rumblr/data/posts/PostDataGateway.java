package is.ru.honn.rumblr.data.posts;

import is.ru.honn.rumblr.general.AbstractRumblrPost;

import java.util.Collection;

public interface PostDataGateway
{
  public void addPost(AbstractRumblrPost post, String username);
  public Collection<AbstractRumblrPost> getPosts(String username);
}
