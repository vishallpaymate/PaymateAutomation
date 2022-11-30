@k
Feature: I want to use this feature file for Upload Kyc

  Background: Login with valid data
    When User navigates to paymate url
    And I will enter valid user name as "anthony550@mailinator.com"
    And I enter valid password as "Paymate@123"
    And I click on login button


  @k0
  Scenario Outline: verify upload Kyc links from dashboard
    When I click on upload kyc link from "<upload Kyc Links>"
    Then I should be land on upload documents page

    Examples:
      | upload Kyc Links  |
      | Business Settings |

  Scenario:  verify upload kyc links
    When I click on following links "<links>"
      | links             |
      | Business settings |

  @k1
  Scenario:  verify upload kyc page when user land on upload kyc page
    When  I click on upload kyc link from "Business Settings"
    And I see business type dropdown and select business type and i should see respective fields
      | Individuals       |
      | Companies         |
      | Partnership firms |


  @k2
  Scenario: verify upload kyc page when user click on upload without data
    When I click on upload kyc link from "Business settings"
    And I select business type and i click on upload button then i should see validation msg in red color
      | Individuals       |
      | Companies         |
      | Partnership firms |

  @k3
  Scenario Outline: verify upload kyc page when user upload document for particular business type
    When I click on upload kyc link from "Business settings"
#    And I select business type "<Business type>"
    And I enter all valid information and click on upload button
      | Name on Pan     | Pan Number | Upload pan card url             | upload business doc dropdown | upload business                            | Address | city  | state | pin code | upload Address drop down | upload address url                         | CIN                | LLPIN             |
      | vijay deshpande | vijay1234j | C:/Users/vijay/Downloads/vv.png |                              | C:\Users\vijay\Downloads\834018040535..png | latur   | latur |       | 413512   |                          | C:\Users\vijay\Downloads\834018040535..png | 545646446544654646 | 46446546545644654 |
    Then I should see validation message "Kyc upload suceefully" in green color
    Examples:
      | Business type |
      #| Individuals       |
      | Companies     |
     # | Partnership firms |

  @uploadkyc
  Scenario: I upload kyc documents for a new signed up Business
    Given I click on upload kyc link
    Then  I enter details in all fields on uploaded documents page
    Then  I click on upload button on uploaded documents page
    Then  I validate all fields on Uploaded documents page



#  Scenario: verify upload kyc page when user enter invalid data
#    When I click on upload kyc link from "Business settings"
#    And I select business type "<Business type>"
#    And I enter invalid data in following fields and data
#      | Pan on name          |
#      | Pan card number      |
#      | invalid pan card img |
#
#
#  Scenario:
  #//li[@class='mdl-menu__item']