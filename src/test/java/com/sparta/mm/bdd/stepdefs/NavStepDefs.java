package com.sparta.mm.bdd.stepdefs;

import com.sparta.mm.pom.pages.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavStepDefs {
    private WebDriver driver;
    private HNHomepage homepage;
    private HNPastPage pastpage;
    private HNCommentsPage commentspage;
    private HNAskPage askpage;
    private HNShowPage showpage;
    private HNJobsPage jobspage;
    private HNNewestPage newestpage;


    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();

    }

    @Given("I am on the homepage")
    public void iAmOnTheHomepage() {
        homepage = new HNHomepage(driver);
        driver.get("https://news.ycombinator.com/");
    }

    @When("I click on the past link")
    public void iClickOnThePastLink() {
        pastpage = homepage.goToPastPage();
    }

    @Then("I will go to the pasts page")
    public void iWillGoToThePastsPage() {
        Assertions.assertEquals("https://news.ycombinator.com/front",pastpage.getUrl());
    }

    @When("I click on the comments link")
    public void iClickOnTheCommentsLink() {
        commentspage = homepage.goToComments();
    }

    @Then("I will go to the comments page")
    public void iWillGoToTheCommentsPage() {
        Assertions.assertEquals("https://news.ycombinator.com/newcomments",commentspage.getUrl());
    }

    @When("I click on the ask link")
    public void iClickOnTheAskLink() {
        askpage = homepage.goToAsk();
    }

    @Then("I will go to the ask page")
    public void iWillGoToTheAskPage() {
        Assertions.assertEquals("https://news.ycombinator.com/ask",askpage.getUrl());
    }

    @When("I click on the show link")
    public void iClickOnTheShowLink() {
        showpage = homepage.goToShow();
    }

    @Then("I will go to the show page")
    public void iWillGoToTheShowPage() {
        Assertions.assertEquals("https://news.ycombinator.com/show",showpage.getUrl());
    }

    @When("I click on the jobs link")
    public void iClickOnTheJobsLink() {
        jobspage = homepage.goToJobs();
    }

    @Then("I will go to the jobs page")
    public void iWillGoToTheJobsPage() {
        Assertions.assertEquals("https://news.ycombinator.com/jobs",jobspage.getUrl());
    }

    @When("I click on the newest link")
    public void iClickOnTheNewestLink() {
        newestpage = homepage.goToNewest();
    }

    @Then("I will go to the newest page")
    public void iWillGoToTheNewestPage() {
        Assertions.assertEquals("https://news.ycombinator.com/newest",newestpage.getUrl());
    }

    @After
    public void tearDown(){
        driver.close();
        driver.quit();
    }

}
