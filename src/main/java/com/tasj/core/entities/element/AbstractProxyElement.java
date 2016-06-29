package com.tasj.core.entities.element;

import com.tasj.core.WaitFor;
import com.tasj.core.WithWaitFor;
import com.tasj.core.Command;
import com.tasj.core.conditions.ElementCondition;
import com.tasj.core.entities.ProxyCollection;
import com.tasj.core.entities.ProxyElement;
import com.tasj.core.entities.collection.ProxyElementInnerCollection;
import com.tasj.core.exceptions.ElementNotFoundException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static com.tasj.core.ConciseAPI.byCSS;
import static com.tasj.core.ConciseAPI.getDriver;
import static com.tasj.core.conditions.ElementConditions.present;
import static com.tasj.core.conditions.ElementConditions.visible;

public abstract class AbstractProxyElement implements ProxyElement {

    public WebElement getWrappedEntity() {
        WebElement element = fetchWrappedEntity();
        if (element != null) {
            return element;
        }
        throw new ElementNotFoundException(toString());
    }

    public abstract WebElement fetchWrappedEntity();

    public ProxyElement $(By innerLocator) {
        return new ProxyElementInnerElement(this, innerLocator);
    }

    public ProxyElement $(String innerCssSelector) {
        return $(byCSS(innerCssSelector));
    }

    public ProxyElement find(By innerLocator) {
        return $(innerLocator);
    }

    public ProxyElement find(String innerCssSelector) {
        return $(byCSS(innerCssSelector));
    }

    public ProxyCollection findAll(By innerLocator) {
        return new ProxyElementInnerCollection(this, innerLocator);
    }

    public ProxyCollection findAll(String innerCssSelector) {
        return findAll(byCSS(innerCssSelector));
    }

    public boolean is(ElementCondition condition) {
        try {
            return condition.check(getWrappedEntity());
        } catch (WebDriverException e) {
            return false;
        }
    }

    public ProxyElement setValue(final String value) {

        new WithWaitFor(this, visible()).run(new Command<WebElement>() {
            public WebElement execute(WebElement element) {
                element.clear();
                element.sendKeys(value);
                return element;
            }
        });
        return this;
    }

    public ProxyElement pressEnter() {
        this.sendKeys(Keys.ENTER);
        return this;
    }

    public ProxyElement pressTab() {
        this.sendKeys(Keys.TAB);
        return this;
    }

    public ProxyElement pressEsc() {
        this.sendKeys(Keys.ESCAPE);
        return this;
    }

    public ProxyElement should(ElementCondition... conditions) {
        WaitFor.until(this, conditions);
        return this;
    }

    public ProxyElement shouldBe(ElementCondition... conditions) {
        return should(conditions);
    }

    public ProxyElement shouldHave(ElementCondition... conditions) {
        return should(conditions);
    }

    public ProxyElement hover() {
        new WithWaitFor(this, visible()).run(new Command<WebElement>() {
            public WebElement execute(WebElement element) {
                new Actions(getDriver()).moveToElement(element).perform();
                return element;
            }
        });
        return this;
    }

    public ProxyElement doubleClick() {
        new WithWaitFor(this, visible()).run(new Command<WebElement>() {
            public WebElement execute(WebElement element) {
                new Actions(getDriver()).doubleClick(element).perform();
                return element;
            }
        });
        return this;
    }

    public void click() {
        new WithWaitFor(this, visible()).run(new Command<WebElement>() {
            public WebElement execute(WebElement element) {
                element.click();
                return element;
            }
        });
    }

    public void submit() {
        new WithWaitFor(this, visible()).run(new Command<WebElement>() {
            public WebElement execute(WebElement element) {
                element.submit();
                return element;
            }
        });
    }

    public void sendKeys(final CharSequence... charSequences) {
        new WithWaitFor(this, visible()).run(new Command<WebElement>() {
            public WebElement execute(WebElement element) {
                element.sendKeys(charSequences);
                return element;
            }
        });
    }

    public void clear() {
        new WithWaitFor(this, visible()).run(new Command<WebElement>() {
            public WebElement execute(WebElement element) {
                element.clear();
                return element;
            }
        });
    }

    public String getTagName() {
        return new WithWaitFor(this, present()).run(new Command<String>() {
            public String execute(WebElement element) {
                return element.getTagName();
            }
        });
    }

    public String getAttribute(final String s) {
        return new WithWaitFor(this, present()).run(new Command<String>() {
            public String execute(WebElement element) {
                return element.getAttribute(s);
            }
        });
    }

    public boolean isSelected() {
        return new WithWaitFor(this, visible()).run(new Command<Boolean>() {
            public Boolean execute(WebElement element) {
                return element.isSelected();
            }
        });
    }

    public boolean isEnabled() {
        return new WithWaitFor(this, visible()).run(new Command<Boolean>() {
            public Boolean execute(WebElement element) {
                return element.isEnabled();
            }
        });
    }

    public String getText() {
        return new WithWaitFor(this, visible()).run(new Command<String>() {
            public String execute(WebElement element) {
                return element.getText();
            }
        });
    }

    public List<WebElement> findElements(final By by) {
        return new WithWaitFor(this, visible()).run(new Command<List<WebElement>>() {
            public List<WebElement> execute(WebElement element) {
                return element.findElements(by);
            }
        });
    }

    public WebElement findElement(final By by) {
        return new WithWaitFor(this, visible()).run(new Command<WebElement>() {
            public WebElement execute(WebElement element) {
                return element.findElement(by);
            }
        });
    }

    public boolean isDisplayed() {
        return new WithWaitFor(this, visible()).run(new Command<Boolean>() {
            public Boolean execute(WebElement element) {
                return element.isDisplayed();
            }
        });
    }

    public Point getLocation() {
        return new WithWaitFor(this, visible()).run(new Command<Point>() {
            public Point execute(WebElement element) {
                return element.getLocation();
            }
        });
    }

    public Dimension getSize() {
        return new WithWaitFor(this, visible()).run(new Command<Dimension>() {
            public Dimension execute(WebElement element) {
                return element.getSize();
            }
        });
    }

    public Rectangle getRect() {
        return new WithWaitFor(this, visible()).run(new Command<Rectangle>() {
            public Rectangle execute(WebElement element) {
                return element.getRect();
            }
        });
    }

    public String getCssValue(final String s) {
        return new WithWaitFor(this, visible()).run(new Command<String>() {
            public String execute(WebElement element) {
                return element.getCssValue(s);
            }
        });
    }

    public <X> X getScreenshotAs(final OutputType<X> outputType) throws WebDriverException {
        return new WithWaitFor(this, visible()).run(new Command<X>() {
            public X execute(WebElement element) {
                return element.getScreenshotAs(outputType);
            }
        });
    }
}
