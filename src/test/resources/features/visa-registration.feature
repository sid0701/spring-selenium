Feature: User Visa Registration Feature

  @visa
  Scenario Outline: I should be able to submit visa form
    Given I am on the Visa Registration Page
    When I enter my "<First Name>" and "<Last Name>"
    And I select my from country "<From Country>" and to country "<To Country>"
    And I enter my date of birth "<Date Of Birth>"
    And I enter my email id "<Email Id>"
    And I enter my mobile no "<Mobile No>"
    And I enter comments "<Comments>"
    And I submit the form
    Then I should get a Registration Number
    Examples:
      | First Name | Last Name | From Country     | To Country                  | Date Of Birth | Email Id           | Mobile No      | Comments  |
      | Kraig      | Wiza      | Isle of Man      | Mali                        | 2011-05-31    | Kraig@nobody.com   | 1-000-884-1373 | Comment 1 |
      | Houston    | Kertzmann | Lithuania        | Mexico                      | 2001-01-01    | Houston@nobody.com | 284.864.6580   |           |
      | Ruthie     | Stamm     | Somalia          | Greece                      | 2004-07-02    | Ruthie@nobody.com  | 1-209-813-9712 | Comment 3 |
      | Shonna     | Nolan     | Christmas Island | French Southern Territories | 2019-04-05    | Shonna@nobody.com  | (162) 387-0305 |           |


