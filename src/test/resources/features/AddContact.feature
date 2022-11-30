@Contact
Feature: I want to use this feature file for add contact

  #PMX
  Background: Login with valid data
    When User navigates to paymate url
    And I will enter valid user name as "simon704@mailinator.com"
    And I enter valid password as "Paymate@123"
    And I click on login button


  #HDFC
#  Background: Login with valid data on HDFC client portal
##    When I navigate to paymate login page for HDFC portal
#    When User navigates to paymate url
#    And I enter valid user name in username field as "lvishalhdfc@yopmail.com"
#    And I enter valid password as "Paymate@2"
#    And I click on login button
#    And I enter otp and click on verify button
#    Then I should be able to click and should navigate to business dash board page

  @c1 @con
  Scenario: verify add contact when user click on add contact link
    When I click on add contact link
    Then I should see following links
      | Bulk Upload Contactss |
      | Contacts             |
      | Manage Contacts      |

  @c2 @con
  Scenario Outline: verify add contact when user click on particular link
    When I click on add contact link
    And I click on contact following links "<links>"
    Then I should land on particular page
    Examples:
      | links                |
      | Bulk Upload Contacts |
      | Add Contact          |
      | Manage Contacts      |

  #bulk upload
  #date:19-04-2019
  @c3
  Scenario Outline: verify add contact page when user click on links contact
    When  I click on add contact link
    And I click on contact following links "<links>"
    Then I should see respective fields
    Examples:
      | links                |
      | Bulk Upload Contacts |
      | Add Contact          |
      | Manage Contacts      |

  @c4 @con
  Scenario: verify bulk upload contact page when user click on upload ,cancel button without data
    When  I click on add contact link
    And I click on contact following links "Bulk Upload Contacts"
    And I click on buttons then i see validation msg
      | Continue |
      | Cancel   |

  @c5 @con
  Scenario: verify bulk upload contact page when user  click on download template
    When  I click on add contact link
    And I click on contact following links "Bulk Upload Contacts"
    And I click on download template link
    Then I should verify file is download
    #ie pop is pending

  @c6 @con
  Scenario: verify bulk upload contact page when user  click on view sample link
    When  I click on add contact link
    And I click on contact following links "Bulk Upload Contacts"
    And I click on view sample link
    Then I should see popup window and data

  @c7 @con
  Scenario: verify bulk upload contact page when user perform close operation
    When  I click on add contact link
    And I click on contact following links "Bulk Upload Contacts"
    And I click on view sample link
    And I should see popup window and data
    And I click on following button to close then pop is closed i land on bulk upload page
      | Close button |
      | Cross icon   |
      | Escape       |

  @c8 @con
  Scenario: verify bulk upload conatct page excel sheet row data with sample
    When  I click on add contact link
    And I click on contact following links "Bulk Upload Contacts"
    And I click on view sample link
    And  I should see popup window and data
    Then I match sample data row and excel data row

  @c9 @con
  Scenario: verify bulk upload contact page when user upload bulk valid data
    When  I click on add contact link
    And I click on contact following links "Bulk Upload Contacts"
    And I write data in downloaded excel file
#     | ReferenceCode | CompanyName  | FirstName | LastName | MobileNo   | EmailID | CompanyAddress | BankAccountNo   | IFSCode     | GSTIN    |PAN       | Notification Details | Pincode | Industry | Business Type | EmpanelmentDate | CreditPeriod |
        | track28| Virtuals | A | B | 9870697982 | virtual10@mailinator.com | N | 21454545456 | icic0000546 | 27AAECP0062G1ZP | AAECP0062G | vss1@mailinator.com |400022  | Automobiles| Manufacturing|||
#      | ajay6   | wifi1     | ajgdgu | ggajay | deshpande | 9870697982 | vigjay3@mailinator.com       | latur | 354156456454564564 | icic0000546 | 29AAACB5343E2ZW | surelock2@example.com |
#      | sanjay6 | CASIO pvt | gdgaju | gdg    | deshpande | 9870697982 | vgijay@mailinator.com        | latur | 354156456454564564 | icic0000546 | 29AAACB5343E2ZW | surelock2@example.com |
    And I upload file
    Then I see entered data is displayed in manage contact and page fields
    And I see uploaded data in table format
    And I click on confirm button and i should see proper validation message
    And I should be land on manage contact and uploaded data should be display
    And I check contact get mail or not

  @c10 @con
  Scenario:  verify bulk upload contact when user upload invalid files
    When  I click on add contact link
    And I click on contact following links "Bulk Upload Contacts"
    And I upload file following file
      | file type                    | file links                                                                                   |
      | .pdf                         | E:\Office\PaymateAutomation\PaymateAutomation\InvalidFiles\test.pdf                          |
      | empty valid file             | E:\Office\PaymateAutomation\PaymateAutomation\InvalidFiles\ContactBulkUploadTemplate (1).xls |
      | valid file with invalid data | E:\Office\PaymateAutomation\PaymateAutomation\InvalidFiles\ContactBulkUploadTemplate.xls     |
    Then I should see proper validation message
#    And I click on confirm button and should display proper validation message #can no longer click confirm button

  @c11 @con
  Scenario: verify bulk upload contact when user upload valid file and data with is kyc required check box
    When  I click on add contact link
    And I click on contact following links "Bulk Upload Contacts"
    And I write data in downloaded excel file
      #| ReferenceCode | CompanyName  | FirstName | LastName  | MobileNo   | EmailID   | CompanyAddress | BankAccountNo  | IFSCode  | GSTIN   |PAN| Notification Details|
      | samm57 | shardha    | vijay  | deshpande | 9870697982 | samm54@mailinator.com  | pune  | 21454545  | icic0000546 | 29AAACB5343E2ZW | AAACB5343E | surelock2@example.com |400022|Automobiles|Manufacturing|||
      | pam38  | ajay pvt   | ajay   | deshpande | 9870697982 | pammy38@mailinator.com | latur | 214544437  | icic0000546 | 29AAACB5343E2ZW | AAACB5343E | surelock2@example.com |400022|Automobiles|Manufacturing|||
      | vam38  | ay pvt     | ajay   | deshpande | 9870697982 | vammy39@mailinator.com | latur | 21454538  | icic0000546 | 29AAACB5343E2ZW | AAACB5343E | surelock2@example.com |400022|Automobiles|Manufacturing|||
      | dam38  | sanjay pvt | ajay   | deshpande | 9870697982 | dammy40@mailinator.com | latur | 21464439  | icic0000546 | 29AAACB5343E2ZW | AAACB5343E | surelock2@example.com |400022|Automobiles|Manufacturing|||
      | ram38  | vijay pvt  | vijayh | deshapdn  | 9870697982 | rammy41@mailinator.com | latur | 21430 | icic0000546 | 29AAACB5343E2ZW | AAACB5343E | surelock2@example.com |400022|Automobiles|Manufacturing|||
#    And I click on is Kyc mandatory checkbox
    And I upload file
    Then I see entered data is displayed in manage contact and page fields
    And I see uploaded data in table format
    And I click on confirm button and i should see proper validation message
#    And I see action icon
    And I check contact get mail or not

  @c12 @con
  Scenario: verify bulk upload contact when user enter duplicate mail id with different reference code and duplicate reference code with different email id
    When  I click on add contact link
    And I click on contact following links "Bulk Upload Contacts"
    And I write data in downloaded excel file
      #| ReferenceCode | CompanyName | NickName | FirstName | LastName  | MobileNo   | EmailID                | CompanyAddress | BankAccountNo   | IFSCode     | GSTIN           | PAN| Notification Details |
      #change  Reference code ,use duplicate email
      | times39 | shardha | vijay | deshpande | 9870697982 | sneha23@mailinator.com        | pune | 2454564456 | icic0000546 | 29AAACB5343E2ZW | AAACB5343E | surelock2@example.com |400022  | Automobiles| Manufacturing|||
    #change mail id ,use duplicate reference code
      | times9  | shardha | vijay | deshpande | 9870697982 | referhenctse39@mailinator.com | pune | 5454564456 | icic0000546 | 29AAACB5343E2ZW | AAACB5343E | surelock3@example.com |400022  | Automobiles| Manufacturing|||
    And I upload file
    And I click on confirm button and i see proper validation message



    #Add Contact
  #Date:24/04/2019
  @c13 @con
  Scenario: verify Add contact page when user click on upload cancel without data
    When  I click on add contact link
    And I click on contact following links "Add Contact"
    And I click on button then i see validation message
      | Save   |
      | Cancel |

  @c14 @con
  Scenario: verify add contact page when user enter valid mandatory fields
    When  I click on add contact link
    And I click on contact following links "Add Contact"
    And I enter mandatory fields
      | Company Name | First Name | Last Name |
      | zynga     | alyxx      | lifee     |
    And I click on Add contact save button
#    Then I should see "Contact saved successfully." msg and i should land on manage contact
    Then I validate contact saved message and I land on manage contact page

  @c15 @con
  Scenario: verify add contact page when user enter only optional fields
    When  I click on add contact link
    And I click on contact following links "Add Contact"
    And I enter only optional fields
      | Email                | Mobile Number | Reference Code | Compnay Address | Bank Account Number | IFSC code   | GSTIN           ||400022|Manufacturing||||
      | tuhtu2@mailinator.com | 9870697982    | vl207         | latur           | 5454564588  | icic0000546 | 29AAACB5343E2ZW ||400022|Manufacturing||||
    And I click on Add contact save button
    Then I should see proper validation msg for manadatory field


  @c16 @con
  Scenario: verify add contact page fields label
    When  I click on add contact link
    And I click on contact following links "Add Contact"
    Then I see label for every text field
      | Label Text          |
      | Company Name *      |
      | Reference Code      |
      | First Name          |
      | Last Name           |
      | Email Address       |
      | Mobile Number       |
      | GSTIN               |
      | PAN Card Number     |
      | Company Address     |
      | Bank Account Number |
      | IFS Code            |
      | Notification Emails |


  @c17
  Scenario: verify add contact page when user enter valid data and click on is Kyc mandatory check box(Add user who not upload documents)
    When  I click on add contact link
    And I click on contact following links "Add Contact"
    And I enter valid data and click on check box
      | Company Name | Reference number | First Name | Last Name | E-mail | Mobile Number | GSTIN           | Company Address | Bank Account Number | IFSC Code   | Notification Emails |
      | Systems      | 1                | Alex       | Baldwin   | jame   | 9870697982    | 29AAACB5343E2ZW | N               | 214545454564457     | icic0000546 | james               |
    And I click on Add contact save button
    Then I should see "Contact saved successfully." msg and i should land on manage contact
    And I click on filter and enter Reference code
    And I check action icon
    And I check contact get mail or not

  @cc
  Scenario: verify add contact page when user enter valid data and click on is Kyc mandatory check box(Add user who  uploaded documents)
    When  I click on add contact link
    And I click on contact following links "Add Contact"
    And I enter valid data and click on check box
      | Company Name | Reference number | First Name | Last Name | E-mail | Mobile Number | GSTIN           | Company Address | Bank Account Number | IFSC Code   | Notification Emails |
      | Systems      | 1                | Alex       | Baldwin   | jame   | 9870697982    | 29AAACB5343E2ZW | N               | 214545454564457     | icic0000546 | james               |
    And I click on Add contact save button
    Then I should see "Contact saved successfully." msg and i should land on manage contact
    And I click on filter and enter Reference code
    And I see view documents icon and other action parameters
    And I check contact get mail

  @c18
  Scenario: verify add contact page when user enter duplicate email id
    When  I click on add contact link
    And I click on contact following links "Add Contact"
    And I enter valid data and click on check box
    #user u r account duplicate email if contact added without reference code
      | Company Name | Reference number | First Name | Last Name | E-mail | Mobile Number | GSTIN           | Company Address | Bank Account Number | IFSC Code   | Notification Emails |
      | Systems      | 1                | Alex       | Baldwin   | jame   | 9870697982    | 29AAACB5343E2ZW | N               | 214545454564457     | icic0000546 | james               |
    And I click on Add contact save button
    Then I should see "Contact Email Address already registered." msg and i should be on same page

  @c19
  Scenario: verify add contact page when user enter duplicate email id with different Reference code
    When  I click on add contact link
    And I click on contact following links "Add Contact"
    And I enter valid data and click on check box
      | E-mail    | Company Name | First Name | Last Name | Nick Name | Mobile Number | Reference number | Company Address | Bank Account Number | IFSC Code   | GSTIN           | Notification Emails |
      | workflows | Mango        | aman       | aman      | am        | 9870697982    | 0025             | Balnk           | 6589545685656       | icic0000546 | 29AAACB5343E2ZW | workflow            |
    And I click on Add contact save button
    Then I should see "Contact saved successfully." msg and i should land on manage contact
    And I click on filter and enter Reference code
    And I check action icon
    And I check contact get mail

  @c20 @con
  Scenario: verify add contact page when  user enter valid data without select is kyc required check box
    When  I click on add contact link
    And I click on contact following links "Add Contact"
    And I enter valid data without click on is Kyc checkBox
      | Company Name | Reference number | First Name | Last Name | E-mail | Mobile Number | GSTIN           | PAN        | Company Address | Bank Account Number | IFSC Code   | Notification Emails |
      | Mango        | 00032             | aman       | aman      | amir   | 9870697982    | 29AAACB5343E2ZW | ARVQK9423M | N               | 214545454564457     | icic0000546 | james               |
    And I click on Add contact save button
#    Then I should see "Contact saved successfully." msg and i should land on manage contact
    Then I validate contact saved message and I land on manage contact page
    And I click on filter and enter Reference code
    And I check action icon
    And I check contact get mail or not


    #Manage Contact
  #Date:2-05-2019

  @c21 @con
  Scenario: verify manage contact page when user check filter functionality
    When  I click on add contact link
    And I click on contact following links "Manage Contacts"
    And I click on filter
    Then I see respect fields with labels and buttons
    And I see text and dropdown and its value and tables heading
      | Drop Down Default value | Table Heading    |
      | 10                      | Xpress ID        |
      | 25                      | Company Name     |
      | 50                      | Mobile No        |
      | 100                     | RegistrationDate |
      | All                     | Status           |
      |                         | Kyc Status       |
      |                         | Actions          |

  @c22
  Scenario: verify manage contact filter functionality
    When  I click on add contact link
    And I click on contact following links "Manage Contacts"
    And I enter following data in fields
      | Email Id               | Company Name        | Company code | Mobile Number |
      | vishalz@mailinator.com | vsystem             | p            | 9870697982    |
      | amir739@mailinator.com | Feil Inc .LTD       | 610021       | 9870697982    |
      | jamesb8@mailinator.com | Hyatt and Sons .LTD | 735607       | 9870697982    |

  #Export scenario is pending
#    And I click on export button
#    Then I see that file is download successfully
#    And I see filter data in excel sheet

  @c24
  Scenario Outline: verify manage contact action functionality
    When  I click on add contact link
    And I click on contact following links "Manage Contacts"
    Then I see following action "<action>" i should be land on respective page
    Examples:
      | action |
#      | Edit             |
#      | Remove Contact   |
#      | view             |
      | Email  |
#      | Upload Documents |

  @c25
  Scenario Outline: verify manage contact when user click on edit
    When  I click on add contact link
    And I click on contact following links "Manage Contacts"
    And I see following action "Edit" i should be land on respective page
    And I click on basic details
    And I enter data in following fields "<fields>"
      | Email id              | Company Name | First Name | Last Name | Nick name | mobile number   | GSTIN        | Notification Details |
      | ggggg                 |              | 464564544  | 46456445  | 55454     | 2fefefefffefeff | fdsfdsff     | @@@@                 |
      | @@@@@@@               |              | @@@@@@@    | @@@@@@@@  | @@@@@     | 454545444       | 446445446464 | 23424                |
      | @mailinator.com       |              |            |           | dsdf43434 | 99702424gy      | @@@@@@@@     | *******              |
      | vijay@mailinator..com |              |            |           | ********* | 454**6565--     | 544fs@@      | ffffffffffffff       |
    Examples:
      | fields               |
      | Email id             |
      | compnay name         |
      | First Name           |
      | Last name            |
      | Nick name            |
      | Mobile number        |
      | GSTIN                |
      | Notification Details |

  @c26
  Scenario: verify manage contact when user click on edit and enter duplicate mail id and duplicate referance code
    When  I click on add contact link
    And I click on contact following links "Manage Contacts"
    And I see following action "Edit" i should be land on respective page
    And I click on basic details
    Then I enter data in fields and i see proper validation message
    #update duplicate mail id
      | Email                 | Reference code |
      | deshpande@yopmail.com | View           |
      | rrrr@yopmail.com      | Pay123         |
#      | james9b8@mailinator.com    | 735607         |
#      | workflow5m3@mailinator.com | 483340         |


  @c27
  Scenario: verify manage contact when user click on edit and user update mandatory fields
    When  I click on add contact link
    And I click on contact following links "Manage Contacts"
    And I see following action "Edit" i should be land on respective page
    And I click on basic details
    And I check fields are editable
    Then I enter data in fields and i see proper validation message in green color
      | First Name | Last Name | Company Name |
      | Raj        | guna      | pvt Ltd      |

  @c28
  Scenario: verify van details tab when user visit without Generate van number
    When  I click on add contact link
    And I click on contact following links "Add Contact"
    And I enter valid data and click on check box
      | Company Name | Reference number | First Name | Last Name | E-mail | Mobile Number | GSTIN           | PAN        | Company Address | Bank Account Number | IFSC Code   | Notification Emails |
      | Mango        | 0017             | aman       | aman      | amir   | 9870697982    | 29AAACB5343E2ZW | ARVQK9423M | N               | 214545454564457     | icic0000546 | james               |
    And I click on Add contact save button
    Then I should see "Contact saved successfully." msg and i should land on manage contact
    And I click on filter and enter Reference code
#    And I click on contact following links "Manage Contacts"
    And I click on edit button and check the following fields
      | Fields     |
      | Xpress ID  |
      | VAN Number |
      | Status     |
      | Actions    |

  @c29 @con
  Scenario: verify VAN details tab when user click on Generate van
    When  I click on add contact link
    And I click on contact following links "Add Contact"
    And I enter valid data without click on is Kyc checkBox
      | Company Name | Reference number | First Name | Last Name | E-mail | Mobile Number | GSTIN           | PAN        | Company Address | Bank Account Number | IFSC Code   | Notification Emails |
      | Mango        | 0036             | aman       | aman      | amir   | 9870697982    | 29AAACB5343E2ZW | ARVQK9423M | N               | 21454522     | icic0000546 | james               |
    And I click on Add contact save button
#    Then I should see "Contact saved successfully." msg and i should land on manage contact
    Then I validate contact saved message and I land on manage contact page
    And I click on filter and enter Reference code
#    And I click on contact following links "Manage Contacts"
    Then I click on Generate Van and validate alert message
#    Then I click on Generate VAN and i see validation msg in green color
#    And  I should check user get mail or not and verify mail content
    #Email verification is pending

  @van
  Scenario: Add new contact and verify van Details when clicked on Generate van
    When  I click on add contact link
    And I click on contact following links "Add Contact"
    And I enter valid data and click on check box
      | E-mail | Company Name | First Name | Last Name | Nick Name | Mobile Number | Reference number | Company Address | Bank Account Number | IFSC Code   | GSTIN           | Notification Emails |
      | sam    | S            | A          | B         | am        | 9870697982    | 0001             | N               | 6589545685656       | icic0000546 | 29AAACB5343E2ZW | vipul               |
    And I click on Add contact save button
    Then I should see "Contact saved successfully." msg and i should land on manage contact
    And I click on filter and enter Reference code
    Then I click on Generate VAN and i see validation msg in green color
    And  I should check user get mail or not and verify mail content


  @c30
  Scenario Outline: verify VAN details tab when user already generated VAN number
    When  I click on add contact link
    And I click on contact following links "Manage Contacts"
    And I click on filter
    And I enter "<Company code>" in the search field
    And I click on view if alreday van generated
    Then I should see NEFT/RTGS Payment Details window and request details
    Examples:
      | Company code |
      | 0013         |
#      | 735607       |

#  @c31
#  Scenario: verify VAN details tab when user already generated VAN and click on delete
#    When  I click on add contact link
#    And I click on contact following links "Add Contact"
#    And I enter valid data and click on check box
#      | E-mail | Company Name | First Name | Last Name | Nick Name | Mobile Number | Reference number | Company Address | Bank Account Number | IFSC Code   | GSTIN           | Notification Emails |
#      | vipul  | S            | A          | B         | am        | 9870697982    | 1                | N               | 6589545685656       | icic0000546 | 29AAACB5343E2ZW | vipul               |
#    And I click on Add contact save button
#    Then I should see "Contact saved successfully." msg and i should land on manage contact
#    And I click on filter and enter Reference code
#    Then I click on Generate VAN and i see validation msg in green color
##    And  I should check user get mail or not and verify mail content
##    When  I click on add contact link
##    And I click on contact following links "Manage Contacts"
##    And I click on delete icon
#    And I click on delete icon in Van details tab
#    Then I see confirm pop is opened and i click on confirm button
#    And I see validation in green color
#    And I see status is deleted and action parameter is empty
#
#  @c32
#  Scenario: verify VAN details tab when user already generated VAN and click on deactivate this send
#    When  I click on add contact link
#    And I click on contact following links "Add Contact"
#    And I enter valid data and click on check box
#      | E-mail | Company Name | First Name | Last Name | Nick Name | Mobile Number | Reference number | Company Address | Bank Account Number | IFSC Code   | GSTIN           | Notification Emails |
#      | vipul  | S            | A          | B         | am        | 9870697982    | 1                | N               | 6589545685656       | icic0000546 | 29AAACB5343E2ZW | vipul               |
#    And I click on Add contact save button
#    Then I should see "Contact saved successfully." msg and i should land on manage contact
#    And I click on filter and enter Reference code
#    Then I click on Generate VAN and i see validation msg in green color
#    And I click in deactive icon in Van details tab
##    And I click on deactive icon
#    Then I see pop is opened and i click on confirm button
#    And I see proper validation msg
#    And I see status is deactivate
#    And I see activate this send and delete this sender actions
#
#  @c33
#  Scenario: verify VAN details tab when van is deactivate and user click on active lin
#    When  I click on add contact link
#    And I click on contact following links "Manage Contacts"
#    And I click on active icon
#    Then I see active pop is opened and i click on confirm button
#    And I see validation msg
#
#  @c34
#  Scenario: verify VAN details tab when user click on resend account details
#    When  I click on add contact link
#    And I click on contact following links "Manage Contacts"
#    And I click on resend account details icon
#    Then I see proper validation mmessage
#    And I should check user get mail or not

  @vandetails
  Scenario: Add new contact and perform various tasks in Van Details tab
    When  I click on add contact link
    And I click on contact following links "Add Contact"
    And I enter valid data and click on check box
      | E-mail | Company Name | First Name | Last Name | Nick Name | Mobile Number | Reference number | Company Address | Bank Account Number | IFSC Code   | GSTIN           | Notification Emails |
      | vipuls | S            | A          | B         | am        | 9870697982    | 0002             | N               | 6589545685656       | icic0000546 | 29AAACB5343E2ZW | vipul               |
    And I click on Add contact save button
    Then I should see "Contact saved successfully." msg and i should land on manage contact
    And I perform the following tasks in Van Details tab
      | Generate Van           |
      | Deactive Van           |
      | Active Van             |
      | Resend Account Details |
      | Delete Sender          |


  @c35
  Scenario: verify received  details tab when user click on received  details tab
    When  I click on add contact link
    And I click on contact following links "Manage Contacts"
    And I click on received details tab
    Then  I see following fields in received detailed tab
      | Xpress ID | Account No. | IFS Code | Status | Actions |

  @c36
  Scenario: verify received details data if user already entered  data
    When  I click on add contact link
    And I click on contact following links "Manage Contacts"
    And I click on edit button and checked data

  @c37
  Scenario: verify received details tab when  user click on deactive
    When  I click on add contact link
    And I click on contact following links "Manage Contacts"
    And I click on request received deactive icon
    Then I should see deactive pop confirmation
    And I click on confirm button and I should see validation msg
    And I check fields are in read only from and status is deactive

  @c38
  Scenario: Verify received details tab when status is decative and user click on active
    When  I click on add contact link
    And I click on contact following links "Manage Contacts"
    And I check status is deactive and i click on active icon
    Then I should see active pop confirmation
    And I click on confirm and i should see validation msg
    And I check status is active

  @c39
  Scenario: Verify received details tab when user click on edit
    When  I click on add contact link
    And I click on contact following links "Manage Contacts"
    And I click on edit button from receiver details tab
    Then I see account number and IFSC fiels is editable and save button should be display
    And I update account number and ifsc code
    And I click on save button from receiver details
    Then I should see validation message
    And I check updated data


  @c40
  Scenario: Verify received details tab when user enter invalid account number and ifsc codce
    When  I click on add contact link
    And I click on contact following links "Manage Contacts"
    And I click on edit button from receiver details tab
    And I enter invalid account number and ifsc code
      | Ac NO        | IFSC code    |
      | @@@@@@@@@@@@ | ifsc         |
      | 45645@@####  | 56545        |
      |              | icic00040546 |
      |              |              |
    Then I should see validation msg for each filed


