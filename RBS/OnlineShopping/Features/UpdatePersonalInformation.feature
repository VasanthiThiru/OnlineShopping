Feature: Pesonal Information

  @Sanity
  Scenario Outline: Update Personal Information
    Given User login to the application with Valid Credentials
    When User click on my personal info link
    And User Update FirstName "<FirstName>" and CurrentPassword
    And User click on Save button
    Then User should see the update confirmation message "Your personal information has been successfully updated."

    Examples: 
      | FirstName |
      | Vasanthi  |
