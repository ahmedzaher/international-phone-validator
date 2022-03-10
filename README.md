# International Phone Validator
## Overview
Internation Phone Validator is a simple web application used to list international phones categorized and eligible to be filtered.
## Technologies
* Springboot
* Thymleaf
* Sqlite Database
* Maven
* Docker
## How to build
* `mvn clean package`
* `docker build -t com.example/international-phone-validator .`
## How to run
`docker run -p 8080:8080 com.example/international-phone-validator
`

can be accessed now on `http://localhost:8080/customers/phones`
