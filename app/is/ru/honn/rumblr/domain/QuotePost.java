package is.ru.honn.rumblr.domain;

import is.ru.honn.rumblr.general.AbstractRumblrPost;

import java.util.Date;

public class QuotePost extends AbstractRumblrPost
{
  protected String quoteText;
  protected String quoteSource;

  public QuotePost()
  {
    this.date = new Date();
    this.type = "quote";
  }

  public QuotePost(String quoteText, String quoteSource)
  {
    this();
    this.quoteText = quoteText;
    this.quoteSource = quoteSource;
  }

  public String render()
  {
    return header() + "Quote: " + quoteText + "\n" + quoteSource + "\n" + tags();
  }

  public String getQuoteText()
  {
    return quoteText;
  }

  public void setQuoteText(String quoteText)
  {
    this.quoteText = quoteText;
  }

  public String getQuoteSource()
  {
    return quoteSource;
  }

  public void setQuoteSource(String quoteSource)
  {
    this.quoteSource = quoteSource;
  }
}
