@Login
Feature: Verifying adactinhotel login details

  Background: 
    Given User should launch browser and pass adactinhotel page

  @Login1
  Scenario Outline: Verifying adactinhotel with valid credentials
    When User should perform login  "<username>" , "<password>"
    Then User should verify after login successfully  "Hello Alex2727!"

    Examples: 
      | username | password |
      | Alex2727 | PXF099   |

  @Login2
  Scenario Outline: Verifying adactinhotel with valid credentials using Enter Key
    When User should perform login using "<username>" , "<password>" and press Enter Key
    Then User should verify after login successfully  "Hello Alex2727!"

    Examples: 
      | username | password |
      | Alex2727 | PXF099   |

  @Login3
  Scenario Outline: Verifying adactinhotel with invalid credentials
    When User should perform login  "<username>" , "<password>"
    Then User should verify error message contains "Invalid Login details or Your Password might have expired"

    Examples: 
      | username | password |
      | Alex2727 | P4RG254  |
