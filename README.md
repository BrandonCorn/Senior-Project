# Puppy Notification Center

    The Puppy Notification Center is a Java project using Spring, Gradle, and the Twilio Notify API. The goal of the application is to supply endpoints for sending appointment reminders and mass marketing messages for clients of dog boarding, grooming, and daycare facilities.  

## Why do we need this? 
    The Puppy Notification Center is a useful tool to those dog service businesses who are still making phone calls to remind clients of appointments and only use social media as a means of communicating mass messages they want to reach all clients with. By making use of this API, sending out those appointment reminders with custom messages and mass marketing messages to current clients can be much less time consuming and more certain to reach a larger number of people since we all rarely go without our phones. 

## Getting Started 
    In order to get started with the Puppy Notification Center users must have Java 11 downloaded on their machines. The development environment used for this build was IntelliJ. After pulling the code, developers must also create a Twilio Developer account at *https://www.twilio.com/try-twilio* to make use of the APIs. Free trial accounts are available with credits that allow users to make use of sending out mass SMS notifications and individiual SMS messages. 

### Setting up environment 
There are configuration values that the project will require you to provide in order to get started. You will need to create an *application.properties* within the */main/resources* directory of the project. The values you will need to provide include 
```
server.error.include-message=always
spring.datasource.driver-class-name=
spring.datasource.url=
spring.datasource.username=
spring.datasource.password=
spring.datasource.jdbcUrl=
twilio.account-sid=
twilio.auth-token=
twilio.phone-number=
```

## Limitations
When using the Twilio API, if you only sign up for a free trial account, the API will only be able to send SMS messages to verified phone numbers. In order to expand the functionality of the API, developers will need to create accounts with more flexibility and control of the Twilio APIs use. 

