Feature: Reqres feature GET
  @Latihan
  Scenario Outline: Get list user with valid parameter page
    Given Get list user with parameters page <page>
    When Send Get list user request
    Then Status code should be 200 OK
    And Response body page should be <page>
    Examples:
    | page |
    | 1    |
    | 2    |
  @latihan
  Scenario: Post create users
    Given Post create user with valid json
    When Send post create user request
    Then Status code should be 201 Created
    And Response body should contain name "Fattah" and job "QA Engineer"
  @Tugas
  Scenario Outline: Put update user with json
    Given Put update user with valid json with <id>
    When Send put update user
    Then Status code should be 200 OK
    And Response body should contain name "Fattah Update" and job "QA Engineer"
    And Validate put update with json shcema
    Examples:
      | id |
      | 1  |
      | 2  |
  @Tugas
  Scenario Outline: Delete user with valid id
    Given Delete user with id <id>
    When Send delete user request
    Then Status code should be 204 No Content
    Examples:
      | id |
      | 2  |


