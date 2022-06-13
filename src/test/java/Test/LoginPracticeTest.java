package Test;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPracticeTest extends BaseTest {

    String validUsername = "tomsmith";
    String validPassword = "SuperSecretPassword!";
    String invalidUsername = "tomazdravkovic";
    String invalidPassword = "SuperBSecretPassword!1";

    @BeforeMethod
    public void pageSetup() throws InterruptedException {
    driver.manage().window().maximize();
    driver.navigate().to("https://the-internet.herokuapp.com/login");
    Thread.sleep(3000);
}

    @Test
    public void succesfulLogIn() throws InterruptedException {
        logInPage.insertUsername(validUsername);
        logInPage.insertPassword(validPassword);
        logInPage.getLogInButton().click();

        Thread.sleep(5000);

        Assert.assertTrue(logoutPage.getLogoutButton().isDisplayed());

        Thread.sleep(3000);

        logoutPage.clickOnLogOutButton();

        Thread.sleep(6000);


}


}
