Feature: Register Reqres
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