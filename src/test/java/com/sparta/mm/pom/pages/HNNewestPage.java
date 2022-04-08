package com.sparta.mm.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HNNewestPage extends HNPage {

    public HNNewestPage(WebDriver driver) {
        super(driver);
    }


    public boolean isFirstArticleLessThanAnHour(){
        String date = driver.findElement(By.className("age")).getText();
        return date.contains("minutes ago");

    }
}
