package com.udemy.spring.spring_selenium.google_project.main;

import com.google.common.util.concurrent.Uninterruptibles;
import com.udemy.spring.spring_selenium.common_components.AbstractComponent;
import com.udemy.spring.spring_selenium.kelvin.annotations.PageFragment;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

@PageFragment
public class SearchWidget extends AbstractComponent {

    @FindBy(name = "q")
    private WebElement searchBox;

    public void search(String keyword){
        var keywordInChar = keyword.toCharArray();
        for(var c : keywordInChar){
            Uninterruptibles.sleepUninterruptibly(20, TimeUnit.MILLISECONDS);
            this.searchBox.sendKeys(c + "");
        }

    }

    @Override
    public boolean isDisplayed() {
        return super.isDisplayed(this.searchBox);
    }
}
