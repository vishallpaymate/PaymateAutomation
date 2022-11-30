@LoginHDFC
Feature: I want to use this template for my HDFC Login Page

  @LH1
  Scenario: verify Login page links when user land on Login page
    When I should see forgot password link and register now for HDFC
    Then I click on forgot password link for HDFC
    And I click on on Sign up here link

  @LH2
  Scenario: verify Login field Labels
    When I navigate to paymate login page for HDFC portal
    Then I see user name label for HDFC as "Registered Email ID"
    And I see Password Label for HDFC As "Password"

  @LH3
  Scenario: Verify Login page of registered user with valid data
    When I navigate to paymate login page for HDFC portal
    And I enter valid user name in username field as "lvishalhdfc@yopmail.com"
    And I enter valid password as "Paymate@2"
    And I click on login button
    And I enter otp and click on verify button
    Then I should be able to click and should navigate to business dash board page

  @LH4
  Scenario: Verify Login page with Blank data
    When I click on login button
    Then I should not be loggedIn in HDFC
    And  I should be see proper validation message for user name and for password in red color for HDFC

  @LH5
  Scenario Outline:Verify Login functionality when user enter valid user name and invalid password
    When I enter valid user name "<User name>" and following invalid password "<password>"
    And I click on login button
    Then I should get following validation msg"<validationMsg>" and mail should be open for particular validation msg
    Examples:
      | User name               | password     | validationMsg                                                                                                         |
      | lvishalhdfc@yopmail.com | fffefefef    | Please enter the correct email / password. You have 2 login attempts left                                             |
      | lvishalhdfc@yopmail.com | efefefefef   | Please enter the correct email / password. You have 1 login attempt left.Click on Forgot Password to reset password.  |
      | lvishalhdfc@yopmail.com | fefdsfdsfdff | Your account has been blocked due to 3 failed login attempts. To reset your password please click on Forgot Password. |


  @statichdfc
  Scenario Outline: I login to client application and check static links at the bottom of the home page
    When I will enter valid user name as "lvishalhdfc@yopmail.com"
    And  I enter valid password as "Paymate@2"
    And I click on login button
    And I enter otp and click on verify button
    And I click on the following "<Links>" for HDFC
    Then I should land on particular page for static links
    Examples:
      | Links          |
#      | Terms of use   |
#      | Privacy policy |
#      | Help           |
      | Charges        |
#      | Contact Us     |