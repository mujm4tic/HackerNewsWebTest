package com.sparta.mm.pom;

import com.sparta.mm.pom.pages.HNHomepage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HackerNewsPOMTestsM {

    private static WebDriver driver;
    private HNHomepage homepage;


    @BeforeAll
    static void setupAll(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        homepage = new HNHomepage(driver);
    }

    @Test
    @DisplayName("Check that the ask link works")
    void checkThatTheAskLinkWorks() {
        assertEquals("https://news.ycombinator.com/ask", homepage.goToAsk().getURL());
    }

    @Test
    @DisplayName("If Header Exists")
    void ifHeaderExists() {
        assertTrue(homepage.goToAsk().doesHeaderExist());
    }

    @Test
    @DisplayName("Ask Page Has 30 Entries")
    void askPageHas30Entries() {
        assertTrue(homepage.goToAsk().getNumberContentTitles()==30);
    }

}
