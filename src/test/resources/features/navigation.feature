Feature: Being able to navigate to pages on hacker news

  Background: Starting from the homepage
    Given I am on the homepage


    Scenario: go to the past page from the homepage
      Given I am on the homepage
      When I click on the past link
      Then I will go to the pasts page

    Scenario: go to the comments page from the homepage
      Given I am on the homepage
      When I click on the comments link
      Then  I will go to the comments page

    Scenario: go to the  ask page from the homepage
      Given I am on the homepage
      When I click on the ask link
      Then I will go to the ask page

    Scenario: go to the show page from the homepage
      Given I am on the homepage
      When I click on the show link
      Then I will go to the show page

    Scenario: go to the jobs page from the homepage
      Given I am on the homepage
      When I click on the jobs link
      Then I will go to the jobs page

    Scenario: go to the newest page from the homepage
      Given I am on the homepage
      When I click on the newest link
      Then I will go to the newest page

