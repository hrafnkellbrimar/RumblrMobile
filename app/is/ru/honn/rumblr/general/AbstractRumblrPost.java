package is.ru.honn.rumblr.general;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class AbstractRumblrPost implements RumblrPost
{
  protected int id;
  protected Date date;
  protected String type;
  protected String username;       // so we can get the user in the post.
  protected List<String> tags = new ArrayList<String>();
  public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-mm-dd hh:MM:ss");

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public String getUrl()
  {
    return "posts?" + id;
  }

  public Date getDate()
  {
    return date;
  }

  public void setDate(Date date)
  {
    this.date = date;
  }

  public String getType()
  {
    return type;
  }

  public void setType(String type)
  {
    this.type = type;
  }

  public void addTag(String tag)
  {
    tags.add(tag);
  }

  public List getTags()
  {
    return tags;
  }

  public void addTags(List<String> tags)
  {
    this.tags.addAll(tags);
  }

  protected String header()
  {
    return "id: " + id + " " + DATE_FORMAT.format(date) + " " + getUrl() + "\n";
  }

  protected String tags()
  {
    StringBuilder tagString = new StringBuilder();
    tagString.append("Tags: ");
    for(String tag : tags)
    {
      tagString.append("#").append(tag).append(" ");
    }
    return tagString.toString();
  }
}
