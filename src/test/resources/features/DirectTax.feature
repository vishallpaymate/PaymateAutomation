@DirectTax
Feature: I want Use This Template for DirectTax Functionality

  Background: Login with valid data
    When User navigates to paymate url
    And I will enter valid user name as "pfal@yopmail.com"
    And I enter valid password as "Paymate@123"
    And I click on login button

  @dt1
  Scenario: verify Direct Tax menu when user click on Direct tax link
    When I click on Payments
    Then I click on Direct tax link
    Then I should see following links for Direct Tax Payment
      | Add PAN/TAN    |
      | Manage PAN/TAN |
      | Pay Tax        |