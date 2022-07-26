@Search
Feature: Verifying adactinhotel searchhotel details

  Background: 

  @Search1
  Scenario Outline: Verifying serachhotel page with all valid credentials
    Given User should launch browser and pass adactinhotel page
    When User should perform login  "<Username>" , "<Password>"
    And User should verify after login successfully  "Hello Alex2727!"
    And User should search hotel "<Location>","<Hotels>","<RoomType>","<NumberofRooms>","<CheckInDate>","<CheckOutDate>","<AdultsPerRoom>"and"<ChildrenPerRoom>"
    Then User should verify after search hotel "Select Hotel"

    Examples: 
      | Username | Password | Location | Hotels      | RoomType | NumberofRooms | CheckInDate | CheckOutDate | AdultsPerRoom | ChildrenPerRoom |
      | Alex2727 | PXF099   | Paris    | Hotel Creek | Double   | 2 - Two       | 03/07/2022  | 04/07/2022   | 3 - Three     | 1 - One         |

  @Search2
  Scenario Outline: Verifying searchhotel page by passing only mandatory credentials
    Given User should launch browser and pass adactinhotel page
    When User should perform login  "<Username>" , "<Password>"
    And User should verify after login successfully  "Hello Alex2727!"
    And User should search hotel by passing "<Location>","<NumberofRooms>","<CheckInDate>","<CheckOutDate>"and"<AdultsPerRoom>"
    Then User should verify after search hotel "Select Hotel"

    Examples: 
      | Username | Password | Location | NumberofRooms | CheckInDate | CheckOutDate | AdultsPerRoom |
      | Alex2727 | PXF099   | Paris    | 2 - Two       | 03/07/2022  | 04/07/2022   | 3 - Three     |

  @Search3
  Scenario Outline: Verifying searchhotel page with credentials
    Given User should launch browser and pass adactinhotel page
    When User should perform login  "<Username>" , "<Password>"
    And User should verify after login successfully  "Hello Alex2727!"
    And User should search hotel "<Location>","<Hotels>","<RoomType>","<NumberofRooms>","<CheckInDate>","<CheckOutDate>","<AdultsPerRoom>"and"<ChildrenPerRoom>"
    Then User should verify error message after search "Check-In Date shall be before than Check-Out Date","Check-Out Date shall be after than Check-In Date"

    Examples: 
      | Username | Password | Location | Hotels      | RoomType | NumberofRooms | CheckInDate | CheckOutDate | AdultsPerRoom | ChildrenPerRoom |
      | Alex2727 | PXF099   | Paris    | Hotel Creek | Double   | 2 - Two       | 03/07/2023  | 04/07/2022   | 3 - Three     | 1 - One         |

  @Search4
  Scenario Outline: Verifying searchhotel page without any credentials
    Given User should launch browser and pass adactinhotel page
    When User should perform login  "<Username>" , "<Password>"
    And User should verify after login successfully  "Hello Alex2727!"
    When User should perform search hotel without entering any fields
    Then User should click search and verify message after login "Please Select a Location"

    Examples: 
      | Username | Password |
      | Alex2727 | PXF099   |
