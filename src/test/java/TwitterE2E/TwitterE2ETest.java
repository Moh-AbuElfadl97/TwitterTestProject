package TwitterE2E;

import Base.BaseTest;
import Pages.LogoutPage;
import Pages.PasswordPage;
import Pages.TweetsPage;
import Pages.UsernamePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TwitterE2ETest extends BaseTest {

    @Test
    public void testE2EScenario(){
        login("Username", "Password");
        TweetsPage timeLine = new TweetsPage(driver);
        //test successfull login
        Assert.assertTrue(timeLine.isHomeLinkVisible(),"Login was not successful. Home link is not visible.");

        String tweetText = "This is a test tweet using Selenium Java and TestNG";
        timeLine.postTweet(tweetText);
        //test tweet posted successfully
        Assert.assertTrue(timeLine.isPosted(tweetText),"Tweet was not posted successfully.");

        LogoutPage logout = timeLine.clickLogOutButton();
        logout.confirmLogout();
        //test successfull logout
        Assert.assertTrue(logout.isCreateAccountLinkVisible(),"Create Account Button not found, Logout Not Confirmed");


    }
}
