Feature: Being able to see a list of 30 titles on Hacker News

  Scenario: Seeing list of articles on Homepage
    Given I have opened Hacker News
    When I am on the homepage
    Then I will see thirty articles

  Scenario: Seeing list of thirty newest articles on Newestpage
    Given I am on the homepage
    When I click on the new link
    Then I will see thirty newest articles

  Scenario: Seeing list of thirty past articles on Pastpage
    Given I am on the homepage
    When I click on the past link
    Then I will see thirty old articles

  Scenario: Seeing list of thirty questions on Askpage
    Given I am on the homepage
    When I click on the ask link
    Then I will see thirty questions

  Scenario: Seeing list of thirty shows on ShowPage
    Given I am on the homepage
    When I click on the show link
    Then I will see thirty shows

  Scenario: Seeing list of thirty jobs on ShowPage
    Given I am on the homepage
    When I click on the jobs link
    Then I will see thirty jobs