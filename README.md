# Workflow

A CLI tool to help you stay focused within the terminal

# How to Run
1. Install Java (https://www.java.com/en/download/)
2. Whenever you want to lock in, run java Main.java

# Algorithm

Main class

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

Timer class

1. timer()
    1. Print a message indicating the start of the timer
    2. Loop 15 times
        1. If the loop number is divisible by 5, print the time remaining
        2. Sleep for 1 minute
    3. Print a message when the timer finishes

# References

w3Schools Java: https://www.w3schools.com/java/default.asp

"Java, Java, Java: Objected-Oriented Problem Solving, 3rd Edition" by R. Morelli and R. Walde
