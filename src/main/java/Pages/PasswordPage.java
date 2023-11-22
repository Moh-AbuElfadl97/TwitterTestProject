package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PasswordPage {
    private final WebDriver driver;
    private final By passwordField = By.xpath("//input[@autocomplete=\"current-password\"]");
    private final By loginButton = By.xpath("//span[text()='Log in']");

    public void setPassword(String password){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));

        // Clear existing text and set the new username
        usernameInput.clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public PasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public TweetsPage clickLogin(){
        driver.findElement(loginButton).click();
        return new TweetsPage(driver);
    }
}
