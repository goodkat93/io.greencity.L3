package io.github.greencity.l3.pages;

import io.github.greencity.l3.helpers.StableElementSearch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import sun.rmi.runtime.Log;

import java.util.concurrent.TimeUnit;

public class LoginPage implements StableElementSearch {

    By signInButton = By.cssSelector("li.sign-up-link>div.create-button>span");

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public LoginPage setEmail(String email) {
        searchElementByXpath("//input[@formcontrolname='email']").sendKeys(email);
        return this;
    }

    public LoginPage testEmail() {
        searchElementByCss("div.error-message>app-error>div");
        String pageSource = driver.getPageSource();
        Assert.assertFalse(pageSource.contains("error-message ng-star-inserted"));
        searchElementByXpath("//input[@formcontrolname='email']").clear();
        return this;
    }

    public LoginPage clickSignUp() {
        driver.findElement(signInButton)
                .click();
        return new LoginPage(driver);
    }

    public LoginPage setUserName(String UserName) {
        searchElementByXpath("//input[@formcontrolname='firstName']")
                .sendKeys(UserName);
        searchElementByXpath("//input[@formcontrolname='email']").click();
        return this;
    }


    @Override
    public WebDriver setDriver() {
        return this.driver;
    }
}
