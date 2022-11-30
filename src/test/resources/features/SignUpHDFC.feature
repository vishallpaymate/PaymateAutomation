@SignUpHDFC

Feature: I want Use This Template for SignUp Functionality for HDFC portal

  Background: When user enters valid url
    When User navigates to paymate url

 @signh0
 Scenario: Verify signup Page When User Land On SignUp Page
   When I click on Register Now link from Login Page
   Then I Should be Land On Register page for HDFC
   And I should see Label of All text fields for HDFC
   And I Should see Check box with "I Accept Terms & Conditions" text for HDFC
   And I Should see Signp Button And Sign In link for HDFC
   And I click on SigIn link den i should be land on SignIn page for HDFC
   And I Should See Forgot Password link with clickable Link from SignUp page for HDFC
   And I should be land on Forget Password Page from Sign Up page for HDFC

  @signh1
  Scenario Outline: Register new business on HDFC portal
    When I click on Register Now link from Login Page
    And I enter "<firstName>" and "<LastName>" and "<Email>" and "<mobile Number>"
    And I click on terms and conditions check box for HDFC
    Then I should see popUp window with terms and conditions text and accept button for HDFC
    And I Click on Signup Button and i should see proper validation message in green color for HDFC
    And I should land on verify and confirm your email addres page for HDFC
    And I Should see two links with clickable
    And I should get mail "<Email>" i should see verify email link for HDFC
    And I click on verify email Address button for HDFC
    And I enter otp and click on verify button
    Then I should see proper validation message in green color for HDFC
    And I Should land on create password page for HDFC
    And I enter password and ReEnter password for HDFC
    And I click on submit button and i should see proper validation message in green color for HDFC
    Then I should be land on business page
    And I see all filed Labels and fields are enable for HDFC
    And I see all filed Labels and fields are enable
    And I enter foloowing business name"<BusinessName>"
    And I enter valid subBusiness name"<SubBusinessName>"
    And I click on business type filed for HDFC
    And I select following business type"<BusinessType>" for HDFC
    And I click on category dropDown field for HDFC
    And I select valid category for HDFC
    And I select valid Sub category for HDFC
    And I enter website information
    And I enter business information
    And I click Complete signup button
    Then I should be register successfully with validation message in green color
    And I should get mail "<Email>" i should see login link
    And I should be land on login page for HDFC
    And I enter valid user name as "<Email>"
    And I enter valid password as "Paymate@123"
    And I click on login button
    And I enter otp and click on verify button
#    And I should land on enter card details popup and I verify all fields
#    And I enter card details and click continue button
#    And I enter cvv and click Pay now button
#    Then I should be land on paymate dashboard
#    And I check the respective kyc fields are present as per "<BusinessType>"
    Examples:
      | firstName | LastName | Email | mobile Number | BusinessType   | BusinessName | SubBusinessName |
      | Vishal    | Lamba    | johnny  | 9870697982    | Proprietorship | pvt ltd      | vl              |