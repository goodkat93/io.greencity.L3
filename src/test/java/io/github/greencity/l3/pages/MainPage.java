package io.github.greencity.l3.pages;

import io.github.greencity.l3.helpers.StableElementSearch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage implements StableElementSearch {
    By signInButton = By.cssSelector("li.sign-up-link>div.create-button>span");
    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage open(){
        driver.get("https://ita-social-projects.github.io/GreenCityClient");
        driver.manage().window().maximize();
        return this;
    }

    public LoginPage clickSignUp(){
        driver.findElement(signInButton)
                .click();
        return new LoginPage(driver);
    }

    @Override
    public WebDriver setDriver() {
        return this.driver;
    }
}
