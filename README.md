<h3>Library SDA Project<h3>

Project of e-library created in connection with presenting end results of Java Basic Course - organised via <a href="https://sdacademy.pl/">SDAcademy</a>.<br>
Project won 2nd place in Open Competition organised via one of ours teachers Przemysław Bykowski (<a href="http://bykowski.pl/">www.bykowski.pl</a>). 
<br>
<u>Creators:</u>
<ul><li>Michał Chmielewski <a href="https://github.com/mehowch">github profile</a></li><li>Michał Skrzypczak <a href="https://github.com/P3droCi7">github profile</a></li></ul>

Application deployed on Heroku: <a href="https://librarysda.herokuapp.com/startpage">Library Project</a>
<br>
Application uses H2 DB file with create-drop parameter.
H2 DB initialized with sample book and user data:
<table>
<tr>
<th>Role</th>
<th>Login</th>
<th>Password</th>
</tr>
<tr>
<th>Admin</th>
<th>naveen</th>
<th>naveen</th>
</tr>
<tr>
<th>User</th>
<th>priya</th>
<th>priya</th>
</tr>
</table>

<u>Technologies used:</u>
Spring Boot, Spring Boot Security, Swagger2, Thymeleaf, Maven, MySQL DB, H2 DB(Heroku).

<u>Documentation:</u>
Spring Security provides safe login/logout process as well as application layer functionality access. All user passwords are encrypted and safely stored inside database.
<br>
Application provides two user roles:
<ul>
<li>Admin - creates new users, manages book storage (creates new books, deletes old books, updates books)</li>
<li>User - borrows books, returns books</li>
</ul>

Presentation layer created with help of Thymeleaf allows user to access user gui and easly search for books to borrow. User may access User panel and see all currently borrowed books.

Endpoints:
<ul>
<li>Swagger UI <a href="https://librarysda.herokuapp.com/swagger-ui.html">Documentation</a></li>
<li>H2 <a href="https://librarysda.herokuapp.com/console">Console</a></li>
</ul>


<u>Future development of the project:</u>
TODO: Update Book, Search Book, Book Profile, Remove User, Add ability to borrow max 5 books at once.


