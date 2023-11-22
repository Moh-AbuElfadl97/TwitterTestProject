package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UsernamePage {
    private final WebDriver driver;

    private final By usernameField = By.xpath("//input[@autocomplete=\"username\"]");

    private final By nextButton = By.xpath("//span[text()='Next']");

    public UsernamePage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUsername(String username){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));

        // Clear existing text and set the new username
        usernameInput.clear();
        driver.findElement(usernameField).sendKeys(username);
    }

    public PasswordPage clickNext(){
        driver.findElement(nextButton).click();
        return new PasswordPage(driver);
    }

}
