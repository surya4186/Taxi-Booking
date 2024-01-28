# Taxi Booking Application

The Taxi Booking Application is a Java-based console application that facilitates the booking of taxis. It includes features such as creating taxis, booking taxis based on availability, and printing taxi details.

## Overview

This application provides a simplified taxi booking system with capabilities for creating taxis, checking availability, and booking rides.

## Features

- **Book Taxi:** Users can book a taxi by providing pickup and drop points.
- **Print Taxi Details:** View details of available taxis and their current state.
- 
### Planning
Project Duration: 31 days.
Type: Console Application.
Language: Java.
Contributor: 1.

## Project Structure

- **Package: com.zsgs.taxiview**
  - `TaxiView`: The main class handling the user interface and navigation.

- **Package: com.zsgs.booktaxi**
  - `BookTaxiView`: Contains functionalities related to taxi booking.
  - `BookTaxiViewModel`: Manages the logic for booking taxis.

- **Package: com.zsgs.dto**
  - `Taxi`: DTO (Data Transfer Object) class representing taxi details.

- **Other Packages:**
  - `com.zsgs.repo`: Contains classes related to data storage and retrieval.
  
## Usage

1. Start the application.
2. Choose an option from the main menu:
   - Option 0: Book a taxi.
   - Option 1: Print taxi details.
   - Any other option: Exit the application.

## Classes

### `TaxiView`

The main class responsible for starting the application, displaying the menu, and handling user input.

### `BookTaxiView`

A class containing functionalities related to booking taxis.

### `BookTaxiViewModel`

Manages the logic for booking taxis, including sorting available taxis and updating taxi details.

### `Taxi`

A Data Transfer Object (DTO) representing taxi details.

### `TaxiModel`

Contains classes related to data storage and retrieval for taxis.


