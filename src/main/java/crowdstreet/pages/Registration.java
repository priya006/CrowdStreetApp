package crowdstreet.pages;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Registration {
    WebDriver webDriver;

    public Registration(WebDriver webDriver) {

        this.webDriver = webDriver;

    }

    //WebElements


    public WebElement getEmailID() {
        return webDriver.findElement(By.xpath("//div[@class='email-input sc-bdVaJa cXgeQK']//input"));
    }

    public WebElement enterUserName() {

        return webDriver.findElement(By.xpath("//div[@class='input-container flex-input -left sc-bdVaJa hgkmdP']//div[@class='ui icon input css-o5h0vj e1g1cy8v0']//input"));

    }

    public WebElement enterLastName() {
        return webDriver.findElement(By.xpath("//div[@class='input-container flex-input sc-bdVaJa hgkmdP']//div[@class='ui icon input css-o5h0vj e1g1cy8v0']//input"));
    }

    public WebElement enterPassword() {
        return webDriver.findElement(By.xpath("//div[@class='input-container password-input sc-bdVaJa hgkmdP']//input"));
    }

    public WebElement passwordVisibilityToggle() {
        return webDriver.findElement(By.xpath("//div[@class='icon password-visibility-toggle css-xewyfa']"));
    }

    public List<WebElement> confirmPassword() {
        return webDriver.findElements(By.xpath("//div[@class='ui icon input css-o5h0vj e1g1cy8v0']//input"));
    }

    public List<WebElement> enterPhoneNumber() {
        return webDriver.findElements(By.xpath("//div[@class='ui error icon input css-o5h0vj e1g1cy8v0']//input"));
    }

    public WebElement enterAddress() {
        return webDriver.findElement(By.xpath("//div[7]//div[1]//input[1]"));
    }

    public WebElement enterCity() {
        return webDriver.findElement(By.xpath("//div[8]//div[1]//input[1]"));
    }

    public List<WebElement> enterStateAndCountry() {
        return webDriver.findElements(By.xpath("//div[@class='ui search selection dropdown']//input[@class='search']"));
    }

    public WebElement accreditedInvestorRadioButton() {
        return webDriver.findElement(By.xpath("//div[@class='accredited-investor-container css-o1tkm0 e109gmdt0 sc-bdVaJa cnuUcN']//label[1]//div[1]"));
    }

    public WebElement termsOfServiceCheckbox() {
        return webDriver.findElement(By.xpath("//div[@class='terms-of-service-container css-ldki8z e1iyn53t0 sc-bdVaJa cnuUcN']//div[1]//label[1]//div[1]"));
    }

    public WebElement investmentOppurtunitiesCheckBox() {
        return webDriver.findElement(By.xpath("//div[@class='terms-of-service-container css-ldki8z e1iyn53t0 sc-bdVaJa cnuUcN']//div[2]//label[1]//div[1]"));
    }

    public WebElement captchaCheckmark() {
        return webDriver.findElement(By.xpath("//div[contains(@class, 'recaptcha')]"));
    }

    public WebElement signUpButton() {
        return webDriver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/button[1]"));
    }
}
