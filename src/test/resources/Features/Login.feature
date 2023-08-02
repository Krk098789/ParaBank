@Cyclos
Feature: Login Functionality of Cyclos

  Scenario Outline: With valid credentials user should loged in
    Given Launch the browser
    When Provide Username and Password
    And Click on submit Button
    Then user is going to verify "<Text>"

    Examples: 
      | Text    |
      | Banking |

  Scenario Outline: User should not loged in with invalid credentils
    Given Launch the browser
    When Provide invalid username and password
    And Click on submit Button
    Then user move to page by "<ErrorMsg>"

    Examples: 
      | ErrorMsg                                                    |
      | The given name / password are incorrect. Please, try again. |
