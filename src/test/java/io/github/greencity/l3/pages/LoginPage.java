package io.github.greencity.l3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import sun.rmi.runtime.Log;

import java.util.concurrent.TimeUnit;

public class LoginPage {

    WebDriver driver;
    public LoginPage(WebDriver driver) { this.driver = driver; }

    public LoginPage open(){
        driver.get("https://ita-social-projects.github.io/GreenCityClient");
        driver.manage().window().maximize();
        return this;
    }
    public LoginPage clickSignUp(){
        driver.findElement(By.cssSelector("li.sign-up-link span"))
                .click();
        return this;
    }
    public LoginPage setEmail(String email) {
        driver.findElement(By.xpath("//input[@formcontrolname='email']"))
                .sendKeys(email);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        return this;
    }
    public LoginPage testEmail() {
        driver.findElements(By.cssSelector("div.error-message>app-error>div"));
        String pageSource = driver.getPageSource();
        Assert.assertFalse(pageSource.contains("error-message ng-star-inserted"));
        driver.findElement(By.xpath("//input[@formcontrolname='email']")).clear();
        return this;
    }

    public LoginPage clickAgain() {
        driver.findElement(By.cssSelector("li.sign-up-link span"))
                .click();
        return this;
    }

    public LoginPage setUserName(String UserName) {
        driver.findElement(By.xpath("//input[@formcontrolname='firstName']"))
                .sendKeys(UserName);
        driver.findElement(By.xpath("//input[@formcontrolname='email']")).click();
        return this;
    }


}
