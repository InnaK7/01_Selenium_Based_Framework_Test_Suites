package com.tasj.google;

import com.tasj.testconfigs.BaseTest;
import org.junit.Test;

import static com.tasj.pages.google.Google.*;

public class GoogleTest extends BaseTest {

    @Test
    public void testSearchAndFollowLink() {

        visit();
        search("Selenium automates browsers");
        assertCountResults(10);
        assertResultText(0, "Selenium automates browsers");

        followResultLink(0);
        assertSeleniumPage();
    }
}
