Feature: karate example

  Scenario: Get request to get all bookings
    Given path 'https://restful-booker.herokuapp.com/booking'  
    When method get
    Then status 200
    
   Scenario: Post request to create a booking
    Given url 'https://restful-booker.herokuapp.com/booking'
    And header Content-Type = 'application/json'
    And request  {"firstname": "John", "lastname": "doe","totalprice": 100, "depositpaid": true,"bookingdates": { "checkin": "2024-03-06", "checkout": "2024-03-07" }, "additionalneeds": "Breakfast"}
    When method post
    Then status 201 
    
    Scenario: Put request to update a booking
    Given url 'https://restful-booker.herokuapp.com/booking/1'
    And header Content-Type = 'application/json'
    And request  {"firstname": "Tina", "lastname": "doe","totalprice": 111, "depositpaid": true,"bookingdates": { "checkin": "2024-03-06", "checkout": "2024-03-07" }, "additionalneeds": "Breakfast"}
    When method PUT
    Then status 200
    
    Scenario: Patch request to partially update a booking
    Given url 'https://restful-booker.herokuapp.com/booking/1'
    And request { "totalprice" : 201 }
    When method PATCH
    Then status 200
    
    
    Scenario: Delete request to delete a booking
    Given url 'https://restful-booker.herokuapp.com/booking/1'
    When method DELETE
    Then status 200