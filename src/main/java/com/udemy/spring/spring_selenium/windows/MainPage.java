package com.udemy.spring.spring_selenium.windows;

import com.udemy.spring.spring_selenium.common_components.AbstractComponent;
import com.udemy.spring.spring_selenium.kelvin.annotations.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Page
public class MainPage extends AbstractComponent {

    @FindBy(tagName = "a")
    private List<WebElement> links;

    public void goTo(){
        this.driver.get("https://vins-udemy.s3.amazonaws.com/ds/window/main.html");
    }

    public void openAllLinks(){
        this.links.stream()
                .forEach(WebElement::click);
    }

    public void close(){
        this.driver.quit();
    }

    @Override
    public boolean isDisplayed() {
       return super.isDisplayed(links);
    }
}
