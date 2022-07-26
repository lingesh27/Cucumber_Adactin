@Select
Feature: Verifying adactinhotel selecthotel details

  Background: 
    Given User should launch browser and pass adactinhotel page

  @Select1
  Scenario Outline: Verifying selecthotel page by selecting a hotel
    When User should perform login  "<Username>" , "<Password>"
    And User should verify after login successfully  "Hello Alex2727!"
    And User should search hotel "<Location>","<Hotels>","<RoomType>","<NumberofRooms>","<CheckInDate>","<CheckOutDate>","<AdultsPerRoom>"and"<ChildrenPerRoom>"
    And User should verify after search hotel "Select Hotel"
    When User should select a hotel
    Then User should verify after select hotel "Book A Hotel"

    Examples: 
      | Username | Password | Location | Hotels      | RoomType     | NumberofRooms | CheckInDate | CheckOutDate | AdultsPerRoom | ChildrenPerRoom |
      | Alex2727 | PXF099   | Paris    | Hotel Creek | Super Deluxe | 4 - Four      | 03/07/2022  | 04/07/2022   | 3 - Three     | 1 - One         |

  @Select2
  Scenario Outline: Verifying selecthotel page by without selecting any hotel
    When User should perform login  "<Username>" , "<Password>"
    And User should verify after login successfully  "Hello Alex2727!"
    And User should search hotel "<Location>","<Hotels>","<RoomType>","<NumberofRooms>","<CheckInDate>","<CheckOutDate>","<AdultsPerRoom>"and"<ChildrenPerRoom>"
    And User should verify after search hotel "Select Hotel"
    And User should click Continue without selecting any hotel
    Then User should verify error message on select hotel page "Please Select a Hotel"

    Examples: 
      | Username | Password | Location | Hotels      | RoomType     | NumberofRooms | CheckInDate | CheckOutDate | AdultsPerRoom | ChildrenPerRoom |
      | Alex2727 | PXF099   | Paris    | Hotel Creek | Super Deluxe | 4 - Four      | 03/07/2022  | 04/07/2022   | 3 - Three     | 1 - One         |
