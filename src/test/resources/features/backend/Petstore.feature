Feature:Accessing Pet details and ordering items

 Scenario:
   Given Added a new pet to the store
   And new POST response should be validated against the input
   When a GET request is sent to find the "available" pets
   And a GET request is sent to fetch a particular pet id
   Then a PUT request to update my pet details "Sheriff" and "sold"
   And A Delete request to delete my pet details









