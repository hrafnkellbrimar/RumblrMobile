package is.ru.honn.rumblr.client;

import is.ru.honn.rumblr.data.posts.PostDataGateway;
import is.ru.honn.rumblr.general.UserDTO;
import is.ru.honn.rumblr.data.users.UserDataGateway;
import is.ru.honn.rumblr.domain.LinkPost;
import is.ru.honn.rumblr.domain.QuotePost;
import is.ru.honn.rumblr.domain.RegularPost;
import is.ru.honn.rumblr.general.AbstractRumblrPost;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Bootstrap
{
  public static void main(String[] args)
  {
    new Bootstrap();
  }

  public Bootstrap()
  {
    ApplicationContext ctx = new FileSystemXmlApplicationContext("applicationContext.xml");
    PostDataGateway postGateway = (PostDataGateway) ctx.getBean("postDataGateway");
    UserDataGateway userGateway = (UserDataGateway) ctx.getBean("userDataGateway");

    UserDTO user1 = new UserDTO("RU honn", "ru-honn", "abc123", "ruhonn@ru.is");
    UserDTO user2 = new UserDTO("Wile E. Coyote", "coyote", "abc123", "wile@acme.com");
    UserDTO user3 = new UserDTO("Homer Jay Simpson", "simpson", "abc123", "homer@springfield.com");
    UserDTO user4 = new UserDTO("George Jetson", "jetson", "abc123", "jetson@future.com");

    userGateway.addUser(user1);
    userGateway.addUser(user2);
    userGateway.addUser(user3);
    userGateway.addUser(user4);

    userGateway.follow("ru-honn", "coyote");
    userGateway.follow("ru-honn", "simpson");
    userGateway.follow("ru-honn", "jetson");

    AbstractRumblrPost post1 = new LinkPost("http://gamessummit.eu/home.html", "Games Summit 2011 Antwerp");
    AbstractRumblrPost post2 = new RegularPost("Verkefni 5  Hnnun og smi hugbnaar", "Verkefni 5 gengur t  a gera gagnalag fyrir Rumblr");
    AbstractRumblrPost post3 = new LinkPost("ru-honn.tumblr.com", "RU-honn er  Tumblr");
    AbstractRumblrPost post4 = new QuotePost("I love deadlines. I like the whooshing sound they make as they fly by.", "Douglas Adams");
    AbstractRumblrPost post5 = new LinkPost("http://www.youtube.com/watch?v=ZmH9Dkg3xKA", "New Technology 2012 - The People's Trailer");
    AbstractRumblrPost post6 = new LinkPost("http://www.technologyreview.com/business/39006/", "The game has changed: interesting stats on computer games. Games Scorecard from @techreview");

    postGateway.addPost(post1, "ru-honn");
    postGateway.addPost(post2, "coyote");
    postGateway.addPost(post3, "simpson");
    postGateway.addPost(post4, "jetson");
    postGateway.addPost(post5, "ru-honn");
    postGateway.addPost(post6, "ru-honn");
  }
}
