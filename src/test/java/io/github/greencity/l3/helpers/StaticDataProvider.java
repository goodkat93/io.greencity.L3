package io.github.greencity.l3.helpers;

import org.testng.annotations.BeforeGroups;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class StaticDataProvider {

    @BeforeGroups(value = {"SmokeSingUp"})
    @DataProvider(name = "usernameDataProvider")
    public Object[][] usernameDataProvider() {
        return new Object[][]{
                {"", "The name must contain 6-30 characters and can contain letters(a-z), numbers(0-9) and a dot(.)"},
                {"%T#%@#%@#$", "The name must contain 6-30 characters and can contain letters(a-z), numbers(0-9) and a dot(.)"},
                {"ggg", "The name must contain 6-30 characters and can contain letters(a-z), numbers(0-9) and a dot(.)"},
        };
    }

    @BeforeGroups(value = {"LessonExample"})
    @DataProvider(name = "LessonExampleDataProvider")
    public Object[][] LessonExampleDataProvider() {
        return new Object[][]{
                {"greencityp" + getRandom(), "asd",

                        setErrData("Please check that your e-mail address is indicated correctly," +
                                "The name must contain 6-30 characters and can contain letters(a-z),"
                        ),
                },
        };
    }


    private String getRandom() {
        return String.format("%s, %d", "+", (int) (Math.random() * ((Integer.MAX_VALUE - 1) - 10 + 1) + 1))
                .replaceAll("\\s+", "")
                .replace("-", "")
                .replace(",", "");
    }

    private List<String> setErrData(String errors) {
        String[] expectedDataStringArray = errors.trim().replaceAll("\\s+", "").split(",");
        return Arrays.asList(expectedDataStringArray);
    }

    @BeforeGroups(value = {"HomeWork"})
    @DataProvider(name = "HomeWorkDataProvider")

    public Object[][] HomeWorkDataProvider() {
        return new Object[][]{
                {"https://ita-social-projects.github.io/GreenCityClient/#/news"},
                {"https://ita-social-projects.github.io/GreenCityClient/#/tips"},
                {"https://ita-social-projects.github.io/GreenCityClient/#/map"},
                {"https://ita-social-projects.github.io/GreenCityClient/#/about"},

        };
    }
}