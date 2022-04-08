package com.sparta.mm.pom;

import com.sparta.mm.pom.pages.HNHomepage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
        @DisplayName("check headers exist")
        void checkHeadersExists() {
            for (String topLink : TOP_LINKS) {
                Assertions.assertTrue(homepage.doesTopLinkExist(topLink));
            }
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
    }

    @Nested
    @DisplayName("Test Ask Page")
    class testAskPage{
        @Test
        @DisplayName("Check that the ask link works")
        void checkThatTheAskLinkWorks() {
            assertEquals("https://news.ycombinator.com/ask", homepage.goToAsk().getURL());
        }

        @Test
        @DisplayName("If Ask Header Exists")
        void ifHeaderExists() {
            assertTrue(homepage.goToAsk().doesHeaderExist());
        }

        @Test
        @DisplayName("Ask Page Has 30 Entries")
        void askPageHas30Entries() {
            assertTrue(homepage.goToAsk().getNumberContentTitles()==30);
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
