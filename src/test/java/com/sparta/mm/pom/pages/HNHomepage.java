package com.sparta.mm.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HNHomepage {

    private WebDriver driver;
    private By pagetop = By.className("pagetop");
    private By morelink = By.className("morelink");
    private By titlelink = By.className("titlelink");
    private By rank = By.className("rank");

    By newest = new By.ByLinkText("new");
    By past = new By.ByLinkText("past");
    By comments = new By.ByLinkText("comments");
    By ask = new By.ByLinkText("ask");
    By show = new By.ByLinkText("show");

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

    public boolean doesHeaderExist(String name) {
        System.out.println(pagetop.toString());
        return driver.findElement(pagetop).getText().contains(name);
    }

    public void loadMoreArticles() {
        driver.findElement(morelink).click();
    }

    public int getNumberOfArticles() {
        List<WebElement> titlelinks = driver.findElements(titlelink);
        System.out.println(titlelinks);
        return titlelinks.size();
    }

    public List<String> getListArticles() {
        List<String> articles = new ArrayList<>();
        List<WebElement> titlelinks = driver.findElements(titlelink);
        for (WebElement element : titlelinks) {
            articles.add(element.getText());
            System.out.println(element.getText());
        }
        return articles;
    }

    public List<Integer> getListNumberArticles() {
        List<Integer> numberArticles = new ArrayList<>();
        List<WebElement> ranks = driver.findElements(rank);
        for (WebElement element : ranks) {
            numberArticles.add(numArticleToInt(element));
            System.out.println(element.getText());
        }
        return numberArticles;
    }

    public int getNumberArticle(int num) {
        WebElement element = driver.findElements(rank).get(num - 1);
        return numArticleToInt(element);

    }

    private Integer numArticleToInt(WebElement element) {
        return Integer.valueOf(element.getText().replace(".", ""));
      
    public HNShowPage goToShow() {
        driver.findElement(show).click();
        return new HNShowPage(driver);
    }

}
