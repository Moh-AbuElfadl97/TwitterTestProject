package Signin;

import Base.BaseTest;
import Pages.TweetsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SigninTest extends BaseTest {

    @Test(priority = 1)
    public void testSuccessfullLogin(){

        login("Abuelfadl_M909", "Abu716@203");
        TweetsPage timeLine = new TweetsPage(driver);
        Assert.assertTrue(timeLine.isHomeLinkVisible(),"Login was not successful. Home link is not visible.");

    }



}
