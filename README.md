# AirportSystem
This repositrory holds code of Spring application which calculates data related to managing the airport system
---

This application impelements two main functionalities. It allows users to add Cargo & Flight data to database and retrieve summary objects from endpoints.
API documentation is available in runtime under: http://localhost:8080/swagger-ui

This application is a solution to the task, which is the part of recruitment process. I implemented two requested functionalities.

---
> 1. For requested Flight Number and date will respond with following  
> a. Cargo Weight for requested Flight  
> b. Baggage Weight for requested Flight  
> c. Total Weight for requested Flight  

Documentation will show more complicated model - weight is presented in lbs and kgs.

---
Again for requested functionaliy of:

> 2. For requested IATA Airport Code and date will respond with following :  
> a. Number of flights departing from this airport,  
> b. Number of flights arriving to this airport,  
> c. Total number (pieces) of baggage arriving to this airport,  
> d. Total number (pieces) of baggage departing from this airport.  

In documentation you can see DTO with appriopriate fields.

---
Last but not least - testing.
In documentation there are two tests available - one if server is responding, second performs all tests.
