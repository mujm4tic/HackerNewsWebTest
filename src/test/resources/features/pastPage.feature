Feature: Past page feature
    Scenario: seeing the data on the pasts page
    Given I am on the homepage
    When I click the pasts link
    Then I will see the yesterday date

  Scenario: seeing 30 items on the pasts page
    Given I am on the homepage
    When I click the pasts link
    Then I will see thirty items

  Scenario: seeing 30 items on the more
    Given I am on the pasts page
    When I click the more link
    Then I will see the next thirty items