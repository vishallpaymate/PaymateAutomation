@RequestPayment
Feature: I want to use this feature file request Payment

  Background: Login with valid data
    When User navigates to paymate url
    And I will enter valid user name as "lvishal@yopmail.com"
    And I enter valid password as "Paymate@123"
#    And I enter valid user name as "ant@yopmail.com"
#    And I enter valid password as "Paymate@123"
    And I click on login button

  @req
  Scenario: Verify collect payment when user click on sales
    When I click on Sales
    Then I see following options
      | Menus options            |
      | Collect Payment          |
      | Track Collections        |
      | Purchase Orders Received |


  @req0
  Scenario Outline: Verify collect payment when user click on sales
    When I click on Sales
    And I click on following "<Links>"
    Then I should be land on particular page
    Examples:
      | Links                    |
      | Collect Payment          |
      | Track Collections        |
      | Purchase Orders Received |

  @req1
  Scenario: Verify collect payment page when user click on collection payment links
    When I click on Sales
    And I click on following "Collect Payment"
    Then I see all fields and labels

  @req2
  Scenario:  Verify collect payment page when user click on continue button without data
    When I click on Sales
    And I click on following "Collect Payment"
    When I click on continue button from collect payment page
    Then I see proper validation msg for mandatory fields in red color

  @req3
  Scenario: Verify collect payment page when user enter only mandatory fields and click on Book another button
    #enter register business contact
    When I click on Sales
    And I click on following "Collect Payment"
    And I  select contact name and  enter valid amount
      | Amount | Contact             | reference code | currency |
#      | 100    | ihokrgaxx.LTD       | 372375         | INR      |
#      | 200    | uadhoc user | 789            | INR      |
#      | 300    | vendors     | 456            | INR      |
      | 2350   | Hyatt and Sons .LTD | 735607         | INR      |
    And I check booked transactions tab
    Then I should see book transactions
    And I click on select all radio button
    And I click on send request button
    Then I see validation msg in green color
    And I should redirect on track collections page
    #And I verify track collection request and status
#    And I checked contact got mail or not
#    And I opened mail and Login and make payment/Register and make payment/quick pay
#    And I select transactions and click on submit button and i redirect on pending approval screen

  @req4
  Scenario: verify booked transactions screen when user clicked
    When I click on Sales
    And I click on following "Collect Payment"
    And I click on booked transactions tab
    Then I see respective fields
    And I see transaction if there is any booked transaction other wise "You have no transactions" msg should be display


  @req5
  Scenario: Verify collect payment page when user enter only mandatory fields and click on Continue button(b2b)
    When I click on Sales
    And I click on following "Collect Payment"
    And I enter following data and click on continue button
      | contact             | Amount  | reference code | currency | Gst Type | Gst Rate | Net Terms | Invoice date | Attached Invoice file | Invoice number | Remarks | MDR customer charges |
#      | ihokrgaxx.LTD | 3500.00 | 372375         | INR      |          |          |           |              |                       |                |         |                      |
      | Hyatt and Sons .LTD | 3500.00 | 735607         | INR      |          |          |           |              |                       |                |         |                      |

    Then I see booked transaction tab is expanded
    And I click on select all radio button
    And I click on send request button
    Then I see validation msg in green color
    And I should redirect on track collections page
    Then I check user mail and click on login link
    And I redirect on request received page
    And I redirect on payment report page
    And I check transaction report
    And I check collection report of request business
    And I settle amount from PMX admin
    And I check collection report and payment report
    And I select discount "<Type of discount>" and "<Discount type>" and "<Discount amt>"
    And I calculate payable amount
    And I redirect on pending approval screen
    And I approve transaction and i redirect on top up account page
    And I check transaction report
    And I check collection report of request business
    And I settle amount from PMX admin

  @req6
  Scenario Outline: Verify collect payment page when user enter All fields and click on Continue button(b2b)
    When I click on Sales
    And I click on following "Collect Payment"
    And I enter following data and click on continue button
      | contact             | Amount  | reference code | currency | Gst Type | Gst Rate | Net Terms | Invoice date | Attached Invoice file                                       | Invoice number | Remarks      | MDR customer charges |
#      | shopper stop        | 3500.00 | 1234           | INR      | IGST     | 12       | 15        | 19/Aug/2019  | C:\\Users\\vijay\\Pictures\\Screenshots\\Screenshot (2).png | 4567           | test payment | 1                    |
      | Hyatt and Sons .LTD | 3500.00 | 735607         | INR      | IGST     | 12       | 15        | 19/Aug/2019  | C:\\Users\\vijay\\Pictures\\Screenshots\\Screenshot (2).png | 4567           | test payment | 1                    |
    Then I see booked transaction tab is expanded
    And I click on select all radio button
    And I click on send request button
    Then I see validation msg in green color
    And I should redirect on track collections page
    Then I check user mail and click on login link
    And I redirect on request received page
    And I select discount "<Type of discount>" and "<Discount type>" and "<Discount amt>"
    And I redirect on pending approval screen
    And I approve transaction and i redirect on top up account page
    And I check transaction report
    And I check collection report of request business
    And I settle amount from PMX admin
    And I check collection report and payment report
    Examples:
      | Type of discount     | Discount type | Discount amt |
      | Apply Fixed Discount | Fixed         | 500          |
      | Apply Fixed Discount | Percentage    | 3            |
      | Apply discount       |               |              |

  @req7
  Scenario: Verify collection payment page when user enter only mandatory fields and click on Continue button(b2register contact)
    When I click on Sales
    And I click on following "Collect Payment"
    And I enter following data and click on continue button
      | Company Name  | Payable Amount | Reference code | Currency | Gst Type | Gst Rate | Net Terms | Invoice date | Attached Invoice file                                                         | Invoice number | Remarks          | MDR customer charges |
      | acerr pvt ltd | 3500.00        | 372375         | INR      | IGST     | 12       | 15        | 14/Feb/2021  | E:\Office\PaymateAutomation\PaymateAutomation\InvalidFiles\Screenshot (1).png | 4567           | test transaction | 1                    |
    Then I see booked transaction tab is expanded
    Then I check booked details in Booked transaction tab
    And I click on select all radio button
    And I click on send request button
    Then I see validation msg in green color
    And I should redirect on track collections page
    Then I should check mail and click on login link
    And I get redirected to request received page and I verify transaction details
    And I click on Accept Request icon in action column to approve transaction
    And I redirect on top up account page
    And I check transaction payment report of register contact
    And I check collection report of request business
    And I settle amount from PMX admin
    And I check collection report and payment report
    And I check payment reports


  @req8
  Scenario: Verify collection payment page when user enters only mandatory fields and click on Continue button(b2register contact)
    And I check collection report and payment reports
#      | Company Name  | Reference Code | Payable Amount | Currency |
#      | ihokrgaxx.LTD | 372375         | 3920.00        | INR      |
    And I settle amount from PMX admin

  @req9
  Scenario: Upload a Bulk Payment Request File
    When I click on Sales
    And I click on following "Collect Payment"
    And I verify different tabs are present on the collect payment page
      | UPLOAD A BULK PAYMENT REQUEST FILE |
      | REQUEST A PAYMENT                  |
      | BOOKED TRANSACTIONS                |
    And I click on Upload Bulk Payment Request File tab
    And I verify all fields are present in Bulk Payment tab
    And I upload a file for Bulk Payment Request in upload field
#      | ReferenceCode | EmailID                 | Amount | GSTType | GSTRate | NetTerm | InvoiceDate | InvoiceNumber | Currency | Remarks          |
      | 372375 | vipul5y3@mailinator.com | 3300 | IGST | 12 | 15 | 16/02/2020 | 455 | INR | test transaction |
    And I click on continue button and check data in Booked transactions tab

