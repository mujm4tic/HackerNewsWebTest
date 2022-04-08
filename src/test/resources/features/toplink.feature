Feature: Pages have their own named links at the top of the page

  Scenario: Seeing the ask button at the top of the ask page
    Given I am on the homepage
    When I click on the ask link
    And I am taken to the ask page
    Then I see the ask button at the top of the page

  Scenario: Seeing the comments button at the top of the comments page
    Given I am on the homepage
    When I click on the comments link
    And I am taken to the comments page
    Then I see the comments button at the top of the page

  Scenario: Seeing the jobs button at the top of the jobs page
    Given I am on the homepage
    When I click on the jobs link
    And I am taken to the jobs page
    Then I see the jobs button at the top of the page

  Scenario: Seeing the newest button at the top of the newest page
    Given I am on the homepage
    When I click on the newest link
    And I am taken to the newest page
    Then I see the newest button at the top of the page

  Scenario: Seeing the past button at the top of the past page
    Given I am on the homepage
    When I click on the past link
    And I am taken to the past page
    Then I see the past button at the top of the page