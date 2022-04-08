package com.sparta.mm.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class HNPage {
    public WebDriver driver;
    private By pagetop = By.className("pagetop");
    private By titlelink = By.className("titlelink");
    private By morelink = By.className("morelink");
    private By itemlist = By.className("itemlist");

    public static final String[] TOP_LINKS = new String[]{"Hacker News", "new", "past", "comments", "ask", "show", "jobs", "submit"};

    public HNPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getSizeListTitle() {
        List<WebElement> titlelinks = driver.findElements(titlelink);
        return titlelinks.size();
    }

    public void clickMore() {
        driver.findElement(morelink).click();
    }

    public boolean doesTopLinkExist(String name) {
        System.out.println(driver.findElement(pagetop).getText());
        return driver.findElement(pagetop).getText().contains(name);
    }

    public boolean doPageContain(String word){
        String moreJobs = driver.findElement(itemlist).getText();
        return moreJobs.contains(word);
    }

    public boolean doListContain(String word){
        List<WebElement> elements = driver.findElements(titlelink);
        for(WebElement element : elements){
            if(element.getText().contains(word)){
                return true;
            }
        }
        return false;
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }


}
