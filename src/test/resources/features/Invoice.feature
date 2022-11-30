@Invoice
Feature: I want to use this feature file for invoice scripts

  Background: Login with valid data
    And I will enter valid user name as "lvishal@yopmail.com"
    And I enter valid password as "Paymate@2"
    And I click on login button

  @inv1
  Scenario: Verify Invoicing links under Invoicing tab
    When I click on Invoicing link
    Then I should see the following links under Invoicing
      | Send Invoices      |
      | Track Invoices     |
      | Settings           |
      | Customize Invoices |

  @inv2
  Scenario Outline: Verify page title after clicking links under Invoicing tab
    When I click on Invoicing link
    And I click on invoicing following links "<links>"
    Then I should land on particular page for invoicing links
    Examples:
      | links          |
      | Send Invoices  |
      | Track Invoices |
      | Settings       |

  @inv3
  Scenario: Verify all fields when user navigates to Send Invoices page
    When I click on Invoicing link
    And I click on invoicing following links "Send Invoices"
    Then I verify all fields on Send Invoices page

  @inv4
  Scenario: Verify validations for all mandatory fields on Send Invoices page
    When I click on Invoicing link
    And I click on invoicing following links "Send Invoices"
    And I click on preview button
    Then I verify validation messages for all mandatory fields on Send invoice page


