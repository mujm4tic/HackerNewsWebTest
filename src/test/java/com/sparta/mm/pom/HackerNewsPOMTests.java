package com.sparta.mm.pom;

import com.sparta.mm.pom.pages.HNHomepage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.Arrays;

import static com.sparta.mm.pom.pages.HNPage.TOP_LINKS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class HackerNewsPOMTests {
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
    @DisplayName("Test Homepage")
    class testHomepage{

        @Test
        @DisplayName("check top links exist")
        void checkTopLinksExists() {
            boolean doesToplinksExist = Arrays.stream(TOP_LINKS).anyMatch(topLink -> homepage.doesTopLinkExist(topLink));
            Assertions.assertTrue(doesToplinksExist);
        }

        @Test
        @DisplayName("check number articles is 30")
        void checkNumberArticlesIs30() {
            Assertions.assertEquals(30, homepage.getSizeListTitle());
        }

        @Test
        @DisplayName("check if 30 new articles are shown")
        void checkIf30NewArticlesAreShown() {
            homepage.clickMore();
            Assertions.assertTrue((homepage.getNumberArticle(1) == 31) && (homepage.getNumberArticle(30) == 60));
        }
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
    @DisplayName("Test Show Page")
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

        @Test
        @DisplayName("Check title must start with Show HN:")
        void checkTitleMustStartWithShowHN() {
            Assertions.assertTrue(homepage.goToShow().isTitleStartWithShowHN());
        }

        @Test
        @DisplayName("Check title must start with Show HN: after clicking More")
        void checkTitleMustAlwaysStartWithShowHN() {
            Assertions.assertTrue(homepage.goToShow().isTitleAlwaysStartWithShowHN());
        }
    }

    @Nested
    @DisplayName("Test Ask Page")
    class testAskPage{
        @Test
        @DisplayName("Check that the ask link works")
        void checkThatTheAskLinkWorks() {
            assertEquals("https://news.ycombinator.com/ask", homepage.goToAsk().getUrl());
        }

        @Test
        @DisplayName("If Ask Header Exists")
        void ifHeaderExists() {
            assertTrue(homepage.goToAsk().doesTopLinkExist("ask"));
        }

        @Test
        @DisplayName("Ask Page Has 30 Entries")
        void askPageHas30Entries() {
            assertEquals(30, homepage.goToAsk().getSizeListTitle());
        }

        @Test
        @DisplayName("First Score Is Found in 6 Second")
        void isFoundInTime() {
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(6))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            driver.get(homepage.goToAsk().getUrl());
            WebElement result = wait.until(driver -> driver.findElement(By.id("score_30940747")));
            System.out.println(result);
            Assertions.assertTrue(result.isDisplayed());
        }
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
