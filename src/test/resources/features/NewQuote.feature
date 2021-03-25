Feature: Home Insurance quote
  As a customer
  In order to get policy quotes
  I fill the policy quote details page

Background: User navigates to home page
  Given I go to the homepage

@test
Scenario: Validate user is allowed to fill details fields
  Given I fill the AboutMe section with
      |mr                     |
      |John                   |
      |Doe                    |
      |14                     |
      |7                      |
      |1990                   |
      |single                 |
      |Pilot                  |
      |No                     |
      |07838793939            |
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
    |EC2N 4AY                        |
    |110                             |
    |Bishopsgate                     |
    |London                          |
    |EC2N 4AY                        |
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
  |100000|
  |0     |
  |no    |
  |200   |
  When I compare quotes
  Then I should be on the quote listings page
  And I close the browser
