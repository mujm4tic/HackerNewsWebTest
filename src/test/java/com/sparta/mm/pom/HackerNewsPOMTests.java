package com.sparta.mm.pom;

import com.sparta.mm.pom.pages.HNHomepage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class HackerNewsPOMTests {
    private static WebDriver driver;
    private HNHomepage homepage;

    private static final String[] headers = new String[]{"Hacker News", "new", "past", "comments", "ask", "show", "jobs", "submit"};

    @BeforeAll
    static void setupAll() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        homepage = new HNHomepage(driver);
    }

    @Test
    @DisplayName("check headers exist")
    void checkHeadersExists() {
        for (String header : headers) {
            Assertions.assertTrue(homepage.doesHeaderExist(header));
        }
    }

    @Test
    @DisplayName("check number articles is 30")
    void checkNumberArticlesIs30() {
        Assertions.assertEquals(30, homepage.getNumberOfArticles());
    }

    @Test
    @DisplayName("check if 30 new articles are shown")
    void checkIf30NewArticlesAreShown() {
        homepage.loadMoreArticles();
        Assertions.assertTrue((homepage.getNumberArticle(1) == 31) && (homepage.getNumberArticle(30) == 60));
    }

    @Nested
    @DisplayName("Test past page")
    class testPastPage {
        @Test
        @DisplayName("Check that the past link works")
        void checkThePastLinkWorks() {
            Assertions.assertTrue(homepage.goToPastPage().isThatThePastLinkWorks());
        }

        @Test
        @DisplayName("Check the past page has yesterday's date")
        void checkThePastHasYesterdaySDate() {
            Assertions.assertTrue(homepage.goToPastPage().isDateYesterday());
        }

        @Test
        @DisplayName("Check number of item must be 30")
        void checkNumberOfItemEquals30() {
            Assertions.assertTrue(homepage.goToPastPage().isNumberOfItemEquals30());
        }

        @Test
        @DisplayName("Check number of item must be 30 when click More")
        void checkNumberOfItemAlwaysEquals30() {
            Assertions.assertTrue(homepage.goToPastPage().isNumberOfItemAlwaysEquals30());
        }
    }

    @Nested
    @DisplayName("Test past page")
    class testShowPage {
        @Test
        @DisplayName("Check that the show link works")
        void checkTheShowLinkWorks() {
            Assertions.assertTrue(homepage.goToShow().isThatTheShowLinkWorks());
        }

        @Test
        @DisplayName("Check number of item must be 30")
        void checkNumberOfItemEquals30() {
            Assertions.assertTrue(homepage.goToShow().isNumberOfItemEquals30());
        }
    }

    @AfterEach()
    void teardown() {
        driver.close();
    }

    @AfterAll
    static void teardownAll() {
        driver.quit();
    }
}
