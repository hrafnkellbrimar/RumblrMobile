package is.ru.honn.rumblr.domain;

import is.ru.honn.rumblr.general.AbstractRumblrPost;

import java.util.Date;

public class RegularPost extends AbstractRumblrPost
{
  protected String regularTitle;
  protected String regularBody;

  public RegularPost()
  {
    this.date = new Date();
    this.type = "regular";
  }

  public RegularPost(String regularTitle, String regularBody)
  {
    this();
    this.regularTitle = regularTitle;
    this.regularBody = regularBody;
  }

  public String render()
  {
    return header() + "Regular: " + regularTitle + "\n" + regularBody + "\n" + tags();
  }

  public String getRegularTitle()
  {
    return regularTitle;
  }

  public void setRegularTitle(String regularTitle)
  {
    this.regularTitle = regularTitle;
  }

  public String getRegularBody()
  {
    return regularBody;
  }

  public void setRegularBody(String regularBody)
  {
    this.regularBody = regularBody;
  }
}
