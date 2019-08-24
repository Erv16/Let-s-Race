# CS542: Assignment 2
## Name: Erwin Joshua Palani

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in racingDrivers/src folder.

-----------------------------------------------------------------------

#### Note: Assuming you are in erwin_palani_assign_2/racingDrivers.

## Instruction to clean:

####Command: 
ant -buildfile src/build.xml clean

Description: It cleans up all the .class files that were generated when you compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: 
ant -buildfile src/build.xml run -Darg0=<inputFile.txt> -Darg1=<outputFile.txt> -Darg2=<Logger-Value> 

Example:

ant -buildfile racingDrivers/src/build.xml run -Darg0=inputFile.txt -Darg1=outputFile.txt -Darg2=3



-----------------------------------------------------------------------
## Description:

The assignment entails calculating the state of mind of race drivers in a race based on their positions in the race. The program receieves the distances covered by each driver at an instance of time using which the positions are calculated. If the drivers have a tie ie. the same position, they are in a designated state of mind (being Reckless). It requires an input file, an output file to be written to and a Logger value as the command line argument to run. (Note: The logger value can range from 0 to 4)

The following are the descriptions of the logger values to be selected from: 

DEBUG_VALUE=4 [Print to stdout everytime a constructor is called. Prints the output to the file.]

DEBUG_VALUE=3 [Print to stdout everytime the state is changed. Prints the output to the file.]

DEBUG_VALUE=2 [Print to stdout each of the results being written to file. Prints the output to the file.]

DEBUG_VALUE=1 [Print to stdout updates on FileProcessor and the lines being read from the input file. Prints the output to the file.]

DEBUG_VALUE=0 [No output should be printed from the application to stdout. It is ok to write to the output file though" ]

Sources or References used:

1. https://stackoverflow.com/questions/6548157/how-to-write-an-arraylist-of-strings-into-a-text-file
To understand how the contents of the Results structure can be written to a file.

2. https://stackoverflow.com/questions/25103655/java-newline-n-not-working-in-save-to-text-file
Since the '\n' doesn't work as is while writing to file, had to make use of '\r\n' to forcefully add a break line.

3. https://www.geeksforgeeks.org/state-design-pattern/
To understand a simple implementation of the State Design Pattern

4. https://stackoverflow.com/questions/14021827/extends-class-and-implements-interface-in-java
To understand how to both extend and implement at the same time in java

5. https://www.geeksforgeeks.org/singleton-class-java/
How to create a Singleton instance

6. https://www.geeksforgeeks.org/abstract-classes-in-java/
How to create an abstract base class

-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied it, nor have I given my solution to anyone else. I understand that if I am involved in plagiarism or cheating I will have to sign an official form that I have cheated and that this form will be stored in my official university record. I also understand that I will receive a grade of 0 for the involved assignment for my first offense and that I will receive a grade of F for the course for any additional
offense.""

Date: 06/28/2019 Erwin Joshua Palani 


