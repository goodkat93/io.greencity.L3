package io.github.greencity.l3.tests;

import io.github.greencity.l3.pages.MainPage;
import io.github.greencity.l3.runner.Runner;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GreenCityTestUserName extends Runner{

/*    @Test(groups = {"SmokeSingUp"},dataProvider = "usernameDataProvider",dataProviderClass = StaticDataProvider.class )
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
*/


//    @Test
//    public void testItems() {
//        new MainPage(driver)
//                .open()
//                .clickEcoNewsButton()
//                .toggleButtonNews()
//                .newsToggleOff()
//                .scrolldown()
//                .findItems()
//                .findItemsCountShouldExit();
//    }

    @Test
    public void testToggleButtonAds() {
        new MainPage(driver)
                .open()
                .clickEcoNewsButton()
                .toggleButtonAds();
    }

    @Test
    public void testToggleButtonEvents(){
        new MainPage(driver)
                .open()
                .clickEcoNewsButton()
                .toggleButtonEvents()
                .eventsToggleOff();
    }

    @Test
    public void testToggleButtonNews(){
        new MainPage(driver)
                .open()
                .clickEcoNewsButton()
                .toggleButtonNews()
                .scrollDown()
                .findItems()
                .scrollUp()
                .newsToggleOff();

    }

    @Test
    public void scrollTesting(){
        new MainPage(driver)
                .open()
                .clickEcoNewsButton()
                .scrollDown()
                .findItems();
    }

    @Test
    public void listViewTesting(){
        new MainPage(driver)
                .open()
                .clickEcoNewsButton()
                .switchToListView()
                .scrollDown();
        Assert.assertTrue(driver.findElement(By.cssSelector("app-news-list-list-view")).isDisplayed());

    }

}

