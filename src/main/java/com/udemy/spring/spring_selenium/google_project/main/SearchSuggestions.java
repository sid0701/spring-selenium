package com.udemy.spring.spring_selenium.google_project.main;

import com.udemy.spring.spring_selenium.common_components.AbstractComponent;
import com.udemy.spring.spring_selenium.kelvin.annotations.PageFragment;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@PageFragment
public class SearchSuggestions extends AbstractComponent {

    @FindBy(xpath = "//*[@role='listbox']/li")
    private List<WebElement> suggestions;

    public void selectSuggestion(int index){
        suggestions.get(index-1).click();
    }

    @Override
    public boolean isDisplayed() {
        return super.isDisplayed(suggestions);
    }
}
