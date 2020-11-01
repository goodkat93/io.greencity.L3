package io.github.greencity.l3.tests;

import io.github.greencity.l3.pages.LoginPage;
import io.github.greencity.l3.runner.Runner;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GreenCityTestUserName extends Runner {

    @DataProvider(name = "usernameDataProvider")
    public Object[][] usernameDataProvider(){
        return new Object[][]{
                {"", "The name must contain 6-30 characters and can contain letters(a-z), numbers(0-9) and a dot(.)"},
                {"%T#%@#%@#$", "The name must contain 6-30 characters and can contain letters(a-z), numbers(0-9) and a dot(.)"},
                {"ggg","The name must contain 6-30 characters and can contain letters(a-z), numbers(0-9) and a dot(.)"},
        };
    }


    @Test(dataProvider = "usernameDataProvider")
    public void TestUsername(String username, String errorMsg) {
        new LoginPage(driver)
                .open()
                .clickAgain()
                .setUserName(username);
        Assert.assertEquals(driver.findElement(By.cssSelector("app-error>div")).getText(), errorMsg);
    }
}

    