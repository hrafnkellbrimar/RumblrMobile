package is.ru.honn.rumblr.general;

public class PostDetailDTO
{
  protected int postid;
  protected String name;
  protected String value;
  protected String username;

  public PostDetailDTO()
  {
  }

  public PostDetailDTO(int postid, String name, String value, String username)
  {
    this.postid = postid;
    this.name = name;
    this.value = value;
    this.username = username;
  }

  public int getPostid()
  {
    return postid;
  }

  public void setPostid(int postid)
  {
    this.postid = postid;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getValue()
  {
    return value;
  }

  public void setValue(String value)
  {
    this.value = value;
  }

  public String getUsername()
  {
    return username;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }
}
