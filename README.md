# WeCARE - Life Coaching Platform Backend
WeCARE is an online life coaching platform that allows users to sign up, view available life coaches, book appointments, and manage them. Life coaches can sign up, manage their profiles, and view their scheduled appointments. The **backend** is implemented using Spring Boot to expose RESTful APIs for both users and coaches.

## Features
### For Users:
* Sign Up / Login: Users can sign up or log in using their credentials.
* View Profile: View personal profile details.
* Upcoming Appointments: Users can view their upcoming appointments.
* Manage Appointments: Users can book, reschedule, or cancel appointments with life coaches.
### For Life Coaches:
* Sign Up / Login: Life coaches can sign up or log in using their credentials.
* View Profile: Coaches can view their personal and professional details.
* Upcoming Schedule: Coaches can view their upcoming appointments.
* View All Coaches: List of available life coaches.

## Technologies Used
* **Backend**: Spring Boot (Spring REST)
* **Database**: PostgreSQL (or another relational database)
* **Authentication**: JWT (JSON Web Tokens)
* **Email Service**: Email notifications for appointment status
* **Dependency Management**: Maven
* **Others**: JPA, Hibernate, Spring Security

## API Documentation

### CoachRestController
Handles API requests related to **life coaches**.
**Endpoints**

1. Create Coach
** Request Type: POST
API Path: /coaches
Request Body: CoachDTO coachDTO
Response: ResponseEntity<String>
Description: Creates a new coach. If validation passes, returns the coach ID. If validation fails, returns error messages.
Login Coach
Request Type: POST
API Path: /coaches/login
Request Body: LoginDTO loginDTO
Response: ResponseEntity<Boolean>
Description: Logs in an existing coach. Returns true if credentials are correct, otherwise false.
Get Coach Profile
Request Type: GET
API Path: /coaches/{coachId}
Path Variable: coachId
Response: ResponseEntity<CoachDTO>
Description: Retrieves the profile of a coach by coachId.
Show All Coaches
Request Type: GET
API Path: /coaches/all
Response: List<CoachDTO>
Description: Retrieves a list of all available life coaches.
Show My Schedule
Request Type: GET
API Path: /coaches/booking/{coachId}
Path Variable: coachId
Response: List<BookingDTO>
Description: Retrieves a list of upcoming appointments for the specified coach.
UserRestController
Handles API requests related to users.

Endpoints

Create User
Request Type: POST
API Path: /users
Request Body: UserDTO userDTO
Response: ResponseEntity<String>
Description: Creates a new user. Returns the user ID upon success, or validation error messages if the request fails.
Login User
Request Type: POST
API Path: /users/login
Request Body: LoginDTO loginDTO
Response: ResponseEntity<Boolean>
Description: Logs in an existing user. Returns true if credentials are correct, otherwise false.
Get User Profile
Request Type: GET
API Path: /users/{userId}
Path Variable: userId
Response: ResponseEntity<UserDTO>
Description: Retrieves the profile of the user by userId.
Show My Appointments
Request Type: GET
API Path: /users/booking/{userId}
Path Variable: userId
Response: List<BookingDTO>
Description: Retrieves a list of upcoming appointments for the specified user.
BookRestController
Handles API requests related to appointments.

Endpoints

Book Appointment
Request Type: POST
API Path: /users/{userId}/booking/{coachId}
Path Variables: userId, coachId
Request Body: String slot, LocalDate dateOfAppointment
Response: ResponseEntity<Boolean>
Description: Books an appointment for a user with a specified coach, date, and time slot.
Reschedule Appointment
Request Type: PUT
API Path: /booking/{bookingId}
Path Variable: bookingId
Request Body: String slot, LocalDate dateOfAppointment
Response: ResponseEntity<Boolean>
Description: Reschedules an existing appointment with a new time slot.
Cancel Appointment
Request Type: DELETE
API Path: /booking/{bookingId}
Path Variable: bookingId
Response: ResponseEntity<?>
Description: Cancels an existing appointment.
Getting Started

1. Clone the Repository
git clone https://github.com/yourusername/wecare-backend.git
2. Install Dependencies
Ensure you have Maven installed and run the following command:

mvn install
3. Set Up Database
Set up a relational database (e.g., PostgreSQL).
Update the application.properties file with your database connection details:
spring.datasource.url=jdbc:postgresql://localhost:5432/wecaredb
spring.datasource.username=your-db-username
spring.datasource.password=your-db-password
spring.jpa.hibernate.ddl-auto=update
4. Set Up Email Service (Optional)
If you're using an email service like SendGrid or Mailgun, configure it in the application.properties:

spring.mail.host=smtp.mailtrap.io
spring.mail.username=your-email-username
spring.mail.password=your-email-password
5. Run the Application
To run the Spring Boot application, execute the following:

mvn spring-boot:run
The application will be available at http://localhost:8080.


## Database Schema
### User Table
| Column |	Data Type |	Description |
| ------------- | ------------- |------------ |
|`user_id`	|String|	Unique User ID|
|`name`|	String|	User's Full Name|
|`gender`|	String|	User's Gender|
|`date_of_birth`|	LocalDate	|User's Date of Birth|
|`password`	|String	|Password for user authentication|
|`mobile_number`|	Long	|User's Mobile Number|
|`email`	|String	|User's Email Address|
|`pincode`	|Integer|	User's PIN Code|
|`city`	|String|	User's City|
|`state`	|String	|User's State|
|`country`|	String	|User's Country|

### Coach Table
| Column |	Data Type |	Description |
| ------------- | ------------- |------------ |
|`coach_id`	|String	|Unique Coach ID|
|`name`	|String	|Coach's Full Name|
|`gender`|	String	|Coach's Gender|
|`date_of_birth`|	LocalDate|	Coach's Date of Birth|
|`password`	|String	|Password for coach authentication|
|`mobile_number`	|Long	|Coach's Mobile Number|
|`speciality`	|String	|Coach's Area of Expertise|

### Booking Table
| Column |	Data Type |	Description |
| ------------- | ------------- |------------ |
|`booking_id`	|Integer	|Auto-generated Booking ID|
|`user_id`	|String	|ID of the user who made the booking|
|`coach_id`	|String	|ID of the life coach for the appointment|
|`appointment_date`	|LocalDate	|Date of the scheduled appointment|
|`slot`	|String|	Time slot for the appointment|





