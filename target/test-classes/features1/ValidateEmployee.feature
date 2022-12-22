Feature: Validate Employee API's
Scenario Outline: Verify if Employee is being added Successfully
	Given Add "PayLoad" From "Employee" class
	When user calls "CreateEMP" with "POST" http request
	Then status in reponse is 200
	And Validate for "data" from "response"