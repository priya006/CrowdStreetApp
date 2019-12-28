import crowdstreet.pages.CreateAccount;
import crowdstreet.pages.LaunchApp;
import crowdstreet.pages.Registration;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;


import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;

public class RegistrationProcessTest {

    @Test
    public void RegisterUser() throws InterruptedException {

        // Initialize browser
        WebDriver driver = new ChromeDriver();

        LaunchApp launchApp = new LaunchApp(driver);
        Registration registration = new Registration(driver);
        CreateAccount createAccount = new CreateAccount(driver);

        driver.manage().window().fullscreen();
        String actualUrl = "https://test.crowdstreet.com/properties/?";
        launchApp.getUrl(actualUrl);


        String expectedUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl, expectedUrl);

        Thread.sleep(300);

        createAccount.createAccount().click();

        Thread.sleep(300);
        assertTrue(driver.getTitle().contains("Create Account"));

        String userName = "" + (int) (Math.random() * Integer.MAX_VALUE);
        String emailID = "priya" + userName + "@gmail.com";

        registration.getEmailID().sendKeys(emailID);


        registration.enterUserName().sendKeys("priya");


        registration.enterLastName().sendKeys("boopathi");
        WebElement createPassword = registration.enterPassword();
        createPassword.sendKeys("fakepassword1A!");
        createPassword.sendKeys(Keys.TAB);
        registration.passwordVisibilityToggle().click();
        createPassword.sendKeys(Keys.TAB);

        Thread.sleep(100);
        registration.confirmPassword().get(4).sendKeys("fakepassword1A!");


        registration.enterPhoneNumber().get(1).sendKeys("9259630196");


        registration.enterCity().sendKeys("portland");
        registration.enterStateAndCountry().get(0).sendKeys("oregon", Keys.TAB, Keys.TAB);


        registration.accreditedInvestorRadioButton().click();
        registration.termsOfServiceCheckbox().click();
        registration.investmentOppurtunitiesCheckBox().click();

        Thread.sleep(1000);
        registration.captchaCheckmark().click();

        Thread.sleep(5000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,250)");
        registration.signUpButton().click();
        driver.close();

    }


    //Add selenium jar files
    //upload in github so that they can fork
    //asssertion add
    //replace all thread.sleep method
    //close the browser
    //pull all the test to a seperate file
    //add confirmation dialog as test
    //Add @before
    //Add @after

}
