@PaymentApproval
Feature: I want to use this feature payment approval workflow

  Background: Login with valid data
    When User navigates to paymate url
    And I will enter valid user name as "simon156@mailinator.com"
    And I enter valid password as "Paymate@1"
    And I click on login button


  @manageusers1
  Scenario: I verify links under User Settings
    When I click on Account Settings
    And  I click on User Settings
    Then I see following user settings links
      | User Settings             |
      | Add User                  |
      | Manage Users              |
      | Mobile User Configuration |

  @manageusers2
  Scenario Outline: I create users for workflow process
    When I click on Account Settings
    And  I click on User Settings
    And I click on Add User and navigate to Add user page
    And And I enter "<firstname>" and "<lastname>" and "<email>" and "<role>"
    And I click on Save button on Add user page
#    And I validate user saved message
    And I validate "<role>" added message
    And I should get mail for add user "<email>" i should see login link
    And I see new password and confirm password fields
    And I enter valid new password on Set password page as "Paymate@123"
    And I enter confirm password on Set password page as "Paymate@123"
    And I click on save button
    And I should be land on login page
#    And I enter valid user name for adduser as "<email>"
#    And I click on Set Password button
#    And I enter valid password from email
#    And I click on login button
#    And I enter current and new password and click save
#    And I should be land on login page
    And I enter valid user name for adduser as "<email>"
    And I enter valid password as "Paymate@123"
    And I click on login button
    Examples:
      | firstname | lastname | email | role     |
      | maker     | test     | maker    | Transaction Maker    |
#      | approver  | test     | approver | Transaction Approver |
#      | payer     | test     | payer    | Payer                |
#      | mis       | test     | mis   | MIS User |


  @pflow0
  Scenario: I verify workflow settings and sub menus are available
    When I click on Account Settings
    Then I click on Workflow Settings
    Then I see following workflow options
      | Workflow menus    |
      | Payment Limits    |
      | Payment Workflows |
      | Contact Approvals |


  @pflow1
  Scenario Outline: I verify each link under Workflow Settings
    When I click on Account Settings
    Then I click on Workflow Settings
    Then  I click on Workflow menu "<Links>"
    Then I should be land on particular page for workflow links
    Examples:
      | Links             |
      | Payment Limits    |
      | Payment Workflows |
      | Contact Approvals |


  @pflow2
  Scenario: I verify all fields and buttons on Set Limit Page
    When I click on Account Settings
    Then I click on Workflow Settings
    Then  I click on Workflow menu "Set Limit"
    Then I verify all fields are present on Set Limit Page

  @pflow3
  Scenario Outline: I verify Set Limit Page with no inputs
    When I click on Account Settings
    Then I click on Workflow Settings
    Then I click on Workflow menu "Set Limit"
    And  I click on "<Buttons>" on set limit page
#    Then I click on continue button on set limit page
    Then I verify validation messages for all fields
    Examples:
      | Buttons     |
      | Add Another |
      | Continue    |


  @pflow4
  Scenario: I verify validation messages for invalid inputs on set limit page
    When I click on Account Settings
    Then I click on Workflow Settings
    Then I click on Workflow menu "Set Limit"
    Then I enter start limit less than end limit and check validation messages
    Then I enter same values in start and end limit fields and check validation message

  @pflow5
  Scenario: I verify all the columns in the Manage Limit section and default unlimited limit
    When I click on Account Settings
    Then I click on Workflow Settings
    And  I click on Workflow menu "Manage Limit"
    And  I verify all column names for Manage Limit
      | Column Names |
      | Limit Name   |
      | Start Limit  |
      | End Limit    |
      | Action       |
    Then I verify first row as unlimited limit and default values
      | Default Values |
      | Unlimited      |
      | 0              |
      | 0              |


  @pflow6
  Scenario: I enter valid inputs Set Limit page and verify the same in Manage Limit
    When I click on Account Settings
    Then I click on Workflow Settings
    Then I click on Workflow menu "Set Limit"
    Then I enter inputs in all fields on set limit page
    And  I click on "Continue" on set limit page
    And  I verify limit saved validation message
    Then  I click on Workflow menu "Manage Limit"
    Then I verify limit added in manage limit section
      | Limit Values |
      | test1        |
      | 100.00       |
      | 500.00       |


  @pflow7
  Scenario: I verify validation message for already added limit range
    When I click on Account Settings
    Then I click on Workflow Settings
    Then I click on Workflow menu "Set Limit"
    Then I enter inputs in all fields on set limit page
    And  I click on "Continue" on set limit page
    Then I verify limit range already defined message

  @pflow8
  Scenario: I verify validation message for already added limit name
    When I click on Account Settings
    Then I click on Workflow Settings
    Then I click on Workflow menu "Set Limit"
    Then I enter inputs in all fields on set limit page
    And  I click on "Continue" on set limit page
    Then I verify limit name already defined message


#  @pflow9
#  Scenario: I verify
#    When I click on Account Settings
#    Then I click on Workflow Settings
#    Then I click on Workflow menu "Manage Limit"
#    Then I verify limit added in manage limit section
#      | Limit Values |
#      | test3        |
#      | 2500.00      |
#      | 2000.00      |

  @manageflow
  Scenario: I verify all default fields and buttons on Manage workflow page
    When I click on Account Settings
    And I click on Workflow Settings
    And I click on Workflow menu "Payment Approvals"
    And I should be land on particular page for workflow links
    Then I check Design Workflow button is present


  @manageflow1
  Scenario: I click on Design Workflow button and verify all fields are present
    When I click on Account Settings
    And I click on Workflow Settings
    And I click on Workflow menu "Payment Approvals"
    And I click on Design Workflow button
    Then I verify select payment limit dropdown is present
    Then I verify Add new Limit button is present
    Then I verify steps for makers approvers and payers is present and disabled
      | Design Workflow Steps    |
      | Step 1: Select Makers    |
      | Step 2: Select Approvers |
      | Step 3: Select Payers    |
    Then I verify cancel button is present

  @manageflow2
  Scenario: I verify that clicking on Add new Limit navigates to set limit page
    When I click on Account Settings
    And I click on Workflow Settings
    And I click on Workflow menu "Payment Approvals"
    And I click on Design Workflow button
    And I click on Add new Limit button
    Then I verify i am on set limit page


  @manageflow3
  Scenario: I verify all validation messages in Design workflow steps
    When I click on Account Settings
    And I click on Workflow Settings
    And I click on Workflow menu "Payment Approvals"
    And I click on Design Workflow button
    And I select a payment limit from dropdown
    And I verify a user is present in the Select Makers dropdown box
    And I remove the Maker user and click Next to verify validation message
    And I click on Add level with no approver and validate message
    And I click Add level with minimum approver as blank and validate message
    Then I click on save workflow with no payer and validate message


  @manageflow4
  Scenario: I Design a new workflow from Design worklfow page
    When I click on Account Settings
    And I click on Workflow Settings
    And I click on Workflow menu "Payment Approvals"
    And I click on Design Workflow button
    And I select a payment limit from dropdown
    And I verify a user is present in the Select Makers dropdown box
    And I verify No Maker needed checkbox and Next button are present
    And I click on next button for maker
    And I select approvers from select approver dropdown box and enter minimum approvers
    And I verify Add level and Back buttons are present
    And I click on Add level button and verify message
    And I verify edit and delete actions button are present in approver tab
    And I click next button for Approver
    And I verify a user is present in the Select Payers dropdown box
    And I verify No payer Needed checkbox and Cancel button are present in payers tab
    And I verify Save Workflow and Cancel buttons are present
    Then I click on Save Workflow button and verify message

  @contactflow
  Scenario: I verify all fields on Contact Approval Workflow page
    When I click on Account Settings
    Then I click on Workflow Settings
    Then I click on Workflow menu "Contact Approvals"
    Then I verify all fields and text in Makers section
    Then I verify all fields and text in Approver section
    And I verify Save Workflow and Clear buttons are present

  @contactflow1
  Scenario: I verify all validation messages on Contact Approval Workflow page
    When I click on Account Settings
    Then I click on Workflow Settings
    Then I click on Workflow menu "Contact Approvals"
#    And I click on Edit workflow
    And I verify a user is present in the Select Makers dropdown box
    And I remove Maker user and click Save Workflow and validate message
    And I click Save Workflow with empty approver and validate message

  @contactflow2
  Scenario: I design a new Contact workflow
    When I click on Account Settings
    Then I click on Workflow Settings
    Then I click on Workflow menu "Contact Approvals"
    And I verify a user is present in the Select Makers dropdown box
    And I enter approvers from select approvers dropdown box
    And I click Save workflow button and validate message
    Then I navigate to Contact Approval Workflow page

     













