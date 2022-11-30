@Login
Feature: I want to use this template for my Login Page

  Background: When user enters valid url
    When User navigates to paymate url

  @L1
  Scenario: verify Login page links when user land on Login page
    When I should see forgot password link and register now
    Then I click on forgot password link
    And I click on register now link

  @L2
  Scenario: verify Login field Labels
    When I navigate to paymate login page
    Then I see user name label as "Email ID"
    And I see Password Label As "Password"

  @L3
  Scenario: Verify Login page of registered user with valid data
    When I navigate to paymate login page
    And I enter valid user name in username field as "zebpvt@yopmail.com"
    And I enter valid password as "Payymate@5"
    And I click on login button
#    Then I should be land on paymate dashboard
    Then I should be able to click and should navigate to business dash board page

  @L4
  Scenario: Verify Login page with Blank data
    When I click on login button
    Then I should not be loggedIn
    And  I should be see proper validation message for user name and for password in red color

  @L5
  Scenario: Verify Login page with invalid data
    When I enter invalid user name as "vij9@grr.la"
    And I enter invalid password as  "ymate@123"
    And I click on login button
#    Then I should not be loggedIn
    And  I should be see proper validation message in red color

  @L6
  Scenario Outline:Verify Login functionality when user enter valid user name and invalid password
    When I enter valid user name "<User name>" and following invalid password "<password>"
    And I click on login button
    Then I should get following validation msg"<validationMsg>" and mail should be open for particular validation msg
    Examples:
      | User name              | password     | validationMsg                                                                                                         |
      | zebpvt@yopmail.com | fffefefef    | Please enter the correct email / password. You have 2 login attempts left                                             |
      | zebpvt@yopmail.com | efefefefef   | Please enter the correct email / password. You have 1 login attempt left.Click on Forgot Password to reset password.  |
      | zebpvt@yopmail.com | fefdsfdsfdff | Your account has been blocked due to 3 failed login attempts. To reset your password please click on Forgot Password. |


  @staticlinks
  Scenario Outline: I login to client application and check static links at the bottom of the home page
    When I will enter valid user name as "lvishal@yopmail.com"
    And  I enter valid password as "Paymate@123"
    And I click on login button
    And I click on the following "<Links>"
    Then I should land on particular page for static links
    Examples:
      | Links          |
      | Terms of use   |
      | Privacy policy |
      | Help           |
      | Charges        |
      | Contact Us     |

#  @useraccess1
#  Scenario: I login as a maker user and verify access
#    When I enter valid user name in username field as "mis578@mailinator.com"
#    And I enter valid password as "Paymate@123"
#    And I click on login button
#    Then I click on add contact link
#    And I click on contact following links "Manage Contacts"
#    Then I verify action column has only view access
#    Then I navigate to Reports section

#@signleUser
#    When User navigates to paymate url
#    And I will enter valid user name as "johnny270@mailinator.com"
#    And I enter valid password as "Paymate@123"
#    And I click on login button
#    When I click on Account Settings
#    And  I click on User Settings
#    And I click on Add User and navigate to Add user page
#    And And I enter "<firstname>" and "<lastname>" and "<email>" and "<role>" for single user multiple business
#    And I click on Save button on Add user page
#    And I validate "<role>" added message