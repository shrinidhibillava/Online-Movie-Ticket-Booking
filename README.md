# ONLINE-TICKET-BOOKING

1)Introduction The Online Movie Ticket Booking application offers a user-friendly platform for movie enthusiasts to explore currently showing movies, check showtimes, select preferred seats And Screen, and conveniently book tickets from the comfort of their own devices.

2)Features User Registration and Authentication: Users can register accounts or log in to access the ticket booking functionality. Movie Listing: Browse through a list of currently showing movies with their brief descriptions and ratings. Movie Details: View detailed information about a selected movie, including synopsis, cast, and trailer. Showtimes: Check available showtimes for a movie, including date, time, and theater location. Seat Selection: Choose seats from a visual layout of the theater to ensure preferred viewing. Booking and Payment: Add selected seats to the cart, proceed to payment, and complete the booking process securely. Booking History: Users can view their booking history, including details of past bookings and tickets. Admin Dashboard: Admins can manage movies, showtimes, theaters, and user accounts. Movie Management: Admins can add new movies, update movie details, and remove movies. Showtime Management: Admins can create and manage showtimes for movies. Theater Management: Admins can manage theater information, such as location and seating layout. User Management: Admins can review user activity, manage accounts, and address support issues.

3)Technologies Used Spring MVC: The application is built using the Spring MVC framework, which facilitates the development of web applications using the Model-View-Controller pattern. Java: The primary programming language for implementing the application's backend logic. Thymeleaf: A modern server-side Java template engine for creating dynamic HTML templates. HTML, CSS, Jsp AND Servlet: Used for creating the user interface and providing an interactive experience. Bootstrap: A front-end framework for creating responsive and visually appealing designs. MySQL: The relational database management system used to store movie, showtime, booking, and user information. Spring Security: Integrated security mechanisms for user authentication and authorization. Hibernate: Used for database modeling, querying, and interacting with the database. Maven: A build automation and project management tool for managing dependencies and building the application.

4)Usage Users can register or log in to their accounts. Browse the list of currently showing movies and select a movie to view details. Check available showtimes and select preferred seats. Add selected seats to the cart, proceed to checkout, and make secure online payments. Users can view their booking history and download tickets. Admins can log in to the admin dashboard to manage movies, showtimes, theaters, and user accounts.

5)Contributing Contributions to the project are welcome! If you find any issues or want to add new features, feel free to open a pull request. Run Project

Go to Hibernate file make changes

      creat scham in Mysql movies 

         <property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>

   <property name="hibernate.connection.password">root</property>
    
   <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/movies</property>
    
  <property name="hibernate.connection.username">root</property>
    
  <property name="hibernate.dialect">org.hibernate.dialect.MySQL5Dialect</property>
    
  <property name="hbm2ddl.auto">update</property>
    
   <property name="show_sql">true</property>
http://localhost:8080/Movie12/Organization.jsp and http://localhost:8080/Movie12/GPay.jsp Than go with http://localhost:8080/Movie12/login.jsp
