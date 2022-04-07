package com.sparta.mm.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HNHomepage {

    private WebDriver driver;

    By newest = new By.ByLinkText("new");
    By past = new By.ByLinkText("past");
    By comments = new By.ByLinkText("comments");
    By ask = new By.ByLinkText("ask");

    public HNHomepage(WebDriver driver) {
        this.driver = driver;
        driver.get("https://news.ycombinator.com/");
    }

    public HNNewestPage goToNewest() {
        driver.findElement(newest).click();
        return new HNNewestPage(driver);
    }

    public HNPastPage goToPastPage() {
        driver.findElement(past).click();
        return new HNPastPage(driver);
    }

    public HNCommentsPage goToComments() {
        driver.findElement(comments).click();
        return new HNCommentsPage(driver);
    }

    public HNAskPage goToAsk() {
        driver.findElement(ask).click();
        return new HNAskPage(driver);
    }


}
