package com.tasj.testconfigs;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.tasj.core.ConciseAPI.getDriver;
import static com.tasj.core.ConciseAPI.setDriver;

public class BaseTest {

    @BeforeClass
    public static void createDriver() {
        setDriver(new FirefoxDriver());
    }

    @AfterClass
    public static void tearDown() {
        getDriver().quit();
    }

}
