import crowdstreet.pages.CreateAccount;
import crowdstreet.pages.LaunchApp;
import crowdstreet.pages.Registration;
import org.junit.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;


import static junit.framework.TestCase.assertTrue;

public class RegistrationProcessTest {

    public static final String password = "fakepassword1A!";
    public static final String phoneNumber = "9259630196";
    public static final String firstName = "priya";
    public static final String lastName = "boopathi";
    public static final WebDriver driver = new ChromeDriver();
    public static final String cityName = "portland";
    public static final String stateName = "oregon";
    public static final String url = "https://test.crowdstreet.com/properties/?";
    public static String actualBaseUrl;
    public static final LaunchApp launchApp = new LaunchApp(driver);

    @BeforeClass
    public static void setUp() throws Exception {

        //Set Chrome Driver
        //System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");

        // Maximize browser
        driver.manage().window().fullscreen();
        String actualBaseUrl = url;
        launchApp.getUrl(actualBaseUrl);

    }

    @Test
    public void RegisterUser() throws InterruptedException {

        String expectedUrl = url;
        Registration registration = new Registration(driver);
        CreateAccount createAccount = new CreateAccount(driver);


        actualBaseUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualBaseUrl, expectedUrl);

        Thread.sleep(300);
        createAccount.createAccount().click();

        Thread.sleep(300);
        assertTrue(driver.getTitle().contains("Create Account"));

        String userName = "" + (int) (Math.random() * Integer.MAX_VALUE);
        String emailID = firstName + userName + "@gmail.com";

        registration.getEmailID().sendKeys(emailID);
        registration.enterUserName().sendKeys(firstName);


        registration.enterLastName().sendKeys(lastName);
        WebElement createPassword = registration.enterPassword();
        createPassword.sendKeys(password);
        createPassword.sendKeys(Keys.TAB);
        registration.passwordVisibilityToggle().click();
        createPassword.sendKeys(Keys.TAB);

        Thread.sleep(100);
        registration.confirmPassword().get(4).sendKeys(password);


        registration.enterPhoneNumber().get(1).sendKeys(phoneNumber);


        registration.enterCity().sendKeys(cityName);
        registration.enterStateAndCountry().get(0).sendKeys(stateName, Keys.TAB, Keys.TAB);


        registration.accreditedInvestorRadioButton().click();
        registration.termsOfServiceCheckbox().click();
        registration.investmentOppurtunitiesCheckBox().click();

        Thread.sleep(1000);
        registration.captchaCheckmark().click();

        Thread.sleep(5000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,250)");
        registration.signUpButton().click();

        Thread.sleep(1000);


    }

    @AfterClass
    public static void tearDown() {

        // Closing the browser and WebDriver
        driver.close();
        driver.quit();
    }


}
