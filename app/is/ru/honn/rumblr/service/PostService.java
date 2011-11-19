package is.ru.honn.rumblr.service;

import is.ru.honn.rumblr.data.posts.PostDataGateway;
import is.ru.honn.rumblr.general.AbstractRumblrPost;

import java.util.Collection;

public interface PostService
{
  public void addPost(AbstractRumblrPost post, String username);
  public Collection<AbstractRumblrPost> getPosts(String username);
  public void setPostDataGateway(PostDataGateway postDataGateway);
}
