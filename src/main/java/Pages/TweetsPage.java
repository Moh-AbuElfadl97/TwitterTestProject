package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TweetsPage {
    private final WebDriver driver;
    private final By homeButtonLink = By.xpath("//a[@data-testid='AppTabBar_Home_Link']");
    private final By tweetInputArea = By.xpath("//div[@data-testid='tweetTextarea_0']");
    private final By postButton = By.xpath("//div[@data-testid='tweetButtonInline']");
    private final By accountIcon = By.xpath("//div[@data-testid='SideNav_AccountSwitcher_Button']");
    private final By logoutButtonXpath = By.xpath("//a[@href='/logout' and @data-testid='AccountSwitcher_Logout_Button']");

    public TweetsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isHomeLinkVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement homeLink = wait.until(ExpectedConditions.visibilityOfElementLocated(homeButtonLink));
            return homeLink.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.StaleElementReferenceException e) {
            return false;
        }
    }

    public void postTweet(String tweetText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement tweetBox = wait.until(ExpectedConditions.visibilityOfElementLocated(tweetInputArea));
        tweetBox.clear();
        driver.findElement(tweetInputArea).sendKeys(tweetText);
        WebElement postTweet = wait.until(ExpectedConditions.visibilityOfElementLocated(postButton));
        postTweet.click();
    }

    public boolean isPosted(String tweetText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        try {
            WebElement postedTweet = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='tweetText' and contains(., '"+tweetText+"')]")));
            return postedTweet.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.StaleElementReferenceException e) {
            return false;
        }


    }
    public LogoutPage clickLogOutButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement account = wait.until(ExpectedConditions.visibilityOfElementLocated(accountIcon));
        account.click();
        WebElement logoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButtonXpath));
        logoutButton.click();
        return new LogoutPage(driver);
    }


}