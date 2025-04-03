Feature: Submit web form

  Scenario: Fill and submit form
    Given User launches the web form
    When User fills out the form
    And User submits the form
    Then Form should be submitted successfully
