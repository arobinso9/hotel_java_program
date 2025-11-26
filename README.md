Hotel Reservation System

This project implements a fully object-oriented Hotel Reservation System using Java.
It demonstrates strong OOP design including:

Inheritance
Composition
Custom exceptions
Copy constructors
Polymorphism
Encapsulation
Enum usage
Aggregation of objects inside a Hotel

The system allows creation and management of:
Guests
Employees
Rooms
Reservations
Booking statuses
Hotel operations

Key Features
Add guests, employees, rooms, and reservations
Prevent duplicates using custom “exists” exceptions
Validate dates and pricing using custom error types
Query, print, and manage hotel data
Rich toString() output formatting
Demonstrates proper constructor chaining and inheritance
Class Documentation

Below is a summary of all major classes in the project.
# Person.java
Base class representing shared traits for both Guests and Employees.
Fields:
First name
Last name
Gender
Address
Birthdate

Used via inheritance by:
Guest
Employee

Includes constructors, validation, getters, and overridden toString().

### Guest.java
Extends Person and represents a hotel guest.
Contains additional fields: reservation number, phone, email.

Implements:
Validation
Copy constructor
equals() using reservation number
toString() for formatted printing

### Employee.java

Also extends Person.
Adds:
Employee ID
Job role
Pay rate

Throws InvalidRateException for invalid pay rates.

### Address.java
Represents a mailing address.
Provides formatted toString() output.

### Gender.java
An enum representing:
MALE
FEMALE
OTHER

### Room.java

Represents a hotel room with:
Room number
Room type
Rate
Booking status

Throws InvalidRateException for invalid nightly rates.

### BookingStatus.java
Enum representing:
AVAILABLE
RESERVED
OCCUPIED
OUT_OF_SERVICE

Used by Room and Reservation.

### Reservation.java
Represents a booking between a Guest and a Room.
Stores:
Guest
Room
Check-In date
Check-Out date
Confirmation number

Validates:
Date order
Availability
Conflicts

Uses exceptions:
InvalidDateException
ReservationExistsException
ReservationNotFoundException

### Hotel.java
The main aggregation class.
Manages collections of:
Guests
Employees
Rooms
Reservations

Provides methods to:
Add/update/remove items
Search for guests, employees, rooms
Create and cancel reservations
Print all records
Prevents duplicates via custom exceptions.
Custom Exceptions

The project includes multiple custom exception types:

Exception	                          Purpose:
InvalidRateException	              Thrown when room or employee rates are invalid
InvalidDateException	              Thrown for invalid reservation dates
GuestExistsException	              Prevents duplicate guests
EmployeeExistsException	            Prevents duplicate employees
RoomExistsException	                Prevents duplicate rooms
ReservationExistsException	        Prevents duplicate reservations
ReservationNotFoundException	      Thrown when searching for a missing reservation

ClientCode.java
This is the driver program used to:
Instantiate hotel objects
Add sample guests, employees, rooms
Create reservations
Print system output

It demonstrates correct usage of all classes.
UML-Style Inheritance Diagram
                   Person
                  /      \
             Guest       Employee

Aggregation in Hotel:
Hotel
 ├── List<Guest>
 ├── List<Employee>
 ├── List<Room>
 └── List<Reservation>
