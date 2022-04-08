package com.sparta.mm.bdd.stepdefs;

import com.sparta.mm.pom.pages.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyStepdefsToplink {

    private WebDriver driver;
    private HNHomepage homepage;
    private HNAskPage askPage;
    private HNCommentsPage commentsPage;
    private HNJobsPage jobsPage;
    private HNNewestPage newPage;
    private HNPastPage pastPage;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void teardown(){
        driver.close();
        driver.quit();
    }

    @Given("I am on the homepage")
    public void iAmOnTheHomepage() {
        homepage = new HNHomepage(driver);
    }

    @When("I click on the ask link")
    public void iClickOnTheAskLink() {
        askPage = homepage.goToAsk();
    }

    @And("I am taken to the ask page")
    public void iAmTakenToTheAskPage() {
    }

    @Then("I see the ask button at the top of the page")
    public void iSeeTheAskButtonAtTheTopOfThePage() {
        Assertions.assertTrue(askPage.doesTopLinkExist("ask"));
    }

    @When("I click on the comments link")
    public void iClickOnTheCommentsLink() {
        commentsPage = homepage.goToComments();
    }

    @And("I am taken to the comments page")
    public void iAmTakenToTheCommentsPage() {
    }

    @Then("I see the comments button at the top of the page")
    public void iSeeTheCommentsButtonAtTheTopOfThePage() {
        Assertions.assertTrue(commentsPage.doesTopLinkExist("comments"));
    }

    @When("I click on the jobs link")
    public void iClickOnTheJobsLink() {
        jobsPage = homepage.goToJobs();
    }

    @And("I am taken to the jobs page")
    public void iAmTakenToTheJobsPage() {
    }

    @Then("I see the jobs button at the top of the page")
    public void iSeeTheJobsButtonAtTheTopOfThePage() {
        Assertions.assertTrue(jobsPage.doesTopLinkExist("jobs"));
    }

    @When("I click on the newest link")
    public void iClickOnTheNewestLink() {
        newPage = homepage.goToNewest();
    }

    @And("I am taken to the newest page")
    public void iAmTakenToTheNewestPage() {
    }

    @Then("I see the newest button at the top of the page")
    public void iSeeTheNewestButtonAtTheTopOfThePage() {
        Assertions.assertTrue(newPage.doesTopLinkExist("new"));
    }

    @When("I click on the past link")
    public void iClickOnThePastLink() {
        pastPage = homepage.goToPastPage();
    }

    @And("I am taken to the past page")
    public void iAmTakenToThePastPage() {
    }

    @Then("I see the past button at the top of the page")
    public void iSeeThePastButtonAtTheTopOfThePage() {
        Assertions.assertTrue(pastPage.doesTopLinkExist("past"));
    }
}
