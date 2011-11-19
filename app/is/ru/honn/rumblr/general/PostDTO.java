package is.ru.honn.rumblr.general;

import java.util.Date;

public class PostDTO
{
  protected int id;
  protected Date date;
  protected String type;

  public PostDTO()
  {
  }

  public PostDTO(int id, Date date, String type)
  {
    this.id = id;
    this.date = date;
    this.type = type;
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
