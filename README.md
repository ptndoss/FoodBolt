# CMPE-282 Final Project - FoodBolt (Team Spartans)
Repo for the CMPE-282 Final Project

## Overview

   Dining-out in our favorite restaurant with our beloved ones is one of the main recreations for many people. In order to spend some quality time with our family, friends or business partners during dining, it is necessary to be sure about the slot at the restaurant for the number of people to dine in. There are very minimal online services which offer table booking for multiple restaurants around the locality. Food Bolt application is a table reservation platform which provides seamless access for both users and restaurant owners to reserve tables. 

  

  One-Click IoT device enhances the user experience in table reservation which gives an edge over our competitors. With extensive use of cloud resource, we have optimized the cost of development and operation without compromising the quality of reservation service. With the optimized cost, we are bringing the IoT device to customers at free of cost and enhancing added value to our service.


**ARCHITECTURE DIAGRAM**

![arc1](https://user-images.githubusercontent.com/42689991/57660966-c1029d00-759d-11e9-9b77-bb6aea731e4e.png)


![arc2](https://user-images.githubusercontent.com/42689991/57660967-c19b3380-759d-11e9-9426-50b2a44d1c7d.png)


**TECHNOLOGIES USED**

1. FrontEnd 

    - HTML  
    - JavaScript  
    - CSS  
    - BootStrap 
    - Thymeleaf 

2. Backend

    - Java 
    - Spring Boot Framework 

3. Database

    - RDS (MySQL) - Used as the DB for the application for storing the major data. 

4. AWS Resources

    - Route53 - DNS to resolves the IP address for the application domain. 
    - ELB - Elastic Load Balancer is used to handle the load and route it to different EC2 instances. 
    - EC2 - For hosting the Web and Application server. 
    - Auto Scaling - Used to support the highly available and scalable web application. 
    - Lambda - Used the lambda function for handling the IOT 1-click button and sending the notification to the user for booking confirmation. Also to upload the logs to Cloud Watch. 
    - SES - Simple Email Service is used to send email on RDS update. 
    - SNS - Simple Notification Service is used to send email on EC2 health change. 
    - Certificate Manager - Generating the SSL certificate for implementing HTTPS. 
    - IOT Core: For connecting the 1-click device to the cloud. 
    - IOT 1-Click: For triggering the Lambda functions from the IOT device. 
    - S3 - Used to store the build from Jenkins. 
    - AWS CloudFormation - To reconstruct the AWS infrastructure. 
    - AWS ECS - Amazon Elastic Container Service   - To deploy the code in Amazon container. 

5. Source Code Management

    - GitHub 

7. CI/CD

    - Jenkins 
    - Code Pipeline - Used to deploy the changes to the system 
    - Code Build: Generating the build output. 
    - Code Commit: This is used as the version control and code repository (code is also uploaded to the GitHub) 
    - Code Deploy: Deploys the code to the server.
    
**Infrastructure as a Service (IaaS)**

**AWS Cloud Formation**
    An Application stack has been created which consists of EC2 instance, RDS for MySQL, Security groups and continous integration pipeline. Application then be containerized to run on EC2 created by the cloud formation script.
    
### Advantages of using Cloud Services  
  
**High Availability**

**Cost Optimization**

With the extensive use of AWS resources, we have optimized the cost in every phase of the development lifecycle. With the pay-as-you-go model, the operational cost has been reduced drastically than the traditional model. With the help of Auto-scaling, we make sure we are utilizing only the resources necessary for the load our application is handling at any point of time with this approach we are reducing the cost further and providing more valuable service to our customers.

**Security**

The AWS resources are placed in a Virtual Private Cloud with additional AWS security components like Internet Gateway which allows for the communication of the AWS resources in a subnet to the Internet. The Route table contains the list of inbound and outbound rules to allow communication to specific ports. The EC2 instances are connected to the Security Group with Internet Gateway making it a Subnet whereas the Internet Gateway is not attached to the Security Group of the RDS to make it a Private Subnet.


**Disaster Recovery**

RDS has been enabled in Multiple Availability Zones in order to make the application highly available and also available during a disaster. In addition to Multi-AZ deployment is enabled, the application archives the backup for one week. Also, frequent RDS snapshots are taken to rebuild in case of any failures.


**Role Based Access**

The end user can access the application by two roles namely User role and Service Provider role. A user is given the access to view the list of restaurants registered under the application, book the desired restaurant, cancel the reservation and view the history of booking made under the user profile. The Service Provider has registered the restaurant under the application, cancel the reservations made in the restaurant and view the panel of bookings made in the restaurant.

**Fault-Tolerant**

A web application consists of three tiers namely web, application, and database. The Web tier to resistant to fault tolerance by the AWS service of Elastic Load Balancing. Since the Load Balancer redirects the web traffic to healthy Amazon EC2 instances for more consistent application performance. The Application tier is resistant to fault tolerance through Auto-Scaling which monitors the application enables scaling of EC2 instances based upon end user’s usage of the application. The Database tier is resistant to fault tolerance by maintaining a standby database in the other zone and a read replica in the primary zone.

# Screenshots - AWS services

### cloud formation stack
![1](https://user-images.githubusercontent.com/42689991/57642097-62bcc680-756b-11e9-9470-038ea00f408a.PNG)

### cloudwatch logs for cloudformation
![2](https://user-images.githubusercontent.com/42689991/57642098-63555d00-756b-11e9-906d-049acb71b6fe.PNG)

### ECS cluster for EC2 service
![3](https://user-images.githubusercontent.com/42689991/57642099-63edf380-756b-11e9-99ef-651a8b537915.PNG)

### ECR docker container repository
![3a](https://user-images.githubusercontent.com/42689991/57642102-64868a00-756b-11e9-8c23-463070f85ce1.PNG)

###s3 bucket stores master cloudformation template and nested stacks
![4](https://user-images.githubusercontent.com/42689991/57642150-7bc57780-756b-11e9-887b-ecec6cbc219e.PNG)

### AWS code build for project repo in AWS code commit
![5](https://user-images.githubusercontent.com/42689991/57642151-7bc57780-756b-11e9-8415-3f6865d777bf.PNG)

### AWS Code commit for project
![6](https://user-images.githubusercontent.com/42689991/57642152-7c5e0e00-756b-11e9-9ac2-4f780818310c.PNG)

### cloudformation template for ECS cluster
![9](https://user-images.githubusercontent.com/42689991/57642153-7c5e0e00-756b-11e9-8235-8fdb1d7cc2df.PNG)

### Foodbolt stack resources list
![10](https://user-images.githubusercontent.com/42689991/57642154-7c5e0e00-756b-11e9-8a4e-6c7c2c730701.PNG)

### EC2 instances deployed from cloudformation through ECR docker image
![13](https://user-images.githubusercontent.com/42689991/57642156-7cf6a480-756b-11e9-866a-567191d58858.PNG)

### Route 53 domian name for ALB hosted zone
![14](https://user-images.githubusercontent.com/42689991/57642157-7cf6a480-756b-11e9-9543-d24e1b8901ff.PNG)

### Deployment of Foodbolt Project through CloudFormation
![14a](https://user-images.githubusercontent.com/42689991/57642158-7d8f3b00-756b-11e9-8cde-fd0b83682886.PNG)

### load balancer
![15](https://user-images.githubusercontent.com/42689991/57642160-7e27d180-756b-11e9-90b3-9f2b284ff613.PNG)

### Autoscaling group
![16](https://user-images.githubusercontent.com/42689991/57642162-7e27d180-756b-11e9-8716-b6882ec5d14c.PNG)

### Foodbolt cloudfromation stack
![17](https://user-images.githubusercontent.com/42689991/57642164-7ec06800-756b-11e9-9452-6fc06192dbac.PNG)

### Nested stack - VPC
![18](https://user-images.githubusercontent.com/42689991/57642167-7f58fe80-756b-11e9-853c-e666aa6919b8.PNG)

### VPC for foodboltstack
![18a](https://user-images.githubusercontent.com/42689991/57642168-7f58fe80-756b-11e9-8f88-cc059de6a445.PNG)

### Nested stack - CICD
![19](https://user-images.githubusercontent.com/42689991/57642169-7ff19500-756b-11e9-84f9-9bde00d05689.PNG)

### Foodboltstack build
![19a](https://user-images.githubusercontent.com/42689991/57642171-7ff19500-756b-11e9-8e0b-c7da62abedcd.PNG)

### AWS container repository
![20](https://user-images.githubusercontent.com/42689991/57642173-808a2b80-756b-11e9-91ee-ed015a2c49b9.PNG)

### Docker image build in AWS codebuild
![21](https://user-images.githubusercontent.com/42689991/57642175-8122c200-756b-11e9-8b8a-55c7b1e4ec20.PNG)

### Nested stack - codebuild
![22](https://user-images.githubusercontent.com/42689991/57642178-8253ef00-756b-11e9-96d6-9659144f72d0.PNG)

### CICD pipeline form Jenkins build - commit, build, deploy, approval, production
![23a](https://user-images.githubusercontent.com/42689991/57642183-82ec8580-756b-11e9-9034-3921a736c32b.PNG)


![23b](https://user-images.githubusercontent.com/42689991/57642184-83851c00-756b-11e9-858a-3f4a776065b6.PNG)

### Jenkins Build for Foodbolt project
![24](https://user-images.githubusercontent.com/42689991/57642186-84b64900-756b-11e9-818c-eee873b6f913.PNG)

