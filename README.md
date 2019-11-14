# Nielsen Sports Coding Challenge

## Car Service Center Application System REST API

### Problem:

> For this test please create a simple application with a REST API that can store and manage appointments for
a car service center. Appointments should be persisted in a datastore. Please create the data model that you
feel is appropriate for the task at hand.
>
>The application should have REST endpoints that do the following:
> - Delete appointments from the database
> - Create new appointments
> - Update the status of an existing appointment
> - Retrieve a specific appointment from the database.
> - Retrieve all appointments that are scheduled between a date range and sorted by price.
>
> Additionally an appointment scheduler function should create new appointments at a random interval.
Technologies to consider:
> - Language of choice (Java, C#, node.js, etc.)
> - Command line build systems (Maven, Gradle, npm, etc.)
> - Datastore of choice
> - Docker/Kubernetes
> - Unit testing framework (Mocha, JUnit, etc.)
> - CI/CD Orchestration (Jenkins, Ansible, etc.)
>
> It is okay to include other libraries/dependencies as necessary, but be prepared to discuss with your
interviewer.

### Design

There are four main components for the scheduler:
- database and ORM/DAO (business objects)
- service layer (business logic)
- REST API
- security layer

Spring Boot provides us with in-memory database options for building a prototype as well as 
a REST framework including annotations. The only thing left to build is the actual database 
and the business logic/objects.

The REST API should support the following functions:
- POST /appointments { ... } (create)
- GET /appointments/1 (read)
- PUT /appointments/1 (update)
- DELETE /appointments/1 (delete)
- GET /appointments (list)

### Considerations

**Language:** Java\
**Build:** Gradle\
**Datastore:** H2\
**Test:** JUnit\
~~**Container:** Docker~~\
~~**CD/CI:** Jenkins~~

