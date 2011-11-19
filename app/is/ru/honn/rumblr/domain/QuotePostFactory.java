package is.ru.honn.rumblr.domain;

import is.ru.honn.rumblr.general.PostDTO;
import is.ru.honn.rumblr.general.PostDetailDTO;
import is.ru.honn.rumblr.factory.PostFactory;
import is.ru.honn.rumblr.general.AbstractRumblrPost;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class QuotePostFactory extends PostFactory
{
  @Override
  public ArrayList<PostDetailDTO> createSubPostDetailsFromPost(AbstractRumblrPost post, String username)
  {
    ArrayList<PostDetailDTO> postDetails = new ArrayList<PostDetailDTO>();
    QuotePost quotePost = (QuotePost)post;
    postDetails.add(new PostDetailDTO(post.getId(), "quote-text", quotePost.getQuoteText(), username));
    postDetails.add(new PostDetailDTO(post.getId(), "quote-source", quotePost.getQuoteSource(), username));
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
    QuotePost quotePost = new QuotePost();
    quotePost.setId(post.getId());
    quotePost.setType(post.getType());
    quotePost.setDate(post.getDate());

    for(PostDetailDTO pd : postDetails)
    {
      if(pd.getName().equals("quote-text"))
        quotePost.setQuoteText(pd.getValue());
      else if (pd.getName().equals("quote-source"))
        quotePost.setQuoteSource(pd.getValue());
      else if (pd.getName().equals("tag"))
        quotePost.addTag(pd.getValue());
    }
    return quotePost;
  }
}
