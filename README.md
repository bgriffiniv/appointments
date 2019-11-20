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

#### Structure
There are four main components for the scheduler:
- database and DTOs
- service layer
- REST API
- security layer

#### Framework & Tools
Spring Boot provides us with in-memory database options for building a prototype as well as 
a REST framework including annotations. The only thing left to build is the actual database 
and the business logic/objects.

#### API
The REST API should support the following functions:
- POST /appointments { ... } (create)
- GET /appointments/1 (read)
- PUT /appointments/1 { ... } (update)
- DELETE /appointments/1 (delete)
- GET /appointments (list)

#### JSON Schema

At the center of the design is the Appointment entity, surrounded by the groups of descriptive 
properties.

```
Appointment : {
  contact : Contact,
  serviceList : Service[],
  vehicle : Vehicle,
  availability1 : String,
  availability2 : String,
  notes : String
},
Contact : {
  firstName : String,
  lastName : String,
  phone : String,
  email : String,
  address1 : String,
  address2 : String,
  city : String,
  state : String,
  zip : String,
  contactBy : ["PHONE", "EMAIL"]
},
Service : {
  type : String,
  description : String,
  appointmentList : Appointment[]
},
Vehicle : {
  year : String,
  make : String,
  model : String,
  mileage : String
}
```

#### SQL Schema

There is a join table `Appointment_Service` with `appointment_id` and `service_id` columns to 
facilitate the Many-to-Many relationship between `Appointment` and `Service` tables.

### Considerations

**Language:** Java\
**Build:** Gradle\
**Datastore:** H2\
**Test:** JUnit\
~~**Container:** Docker~~\
~~**CD/CI:** Jenkins~~

