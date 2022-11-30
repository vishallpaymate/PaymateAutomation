@Admin
Feature: I want to use this feature file for PMC admin

  Background: Login with valid data
    When User navigates to paymate url
    Then I enter admin username as "vishall@yopmail.com"
    Then I enter admin password as "abc123B$"
#    Then I enter admin username as "vishall@mailinator.com"
#    Then I enter admin password as "Paymate@123"
    And  I click on Login button for admin page

  @businessDetails @b1
  Scenario: I validate all mandatory fields on Add Business Page
    And I go to Add Business from Business Management menu
    Then I expand Business Details section and click next
    Then I check validation for all mandatory fields


  @addBusiness @bb
  Scenario: I add a new business from Admin Portal
    And I go to Add Business from Business Management menu
    Then I expand Business Details section and click next
    Then I enter all details in Business Details Field and click next
    Then I select Subscription Plan and click save
    And I am on Upload Documents Page where I enter all mandatory fields and click Confirm


  @cpdetails
  Scenario: I validate all mandatory fields on add user Page
    And I go to Add user Page from Settings menu
    Then I click on Save button
    Then I check validation for all mandatory fields for add user Page

    @ad
    Scenario: Manage Business
    Then I login to admin portal
    And I go to Manage Business from Business Management menu
