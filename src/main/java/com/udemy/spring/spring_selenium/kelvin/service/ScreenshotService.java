package com.udemy.spring.spring_selenium.kelvin.service;

import com.udemy.spring.spring_selenium.kelvin.annotations.LazyAutowired;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

@Lazy
@Service
public class ScreenshotService {

    @LazyAutowired
    private ApplicationContext context;

    @Value("${screenshot.path}")
    private Path screenshotPath;

    public void takesScreenshot(final String imgName) throws IOException {
        File sourceFile = this.context.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.FILE);
        FileCopyUtils.copy(sourceFile,screenshotPath.resolve(imgName+".png").toFile());
    }

    public byte[] getScreenshotAsBytes(){
       return this.context.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.BYTES);
    }

}
