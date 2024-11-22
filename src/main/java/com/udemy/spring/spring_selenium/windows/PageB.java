package com.udemy.spring.spring_selenium.windows;

import com.udemy.spring.spring_selenium.common_components.AbstractComponent;
import com.udemy.spring.spring_selenium.kelvin.annotations.Page;
import com.udemy.spring.spring_selenium.kelvin.annotations.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Window("Page B")
public class PageB extends AbstractComponent {

    @FindBy(id = "area")
    WebElement textArea;

    public void writeMsg(final String msg){
        this.textArea.sendKeys(msg);
    }

    @Override
    public boolean isDisplayed() {
        return super.isDisplayed(textArea);
    }
}
