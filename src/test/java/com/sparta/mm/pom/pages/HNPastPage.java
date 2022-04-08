package com.sparta.mm.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;


public class HNPastPage extends HNPage {

    public HNPastPage(WebDriver driver) {
        //this.driver = driver;
        super(driver);
    }

    public boolean isDateYesterday() {
        String dateCheck = driver.findElement(By.className("pagetop")).getText();
        LocalDate yesterday = LocalDate.now().minusDays(1);
        return dateCheck.contains(yesterday.toString());
    }

    public boolean isNumberOfItemEquals30() {
        int count = driver.findElements(By.className("athing")).size();
        return count == 30;
    }

    public boolean isNumberOfItemAlwaysEquals30() {
        boolean equals30 = true;
        boolean isMoreExist = isMoreExist();
        while (isMoreExist) {
            if (getNumberOfItem() != 30) {
                equals30 = false;
            }
            clickMore();
            isMoreExist = isMoreExist();
        }
        return equals30;
    }

    public boolean isThatThePastLinkWorks() {
        return getUrl().equals("https://news.ycombinator.com/front");
    }

    //public void clickMore() {
    //    driver.findElement(By.className("morelink")).click();
    //}

    private int getNumberOfItem() {
        return driver.findElements(By.className("athing")).size();
    }

    private boolean isMoreExist() {
        return driver.findElements(By.className("morelink")).size() > 0;
    }

    //public String getUrl() {
    //    return driver.getCurrentUrl();
    //}
}
