package com.udemy.spring.spring_selenium.google_project.results;

import com.udemy.spring.spring_selenium.common_components.AbstractComponent;
import com.udemy.spring.spring_selenium.kelvin.annotations.LazyAutowired;
import com.udemy.spring.spring_selenium.kelvin.annotations.Page;

@Page
public class GoogleResultsPage extends AbstractComponent {

    @LazyAutowired
    private NavigationBar navigationBar;

    @LazyAutowired
    private ResultStats resultStats;

    public NavigationBar getNavigationBar(){
        return this.navigationBar;
    }

    public ResultStats getResultStats(){
        return this.resultStats;
    }

    @Override
    public boolean isDisplayed() {
        return this.navigationBar.isDisplayed();
    }
}
