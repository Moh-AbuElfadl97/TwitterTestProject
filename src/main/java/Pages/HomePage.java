package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public UsernamePage clickFormAuthLink (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement signinButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-testid='loginButton']")));
        signinButton.click();
        return new UsernamePage(driver);
    }

}
