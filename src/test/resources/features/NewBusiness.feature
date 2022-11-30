@newbusiness

Feature: I want to use this feature file for newly added Business account

  Background: Login with valid data
    When User navigates to paymate url
    And I will enter valid user name as "rebecca513@mailinator.com"
    And I enter valid password as "Paymate@123"
    And I click on login button

  @uploadkyc @ukyc
  Scenario: I upload kyc documents for a new signed up Business
#    Given I click on upload kyc link
#    Then  I enter details in all fields on uploaded documents page
#    Then  I click on upload button on uploaded documents page
#    Then  I validate all fields on Uploaded documents page
#    Then  I logout of PMX
    Then I navigate to admin portal
    Then I login to admin portal
    And I go to Manage Documents from Business Management menu
    And I enter "rebecca513@mailinator.com" in the Email field and click filter
    Then I click on Configuration Settings icon
    And I click on Approve Pan button and verify message
    And I click on Approve Business document and verify message
    And I click on Approve Address document and verify message



  @makepnew
  Scenario: I make a Single Payment using express account
    Then I click on Payments
    And I click on following "Make Payment" for Payments
    And I enter following details in Single Payment tab and click continue
      | Company Name | Reference Code | Account Number  | IFSC Code   | Bank Name          | Amount | Invoice number | Invoice date | Attached Invoice File                                                         | Net Terms | Gst Type | Gst Rate | TDS Type | TDS  | Remarks          |
      | ajay pvt     | pam26          | 214545454564437 | icic0000546 | ICICI BANK LIMITED | 500.00 | 4567           | 1/Jan/2021   | E:\Office\PaymateAutomation\PaymateAutomation\InvalidFiles\Screenshot (1).png | 15        | IGST     | 12       | Fixed    | 2.00 | test transaction |
    Then I see booked transaction tab is expanded for Payments
    And I click on select all radio button
    And I click on send request button
    Then I see validation msg for make payment
    And I should redirect on Pending Approvals page
    And I click on filter and select today date
    And I sort the transactions in Descending order by Date
    Then I select transaction and click on approve
    And I navigate to Process Transaction window and verify details
    And I click on Make Payment button and validate message
    And I go to Reports menu and check Payment report
    Then I logout of PMX
    Then I login to admin portal
    And  I navigate to Settlement Reports
    And I filter using Bank reference number for the transaction
    And I validate bank status is "SENT TO BENEFICIARY"
    Then I click on get status icon from action column
    And I filter transaction using Transaction ID
    Then I validate bank status is "COMPLETED"