Feature: Login reqres

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