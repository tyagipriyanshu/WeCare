# WeCARE - Life Coaching Platform Backend
**WeCARE** is an online life coaching platform that allows users to sign up, view available life coaches, book appointments, and manage them. Life coaches can sign up, manage their profiles, and view their scheduled appointments. The **backend** is implemented using **Spring Boot** to expose **RESTful APIs** for both users and coaches.

## Features
### For Users:
* **Sign Up / Login**: Users can sign up or log in using their credentials.
* **View Profile**: View personal profile details.
* **Upcoming Appointments**: Users can view their upcoming appointments.
* **Manage Appointments**: Users can book, reschedule, or cancel appointments with life coaches.
### For Life Coaches:
* **Sign Up / Login**: Life coaches can sign up or log in using their credentials.
* **View Profile**: Coaches can view their personal and professional details.
* **Upcoming Schedule**: Coaches can view their upcoming appointments.
* **View All Coaches**: List of available life coaches.

## Technologies Used
* **Backend**: Spring Boot (Spring REST)
* **Database**: MySQL (or another relational database)
* **Authentication**: JWT (JSON Web Tokens)
* **Email Service**: Email notifications for appointment status
* **Dependency Management**: Maven
* **Others**: JPA, Hibernate, Spring Security

## API Endpoints
### User API
* POST `/users`: Register a new user.
* POST `/users/login`: User login.
* GET `/users/{userId}`: Get user profile.
* GET `/users/booking/{userId}`: Get user's upcoming appointments.

### Coach API
* POST `/coaches`: Register a new coach.
* POST `/coaches/login`: Coach login.
* GET `/coaches/{coachId}`: Get coach profile.
* GET `/coaches/all`: List all coaches.
* GET `/coaches/booking/{coachId}`: Get coach’s upcoming schedule.

### Booking API
* POST `/users/{userId}/booking/{coachId}`: Book an appointment.
* PUT `/booking/{bookingId}`: Reschedule an appointment.
* DELETE /`booking/{bookingId}`: Cancel an appointment.

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







