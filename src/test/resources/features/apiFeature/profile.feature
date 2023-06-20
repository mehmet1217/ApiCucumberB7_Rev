Feature: Retrieving All Profiles

  Scenario: The User able to see all profiles
    Given The user sends a GET request and able to see all profiles
    Then Verify that status code is 200


  Scenario: GET Request with Path Parameter
    Given The user sends GET request with id 36
    Then Verify that status code is 200
    And Verify that user's info name is "Anderson Talisca" and company is "Al-Hilal" and location is "Riyad"

  Scenario Outline: Get Request One User and Verify All Informations
    Given The user sends GET request with id <id>
    Then Verify that status code is 200
    And Verify that user's info name is "<name>" and company is "<company>" and location is "<location>"
    Examples:
      | id | name | company   | location |
      | 34 | Blg  | Amazon    | Dortmund |
      | 29 | oyku | Microsoft | Germany  |

