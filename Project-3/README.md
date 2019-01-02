# Staging Management System
The Staging Management System allows managers to keep track of Revature associates who have completed training and are awaiting a job assignment. The application is particularly useful in managing associates who are in virtual staging. The system allows associates to check in daily and provide an update to the staging manager which can then be easily viewed to keep track of what associates are currently working on.
<br/>
[Checkin Microservice](https://github.com/SMS-Staging-Management-System/CheckInService)
<br/>
[User Microservice](https://github.com/SMS-Staging-Management-System/UserService)
# Technologies
<b>Client Side:</b> HTML, CSS, REACT, Redux, ReactStrap, TypeScript, Axios
<br/>
<b>Server Side:</b> Java, SQL, Spring MVC/Boot/Data/AOP, Hibernate, JWT, AWS, Hystrix, Zuul, Eureka, FeignClient

 # Roles and Responsibilities
* Created User, Roles, and Cohort models 
* Setp the multiplicity relationship between User and cohort by using Hibernate
* Linked java models to SQL tables using Hibernate
* Created User and Cohort spring bean controllers to map request to respective service
* Created User and Cohort spring bean Services to handle to request
* Created User and Cohort spring bean repository to query SQL database 
* Made DTO for user model in order to create a user by given information sent from client
