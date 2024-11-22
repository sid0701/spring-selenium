package com.udemy.spring.spring_selenium.google_project.results;

import com.udemy.spring.spring_selenium.common_components.AbstractComponent;
import com.udemy.spring.spring_selenium.kelvin.annotations.PageFragment;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageFragment
public class NavigationBar extends AbstractComponent {

    @FindBy(css = "div.sBbkle")
    private WebElement navigationBar;

    @FindBy(xpath = "//div[text()=\"Video's\"]")
    private WebElement videosTab;

    @FindBy(xpath = "//div[text()='Nieuws']")
    private WebElement newsTab;

    @FindBy(xpath = "//div[text()='Tools']")
    private WebElement toolsTab;

    public void clickOnVideosTab(){
        this.videosTab.click();
        this.toolsTab.click();
    }

    public void clickOnNewsTab(){
        this.newsTab.click();
        this.toolsTab.click();
    }

    @Override
    public boolean isDisplayed() {
        return super.isDisplayed(navigationBar);
    }
}
