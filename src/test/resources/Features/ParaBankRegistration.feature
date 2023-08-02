@ParaBank
Feature: ParaBank Functionality Automate

  Scenario Outline: User Should able to register on Parabank using valid Inputs
    Given User is on the login page
    When User should click on Register
    And User should enter "<FirstName>", "<LastName>", "<Address>", "<City>", "<State>", "<SSN>", "<UserName>", "<Password>" ,"<ConfirmPassword>" and "<ZipCode>"
    And User should click on registeration
    Then User should Verify Success Message "<SuccessMessage>"

    Examples: 
      | FirstName | LastName | Address       | City   | State | SSN   | UserName | Password | ConfirmPassword | ZipCode | SuccessMessage                                                |
      | ABC       | BCD      | 123 main road | Mumbai | MH    | 12345 | ABC123   |   123456 |          123456 |  987654 | Your account was created successfully. You are now logged in. |
