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
            assertEquals(30, homepage.getSizeListTitle());
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

        @Test
        @DisplayName("First Score Is Found in 6 Second")
        void isFoundInTime() {
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(6))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            driver.get(homepage.goToAsk().getURL());
            WebElement result = wait.until(driver -> driver.findElement(By.id("score_30940747")));
            System.out.println(result);
            Assertions.assertTrue(result.isDisplayed());
        }
    }

    @Nested
    @DisplayName("Test Comments Page")
    class testCommentPage{
        @Test
        @DisplayName("Test Comments page")
        void methodName() {
            assertEquals("https://news.ycombinator.com/newcomments",homepage.goToComments().getUrl());
        }

        @Test
        @DisplayName("Less Than 30 comments on the screen")
        void lessThan30CommentsOnTheScreen() {
            Assertions.assertTrue(homepage.goToComments().isLessThan30CommentOnPage());
        }

        @Test
        @DisplayName("Check if there is more than 10 Spaces In A Paragraph")
        void checkHowManySpacesInAParagraph() {
            Assertions.assertTrue(homepage.goToComments().HowManySpacesInAParagraph(3) > 10);
        }

        @Test
        @DisplayName("Check if there is more than 100 spaces in the page")
        void checkHowManySpacesInASpecificParagraph() {
            Assertions.assertTrue(homepage.goToComments().HowManySpacesInAParagraph() > 100);
        }

        @Test
        @DisplayName("Check if paragraph contains hello")
        void checkParagraphContains() {
            Assertions.assertTrue(homepage.goToComments().GetParaGraphByIndex(1).contains("hello"));
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
