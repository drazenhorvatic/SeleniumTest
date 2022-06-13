package Base;

import Pages.LogInPage;
import Pages.LogoutPage;
import Test.LoginPracticeTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wdwait;
    public LogInPage logInPage;

    public LogoutPage logoutPage;

    public LoginPracticeTest practiceTesting;

    @BeforeClass
    public void Setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        logoutPage = new LogoutPage(driver, wdwait);
        logInPage = new LogInPage(driver, wdwait);
        practiceTesting = new LoginPracticeTest();

    }

    public void visibilityWait(WebElement element) {
        wdwait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickabilityWait(WebElement element) {
        wdwait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void ScrollIntoView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }


    @AfterClass
    public void TearDown() {
        driver.close();
        driver.quit();

    }
}