@BookHotel
Feature: Verifying adactinhotel bookhotel details

  Background: 
    Given User should launch browser and pass adactinhotel page

  @BookHotel1
  Scenario Outline: Verifying bookhotel page with valid credentials
    When User should perform login  "<Username>" , "<Password>"
    And User should verify after login successfully  "Hello Alex2727!"
    And User should search hotel "<Location>","<Hotels>","<RoomType>","<NumberofRooms>","<CheckInDate>","<CheckOutDate>","<AdultsPerRoom>"and"<ChildrenPerRoom>"
    And User should verify after search hotel "Select Hotel"
    And User should select a hotel
    And User should verify after select hotel "Book A Hotel"
    And User should book hotel by passing "<FirstName>","<LastName>"and"<BillingAddress>"
      | Credit Card No   | Credit Card Type | Expiry Month | Expiry Year | CVV Number |
      | 2587412585698569 | American Express | December     |        2022 |       8585 |
      | 2587412585698561 | VISA             | November     |        2022 |       7585 |
      | 2587412585698567 | Master Card      | July         |        2022 |       5696 |
      | 2587412585698562 | Other            | April        |        2022 |       5825 |
    Then User should verify after bookhotel "Booking Confirmation"

    Examples: 
      | Username | Password | Location | Hotels      | RoomType | NumberofRooms | CheckInDate | CheckOutDate | AdultsPerRoom | ChildrenPerRoom | FirstName | LastName | BillingAddress |
      | Alex2727 | PXF099   | Paris    | Hotel Creek | Double   | 2 - Two       | 03/07/2022  | 04/07/2022   | 3 - Three     | 1 - One         | Anal      | Kumar    | OMR,Chennai    |

  @BookHotel2
  Scenario Outline: Verifying bookhotel page without credentials
    When User should perform login  "<Username>" , "<Password>"
    And User should verify after login successfully  "Hello Alex2727!"
    And User should search hotel "<Location>","<Hotels>","<RoomType>","<NumberofRooms>","<CheckInDate>","<CheckOutDate>","<AdultsPerRoom>"and"<ChildrenPerRoom>"
    And User should verify after search hotel "Select Hotel"
    And User should select a hotel
    And User should verify after select hotel "Book A Hotel"
    And User should click Book Now without passing any credentials
    Then User should verify error message on book hotel page "Please Enter your First Name","Please Enter you Last Name","Please Enter your Address","Please Enter your 16 Digit Credit Card Number","Please Select your Credit Card Type","Please Select your Credit Card Expiry Month"and"Please Enter your Credit Card CVV Number"

    Examples: 
      | Username | Password | Location | Hotels      | RoomType | NumberofRooms | CheckInDate | CheckOutDate | AdultsPerRoom | ChildrenPerRoom |
      | Alex2727 | PXF099   | Paris    | Hotel Creek | Double   | 2 - Two       | 03/07/2022  | 04/07/2022   | 3 - Three     | 1 - One         |
