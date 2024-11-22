package com.udemy.spring.spring_selenium.google_project.results;

import com.udemy.spring.spring_selenium.common_components.AbstractComponent;
import com.udemy.spring.spring_selenium.kelvin.annotations.PageFragment;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@PageFragment
public class ResultStats extends AbstractComponent {

    @FindBy(id = "result-stats")
    private WebElement results;

    @FindBy(tagName = "h3")
    private List<WebElement> suggestions;

    public String getResult(){
        return this.results.getText();
    }

    public Integer count(){
        return this.suggestions.size();
    }

    @Override
    public boolean isDisplayed() {
        return super.isDisplayed(results);
    }
}
