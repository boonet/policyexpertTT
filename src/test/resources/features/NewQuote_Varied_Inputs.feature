@skipit
Feature: Home Insurance quote - multiple inputs
  As a customer
  In order to get policy quotes
  I fill the policy quote details page

  Background: User navigates to quotes entry page
    Given I go to the homepage

  Scenario Outline: Validate user is allowed to fill details fields with varied inputs
    Given I fill the AboutMe section with
      |mr                     |
      |<Firstname>            |
      |<LastName>             |
      |14                     |
      |7                      |
      |1990                   |
      |single                 |
      |Pilot                  |
      |No                     |
      |<mobile>               |
      |vketipisz@qmetric.co.uk|
    And I "Disagree" to statements about me
    And I fill all the statements after disagreement as
      |agree    |
      |agree    |
      |agree    |
      |disagree |
      |disagree |
      |Disagree |
    And I fill all the address related fields as
      |<postcode>                        |
      |110                             |
      |Bishopsgate                     |
      |London                          |
      |<postcode>                        |
      |Yes                             |
      |house                           |
      |semi_detached                   |
      |2005                            |
      |1                               |
      |rented_furnished                |
      |you_and_others_shared_property  |
      |occupied_during_day             |
      |Yes                             |
      |No                              |
    And I "Agree" to statements about my property
    And I fill all the safety details of the property as
      |yes|
      |no|
      |no|
      |no|
      |no|
    And I choose No for joint policy holder
    And my insurance is held for "less_than_a_year"
    And claims made earlier is a "No"
    And policy should start "Today"
    And my policy requirements for "buildings" are as
      |<building_cost>|
      |<rebuilding_cost>|
      |no    |
      |200   |
    When I compare quotes
    Then I should be on the quote listings page



    Examples: Inputs changed for aboutme section
    |Firstname                          |LastName               |mobile            |postcode |building_cost          |rebuilding_cost        |
    | Supercalifragilisticexpialidocious|Longestnameever        |098765456789      |EC2N 4AY |100000                 |0                      |
