package io.github.greencity.l3.helpers;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

    /**
     * convenient way to search Web Elements
     */
//TODO replace elements search workaround with proper implementation using explicit wait
    public interface StableElementSearch {
        /**
         * set Webdriver that should to be used
         * @return WebDriver
         */
        WebDriver setDriver();
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



        default public WebElement searchElementByCss(By locator){
            return explicitSearch(visibilityOfElementLocated(locator));
        }

        default public WebElement searchElementByCss(String locator){
            return explicitSearch(visibilityOfElementLocated(By.cssSelector(locator)));
        }

        default public WebElement searchElementByXpath(By xPath){
            return explicitSearch(visibilityOfElementLocated(xPath));
        }

        default public WebElement searchElementByXpath(String xPath){
            return explicitSearch(visibilityOfElementLocated(By.xpath(xPath)));
        }


        default public List<WebElement> searchElementsByCss(By locator){
            searchElementByCss(locator);
            return setDriver().findElements(locator);
        }


        default public List<WebElement> searchElementsByXpath(By locator){
            searchElementByCss(locator);
            return setDriver().findElements(locator);
        }



        default public List<WebElement> searchElementsByCss(String locator){
            searchElementByCss(locator);
            return setDriver().findElements(By.cssSelector(locator));
        }


        default public List<WebElement> searchElementsXpath(String locator){
            searchElementByCss(locator);
            return setDriver().findElements(By.cssSelector(locator));
        }

        default public <V> V explicitSearch(Function<? super WebDriver, V> condition){
            setDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            V element = (new WebDriverWait(setDriver(),20)).until(condition);
            setDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            return element;
        }

    }
