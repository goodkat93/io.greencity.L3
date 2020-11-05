package io.github.greencity.l3.tests;

import io.github.greencity.l3.helpers.StaticDataProvider;
import io.github.greencity.l3.pages.LoginPage;
import io.github.greencity.l3.pages.MainPage;
import io.github.greencity.l3.runner.Runner;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;

import java.util.List;

public class GreenCityTestUserName extends Runner{

    @Test(groups = {"SmokeSingUp"},dataProvider = "usernameDataProvider",dataProviderClass = StaticDataProvider.class )
    public void TestUsername(String username, String errorMsg) {
        new MainPage(driver)
                .open()
                .clickSignUp()
                .setUserName(username);
        Assert.assertEquals(driver.findElement(By.cssSelector("app-error>div")).getText(), errorMsg);
    }

    @Test(groups = {"LesonExample"},dataProvider = "LesonExampleDataprovider",dataProviderClass = StaticDataProvider.class )
    public void Example(String email, String userName,  List<String> errorMsgs) {
        new MainPage(driver)
                .open()
                .clickSignUp()
                .setEmail(email)
                .setUserName(userName);
        Assert.assertTrue(driver.findElements(By.cssSelector("app-error>div"))
                        .get(0).getText().trim().replaceAll("\\s+", "").contains(errorMsgs.get(0)));
        Assert.assertTrue(driver.findElements(By.cssSelector("app-error>div"))
                        .get(1).getText().trim().replaceAll("\\s+", "").contains(errorMsgs.get(1)));
    }

    @Test
    public void MainPageSelectors(){

        new MainPage(driver)
                .open()
                .clickNewsButton()
                .clickTipsButton()
                .clickPlacesButton()
                .clickAboutUsButton();


    }
}

    