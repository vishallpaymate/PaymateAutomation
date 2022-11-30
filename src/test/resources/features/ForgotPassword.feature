@ForgotPassword
Feature: I want to use this template for my Forgot Password

  Background: When user enters valid url
    When User navigates to paymate url

  @tag0
  Scenario: verify ForgotPassword Link when user land on Login Page
    When I am on login page
    Then I should see forgot password link with clickable Link

  @tag1
  Scenario:verify Forgot Password Page when user click on Forgot Password link
    When I click on forgot password link
    Then I should be land on forgot password page
    And I should be see forgot password label as "Email Address"
    And I should see Get OTP button
#    And  I should see user name field
#    And I should see reset my password button with clickable
    And I should see login link

  @tag2
  Scenario:verify User Name Field When user Enter Unregister User Name
    When I click on forgot password link
    And I Enter invalid email id  as "test"
#    And I click on reset my password without user name
    Then I should see proper validation message in red color
    And I should be on same page

#  @tag3
#  Scenario: verify User Name Field When user Enter Unregister User Name
#    When I click on forgot password link
#    And I enter unregister user name
#    And I click on reset my password button
#    Then I should see proper validation message as "You are not a registerd user. Please sign up to use our service." in red color
#    And I should be on forgot password page

  @tag4
  Scenario: Verify Forgot Password when user enter valid User Name
    When I click on forgot password link
    And I enter valid user name "auto@yopmail.com"
    And I click on Get OTP button
#    And I click on reset my password button
    Then I should see Proper validation message as "OTP has been sent to the registered Email Address" in green color
    And I see Resend OTP and Edit Email buttons
#    And I see OTP message title as "One Time Password (OTP) has been sent to your Email"
    And I see OTP input fields are present
    And I should see login link
#    And I should see button text as " Resend Email"
#    And I should get email on my user id as "auto@yopmail.com"

  @tag5
  Scenario: Verify all fields on Set new password page
    When I click on forgot password link
    And I enter valid user name "simon776@yopmail.com"
    And I click on Get OTP button
#    And I click on reset my password button
    When I open forgot password mail id as "simon776@yopmail.com"
    Then I enter otp from email in otp field
    And I see new password and confirm password fields
    And I enter valid new password on Set password page as "Paymate@1"
    And I enter confirm password on Set password page as "Paymate@1"
    And I click on save button
    And I should be land on login page
#    And  I open up a new tab with this URL
#    And I enter valid user name in username field as "auto@yopmail.com"
#    And  I enter email password
#    Then I should be land on change password page
#    And I should see proper label for current password as "Current Password",new password as "New Password",confirm password as "Confirm Password"
#    And I enter confirm pass and new pass as "PayMate@1224"
    And I should see proper validation message as "Password created successfully."

#    And I should get password change confirmation email id as "auto@yopmail.com"

  @tag6
  Scenario: Verify Forgot Password When USer Enter New password as previous 5 password
    When I click on forgot password link
    And I enter valid user name "auto@yopmail.com"
    And I click on Get OTP button
#    And I click on reset my password button
    When I open forgot password mail id as "auto@yopmail.com"
    Then I enter otp from email in otp field
    And I see new password and confirm password fields
    And I enter valid new password on Set password page as "Paymate@1"
    And I enter confirm password on Set password page as "Paymate@1"
    And I click on save button
#    And I should be land on login page
#    When  I open forgot password mail id as "auto@yopmail.com"
#    And  I open up a new tab with this URL
#    And I enter valid user name in username field as "auto@yopmail.com"
#    And I enter email password
#    Then I should be land on change password page
#    And I enter current password
#    And I enter new password as same last five password "Paymate@1232"
#    And I click on save
    And  I should see proper validation message as "A new password cannot be the same as your previous 5 passwords."
