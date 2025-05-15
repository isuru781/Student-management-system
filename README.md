
# README for Student Management System

## Overview
The Student Activity Management System is a Java-based application designed to manage student registrations, track their module marks, and generate reports. This system allows users to perform various operations such as registering students, checking available seats, adding student details, and saving/loading student data from a file.

## Features
- **Check Available Seats**: View the number of available seats for student registration.
- **Register Student**: Register a new student with a unique ID.
- **Delete Student**: Remove a student from the system using their ID.
- **Search Student**: Find a student by their ID and view their details.
- **Store Student Details**: Save student information to a text file.
- **Load Student Details**: Load student information from a text file into the system.
- **View Student List**: Display a sorted list of students based on their names.
- **Add Student Details**: Add additional details such as student name and module marks.
- **Generate Summary**: Generate a summary of student registrations and pass rates.
- **Generate Report**: Create a detailed report of student performance.

## File Structure
```
MultipleFiles/
├── Main.class
├── Main.java
├── Module.class
├── Module.java
├── Student.class
├── Student.java
├── student_system.iml
└── Student_Details.txt
```

## Getting Started
### Prerequisites
- Java Development Kit (JDK) installed on your machine.
- An IDE or text editor for Java development (e.g., IntelliJ IDEA, Eclipse).

### Installation
1. Clone or download the repository containing the files.
2. Open the `Main.java` file in your IDE.
3. Compile the Java files to generate the `.class` files.
4. Run the `Main` class to start the application.

### Usage
- Upon starting the application, a welcome message and a menu of options will be displayed.
- Follow the prompts to select an option and perform the desired action.
- Input validation is implemented to ensure correct data entry.

## Example Usage
1. To register a student, select option `2` and enter a valid student ID (e.g., `w1234567`).
2. To check available seats, select option `1`.
3. To view the list of students, select option `7`.

## File Format
The student details are stored in a text file named `Student_Details.txt` in the following format:
```
StudentID,StudentName,Module1Marks,Module2Marks,Module3Marks,Average,Grade
```
Example:
```
w2082274,isuru,50.0,55.0,58.0,54.33,Pass
```

## Error Handling
The application includes error handling for invalid inputs and file operations. Users will receive appropriate messages for any errors encountered.

## Contributing
Contributions to improve the system are welcome. Please fork the repository and submit a pull request with your changes.

## License
This project is licensed under the MIT License.

## Acknowledgments
- Thanks to the contributors and the community for their support and feedback.

---
