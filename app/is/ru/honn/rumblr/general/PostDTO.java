package is.ru.honn.rumblr.general;

import java.util.Date;

public class PostDTO
{
  protected int id;
  protected Date date;
  protected String type;
  protected String username;                 // so we can get the user in the post.


    public PostDTO()
  {
  }

  public PostDTO(int id, Date date, String type, String username)
  {
    this.id = id;
    this.date = date;
    this.type = type;
    this.username = username;
  }


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
}
