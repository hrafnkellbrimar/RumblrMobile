package is.ru.honn.rumblr.util;

public class RumblrException extends RuntimeException
{
  public RumblrException()
  {
  }

  public RumblrException(String s)
  {
    super(s);
  }

  public RumblrException(String s, Throwable throwable)
  {
    super(s, throwable);
  }

  public RumblrException(Throwable throwable)
  {
    super(throwable);
  }
}
