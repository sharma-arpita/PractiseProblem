This README file explains how to run the Parking lot problem and the pre requisites
required.

---- BUILD FEATURE ----

The project uses Apache Maven 3.3.9 to build and execute the test cases.
The pom.xml has a added dependency of JUnit 4 to create and execute the 
test cases.

---- COMPILE AND RUN ON THE COMMAND LINE ----
The project requires Java 8 to compile and run.
To build and run the project there is a shell script added "parking_lot.sh",
the script builds the project, runs the test cases, compile and run the 
newly created jar.
As required the script should accept a file as input, you should enter:

                  ./parking_lot.sh path_to_file
                  
This will take the inputs from file, writes output on console and exit the 
project.

To enter input vis interactive shell, you should enter:

                        ./parking_lot.sh
                       
and enter the inputs on shell, output will be displayes at STDOUT.
A sample file file_input.sh is there to test with sample output.
