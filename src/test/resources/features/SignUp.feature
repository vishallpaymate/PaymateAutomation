@SignUp
    Feature: I want Use This Template for SignUp Functionality

    Background: When user enters valid url
      When User navigates to paymate url

    @sign0 @signs
    Scenario: Verify signup Page When User Land On SignUp Page
      When I click on Register Now link from Login Page
      Then I Should be Land On Register page
      And I should see Label of All text fields
      And I Should see Check box with "Please accept the terms and conditions" text
      And I Should see Signp Button And Sign In link
      And I click on SigIn link den i should be land on SignIn page
#    And I Should See Forgot Password link with clickable Link from SignUp page
#    And I should be land on Forget Password Page from Sign Up page

      @sign1 @signs
      Scenario Outline: verfiy SignUp page when user Enter valid Data
        When I click on Register Now link from Login Page
        And I enter "<firstName>" and "<LastName>" and "<Email>" and "<mobile Number>"
        And I click on terms and conditions check box
        Then I should see popUp window with terms and conditions text and accept button
        And I Click on Signup Button and i should see proper validation message in green color
        And I should land on verify and confirm your email addres page
        And I Should see two links with clickable
        And I should get mail "<Email>" i should see verify email link
#    And I verify email content for signup
        And I click on verify email Address button
        And I  Shoudl land Verify Mobile number page
        And I should see proper validation msg verify mobile number page
        And I should see text box with One time Password label and two links with clickable  and Submit button with clickable
        And I Enter valid OTP
        And I click on submit button
        Then I should see proper validation message in green color
        And I Should land on create password page
        And I enter password and ReEnter password
        And I click on submit button and i should see proper validation message in green color
        Then I should be land on business page
        And I see all filed Labels and fields are enable
        And I enter foloowing business name"<BusinessName>"
        And I enter following business GSTIN "<GSTIN>"
#      And I enter valid subBusiness name"<SubBusinessName>"
        And I click on business type filed
        And I select following business type"<BusinessType>"
        And I select Industry type for Business
        And I enter a valid pincode for Business
        And I enter a valid City for Business
#      And I click on category dropDown field
#      And I select valid category
#      And I select valid Sub category
        And I select valid State
        And I select valid Region
#      And I enter website information
#      And I enter business information
        And I click Complete signup button
        Then I should be register successfully with validation message in green color
        Then I logout of PMX
        And I should get mail "<Email>" i should see login link
        And I should be land on login page
        And I enter valid user name as "<Email>"
        And I enter valid password as "Paymate@123"
        And I click on login button
        Then I should be land on paymate dashboard
#        And I check the respective kyc fields are present as per "<BusinessType>"
        Examples:
          | firstName | LastName | Email   | mobile Number | BusinessType                  | BusinessName    | GSTIN           |
            | Vishal    | Lamba    | simon   | 9870697982    | Proprietorship                | pvt ltd         | 12AXRPT4168Q1ZH |
#          | sars      | lars     | ryu     | 8888888888    | Private Limited               | shradha pvt ltd | 33AAACS8585H1Z1 |
#          | swati    | kasar    | desmond   | 9870697982    | Limited Liability Partnership | shweta pvt ltd  | 19AAAFQ4862C1ZB |
#          | Vishal    | Lamba    | freeman | 9870697982    | Public Limited                | vss             | 02AABCA5300M2Z6 |
#          | prez      | l        | alex    | 8888888888    | Partnership                   | shradha pvt ltd | 27AAKFD3658BIZJ|
#          | zion      | k        | ken     | 9870697982    | One Person Company            | zion pvt ltd    | 32AADCO1722H1ZX |
#          | cody      | travers  | jimmy   | 8888888888    | Hindu Undivided Family        | cody pvt ltd    | AARHM0269E      |
#          | akira     | m        | gordon  | 9870697982    | Cooperative Society           | akira pvt       | 24AAAAB0575E1ZB |


#  @dummy
#  Scenario Outline: Verify Login page of registered user with valid data
#    When I navigate to paymate login page
#    And I enter valid user name as "<Email>"
#    And I enter valid password as "Paymate@123"
#    And I click on login button
#    Then I should be land on paymate dashboard
#    And I check the respective kyc fields are present as per "<BusinessType>"
#    Examples:
#      | Email                    | mobile Number | BusinessType                  | BusinessName    | SubBusinessName |
#      | vishal9@yopmail.com      | 9870697982    | Proprietorship                | vishal pvt ltd  | vl              |
#      | pav20@yopmail.com        | 8888888888    | Private Limited               | shradha pvt ltd | sl              |
#      | pava19@yopmail.com       | 9870697982   | Limited Liability Partnership | shweta pvt ltd  | sk              |
#      | vishal006@mailinator.com | 9870697982    | Public Limited                | vishal pvt ltd  | vl              |
#      | pav22@mailinator.com     | 8888888888    | Partnership                   | shradha pvt ltd | sl              |
#      | pava23@mailinator.com    | 9870697982   | One Person Company            | shweta pvt ltd  | sk              |
#      | pavaa22@mailinator.com   | 8888888888    | Hindu Undivided Family        | shradha pvt ltd | sl              |
#      | pavaal23@mailinator.com  | 9870697982   | Cooperative Society           | shweta pvt ltd  | sk              |


    @sign2
    Scenario: Verify Signup screen with invalid data
      When I Click on Signup button without entering the details in all the mandatory fields
      Then I Should be able to click SignUp button
      And I see all mandatory fields should be highlighted with red color
#    And I see focus should be moved on to First name field with error message as "Please enter First name"
      When I Click on Signup button without entering any one of the mandatory fields Then I see the field in red color with error message please enter respective field name
      When I Enter Invalid numeric and special character name in First Name and Last Name field
      Then I Should not be able to enter the numeric and special characters
      When I Enter invalid email in email id field
      Then I see an error message "Please enter a valid Email" and field should be highlighted in red color
      When I Enter invalid mobile number
      And I see an error message "Please enter valid Mobile Number" and field highlighted in red color

    @sign4
    Scenario Outline: Verify Signup page with already registered but not verified user details
      When I click on Register Now link from Login Page
#    And I enter "<firstName>" and "<LastName>" and "<Email>" and "<mobile Number>"
      And I enter "<firstName>" , "<LastName>" , "<Email>" and "<mobile Number>"
      And I click on terms and conditions check box
      Then I should see popUp window with terms and conditions text and accept button
      And I Click on Signup Button and i should see proper validation message in green color
      When User navigates to paymate url
#    Given I have to start from login page
      When I click on Register Now link from Login Page
      And I enter "<firstName>" and "<LastName>"
      And I enter email ID "<Email>"which is registered but not verified
      And I enter mobile number "<mobile Number>" which is register but not verified
      And I click on terms and conditions check box
      And  I should see popUp window with terms and conditions text and accept button
      And I Click on Signup Button
      Then I should see validation message "You are already registered with PayMate." and message highlighted in green color
      And I should land Welcome to PayMate Complete your sign-up page
      And I should see Looks like you have already attempted your registration earlier text
      And I should see following buttons "<Buttons>"and i click and user should be land on perticular page
      Examples:
        | firstName | LastName  | Email                 | mobile Number | Buttons     |
#        | vijay     | deshpande | shwetaa65@yopmail.com | 9870697982    | Continue    |
        | vijay     | deshpande | swati01@yopmail.com | 9870697982    | Start Again |
#dont change anything
    @sign5
    Scenario Outline: Verify signup page with already registered user details
      Given I click on Register Now link from Login Page
#    And I enter "<firstName>" and "<LastName>" and "<Email>" and "<mobile Number>"
      And I enter "<firstName>" , "<LastName>" , "<Email>" and "<mobile Number>"
      And I click on terms and conditions check box
      And I should see popUp window with terms and conditions text and accept button
      And I Click on Signup Button
      Then  I should see proper validation message in Red Color and I should be redirect on login page
      Examples:
        | firstName | LastName  | Email              | mobile Number |
        | vijay     | deshpande | ajay03@yopmail.com | 9870697982    |

    @sign6
    Scenario Outline: Verify Complete your signup screen
      Given I click on Register Now link from Login Page
#    And I enter "<firstName>" and "<LastName>" and "<Email>" and "<mobile Number>"
      And I enter "<firstName>" , "<LastName>" , "<Email>" and "<mobile Number>"
      And I click on terms and conditions check box
      And I should see popUp window with terms and conditions text and accept button
      And I Click on Signup Button and i should see proper validation message in green color
      Then I should land on verify and confirm your email addres page
      And I Should see Following link"<links>"
      And I click on links"<links>" and "<Email>"
      Examples:
        | firstName | LastName  | Email                  | mobile Number | links                                          |
        | vijay     | deshpande | bhimm65@mailinator.com | 9870697982    | Click here to resend the email                 |
        | vijay     | deshpande | bhimm66@mailinator.com | 9870697982    | Go back to change your email address provided. |

    @sign7
    Scenario Outline: Verify Mobile Verification page with invalid data
      When I click on Register Now link from Login Page
      And I enter "<firstName>" and "<LastName>" and "<Email>" and "<mobile Number>"
      And I click on terms and conditions check box
      Then I should see popUp window with terms and conditions text and accept button
      And I Click on Signup Button and i should see proper validation message in green color
      And I should land on verify and confirm your email addres page
      And I Should see two links with clickable
      And I should get mail "<Email>" i should see verify email link
      And I click on verify email Address button
      And I  Shoudl land Verify Mobile number page
      And I should see text box with One time Password label and two links with clickable  and Submit button with clickable
      And I Enter following OTP
        | 123       |
        | hghgh     |
        | 112345678 |
        | $%$%$$    |
      And I click on submit button
      Then I should see proper validation message for invalid OTP in red color
      Examples:
        | firstName | LastName | Email | mobile Number |
        | swati    | kasar    | mo24  | 9970697982    |

    @sign8
    Scenario Outline: Verify Mobile Verification page by changing mobile number
      When I click on Register Now link from Login Page
      And I enter firstName as "vijay" and LastName as "deshpande" and "<Email>" and mobile Number as "9870697982"
      And I click on terms and conditions check box
      Then I should see popUp window with terms and conditions text and accept button
      And I Click on Signup Button and i should see proper validation message in green color
      And I should land on verify and confirm your email addres page
      And I Should see two links with clickable
      And I should get mail "<Email>" i should see verify email link
      And I click on verify email Address button
      And I  Shoudl land Verify Mobile number page
      And I should see text box with One time Password label and two links with clickable  and Submit button with clickable
      And I click on following links and i see validation message and i redirect on respective page
        | Click here to Resend OTP                       |
        | Click here change your mobile number provided. |
      Examples:
        | Email      |
        | changemo21 |

    @sign9
    Scenario Outline: Verify Create Password for invalid inputs
      When I click on Register Now link from Login Page
      And I enter firstName as "vijay" and LastName as "deshpande" and "<Email>" and mobile Number as "9870697982"
      And I click on terms and conditions check box
      Then I should see popUp window with terms and conditions text and accept button
      And I Click on Signup Button and i should see proper validation message in green color
      And I should land on verify and confirm your email addres page
      And I Should see two links with clickable
      And I should get mail "<Email>" i should see verify email link
      And I click on verify email Address button
      And I  Shoudl land Verify Mobile number page
#        And I should see text as "One Time Password (OTP) has been sent to your mobile" on verify mobile number page
      And I should see text box with One time Password label and two links with clickable  and Submit button with clickable
      And I Enter valid OTP
      And I click on submit button
      Then I should see proper validation message in green color
      And I Should land on create password page
      And I enter following data in password fields and clik on submit then should display validation msg
        | Enter Password | Reenter Password | validationMessage                     |
        |                |                  | Please enter the password.            |
        | test           | test             | Password do not meet password policy. |
        | Test123        | Test123          | Password do not meet password policy. |
        | abc123$        | abc123$          | Password do not meet password policy. |
        | 426565565655   | 426565565655     | Password do not meet password policy. |
      Examples:
        | Email        |
        | createPass14 |

    @sign10
    Scenario Outline: Verify Business details page with invalid inputs
      When I click on Register Now link from Login Page
      And I enter firstName as "vijay" and LastName as "deshpande" and "<Email>" and mobile Number as "9870697982"
      And I click on terms and conditions check box
      Then I should see popUp window with terms and conditions text and accept button
      And I Click on Signup Button and i should see proper validation message in green color
      And I should land on verify and confirm your email addres page
      And I Should see two links with clickable
      And I should get mail "<Email>" i should see verify email link
      And I click on verify email Address button
      And I  Shoudl land Verify Mobile number page
        #  And I should see text as "One Time Password (OTP) has been sent to your mobile" on verify mobile number page
      And I should see text box with One time Password label and two links with clickable  and Submit button with clickable
      And I Enter valid OTP
      And I click on submit button
      Then I should see proper validation message in green color
      And I Should land on create password page
      And I enter password and ReEnter password
      And I click on submit button and i should see proper validation message in green color
      Then I should be land on business page
      And I see all filed Labels and fields are enable
      And I Enter Following details in All fields and click on complete signUp button
        | Business Name |
        |               |
        | 545445        |
        | @@@@@@        |
        | 12313@@@      |
        | BusinessName  |
      Examples:
        | Email             |
        | businessdetails12 |


#  @dummy2
#  Scenario: Verify Login page of registered user with valid data
#    When I navigate to paymate login page
#    And I will enter valid user name as "vipul5y3@mailinator.com"
#    And I enter valid password as "Paymate@123"
#    And I click on login button
#    And I navigate to Requests Received page
#    And I should redirect on request received page and i approve transaction
