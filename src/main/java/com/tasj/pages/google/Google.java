package com.tasj.pages.google;

import com.tasj.core.WaitFor;
import com.tasj.core.entities.ProxyCollection;
import org.openqa.selenium.By;

import static com.tasj.core.ConciseAPI.*;
import static com.tasj.core.conditions.CollectionConditions.size;
import static com.tasj.core.conditions.ElementConditions.text;
import static com.tasj.core.conditions.ElementConditions.visible;

public class Google {

    public static ProxyCollection results = $$(".srg>.g");

    public static void visit() {
        open("http://google.com/ncr");
    }

    public static void search(String searchText) {
        $(By.name("q")).setValue(searchText).pressEnter();
    }

    public static void assertCountResults(int count) {
        results.shouldHave(size(count));
    }

    public static void assertResultText(int index, String resultText) {
        results.get(index).shouldHave(text(resultText));
    }

    public static void followResultLink(int index) {
        results.get(index).find(".r").click();
    }


    public static void assertSeleniumPage() {
        WaitFor.until($(".downloadBox a"), visible());
        assert (getDriver().getCurrentUrl().equals("http://www.seleniumhq.org/"));
    }
}
