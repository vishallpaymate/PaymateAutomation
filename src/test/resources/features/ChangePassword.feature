@ChangePassword
Feature: I want to use this feature file for change password

  Background: Login with valid data
#    And I enter valid user name as "lock@yopmail.com"
    And I will enter valid user name as "lock@yopmail.com"
    And I enter valid password as "Paymate@025"
    And I click on login button

@test1
  Scenario Outline: verify change password link from profile and verify change password page
    When I click on change password link "<change Password>"
    And I click on change password field
    Then I should land on change password page
    And I see current password filed with label
    And  I see new password field with label
    And I see confirm password field with label
    And I see password guidance text as "* Password should be atleast 8 characters in length. Password should contain atleast one lowercase, one uppercase, one numeral and one special character. For eg: Abc123$a"
    And I see save and cancel button
    Examples:
      | change Password   |
      | DashBoard profile |
      | Profile settings |

  Scenario Outline: verify change password page when user clicks on button with blank data
    When I click on change password link "DashBoard profile"
    And I click on buttons"<buttons>"
    Examples:
      | buttons |
      | Save    |
      | Cancel  |


  Scenario:  verify change password when user enter new password as same last 5 password
    When I click on change password link "DashBoard profile"
    And I enter valid current password "Paymate@025"
    And I enter last five password and i should see proper validation msg in red color
      | PayMte@1234 |


  Scenario: verify change password when user enter new password as same like current password
    When I click on change password link "DashBoard profile"
    And I enter valid passwords "Paymate@025"
    Then  I should see validation message "Current password and New password cannot be same." in red color

  Scenario:  verify change password when current password and confirm password not matched
    When I click on change password link "DashBoard profile"
    And I enter valid current password "Paymate@025"
    And I enter valid new password as "PayMAte@123"
    And I enter valid confirm password as "paymate@123"
    And I click on buttons"Save"
    Then  I should see proper validation message "Password mismatch" in red color

  Scenario: verify change password when Password do not meet password policy
    When I click on change password link "DashBoard profile"
    And I enter valid current password "Paymate@025"
    And I enter password do not meet password policy then I should see validation msg as "Password do not meet password policy." in red color
      | Paymate     |
      | @@@@@@@@    |
      | 1235656     |
      | PAYMATE@123 |

  Scenario: verify change password with valid data
    When I click on change password link "DashBoard profile"
    And I enter valid current password "Paymate@025"
    And I enter valid new password as "Paymate@1223"
    And I enter valid confirm password as "Paymate@1223"
    And I click on save button
    Then I should see Proper validation message "You have updated your password successfully" in green color



