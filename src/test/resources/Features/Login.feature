Feature: Login functionality for registered user for saucedemo.com

  @Test
  Scenario Outline: User can login with valid credentials
    Given user is on login page
    When user enters <username1> and <password1>
    And clicks on login button
    Then products listing page is displayed

    Examples:
      | username1      | password1    |
      | standard_user | secret_sauce |

    @Test
  Scenario Outline: User can’t login with invalid credentials
    Given user is on login page
    When user enters invalid <username1> and <password1>
    And clicks on login button
    Then error is displayed

    Examples:
      | username1       | password1    |
      | locked_out_user | secret_sauce |
      | made_up_user    | secret_sauce |


