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

    public boolean isTitleStartWithShowHN() {
        boolean titleStartWithShowHN = true;
        int numberOfArticle = getNumberOfArticle();
        String[] articles = new String[numberOfArticle];
        for (int i = 0; i < numberOfArticle; i ++) {
            articles[i] = getTitleOfTheArticle(i);
            if (!articles[i].startsWith("Show HN:"))
                titleStartWithShowHN = false;
        }
        return titleStartWithShowHN;
    }

    public boolean isTitleAlwaysStartWithShowHN() {
        boolean isMoreExist = isMoreExist();
        boolean titleStartWithShowHN = true;
        while (isMoreExist) {
            int numberOfArticle = getNumberOfArticle();
            String[] articles = new String[numberOfArticle];
            for (int i = 0; i < numberOfArticle; i ++) {
                articles[i] = getTitleOfTheArticle(i);
                if (!articles[i].startsWith("Show HN:"))
                    titleStartWithShowHN = false;
            }
            clickMore();
            isMoreExist = isMoreExist();
        }
        return titleStartWithShowHN;
    }

    public String getTitleOfTheArticle(int i) {
        return driver.findElements(By.className("titlelink")).get(i).getText();
    }

    public boolean isThatTheShowLinkWorks() {
        return getUrl().equals("https://news.ycombinator.com/show");
    }

    private String getUrl() {
        return driver.getCurrentUrl();
    }

    private int getNumberOfArticle() {
        return driver.findElements(By.className("titlelink")).size();
    }

    private void clickMore() {
        driver.findElement(By.className("morelink")).click();
    }

    private boolean isMoreExist() {
        return driver.findElements(By.className("morelink")).size() > 0;
    }
}
