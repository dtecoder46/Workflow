# Workflow

A CLI tool to help you stay focused within the terminal

# How to Run
1. Install Java (https://www.java.com/en/download/)
2. Input your tasks into tasks.jsonc
3. Whenever you want to lock in, run "java Main.java"

# Algorithm

## Main class

1. readJSON()
    1. Read a list of JSON tasks
        1. Trim each line of whitespace
2. processJSON()
    1. Remove curly braces and commas from the file contents
    2. Split into a list of lines
    3. Make a new list without blank lines
3. mapCreator()
    1. Loop through each line
        1. Split each line by “: “
        2. Pull the key and value into a HashMap
4. Loop until the user says “no” to continuing the workflow
    1. Loop twice
        1. Ask the user for the next task to work on from the list
        2. Run a 15 min timer (Timer.timer())
    2. Start a 15 min break timer (Timer.timer())

## Timer class

1. timer()
    1. Print a message indicating the start of the timer and the task to work on
    2. Loop 15 times
        1. If the loop number is divisible by 5, print the time remaining and the task being worked on
        2. Sleep for 1 minute
    3. Print a message when the timer finishes

## taskInput class

### Attributes
1. *id* - the JSON key to uniquely number each task
2. *json* - the JSON string containing the user's tasks to be sent to tasks.jsonc

### Default constructor
1. Initialize *id* as 1
2. Initialize *json* as "{\n"

### taskLoop()
1. Task input loop
    1. Increment *id* by 1
    2. Ask the user for a task, store in *task*
    2. Append *id* and *task* as a JSON key-value pair to *json*
2. Add "}" to *json*
3. Pass in 

## writeFile class

### Attributes
1. fileContents

### Constructor
1. Set the value of fileContents

### write()
1. Overwrite previous content in tasks.jsonc with fileContents

# References

w3Schools Java: https://www.w3schools.com/java/default.asp

"Java, Java, Java: Objected-Oriented Problem Solving, 3rd Edition" by R. Morelli and R. Walde

Java Thread.sleep(): https://www.geeksforgeeks.org/java/thread-sleep-method-in-java-with-examples/
