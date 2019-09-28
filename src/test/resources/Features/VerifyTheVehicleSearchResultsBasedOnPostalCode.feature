Feature: Search the vehicle based on Postal code and model type
  Descrition : Verify the search results
  based on the potsal code type
  Selects the first model from results
  view the details

  @FunctionaFlow
  Scenario Outline: Vehicle search based on the Postal code and verify the results for postal code: <Postal Code> and type: <Model>
    Given successfully open Ebay motors application
      | Title                                              | Heading                    |
      | Motors.co.uk - buy and sell new & used cars safely | Find the right car for you |
    When enter the postal code as <Postal Code> and select the vehicle company as <company>
    Then user should be present with search cars results page with url search/car/
    Then Get the results page count and print the results page count
    When apply a model filter as <Model>
    Then Get the results page count and print the results page count
    When select to see full details of first result
    Then output vehicle title and variant
    And verify the model as <Model>
    And print vehicle distance from postcode as <Postal Code>

    Examples:
      | Postal Code | company | Model  |
      | OX144RY     | Ford    | Galaxy |