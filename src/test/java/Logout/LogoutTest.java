package Logout;

import Base.BaseTest;
import Pages.LogoutPage;
import Pages.TweetsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {
    @Test
    public void testLogout(){
        login("Abuelfadl_M909", "Abu716@203");
        TweetsPage timeLine = new TweetsPage(driver);
        LogoutPage logout = timeLine.clickLogOutButton();
        logout.confirmLogout();
        Assert.assertTrue(logout.isCreateAccountLinkVisible(),"Create Account Button not found, Logout Not Confirmed");
    }
}
