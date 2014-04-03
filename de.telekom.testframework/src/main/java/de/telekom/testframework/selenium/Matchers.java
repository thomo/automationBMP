package de.telekom.testframework.selenium;

import de.telekom.testframework.selenium.controls.Control;
import de.telekom.testframework.selenium.controls.DelegatedWebElement;
import de.telekom.testframework.selenium.controls.Select;
import de.telekom.testframework.selenium.matchers.CachedElementTypeSafeMatcher;
import java.util.List;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.openqa.selenium.WebElement;

/**
 *
 * @author Daniel Biehl
 */
public class Matchers {

    @Factory
    public static Matcher<WebElement> attribute(final String attributeName, Matcher<String> matcher) {
        return new CachedElementTypeSafeMatcher<WebElement, String>("attribute '" + attributeName + "'", matcher) {

            @Override
            protected Object getValue(WebElement item) {
                return item.getAttribute(attributeName);
            }
        };
    }

    @Factory
    public static Matcher<WebElement> text(final Matcher<String> matcher) {
        return new CachedElementTypeSafeMatcher<WebElement, String>("text", matcher) {

            @Override
            protected Object getValue(WebElement item) {
                return item.getText();
            }
        };
    }

    @Factory
    public static Matcher<WebElement> value(final Matcher<String> matcher) {
        return new CachedElementTypeSafeMatcher<WebElement, String>("value", matcher) {

            @Override
            protected Object getValue(WebElement item) {
                if (item instanceof Control) {
                    return ((Control) item).get();
                }
                return item.getAttribute("value");
            }
        };
    }

    @Factory
    public static Matcher<WebElement> isDisplayed(final Matcher<Boolean> matcher) {
        return new CachedElementTypeSafeMatcher<WebElement, Boolean>("displayed", matcher) {

            @Override
            protected Object getValue(WebElement item) {
                return item.isDisplayed();
            }
        };
    }

    @Factory
    public static Matcher<WebElement> displayed() {
        return new CachedElementTypeSafeMatcher<WebElement, Boolean>("displayed") {

            @Override
            protected Object getValue(WebElement item) {
                return item.isDisplayed();
            }
        };
    }

    @Factory
    public static Matcher<WebElement> isDisplayed() {
        return new CachedElementTypeSafeMatcher<WebElement, Boolean>("is displayed") {

            @Override
            protected Object getValue(WebElement item) {
                return item.isDisplayed();
            }
        };
    }

    @Factory
    public static Matcher<WebElement> isEnabled(final Matcher<Boolean> matcher) {
        return new CachedElementTypeSafeMatcher<WebElement, Boolean>("enabled", matcher) {

            @Override
            protected Object getValue(WebElement item) {
                return item.isEnabled();
            }
        };
    }

    @Factory
    public static Matcher<WebElement> enabled() {
        return new CachedElementTypeSafeMatcher<WebElement, Boolean>("enabled") {

            @Override
            protected Object getValue(WebElement item) {
                return item.isEnabled();
            }
        };
    }

    @Factory
    public static Matcher<WebElement> isEnabled() {
        return new CachedElementTypeSafeMatcher<WebElement, Boolean>("is enabled") {

            @Override
            protected Object getValue(WebElement item) {
                return item.isEnabled();
            }
        };
    }

    @Factory
    public static Matcher<WebElement> selected(final Matcher<Boolean> matcher) {
        return new CachedElementTypeSafeMatcher<WebElement, Boolean>("selected", matcher) {

            @Override
            protected Object getValue(WebElement item) {
                return item.isSelected();
            }
        };
    }

    @Factory
    public static Matcher<WebElement> selected() {
        return new CachedElementTypeSafeMatcher<WebElement, Boolean>("selected") {

            @Override
            protected Object getValue(WebElement item) {
                return item.isSelected();
            }
        };
    }

    @Factory
    public static Matcher<WebElement> isSelected() {
        return new CachedElementTypeSafeMatcher<WebElement, Boolean>("is selected") {

            @Override
            protected Object getValue(WebElement item) {
                return item.isSelected();
            }
        };
    }

    @Factory
    public static Matcher<WebElement> exists(final Matcher<Boolean> matcher) {
        return new CachedElementTypeSafeMatcher<WebElement, Boolean>("exists", matcher) {

            @Override
            protected Object getValue(WebElement item) {
                if (item instanceof DelegatedWebElement) {
                    return ((DelegatedWebElement) item).exists();
                }
                throw new UnsupportedOperationException();
            }
        };
    }

    @Factory
    public static Matcher<WebElement> exists() {
        return new CachedElementTypeSafeMatcher<WebElement, Boolean>("exists") {

            @Override
            protected Object getValue(WebElement item) {
                if (item instanceof DelegatedWebElement) {
                    return ((DelegatedWebElement) item).exists();
                }
                throw new UnsupportedOperationException();
            }
        };
    }

    @Factory
    public static Matcher<WebElement> tagName(final Matcher<String> matcher) {
        return new CachedElementTypeSafeMatcher<WebElement, String>("tag name", matcher) {

            @Override
            protected Object getValue(WebElement item) {
                return item.getTagName();
            }
        };
    }

    @Factory
    public static Matcher<Page> isCurrentPage(final Matcher<Boolean> matcher) {
        return new CachedElementTypeSafeMatcher<Page, Boolean>("current page", matcher) {

            @Override
            protected Object getValue(Page item) {
                return item.isCurrentPage();
            }
        };
    }

    @Factory
    public static Matcher<Page> currentPage() {
        return new CachedElementTypeSafeMatcher<Page, Boolean>("current page") {

            @Override
            protected Object getValue(Page item) {
                return item.isCurrentPage();
            }
        };
    }

    @Factory
    public static Matcher<Page> isCurrentPage() {
        return new CachedElementTypeSafeMatcher<Page, Boolean>("is current page") {

            @Override
            protected Object getValue(Page item) {
                return item.isCurrentPage();
            }
        };
    }

    @Factory
    public static Matcher<Page> loaded(final Matcher<Boolean> matcher) {
        return new CachedElementTypeSafeMatcher<Page, Boolean>("loaded", matcher) {

            @Override
            protected Object getValue(Page item) {
                return item.isLoaded();
            }
        };
    }

    @Factory
    public static Matcher<Page> loaded() {
        return new CachedElementTypeSafeMatcher<Page, Boolean>("loaded") {

            @Override
            protected Object getValue(Page item) {
                return item.isLoaded();
            }
        };
    }

    @Factory
    public static Matcher<Page> isLoaded() {
        return new CachedElementTypeSafeMatcher<Page, Boolean>("is loaded") {

            @Override
            protected Object getValue(Page item) {
                return item.isLoaded();
            }
        };
    }

    @Factory
    public static Matcher<Select> selectedItem(final Matcher<WebElement> matcher) {
        return new CachedElementTypeSafeMatcher<Select, WebElement>("selected item", matcher) {

            @Override
            protected Object getValue(Select item) {
                return item.getSelectedOption();
            }
        };
    }

    @Factory
    public static Matcher<Select> selectedItems(final Matcher<List<WebElement>> matcher) {
        return new CachedElementTypeSafeMatcher<Select, List<WebElement>>("selected items", matcher) {

            @Override
            protected Object getValue(Select item) {
                return item.getSelectedOptions();
            }
        };
    }

    @Factory
    public static Matcher<Select> selectedItemText(final Matcher<String> matcher) {
        return new CachedElementTypeSafeMatcher<Select, String>("selected item text", matcher) {

            @Override
            protected Object getValue(Select item) {
                return item.getSelectedText();
            }
        };
    }

    @Factory
    public static Matcher<Select> selectedItemValue(final Matcher<String> matcher) {
        return new CachedElementTypeSafeMatcher<Select, String>("selected item value", matcher) {

            @Override
            protected Object getValue(Select item) {
                return item.getSelectedValue();
            }
        };
    }

    @Factory
    public static Matcher<Select> selectedItemIndex(final Matcher<Integer> matcher) {
        return new CachedElementTypeSafeMatcher<Select, Integer>("selected item index", matcher) {

            @Override
            protected Object getValue(Select item) {
                return item.getSelectedIndex();
            }
        };
    }

    @Factory
    public static Matcher<Select> item(final String textOrValue, final Matcher<WebElement> matcher) {
        return new CachedElementTypeSafeMatcher<Select, WebElement>("item '" + textOrValue + "'", matcher) {

            @Override
            protected Object getValue(Select item) {
                return item.findItem(textOrValue);
            }
        };
    }

    @Factory
    public static Matcher<Select> item(final int index, final Matcher<WebElement> matcher) {
        return new CachedElementTypeSafeMatcher<Select, WebElement>("item " + index, matcher) {

            @Override
            protected Object getValue(Select item) {
                return item.findItem(index);
            }
        };
    }
    
    @Factory
    public static Matcher<Browser> currentUrl(Matcher<String> matcher) {
        return new CachedElementTypeSafeMatcher<Browser, String>("current url", matcher) {

            @Override
            protected String getValue(Browser item) {
                return item.getCurrentUrl();
            }
        };
    }
}
