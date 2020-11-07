package io.github.greencity.l3.pages;

import io.github.greencity.l3.helpers.StableElementSearch;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;


public class MainPage implements StableElementSearch {
    WebDriver driver;
    Actions actions;

    By greencityLogo = By.xpath("//body//a[@class='small-screen-size']");
    By signInButton = By.cssSelector("li.sign-up-link>div.create-button>span");
    By newsButton = By.xpath("//a[@href='#/news']");
    By tipsButton = By.xpath("//a[@href='#/tips']");
    By placesButton = By.xpath("//a[@href='#/map']");
    By aboutUsButton = By.xpath("//a[@href='#/about']");
    By habitsButton = By.xpath("//div[@class='navigation-menu-left']//*[contains(text(),'My habits')]");
    By endOfNews = By.xpath("//div[@class='wrapper']//*[contains(text(),'Unfotunately ')]");
    By amountNews = By.xpath("//li[@class='gallery-view-li-active ng-star-inserted']");
    By adsFilter = By.xpath("//li[contains(text(),'Ads')]");
    By eventsFilter = By.xpath("//li[contains(text(),'Events')]");
    By newsFilter = By.xpath("//li[contains(text(),'News')]");
    By educationFilter = By.xpath("//li[contains(text(),'Education')]");
    By initiativesFilter = By.xpath("//li[contains(text(),'Initiatives')]");
    By lifehacksFilter = By.xpath("//li[contains(text(),'Lifehacks')]");
    By homepageFilter = By.xpath("//li[contains(text(),'homepage')]");
    By guysIMG = By.xpath("//div[@class='wrapper']//*[contains(text(),'Unfotunately ')]");

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

    public MainPage habitsButton() {

        return new MainPage(driver);
    }

    public MainPage toggleButtonAds() {
        searchElementByXpath(adsFilter).click();
        searchElementsByXpath(amountNews).size();
        int amount = searchElementsByXpath(amountNews).size();
        System.out.println(amount);
        searchElementByXpath(adsFilter).click();
        return new MainPage(driver);
    }
    public MainPage toggleButtonEvents() {

        searchElementByXpath(eventsFilter).click();
        int amount = searchElementsByXpath(amountNews).size();
        System.out.println(amount);
        searchElementByXpath(eventsFilter).click();
        return new MainPage(driver);
    }

    public MainPage toggleButtonNews() {
        searchElementByXpath(newsFilter).click();
        int amount = searchElementsByXpath(amountNews).size();
        System.out.println(amount);
        searchElementByXpath(newsFilter).click();
        return new MainPage(driver);
    }

    public MainPage toggleButtonEducation() {
        searchElementByXpath(educationFilter).click();
        int amount = searchElementsByXpath(amountNews).size();
        System.out.println(amount);
        searchElementByXpath(educationFilter).click();
        return new MainPage(driver);
    }
    public MainPage toggleButtonIniatives() {

        searchElementByXpath(initiativesFilter).click();
        int amount = searchElementsByXpath(amountNews).size();
        System.out.println(amount);
        searchElementByXpath(initiativesFilter).click();
        return new MainPage(driver);
    }

    public MainPage toggleButtonLifehacks() {
        searchElementByXpath(lifehacksFilter).click();
        int amount = searchElementsByXpath(amountNews).size();
        System.out.println(amount);
        searchElementByXpath(lifehacksFilter).click();
        return new MainPage(driver);
    }

    public MainPage toggleButtonHomepage() {
        searchElementByXpath(homepageFilter).click();
        int amount = searchElementsByXpath(amountNews).size();
        System.out.println(amount);
        searchElementByXpath(homepageFilter).click();
        return new MainPage(driver);
    }




    public MainPage findItems() {

        searchElementByXpath(greencityLogo).sendKeys(Keys.END);
        searchElementsByXpath(guysIMG);
        int items1 = searchElementsByXpath(amountNews).size();
        String foundItems = driver.findElement(By.xpath
                ("//div[@class='main-wrapper']//*[contains(text(),'items found')]")).getText();
        String array[] = foundItems.split(" ");
        int items2 = Integer.parseInt(array[0]);
        try { Assert.assertEquals(items1, items2); // должен упасть
            System.out.println("Количество фактических айтемов: " + items1 + " совпадает с указанными");
        } catch (AssertionError e) {
            System.out.println("Количество фактических айтемов: " + items2 + " не совпадает с указанными");
        }
        return new MainPage(driver);
    }

    public MainPage findUserData() {
        int items1 = driver.findElements
                (By.xpath("//li[@class='gallery-view-li-active ng-star-inserted']")).size();
        int dataUsers = driver.findElements
                (By.xpath("//div[@class='user-data-added-news']")).size();

        try { Assert.assertEquals(items1, dataUsers); // должен совпасть
            System.out.println("Количество датаюзеров: " + dataUsers + " совпадает с количеством новостей");
        } catch (AssertionError e) {
            System.out.println("Количество датаюзеров: " + dataUsers + " не совпадает с количеством новостей");
        }
        return new MainPage(driver);
    }

    @Override
    public WebDriver setDriver() {
        return this.driver;
    }
}
