Feature: Place API varildation

Scenario: validate user add new place on the serve

Given User create a payload
When ser send Post request
Then User validate success status code
And Validate response By resonse body

