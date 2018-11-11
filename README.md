l# RestAppHotelbooking

                                                   Create REST application Hotel booking
With capabilities (each represented by separate endpoint):
1. View list of available rooms (room have a number, category, price, additional options like breakfast, cleaning with additional cost) for specified dates.
2. View rooms filtered by category.
3. Create user.
4. User can book the room for specified days.
5. User can view his booking.
6. User can get the total price of the booking (room for dates period + cost of additional options).
7. View all bookings for the hotel.
Authentication and authorization are not included in the task.
Requirements:
1. Source code must be stored on GitHub with access to the repository.
2. The repository must contain file README.MD with instructions for launching the application and any other necessary documentation for the application (in English).
3. Running the application should not require a standalone application server (application should run on embedded tomcat server) or installation of any software except Java and maven.
4. The project should contain SQL-script for creating database tables and filling them with data necessary to test application.
5. The project should be covered with unit tests.
6. Availability of UML class diagram is a plus.
                                                "Instructions for launching the application"
Tech stack: Java 8, Spring Boot, Spring MVC, Spring Data, Hibernate, H2, maven.
1. datascript.sql - SQL-script for creating database tables and filling them with data necessary to test application.
2. View list of available rooms - "http://localhost:8080/room/available"
3. View rooms filtered by category - "http://localhost:8080/find/category/{name}". Name - "KINGROOM", "LUXROOM", "LOSERROOM".
4. Create user - "http://localhost:8080/room/saveUser"
5. User can book the room for specified days - "http://localhost:8080/room/book"
6. User can view his booking - "http://localhost:8080//findBookingUser/{userID}"
7. User can get the total price of the booking (room for dates period + cost of additional options).
8. View all bookings for the hotel - "http://localhost:8080/findallBooking"


Unit tests:
1) Positive and Negative test to "View List of available rooms".
2) Positive and Negative test to "Create user".
3) Positive and Negative test to "View rooms filtered by category".