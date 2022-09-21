@vcj
Feature: Basic search feature

    Scenario: Search from homepage
    Given User is on VLM page
    Then search for veteran in search bar
    And user clicks on search bar
    Then scroll down and select veteran
