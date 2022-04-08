package com.sparta.mm.bdd;

import com.sparta.mm.pom.pages.HNHomepage;
import com.sparta.mm.pom.pages.HNPage;
import com.sparta.mm.pom.pages.HNPastPage;
import com.sparta.mm.pom.pages.HNShowPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.time.LocalDate;

public class MyStepdefs {
    private WebDriver driver;
    private HNHomepage homepage;
    private HNPage HNPage;
    private HNPastPage pastPage;
    private HNShowPage showPage;
    private static ChromeOptions options;
    private static ChromeDriverService services;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        options = new ChromeOptions();
        options.addArguments("headless");
        services = new ChromeDriverService.Builder().usingDriverExecutable(new File("src/test/resources/chromedriver.exe")).usingAnyFreePort().build();
        driver = new ChromeDriver(options);
    }

    @Given("I am on the homepage")
    public void iAmOnTheHomepage() {
        homepage = new HNHomepage(driver);
    }

    @When("I click the pasts link")
    public void iClickThePastsLink() {
        HNPage = homepage.goToPastPage();
    }

    @Then("I will see the yesterday date")
    public void iWillSeeTheYesterdayDate() {
        String dateCheck = driver.findElement(By.className("pagetop")).getText();
        LocalDate yesterday = LocalDate.now().minusDays(1);
        Assertions.assertTrue(dateCheck.contains(yesterday.toString()));
    }

    @Then("I will see thirty items")
    public void iWillSee30Items() {


        Assertions.assertTrue(HNPage.getSizeListTitle() == 30);
    }

    @Given("I am on the pasts page")
    public void iAmOnThePastsPage() {
        homepage = new HNHomepage(driver);
        HNPage = homepage.goToPastPage();

    }

    @When("I click the more link")
    public void iClickTheMoreLink() {
        HNPage.clickMore();
    }

    @Then("I will see the next thirty items")
    public void iWillSeeTheNext30Items() {
        Assertions.assertTrue(HNPage.getSizeListTitle() == 30);

    }

    @When("I click the show link")
    public void iClickTheShowLink() {
        HNPage = homepage.goToShow();
    }

    @Then("I will see the article title start with Show HN:")
    public void iWillSeeTheArticleTitleStartWithShowHN() {
        boolean titleStartWithShowHN = true;
        int numberOfArticle = driver.findElements(By.className("titlelink")).size();
        String[] articles = new String[numberOfArticle];
        for (int i = 0; i < numberOfArticle; i ++) {
            articles[i] = driver.findElements(By.className("titlelink")).get(i).getText();
            if (!articles[i].startsWith("Show HN:"))
                titleStartWithShowHN = false;
        }
        Assertions.assertTrue(titleStartWithShowHN);
    }

    @Given("I am on the show page")
    public void iAmOnTheShowPage() {
        homepage = new HNHomepage(driver);
        HNPage = homepage.goToShow();
    }

    @After
    public void teardown() {
        driver.close();
        driver.quit();
        services.stop();
    }
}
