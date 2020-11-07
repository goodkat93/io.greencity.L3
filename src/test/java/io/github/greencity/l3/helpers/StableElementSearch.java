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
