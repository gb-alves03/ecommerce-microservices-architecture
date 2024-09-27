# E-commerce Microservices Architecture
E-commerce Back-end application based in Microservices and Events-Driven Architectures with Java, Spring and AWS.

## Used Technologies
[![Used Technologies](https://skillicons.dev/icons?i=java,spring,maven,docker,postgres,mongodb,aws)](https://skillicons.dev)
> Java 17 <br>
> Spring Boot (Data JPA and Security) <br>
> Spring Cloud Gateway <br>
> AWS SQS <br>
> AWS SNS <br>
> Docker <br>
> Flyway Migrations

## Microservices Implemented
* Authentication Service (Responsible for users authentication and authorization) <br>
* Products Service (Responsible for products storage and rotation management) <br>
* Order Service (Responsible for managing orders and informing other microservices of the status of orders) <br>
* Payment Service (Responsible for orders payment)
* Notification Service (Responsible to send messages and e-mails to user about theirs orders status)
