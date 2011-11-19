package is.ru.honn.rumblr.domain;

import is.ru.honn.rumblr.general.AbstractRumblrPost;

import java.util.Date;

public class LinkPost extends AbstractRumblrPost
{
  private String linkUrl;
  private String linkText;

  public LinkPost()
  {
    this.date = new Date();
    this.type = "link";
  }

  public LinkPost(String linkUrl, String linkText)
  {
    this();
    this.linkUrl = linkUrl;
    this.linkText = linkText;
  }

  public String render()
  {
    return header() + "Link: " + linkText + ": " + linkUrl + "\n" + tags();
  }

  public String getLinkUrl()
  {
    return linkUrl;
  }

  public void setLinkUrl(String linkUrl)
  {
    this.linkUrl = linkUrl;
  }

  public String getLinkText()
  {
    return linkText;
  }

  public void setLinkText(String linkText)
  {
    this.linkText = linkText;
  }
}
