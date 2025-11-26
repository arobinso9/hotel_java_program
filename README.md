🏨 Hotel Reservation System

This program is a fully object-oriented Hotel Reservation System written in Java.
It demonstrates inheritance, composition, encapsulation, polymorphism, enums, and custom exception handling through a realistic hotel management scenario.


<br>
🎮 Features

Guest Management: Add, store, and validate guest details such as name, contact info, and reservation ID.

Employee Management: Track hotel employees with ID, role, and hourly rate.

Room Management: Handle room numbers, types, nightly rates, and booking status.

Reservations: Create, validate, and manage reservations with check-in and check-out dates.

Error Handling: Prevent duplicates and invalid data through multiple custom exceptions.

Organized Architecture: All data is managed through a central Hotel class.

<br>
🛠️ Technical Details
Object-Oriented Structure

Person → Base class for shared info

Guest / Employee → Inherit from Person

Hotel → Aggregates guests, employees, rooms, reservations

Reservation → Connects Guest + Room + Dates
<br>
Enums: Gender, BookingStatus

Custom Exceptions:
GuestExistsException

EmployeeExistsException

RoomExistsException

ReservationExistsException

ReservationNotFoundException

InvalidDateException

InvalidRateException

<br>

📂 Class Overview
**Person**

Stores first name, last name, gender, address, and birthdate.

**Guest**

Adds reservation number, phone number, email.
Overrides equals() to compare based on reservation number.

**Employee**

Adds employee ID, role, and pay rate.

**Address**

Stores street, city, state, and ZIP code.

**Room**

Stores room number, room type, rate, and booking status.

**Reservation**

Stores guest, room, check-in, and check-out dates.
Validates date order and room availability.

**Hotel**

Main system manager.
Contains lists of:

Guests, Employees, Rooms, Reservations

Provides methods to add/search/manage all components
