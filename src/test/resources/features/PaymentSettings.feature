@PaymentSettings
Feature: I want to use this feature Payments settings module

  Background: Login with valid data
    When I will enter valid user name as "lvishal@yopmail.com"
    And I enter valid password as "Paymate@123"
    Then I click on login button

  @pays1
  Scenario: Verify menu option when user clicks on Payment Settings
    When I click on Payment Settings
    Then I see following options for Payment Settings menu
      | Menus options |


  @pays2
  Scenario Outline: Verify Payment Sett menu pages when user clicks on Payments menu links
    When I click on Payment Settings
    And I click on following "<Links>" for Payment Settings
    Then I should be land on particular page for Payment Settings
    Examples:
      | Links               |
      | Xpress Account      |
      | Add New Card        |
      | Saved Cards         |
      | Settlement Accounts |