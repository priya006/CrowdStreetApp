package crowdstreet.pages;

import org.openqa.selenium.*;

public class CreateAccount {
    WebDriver webDriver;

    public CreateAccount(WebDriver webDriver) {

        this.webDriver = webDriver;

    }

    //WebElements

    public WebElement createAccount() {
        return webDriver.findElement(By.xpath("//div[@class='css-108j06w']//a[@class='_button_d2f0c _flat_d2f0c _button_d2f0c _squared_d2f0c _primary_d2f0c join-button'][contains(text(),'Create An Account')]"));
    }
}
