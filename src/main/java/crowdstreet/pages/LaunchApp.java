package crowdstreet.pages;

import org.openqa.selenium.*;



public class LaunchApp {

    WebDriver webDriver;

    public LaunchApp(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public void getUrl(String url){
        webDriver.get(url);
    }
}
