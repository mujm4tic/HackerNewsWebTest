package com.sparta.mm.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HNShowPage {
    private WebDriver driver;

    public HNShowPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isNumberOfItemEquals30() {
        int count = driver.findElements(By.className("athing")).size();
        return count == 30;
    }

    public boolean isThatTheShowLinkWorks() {
        return getUrl().equals("https://news.ycombinator.com/show");
    }

    private String getUrl() {
        return driver.getCurrentUrl();
    }
}
