package com.sparta.mm.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HNCommentsPage extends HNPage{


    public HNCommentsPage(WebDriver driver) {
        super(driver);
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

    public String GetParaGraphByIndex(int i){
        List<WebElement> elements = driver.findElements(By.className("commtext"));
        String Para = elements.get(i + 1).getText();

        return Para;
    }

    public int HowManySpacesInAParagraph(int p){
        List<WebElement> elements = driver.findElements(By.className("commtext"));
        String Para = elements.get(p).getText();
        int counter = 0;
        for (int i = 0;i< Para.length(); i++){
            if(Para.charAt(i) == ' '){
                counter++;
            }
        }
        return counter;
    }

    public int HowManySpacesInAParagraph() {
        List<WebElement> elements = driver.findElements(By.className("commtext"));
        int counter = 0;
        for (int i = 0; i < elements.get(i).getText().length(); i++) {
            String Para = elements.get(i).getText();
            for (int j = 0; j < Para.length(); j++) {
                if (Para.charAt(j) == ' ') {
                    counter++;
                }else{

                }
            }
        }
        return counter;
    }
    
}
