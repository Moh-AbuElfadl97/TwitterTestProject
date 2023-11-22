package Logout;

import Base.BaseTest;
import Pages.LogoutPage;
import Pages.TweetsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {
    @Test
    public void testLogout(){
        login("Username", "Password");
        TweetsPage timeLine = new TweetsPage(driver);
        LogoutPage logout = timeLine.clickLogOutButton();
        logout.confirmLogout();
        Assert.assertTrue(logout.isCreateAccountLinkVisible(),"Create Account Button not found, Logout Not Confirmed");
    }
}
