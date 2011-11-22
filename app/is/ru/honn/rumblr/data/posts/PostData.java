package is.ru.honn.rumblr.data.posts;

import is.ru.honn.rumblr.factory.PostFactory;
import is.ru.honn.rumblr.general.AbstractRumblrPost;
import is.ru.honn.rumblr.general.PostDTO;
import is.ru.honn.rumblr.general.PostDetailDTO;
import is.ruframework.data.RuData;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PostData extends RuData implements PostDataGateway
{
  public void addPost(AbstractRumblrPost post, String username)
  {
    SimpleJdbcInsert insertPost =
        new SimpleJdbcInsert(getDataSource())
            .withTableName("ru_posts")
            .usingGeneratedKeyColumns("id");
    Map<String, Object> parameters = new HashMap<String, Object>(3);
    parameters.put("date", post.getDate());
    parameters.put("type", post.getType());
    parameters.put("username", username);
    int id = insertPost.executeAndReturnKey(parameters).intValue();
    post.setId(id);

    Collection<PostDetailDTO> details = PostFactory.createPostDetailsFromPost(post, username);
    for (PostDetailDTO pd : details)
    {
      addDetails(pd);
    }
  }

  private void addDetails(PostDetailDTO pd)
  {
    SimpleJdbcInsert insertPostDetail = new SimpleJdbcInsert(getDataSource());
    insertPostDetail.withTableName("ru_post_details");
    Map<String, Object> parameters = new HashMap<String, Object>(4);
    parameters.put("postid", pd.getPostid());
    parameters.put("name", pd.getName());
    parameters.put("value", pd.getValue());
    parameters.put("username", pd.getUsername());
    insertPostDetail.execute(parameters);
  }

  public Collection<AbstractRumblrPost> getPosts(String username)
  {
    Collection<PostDTO> posts;
    Collection<AbstractRumblrPost> postReturn = new ArrayList<AbstractRumblrPost>();

    SimpleJdbcTemplate simpleJdbcTemplate = new SimpleJdbcTemplate(getDataSource());

    posts = (Collection<PostDTO>)simpleJdbcTemplate.query("select * from ru_posts where username=?",
        new PostRowMapper(), username);

    AbstractRumblrPost newPost = null;
    ArrayList<PostDetailDTO> postDetails;
    for(PostDTO post : posts)
    {
      postDetails = (ArrayList<PostDetailDTO>)simpleJdbcTemplate.query("select * from ru_post_details where postid=?",
        new PostDetailRowMapper(), post.getId());

        newPost = (AbstractRumblrPost) PostFactory.createPostFromDTO(post, postDetails);

      postReturn.add(newPost);
    }
    return postReturn;
  }
}
