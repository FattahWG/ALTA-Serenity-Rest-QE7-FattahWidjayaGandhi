Feature: Reqres feature GET

  Scenario Outline: Get list user with valid parameter page
    Given Get list user with parameters page <page>
    When Send Get list user request
    Then Status code should be 200 OK
    And Response body page should be <page>
    Examples:
    | page |
    | 1    |
    | 2    |

  Scenario: Post create users
    Given Post create user with valid json
    When Send post create user request
    Then Status code should be 201 Created
    And Response body should contain name "Fattah" and job "QA Engineer"


  Scenario Outline: Put update user with json
    Given Put update user with valid json with <id>
    When Send put update user
    Then Status code should be 200 OK
    And Response body should contain name "Fattah Update" and job "QA Engineer"
  Examples:
    | id |
    | 1  |
    | 2  |


