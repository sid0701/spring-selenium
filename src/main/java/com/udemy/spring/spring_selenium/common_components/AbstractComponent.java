package com.udemy.spring.spring_selenium.common_components;

import com.udemy.spring.spring_selenium.kelvin.annotations.LazyAutowired;
import com.udemy.spring.spring_selenium.kelvin.annotations.PageFragment;
import jakarta.annotation.PostConstruct;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@PageFragment
public abstract class AbstractComponent {


    @LazyAutowired
    protected WebDriver driver;

    @LazyAutowired
    protected WebDriverWait wait;

    @LazyAutowired
    protected Actions actions;

//    @LazyAutowired
//    protected JavascriptExecutor js;


    @PostConstruct
    private void init() {
        PageFactory.initElements(driver, this);
    }

    protected abstract boolean isDisplayed();

    protected boolean isDisplayed(WebElement e){

        try {
            return this.wait.until((d) -> e.isDisplayed());
        }
        catch (TimeoutException te){
            return false;
        }
    }

    protected boolean isDisplayed(List<WebElement> l){
        return this.wait.until((d) -> l.size() > 2);
    }

}
