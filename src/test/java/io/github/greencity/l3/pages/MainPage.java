package io.github.greencity.l3.pages;

import io.github.greencity.l3.helpers.StableElementSearch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MainPage implements StableElementSearch {

    By signInButton = By.cssSelector("li.sign-up-link>div.create-button>span");
    By newsButton = By.xpath("//a[@href='#/news']");
    By tipsButton = By.xpath("//a[@href='#/tips']");
    By placesButton = By.xpath("//a[@href='#/map']");
    By aboutUsButton = By.xpath("//a[@href='#/about']");
    By notLoginHabitsButton = By.xpath("//a[@href='#/profile/not_signed_in']");
    By LoginHabitsButton = By.xpath("");
    WebDriver driver;



    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage open() {
        driver.get("https://ita-social-projects.github.io/GreenCityClient");
        driver.manage().window().maximize();
        return this;
    }

    public LoginPage clickSignUp() {
        driver.findElement(signInButton)
                .click();
        return new LoginPage(driver);
    }

    public MainPage clickNewsButton() {
        searchElementByXpath(newsButton)
                .click();
        Assert.assertTrue(driver.getCurrentUrl()
                .contains("https://ita-social-projects.github.io/GreenCityClient/#/news"));
        return new MainPage(driver);
    }

    public MainPage clickTipsButton() {
        searchElementByXpath(tipsButton)
                .click();
        Assert.assertTrue(driver.getCurrentUrl()
                .contains("https://ita-social-projects.github.io/GreenCityClient/#/tips"));
        return new MainPage(driver);
    }

    public MainPage clickPlacesButton() {
        searchElementByXpath(placesButton)
                .click();
        Assert.assertTrue(driver.getCurrentUrl()
                .contains("https://ita-social-projects.github.io/GreenCityClient/#/map"));
        return new MainPage(driver);
    }

    public MainPage clickAboutUsButton() {
        searchElementByXpath(aboutUsButton)
                .click();
        Assert.assertTrue(driver.getCurrentUrl()
                .contains("https://ita-social-projects.github.io/GreenCityClient/#/about"));
        return new MainPage(driver);
    }

    public MainPage clickHabits(){
        return new MainPage(driver);
    }


    @Override
    public WebDriver setDriver() {
        return this.driver;
    }
}
