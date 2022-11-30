@SignUpUAE

Feature: I want Use This Template for SignUp Functionality for UAE portal

  Background: Login with valid data
    When User navigates to paymate url
    And I will enter valid user name in UAE as "vishaluaeadmin@yopmail.com"
    And I enter valid password in UAE as "Paymate@123"
    And I click on login button in UAE

  @signuae0
  Scenario: Register new business on UAE portal
    When I am on dashboard page for uae admin login
    Then I click on Add Business tab
    And  I enter all details in Business Information tab
      | Business Name | Contact Name | Contact Designation | Country              | Email-ID | Mobile No | Type of Business                | Business Category             | Business Sub-Category | Sales Rep    | Address | Emirate   | Postal Code |
      | pvt ltd       | v            | test                | UNITED ARAB EMIRATES | zep      | 542133254 | Branch of a foreign partnership | Arts, Crafts and Collectables | Antiques              | PM CAT ADMIN | test    | Abu Dhabi | 111111      |
    And I check box for Card Management Admin
    And I check box for Finance Management Admin
    And I check box for User Management Admin
    And I check box for Contact Management Admin
    Then I click Next button for Business Information tab
    Then I verify Transaction Currency tab is expanded
    And I check boxes for Payable and Receivable Currency
    Then I click Next button for Transaction currency tab
    Then I verify Business subscription tab is expanded
    And I click Next button for Business subscription tab
    Then I verify Transaction charges details tab is expanded
    Then I enter Transaction charge details for both payable and receivable and click save
    Then I verify Settlement charges details tab is expanded
    And I enter Settlement charges details for both Send and Reeive money and click save
    Then I verify Declaration Compliance tab is expanded
    And I click on save button for Compliance
    Then I land on Manage Business page
