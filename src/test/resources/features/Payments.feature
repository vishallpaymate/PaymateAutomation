@Payments
Feature: I want to use this feature Payments module

  Background: Login with valid data
    When User navigates to paymate url
    And I will enter valid user name as "lvishal@yopmail.com"
    And I enter valid password as "Paymate@123"
    And I click on login button

  @makep
  Scenario: Verify menu options when user click on Payments
    When I click on Payments
    Then I see following options for Payments menu
      | Menus options     |
      | Make Payment      |
      | Bill Payments     |
      | Requests Received |
      | Invoices Received |
      | Pending Approvals |
      | GST Payments      |

  @makep1
  Scenario Outline: Verify Payments menu pages when user clicks on Payments menu links
    When I click on Payments
    And I click on following "<Links>" for Payments
    Then I should be land on particular page
    Examples:
      | Links             |
      | Make Payment      |
      | Requests Received |
      | Invoices Received |
      | Pending Approvals |
      | GST Payments      |

  @makep2
  Scenario: I validate all fields and labels on Make Payment page
    When I click on Payments
    And I click on following "Make Payment" for Payments
    And I verify all fields and labels on Make Payment page

  @makep3
  Scenario: I validate all messages when clicked continue with no input on Make payment page
    When I click on Payments
    And I click on following "Make Payment" for Payments
    And I click on continue button for Make payment page
    Then I verify all validation messages for mandatory fields


  @makep4
  Scenario: I make a Single Payment using express account
    Then I click on Payments
    And I click on following "Make Payment" for Payments
    And I enter following details in Single Payment tab and click continue
      | Company Name  | Reference Code | Account Number | IFSC Code   | Bank Name          | Amount | Invoice number | Invoice date | Attached Invoice File                                                         | Net Terms | Gst Type | Gst Rate | TDS Type | TDS  | Remarks          |
      | acerr pvt ltd | 372375         | 6589545685656  | icic0000546 | ICICI BANK LIMITED | 500.00 | 4567           | 1/Jan/2021   | E:\Office\PaymateAutomation\PaymateAutomation\InvalidFiles\Screenshot (1).png | 15        | IGST     | 12       | Fixed    | 2.00 | test transaction |
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

  @makep5
  Scenario: I make Payment using Bulk Payment feature
    When I click on Payments
    And I click on following "Make Payment" for Payments
    And I click on Bulk payment tab
    And I download sample payment file and enter details
      | XpressID   | ReferenceCode | CompanyName   | CompanyAccountNo | IFSCCode    | Amount  | GSTType | GSTRate | TDSType | TDSValue | InvoiceNo | InvoiceDate | NetTerm | DiscountType | DiscountValue | RequestType | Remark |
      | AAAA005VN9 | 372375        | acerr pvt ltd | 6589545685656    | icic0000546 | 3400.00 |         |         |         |          |           |             |         |              |               |             |        |
    And I upload the payment file
    And I check the uploaded data in booked transactions tab
    And I click on Confirm button for Bulk Payments upload
    And I click on select all radio button
    And I click on send request button
    Then I see validation msg for make payment
    And I should redirect on Pending Approvals page
    And I click on filter and select today date
    And I sort the transactions in Descending order by Date
    Then I select transaction and click on approve
    And I click on Make Payment button and validate message
    And I go to Reports menu and check Payment report
    Then I logout of PMX
    Then I navigate to admin portal
    Then I login to admin portal
    And  I navigate to Settlement Reports
    And I filter using Bank reference number for the transaction
    And I validate bank status is "SENT TO BENEFICIARY"
    Then I click on get status icon from action column
    And I filter transaction using Transaction ID
    Then I validate bank status is "COMPLETED"


  @paymentflow
  Scenario: I make payment with payment approval worklfow
    When I logout of PMX
    And I enter valid user name in username field as "makeruser@mailinator.com"
    And I enter valid password as "Paymate@123"
    And I click on login button
    When I click on Payments
    And I click on following "Make Payment" for Payments
    And I enter following details in Single Payment tab and click continue
      | Company Name  | Reference Code | Account Number | IFSC Code   | Bank Name          | Amount | Invoice number | Invoice date | Attached Invoice File                                                         | Net Terms | Gst Type | Gst Rate | TDS Type | TDS  | Remarks          |
      | acerr pvt ltd | 372375         | 6589545685656  | icic0000546 | ICICI BANK LIMITED | 500.00 | 4568           | 1/Jan/2021   | E:\Office\PaymateAutomation\PaymateAutomation\InvalidFiles\Screenshot (1).png | 15        | IGST     | 12       | Fixed    | 2.00 | test transaction |
    Then I see booked transaction tab is expanded for Payments
    And I click on select all radio button
    And I click on send request button
    When I logout of PMX
    And I enter valid user name in username field as "approveruser1@mailinator.com"
    And I enter valid password as "Paymate@123"
    And I click on login button
    And I should redirect on Pending Approvals page
    And I click on filter and select today date
    And I sort the transactions in Descending order by Date
    Then I select transaction and click on approve
    And I navigate to Process Transaction window and verify details
    And I click on Approver button and validate message
    When I logout of PMX
    And I enter valid user name in username field as "payeruser@mailinator.com"
    And I enter valid password as "Paymate@123"
    And I click on login button
    Then I select transaction and click on approve
    And I navigate to Process Transaction window and verify details
    And I click on Make Payment button and validate message for payment flow
    And I go to Reports menu and check Payment report
    Then I logout of PMX
    Then I navigate to admin portal
    Then I login to admin portal
    And  I navigate to Settlement Reports
    And I filter using Bank reference number for the transaction
    And I validate bank status is "SENT TO BENEFICIARY"
    Then I click on get status icon from action column
    And I filter transaction using Transaction ID
    Then I validate bank status is "COMPLETED"

#  @bulkpayments
#  Scenario: I make Payment using Bulk Payment feature
#    When I click on Payments
#    And I click on following "Make Payment" for Payments
#    And I click on Bulk payment tab
#    And I upload file following file
#      | file type | file links                   |
#      | .xlsx     | SampleBulkUploadPayable.xlsx |
