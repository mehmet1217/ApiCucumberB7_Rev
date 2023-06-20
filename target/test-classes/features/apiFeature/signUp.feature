Feature: Sign Up

  @wip
  Scenario Outline: DevEx User Register
    Given The user sends a POST request  with "<email>" and "<password>" and "<name>" and "<google>" and "<facebook>" and "<github>"
    Then Verify that status code is 200
    And Verify that body contains "token"
    And Compiler gets the token
    Examples:
      | email                | password | name  | google      | facebook      | github      |
      | klm12@gmail.co | Test1234 | klmn12 | klm_google | klm_facebook | klm_github |
