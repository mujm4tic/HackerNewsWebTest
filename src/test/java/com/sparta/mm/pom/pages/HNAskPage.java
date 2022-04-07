package com.sparta.mm.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HNAskPage {

    private WebDriver driver;
    private By pagetop = By.className("pagetop");
    private By titlelink = By.className("titlelink");

    public HNAskPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }

    public boolean doesHeaderExist() {
        System.out.println(pagetop.toString());
        return driver.findElement(pagetop).getText().contains("ask");
    }

    public int getNumberContentTitles() {
        List<WebElement> contentTitles = driver.findElements(titlelink);
        System.out.println(contentTitles);
        return contentTitles.size();
    }

    public List<String> getListContentTitles() {
        List<WebElement> contentTitles = driver.findElements(titlelink);
        List<String> titles = new ArrayList<>();
        for (WebElement title : contentTitles) {
            titles.add(title.getText());
            System.out.println(title.getText());
        } return titles;

    }
}
