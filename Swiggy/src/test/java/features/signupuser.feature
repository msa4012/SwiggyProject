@Search
Feature: Sign up on www.swiggy.com website

  @Sanity
  Scenario: The user needs to signup when he first launches swiggy website
    Given User is already on the swiggy website
    When User clicks on Sign up link
    Then The Sign up page is obtained

  @Sanity
  Scenario Outline: Get the user signed up for the swiggy website
    Given User is on the swiggy website already
    When User provides the "<Phone>" "<name>" "<email>" and "<password>"
    Then User clicks on the Continue button
    Then User is signed up

    Examples: 
      | Phone      | name        | email                | password  |
      | 1111111111 | swiggy user | swiggyuser@gmail.com | 123swiggy |
