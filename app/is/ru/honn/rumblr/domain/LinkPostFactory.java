package is.ru.honn.rumblr.domain;

import is.ru.honn.rumblr.general.PostDTO;
import is.ru.honn.rumblr.general.PostDetailDTO;
import is.ru.honn.rumblr.factory.PostFactory;
import is.ru.honn.rumblr.general.AbstractRumblrPost;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LinkPostFactory extends PostFactory
{
  @Override
  public ArrayList<PostDetailDTO> createSubPostDetailsFromPost(AbstractRumblrPost post, String username)
  {
    ArrayList<PostDetailDTO> postDetails = new ArrayList<PostDetailDTO>();
    LinkPost linkPost = (LinkPost)post;
    postDetails.add(new PostDetailDTO(post.getId(), "link-url", linkPost.getLinkUrl(), username));
    postDetails.add(new PostDetailDTO(post.getId(), "link-text", linkPost.getLinkText(), username));
    List<String> tags = post.getTags();
    for(String s : tags)
    {
      postDetails.add(new PostDetailDTO(post.getId(), "tag", s, username));
    }
    return postDetails;
  }

  @Override
  public AbstractRumblrPost createSubPostFromDTO(PostDTO post, Collection<PostDetailDTO> postDetails)
  {
    LinkPost linkPost = new LinkPost();
    linkPost.setId(post.getId());
    linkPost.setType(post.getType());
    linkPost.setDate(post.getDate());
    linkPost.setUsername(post.getUsername()); // so we can get the user in the post.

    for(PostDetailDTO pd : postDetails)
    {
      if(pd.getName().equals("link-text"))
        linkPost.setLinkText(pd.getValue());
      else if (pd.getName().equals("link-url"))
        linkPost.setLinkUrl(pd.getValue());
      else if (pd.getName().equals("tag"))
        linkPost.addTag(pd.getValue());
    }
    return linkPost;
  }

}
