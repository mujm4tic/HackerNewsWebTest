package com.sparta.mm.pom;

import com.sparta.mm.pom.pages.HNHomepage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HackerNewsPOMTestsSim {

    private static WebDriver driver;
    private HNHomepage homepage;

    @BeforeAll
    static void setupAll() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        homepage = new HNHomepage(driver);
    }

    @Nested
    @DisplayName("Test Newest Page")
    class testNewestPage{

        @Test
        @DisplayName("Check that the newest link works")
        void checkThatTheAskLinkWorks() {
            assertEquals("https://news.ycombinator.com/newest", homepage.goToNewest().getUrl());
        }

        @Test
        @DisplayName("Check first article time is less than an hour")
        void checkFirstArticleTimeIsLessThanAnHour() {
            Assertions.assertTrue(homepage.goToNewest().isFirstArticleLessThanAnHour());
        }
    }

    @Nested
    @DisplayName("Test Jobs Page")
    class testJobsPage {

        @Test
        @DisplayName("Check that the newest link works")
        void checkThatTheAskLinkWorks() {
            assertEquals("https://news.ycombinator.com/jobs", homepage.goToJobs().getUrl());
        }

        @Test
        @DisplayName("Check list shows 30 jobs")
        void checkListShows30Jobs() {
            Assertions.assertEquals(30,homepage.goToJobs().getSizeListTitle());
        }

        @Test
        @DisplayName("Check 30 more jobs are listed after clicking more")
        void check30MoreJobsAreListedAfterClickingMore() {
            homepage.goToJobs().clickMore();
            Assertions.assertEquals(30,homepage.goToJobs().getSizeListTitle());
        }

        @Test
        @DisplayName("Check more jobs sentence is shown")
        void checkMoreJobsSentenceIsShown() {
            Assertions.assertTrue(homepage.goToJobs().doPageContain("These are jobs at YC startups"));
        }

        @Test
        @DisplayName("Check at least one title contains word hiring")
        void checkAtLeastOneTitleContainsWordHiring() {
            Assertions.assertTrue(homepage.goToJobs().doListContain("Hiring"));
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
