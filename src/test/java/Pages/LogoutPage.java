package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPage {

    WebDriver driver;
    WebDriverWait wdwait;
    WebElement logoutButton;
    WebElement successNotification;
    WebElement subheader;

    public LogoutPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getLogoutButton() {
        return driver.findElement(By.xpath("/html/body/div[2]/div/div/a"));
    }


    public WebElement getSuccessNotification() {
        return driver.findElement(By.id("flash"));
    }


    public void clickOnLogOutButton() {
        getLogoutButton().click();
    }

}
