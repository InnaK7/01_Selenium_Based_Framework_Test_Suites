package com.tasj.core.entities;

import com.tasj.core.conditions.ElementCondition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public interface ProxyElement extends ProxyEntity<WebElement>, WebElement {

    ProxyElement $(By innerLocator);

    ProxyElement $(String innerCssSelector);

    ProxyElement find(By innerLocator);

    ProxyElement find(String innerCssSelector);

    ProxyCollection findAll(By innerLocator);

    ProxyCollection findAll(String innerCssSelector);

    boolean is(ElementCondition condition);


    ProxyElement setValue(String value);

    ProxyElement pressEnter();

    ProxyElement pressTab();

    ProxyElement pressEsc();

    ProxyElement hover();

    ProxyElement doubleClick();

    ProxyElement should(ElementCondition... conditions);

    ProxyElement shouldBe(ElementCondition... conditions);

    ProxyElement shouldHave(ElementCondition... conditions);

}
