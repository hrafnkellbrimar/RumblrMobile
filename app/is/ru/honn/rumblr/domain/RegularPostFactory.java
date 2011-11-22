package is.ru.honn.rumblr.domain;

import is.ru.honn.rumblr.general.PostDTO;
import is.ru.honn.rumblr.general.PostDetailDTO;
import is.ru.honn.rumblr.factory.PostFactory;
import is.ru.honn.rumblr.general.AbstractRumblrPost;

import java.util.ArrayList;
import java.util.Collection;

public class RegularPostFactory extends PostFactory
{
  @Override
  public ArrayList<PostDetailDTO> createSubPostDetailsFromPost(AbstractRumblrPost post, String username)
  {
    ArrayList<PostDetailDTO> postDetails = new ArrayList<PostDetailDTO>();
    RegularPost regularPost = (RegularPost) post;
    postDetails.add(new PostDetailDTO(post.getId(), "regular-title", regularPost.getRegularTitle(), username));
    postDetails.add(new PostDetailDTO(post.getId(), "regular-body", regularPost.getRegularBody(), username));
    return postDetails;
  }

  @Override
  public AbstractRumblrPost createSubPostFromDTO(PostDTO post, Collection<PostDetailDTO> postDetails)
  {
    RegularPost regularPost = new RegularPost();
    regularPost.setId(post.getId());
    regularPost.setType(post.getType());
    regularPost.setDate(post.getDate());
    regularPost.setUsername(post.getUsername());          // so we can get the user in the post.

    for (PostDetailDTO pd : postDetails)
    {
      if (pd.getName().equals("regular-title"))
        regularPost.setRegularTitle(pd.getValue());
      else if (pd.getName().equals("regular-body"))
        regularPost.setRegularBody(pd.getValue());
      else if (pd.getName().equals("tag"))
        regularPost.addTag(pd.getValue());
    }
    return regularPost;
  }
}
