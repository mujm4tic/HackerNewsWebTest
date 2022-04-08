package com.sparta.mm.bdd.stepdefs;

import com.sparta.mm.pom.pages.*;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimoMyStepdefs {

    private WebDriver driver;
    private HNHomepage homepage;
    private HNNewestPage newestPage;
    private HNPastPage pastPage;
    private HNAskPage askPage;
    private HNShowPage showPage;
    private HNJobsPage jobsPage;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Given("I have opened Hacker News")
    public void iHaveOpenedHackerNews() {
    }

    @Given("I am on the homepage")
    public void iAmOnTheHomepage() {
        homepage = new HNHomepage(driver);
    }

    @Then("I will see thirty articles")
    public void iWillSeeThirtyArticles() {
        Assertions.assertEquals(30, homepage.getSizeListTitle());
    }

    @When("I click on the new link")
    public void iClickOnTheNewLink() {
        newestPage = homepage.goToNewest();
    }

    @Then("I will see thirty newest articles")
    public void iWillSeeThirtyNewestArticles() {
        Assertions.assertEquals(30, newestPage.getSizeListTitle());
    }

    @When("I click on the past link")
    public void iClickOnThePastLink() {
        pastPage = homepage.goToPastPage();
    }

    @Then("I will see thirty old articles")
    public void iWillSeeThirtyOldArticles() {
        Assertions.assertEquals(30, pastPage.getSizeListTitle());
    }

    @When("I click on the ask link")
    public void iClickOnTheAskLink() {
        askPage = homepage.goToAsk();
    }

    @Then("I will see thirty questions")
    public void iWillSeeThirtyQuestions() {
        Assertions.assertEquals(30, askPage.getSizeListTitle());
    }

    @When("I click on the show link")
    public void iClickOnTheShowLink() {
        showPage = homepage.goToShow();
    }

    @Then("I will see thirty shows")
    public void iWillSeeThirtyShows() {
        Assertions.assertEquals(30, showPage.getSizeListTitle());
    }

    @When("I click on the jobs link")
    public void iClickOnTheJobsLink() {
        jobsPage = homepage.goToJobs();
    }

    @Then("I will see thirty jobs")
    public void iWillSeeThirtyJobs() {
        Assertions.assertEquals(30, jobsPage.getSizeListTitle());
    }

    @After
    void teardown() {
        driver.close();
    }

    @AfterAll
    void teardownAll() {
        driver.quit();
    }

}
