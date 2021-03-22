# **Expense Reimbursement Application (March 2021)**
My first full-stack Java application. Allows users to register, login, and logout. Employees can add new reimbursement requests. Finance managers can approve or deny reimbursement tickets.

## About:
This project was my first full-stack Java application created during a 2-week period in March 2021. My client requested an application that allows users to register, login, and logout. Employees can add new expense reimbursement requests which will subsequently be reviewed by a finance manager, who will approve or deny a reimbursement request. Finance managers can view reimbursement tickets made by any employee while individual employees can only view their own reimbursement tickets. 

A visual representation can be seen below:
<img width="702" alt="Screen Shot 2021-03-21 at 6 49 35 PM" src="https://user-images.githubusercontent.com/65792127/111927661-24ea2c80-8a77-11eb-852f-eb9d187a37f4.png">

## Technologies Used

- Java 8
- JavaScript
- PostgreSQL
- HTML
- CSS
- Bootstrap
- Apache Tomcat
- Amazon RDS

## The Process:

### AWS RDS instance & PostgreSQL:
I first created an AWS RDS instance to host my database, then created the database in PostgreSQL.

<img width="407" alt="Screen Shot 2021-03-21 at 7 20 09 PM" src="https://user-images.githubusercontent.com/65792127/111928882-8790f780-8a7a-11eb-9495-3adc8cb658e3.png">

### Java Maven Project:

Next, I structured and programmed the backend of my application using Java and JDBC to connect to my database.

I created Java beans for each of the tables in my database, including getters and setters for each column. I then created the DAO layer to provide further functionality, including CRUD operations to create new users and reimbursements, retrieve user(s) and reimbursement(s) based on specific criteria, update a user's or reimbursement's information, and delete a user or reimbursement.

In order to manage client requests, I implemented a front controller design pattern with servlets. 

### Front End Development (HTML, CSS, JavaScript):

#### Login & Registration Page:
<img width="417" alt="Screen Shot 2021-03-21 at 7 47 15 PM" src="https://user-images.githubusercontent.com/65792127/111930764-4b13ca80-8a7f-11eb-9436-d46974765d74.png">

#### New User Registration Page:
<img width="409" alt="Screen Shot 2021-03-21 at 7 47 38 PM" src="https://user-images.githubusercontent.com/65792127/111930766-4c44f780-8a7f-11eb-92fe-c4a6e862f6da.png">

#### Employee Home Page:
<img width="1338" alt="Screen Shot 2021-03-21 at 7 49 17 PM" src="https://user-images.githubusercontent.com/65792127/111930768-4cdd8e00-8a7f-11eb-9d12-d67cac0c34df.png">

#### Add New Reimbursement:
<img width="412" alt="Screen Shot 2021-03-21 at 7 49 34 PM" src="https://user-images.githubusercontent.com/65792127/111930771-4e0ebb00-8a7f-11eb-852f-e6d2ce80a470.png">

#### Finance Manager Home Page:
<img width="1293" alt="Screen Shot 2021-03-21 at 7 50 52 PM" src="https://user-images.githubusercontent.com/65792127/111930773-4e0ebb00-8a7f-11eb-9ac5-33f1ce449c0b.png">

#### Finance Manager Home Page Functionalities:
<img width="1272" alt="Screen Shot 2021-03-21 at 7 51 27 PM" src="https://user-images.githubusercontent.com/65792127/111930776-4ea75180-8a7f-11eb-9295-e10f32cd4fe0.png">

#### Finance Manager Change Status of a Reimbursement:
<img width="1228" alt="Screen Shot 2021-03-21 at 7 52 15 PM" src="https://user-images.githubusercontent.com/65792127/111930778-4ea75180-8a7f-11eb-8c69-4dd745a6af4b.png">

#### Finance Manager: Reimbursement Status was Changed:
<img width="1197" alt="Screen Shot 2021-03-21 at 7 52 35 PM" src="https://user-images.githubusercontent.com/65792127/111930780-4f3fe800-8a7f-11eb-85c2-aa2ca4785985.png">

#### Finance Manager: Filter by Status Type
<img width="294" alt="Screen Shot 2021-03-21 at 7 53 02 PM" src="https://user-images.githubusercontent.com/65792127/111930781-4f3fe800-8a7f-11eb-9e1a-d349388bfde2.png">

#### Finance Manager: Filtered for "Pending" Only
<img width="1201" alt="Screen Shot 2021-03-21 at 8 14 47 PM" src="https://user-images.githubusercontent.com/65792127/111932047-35ec6b00-8a82-11eb-9af0-74f0eb39fc53.png">

