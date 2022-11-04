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
  @Latihan
  Scenario Outline: Put update user with json
    Given Put update user with valid json with <id>
    When Send put update user
    Then Status code should be 200 OK
    And Response body should contain name "Fattah Update" and job "QA Engineer"
    Examples:
      | id |
      | 1  |
      | 2  |
  @Latihan
  Scenario Outline: Delete user with valid id
    Given Delete user with id <id>
    When Send delete user request
    Then Status code should be 204 No Content
    Examples:
      | id |
      | 2  |

  @Tugas
  Scenario: Login user with valid id
    Given Post login user with valid json
    When Send post login user request
    Then Status code should be 200 OK
    And Response body should contain "QpwL5tke4Pnpja7X4" as token
    And Validate login user with json shcema
  @Tugas
  Scenario: Login invalid user
    Given Post login invalid user with valid json
    When Send post login invalid user request
    Then Status code shold be 400 ERROR
    And Response body page should be contain "Missing password"
    And Validate invalid login user with json shcema
   @Tugas
   Scenario Outline: Register valid user
     Given post regist valid user with valid json
     When send post regist valid user request
     Then Status code should be 200 OK
     And Response body page should be id <id> and token "QpwL5tke4Pnpja7X4"
     And Validate register user with json shcema
     Examples:
       | id |
       | 4  |

   @Tugas
   Scenario: Register invalid user
     Given post regist invalid user with valid json
     When send post regist invalid user request
     Then Status code shold be 400 ERROR
     And Response body page should be error "Missing password"
     And Validate register invalid user with json schema

   @Tugas
   Scenario:



