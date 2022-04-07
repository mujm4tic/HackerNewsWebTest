package com.sparta.mm.pom.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import sun.swing.StringUIClientPropertyKey;

import java.security.PublicKey;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HNCommentsPage {

    private WebDriver driver;

    public HNCommentsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String GetParaGraphByIndex(int i){
        List<WebElement> elements = driver.findElements(By.className("commtext"));
        String Para = elements.get(i + 1).getText();

        return Para;
    }

    public boolean isLessThan30CommentOnPage() {
        List listed = driver.findElements(By.className("commtext"));
        return listed.size() <= 30;
    }



    public boolean CheckIfParagraphsIsString(){
        List<WebElement> elements = driver.findElements(By.className("commtext"));
        boolean Okay = false;
        for (int i = 0; i< elements.size(); i++){
            String Para = elements.get(i).getText();
            if (Para.getClass().equals(String.class)){
                Okay = true;
            }else{
                Okay = false;
            }
        }
        return Okay;
    }

    public boolean CheckSpecificParagraphIsString(int i){
        List<WebElement> elements = driver.findElements(By.className("commtext"));
        String Para = elements.get(i + 1).getText();

        return Para.getClass().equals(String.class);
    }


}
