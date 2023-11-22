package Base;

import Pages.HomePage;
import Pages.PasswordPage;
import Pages.UsernamePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected WebDriver driver;
    protected HomePage HomePage;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://twitter.com/");
        HomePage = new HomePage(driver);

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    protected void login(String username, String password) {
        UsernamePage userPage = HomePage.clickFormAuthLink();
        userPage.setUsername(username);
        PasswordPage passPage = userPage.clickNext();
        passPage.setPassword(password);
        passPage.clickLogin(); // Assuming the login button is on the password page
    }
}
