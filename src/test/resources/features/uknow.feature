Feature: Unknow feature reqres

  @Tugas
  Scenario Outline: Get unknow list
    Given Get unknow list page <page>
    When Send get unkow list request
    Then Status code should be 200 OK
    And Response body page should be page <page>
    Examples:
      | page |
      | 1    |
      | 2    |

  @Tugas
  Scenario Outline: get single unknow
    Given get unknow page <id>
    When Send get unknow single list
    Then Status code should be 200 OK
    And Response body page should be id <id> and name <name>
    Examples:
      | id | name             |
      | 1  | "cerulean"       |
      | 2  | "fuchsia rose"   |
      | 3  | "true red"       |
      | 4  | "aqua sky"       |
      | 5  | "tigerlily"      |
      | 6  | "blue turquoise" |