package io.github.greencity.l3.tests;

import io.github.greencity.l3.pages.LoginPage;
import io.github.greencity.l3.runner.Runner;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GreenCityTestEmail extends Runner {

    @DataProvider(name = "emailDataProvider")
    public Object[][] emailDataProvider() {
        return new Object[][]{
                {"easdasf", " Please check that your e-mail address is indicated correctly"},
                {"f№%^^gdf", " Please check that your e-mail address is indicated correctly"},
                {"ggg", " Please check that your e-mail address is indicated correctly"},
                {"blabla@com", ""},
        };
    }

/*    @Test(dataProvider = "emailDataProvider")
    public void verifyData1(String email, String errMsg) {
        new LoginPage(driver)
                .open()
                .clickSignUp()
                .setEmail(email)
                .testEmail();

        Assert.assertEquals(driver.findElement(By.cssSelector("app-error>div")).getText(), errMsg);
    }

    @Test()
    public void SecondTest() {

        new LoginPage(driver)
                .open()
                .clickSignUp();
    }*/
}