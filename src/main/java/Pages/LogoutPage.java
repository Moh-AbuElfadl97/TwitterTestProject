package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogoutPage {
    private final WebDriver driver;
    private final By logoutButton = By.xpath("//div[@data-testid='confirmationSheetConfirm']");
    private final By createAccountLink = By.xpath("//a[@data-testid='signupButton']");

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
    }
    public void confirmLogout(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement logoutConfirmButton = wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
        logoutConfirmButton.click();
    }
    public boolean isCreateAccountLinkVisible(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement createAccountButton = wait.until(ExpectedConditions.visibilityOfElementLocated(createAccountLink));
            return createAccountButton.isDisplayed();
        }catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.StaleElementReferenceException e) {
            return false;
        }
    }

}
