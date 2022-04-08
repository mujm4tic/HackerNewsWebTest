Feature: Past page feature
  Scenario: seeing article title start with Show HN:
    Given I am on the homepage
    When I click the show link
    Then I will see the article title start with Show HN:

  Scenario: seeing thirty items on the pasts page
    Given I am on the homepage
    When I click the show link
    Then I will see thirty items

  Scenario: seeing article title start with Show HN: after click more
    Given I am on the show page
    When I click the more link
    Then I will see the article title start with Show HN: