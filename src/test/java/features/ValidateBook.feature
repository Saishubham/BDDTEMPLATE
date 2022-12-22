Feature: Validate Book API's
Scenario Outline: Verify if Book is being added Successfully
	Given Add PayLoad "<id>" "<title>" "<description>" "<pageCount>" "<excerpt>" "<publishDate>"
	When user calls "AddBook" with "POST" http request
	Then status in reponse is 200
Examples:
	|id      |  title   |description        |pageCount  |excerpt|publishDate		    |
	|21	     |English   |World cross cente  |222		|abcde  |2022-12-19T11:11:34.191|
	|22	     |Hindi     |World cross centers|223		|abcde  |2022-12-20T11:11:34.191|
	
Scenario Outline: verify if Book is being updated Successfully
	Given Add PayLoad "<id>" "<title>" "<description>" "<pageCount>" "<excerpt>" "<publishDate>"
	When user calls "UpdateBook" with "PUT" http request
	Then status in reponse is 200
Examples:
	|id      |  title   |description        |pageCount  |excerpt|publishDate		    |
	|21	     |English   |World cross cente  |222		|abcde  |2022-12-19T11:11:34.191|
Scenario Outline: verify if Book is being Deleted Successfully
	Given pass path  with "<id>"
	When user calls "DeleteBook" with "Delete" http request
	Then status in reponse is 200
Examples:
	|id      | 		    
	|21	     |