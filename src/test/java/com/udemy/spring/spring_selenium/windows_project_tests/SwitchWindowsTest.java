package com.udemy.spring.spring_selenium.windows_project_tests;

import com.udemy.spring.spring_selenium.SpringBaseTestNGTest;
import com.udemy.spring.spring_selenium.kelvin.service.SwitchWindowsService;
import com.udemy.spring.spring_selenium.windows.MainPage;
import com.udemy.spring.spring_selenium.windows.PageA;
import com.udemy.spring.spring_selenium.windows.PageB;
import com.udemy.spring.spring_selenium.windows.PageC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@TestPropertySource(properties = "browser=chrome")
public class SwitchWindowsTest extends SpringBaseTestNGTest {

    @Autowired
    private MainPage mainPage;

    @Autowired
    private PageA pageA;

    @Autowired
    private PageB pageB;

    @Autowired
    private PageC pageC;

    @BeforeClass
    public void setUp() {
        this.mainPage.goTo();
        Assert.assertTrue(this.mainPage.isDisplayed());
        this.mainPage.openAllLinks();
    }

    @Test(dataProvider = "getData")
    public void testSwitchWindows(int value) {
        this.pageA.writeMsg(value + "\n");
        this.pageB.writeMsg((value * 2) + "\n");
        this.pageC.writeMsg((value * 3) + "\n");

    }

    @DataProvider
    public Object[] getData(){
        return new Object[]{
          3,7,9,2,5
        };
    }


    @AfterTest
    public void tearDown() {
        this.mainPage.close();
    }


}
