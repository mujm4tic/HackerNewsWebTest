package com.sparta.mm.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HNHomepage extends HNPage {

    private By rank = By.className("rank");

    By newest = new By.ByLinkText("new");
    By past = new By.ByLinkText("past");
    By comments = new By.ByLinkText("comments");
    By ask = new By.ByLinkText("ask");
    By show = new By.ByLinkText("show");
    By jobs = new By.ByLinkText("jobs");

    public HNHomepage(WebDriver driver) {
        super(driver);
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

    public HNJobsPage goToJobs() {
        driver.findElement(jobs).click();
        return new HNJobsPage(driver);
    }

    public HNShowPage goToShow() {
        driver.findElement(show).click();
        return new HNShowPage(driver);
    }

    public List<Integer> getListNumberArticles() {
        List<Integer> numberArticles = new ArrayList<>();
        List<WebElement> ranks = driver.findElements(rank);
        for (WebElement element : ranks) {
            numberArticles.add(numArticleToInt(element));
        }
        return numberArticles;
    }

    public int getNumberArticle(int num) {
        WebElement element = driver.findElements(rank).get(num - 1);
        return numArticleToInt(element);

    }
    
    private Integer numArticleToInt(WebElement element) {
        return Integer.valueOf(element.getText().replace(".", ""));
    }
}
