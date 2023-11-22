package PostTweet;

import Base.BaseTest;
import Pages.TweetsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostTweetTest extends BaseTest {
    @Test
    public void testPostTweet(){
        login("Username", "Password");
        TweetsPage timeLine = new TweetsPage(driver);
        String tweetText = "This is a test tweet Hello World!";
        timeLine.postTweet(tweetText);
        Assert.assertTrue(timeLine.isPosted(tweetText),"Tweet was not posted successfully.");
    }
}
