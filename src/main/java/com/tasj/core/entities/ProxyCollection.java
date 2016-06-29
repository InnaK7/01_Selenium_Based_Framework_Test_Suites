package com.tasj.core.entities;

import com.tasj.core.conditions.CollectionCondition;
import com.tasj.core.conditions.ElementCondition;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface ProxyCollection extends ProxyEntity<List<WebElement>>, Iterable<ProxyElement> {

    ProxyCollection should(CollectionCondition... conditions);

    ProxyCollection shouldBe(CollectionCondition... conditions);

    ProxyCollection shouldHave(CollectionCondition... conditions);

    ProxyElement get(int index);

    ProxyElement find(ElementCondition condition);

    ProxyCollection filter(ElementCondition condition);
}
