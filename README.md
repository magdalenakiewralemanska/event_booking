# Event booking project - backend part:

It is a simple web application designed to easily search for events according to categories. Its task is, on the one hand, to create the opportunity to look for ideas for spending free time, and on the other hand, to simplify the search for the one best suited to the user's needs from a wide selection of offers from various organizers. This application is intended to enable simple booking of an appointment, without telephone calls, without leaving home, at any time and to enable quick price comparison. The application has a part intended only for the user-organizer and a part intended for the user-client.
The basic functions of the user-client include:
1. Browsing offers organized by event category,
2. Searching for offers tailored to your needs,
3. Possibility to view available offer dates,
4. Possibility to choose an offer package,
5. Booking a date for a selected offer,
6. Login, registration and user profile.
   
In the case of a user-organizer, the application allows primarily for:
1. Adding and modifying existing offers,
2. Adding packages for individual offers,
3. Viewing the list of posted offers,
4. Setting offer availability dates,
5. Managing your own user account.
This application consists of two basic parts: frontend and backend.

# Backend part:

The backend part of the application consists primarily in creating appropriate model classes (entities with dto), such as e.g. user, offer, package, event, order, etc., creating the possibility of user login based on Spring security and the JWT token, along with assigning roles to individual users. The user can register his account, edit it and change his password. The application supports basic CRUD methods (create, read, update, delete) for user, offer, package, event entities. The individual options for editing basic data and deleting data have been divided according to the roles assigned to users.
#
This repository refers to database support in MySQL.

# In the future:
In the future, it is also planned to create such functionalities as:
1.	ability to search for offers by user's location,
2.	creating an organizer account,
3.	adding the option of user notifications about the current offer status,
4.	adding a payment function,
5.	creating the ability to filter searched offers taking into account various search criteria,
6.	expanding the user account by adding the ability to invite selected people to participate in a selected event.

### Technologies
***
<div align="center">
	<code><img height="50" src="https://user-images.githubusercontent.com/25181517/192108890-200809d1-439c-4e23-90d3-b090cf9a4eea.png" alt="InteliJ" title="InteliJ" /></code>
	<code><img height="50" src="https://user-images.githubusercontent.com/25181517/192108891-d86b6220-e232-423a-bf5f-90903e6887c3.png" alt="Visual Studio Code" title="Visual Studio Code" /></code>
	<code><img height="50" src="https://user-images.githubusercontent.com/25181517/192158954-f88b5814-d510-4564-b285-dff7d6400dad.png" alt="HTML" title="HTML" /></code>
	<code><img height="50" src="https://user-images.githubusercontent.com/25181517/183898674-75a4a1b1-f960-4ea9-abcb-637170a00a75.png" alt="CSS" title="CSS" /></code>
	<code><img height="50" src="https://user-images.githubusercontent.com/25181517/190887639-d0ba4ec9-ddbe-45dd-bea1-4db83846503e.png" alt="Chakra UI" title="Chakra UI" /></code>
	<code><img height="50" src="https://user-images.githubusercontent.com/25181517/183897015-94a058a6-b86e-4e42-a37f-bf92061753e5.png" alt="React" title="React" /></code>
	<code><img height="50" src="https://user-images.githubusercontent.com/25181517/183890598-19a0ac2d-e88a-4005-a8df-1ee36782fde1.png" alt="TypeScript" title="TypeScript" /></code>
	<code><img height="50" src="https://user-images.githubusercontent.com/25181517/121401671-49102800-c959-11eb-9f6f-74d49a5e1774.png" alt="npm" title="npm" /></code>
	<code><img height="50" src="https://user-images.githubusercontent.com/25181517/183568594-85e280a7-0d7e-4d1a-9028-c8c2209e073c.png" alt="Node.js" title="Node.js" /></code>
	<code><img height="50" src="https://user-images.githubusercontent.com/25181517/117201156-9a724800-adec-11eb-9a9d-3cd0f67da4bc.png" alt="Java" title="Java" /></code>
	<code><img height="50" src="https://user-images.githubusercontent.com/25181517/117201470-f6d56780-adec-11eb-8f7c-e70e376cfd07.png" alt="Spring" title="Spring" /></code>
	<code><img height="50" src="https://user-images.githubusercontent.com/25181517/183891303-41f257f8-6b3d-487c-aa56-c497b880d0fb.png" alt="Spring Boot" title="Spring Boot" /></code>
	<code><img height="50" src="https://user-images.githubusercontent.com/25181517/117207242-07d5a700-adf4-11eb-975e-be04e62b984b.png" alt="Maven" title="Maven" /></code>
	<code><img height="50" src="https://user-images.githubusercontent.com/25181517/117207493-49665200-adf4-11eb-808e-a9c0fcc2a0a0.png" alt="Hibernate" title="Hibernate" /></code>
	<code><img height="50" src="https://user-images.githubusercontent.com/25181517/117533873-484d4480-afef-11eb-9fad-67c8605e3592.png" alt="JUnit" title="JUnit" /></code>
	<code><img height="50" src="https://user-images.githubusercontent.com/25181517/190229463-87fa862f-ccf0-48da-8023-940d287df610.png" alt="Lombok" title="Lombok" /></code>
	<code><img height="50" src="https://user-images.githubusercontent.com/25181517/183896128-ec99105a-ec1a-4d85-b08b-1aa1620b2046.png" alt="MySQL" title="MySQL" /></code>
</div>
