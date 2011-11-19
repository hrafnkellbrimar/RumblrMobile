package is.ru.honn.rumblr.domain;

import is.ru.honn.rumblr.data.posts.PostDataGateway;
import is.ru.honn.rumblr.general.AbstractRumblrPost;
import is.ru.honn.rumblr.service.PostService;
import is.ruframework.data.RuData;

import java.util.Collection;

public class PostActions extends RuData implements PostService
{
  private PostDataGateway postDataGateway;

  public PostActions()
  {
  }

  public void setPostDataGateway(PostDataGateway postDataGateway)
  {
    this.postDataGateway = postDataGateway;
  }

  public void addPost(AbstractRumblrPost post, String username)
  {
    postDataGateway.addPost(post, username);
  }

  public Collection<AbstractRumblrPost> getPosts(String username)
  {
    return postDataGateway.getPosts(username);
  }
}
