# User Guide

## Introduction

Welcome to 🪙NUScents🪙, the tailor-made financial tracker for SOC students at
NUS. It is optimized for use via a Command Line Interface (CLI) to offer a clutter-free
solution for our users to manage and monitor their financial activities.

## Prerequisite
Make sure you have Java `11` or above installed on your system.

## Quick Start

1. Download the latest JAR file (`tp.jar`).
2. Copy the JAR file to the folder you want to use as the **home folder** for your financial tracker.
3. Open a command terminal, `cd` into the folder you put the jar file in.
4. Enter the following command to run the program:

   ```
   java -jar tp.jar
   ```

5. You should see a welcome message as shown below:

   ```
   Hello from
    __   __  __   __   ____   _____ _____ __   __ ________   ____
   |  \ |  |  |  |  |/     / /   __|     |  \ |  |__    __|/     /
   |   \|  |  |  |  |\   __\|   /  |   __|   \|  |  |  |   \   __\
   |       |  |  |  | \__   |  |   |   __|       |  |  |    \__   |
   |       |  |__|  |/      |   \__|     |       |  |  |   /      |
   |__|\___|________|______/ \_____|_____|__|\___|  |__|   |_____/
   
   ---------------------------------------------------------------------------------------------
   What can I do for you?
   Hint: To view a list of all possible commands, please enter 'help'.
   ---------------------------------------------------------------------------------------------
   ```
   
## Features 

- Words in UPPER_CASE are the parameters to be supplied by the user.
e.g. in `allowance /amt AMOUNT`, `AMOUNT` is a parameter that can be used
as `allowance /amt 1000`.
- Items in square brackets are optional.
e.g. `allowance` can be used with or without `/note`.

### Viewing help: `help`
To view a list of all possible commands, a brief description of their
functionality and syntax.

Format: `help`

## FAQ

**Q**: How do I transfer my data to another computer? 

**A**: {your answer here}

## Command Summary

| Action            | Format, Examples                                                                                                                                                                                      |
|-------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Add Allowance** | `allowance /amt AMOUNT /date DATE /desc DESCRIPTION [/note ADDITIONAL_INFORMATION] [/cat CATEGORY]` <br> e.g., `allowance /amt 200 /date 30-10-2023 /desc pocket money /note November /cat allowance` |
| **Add Expense**   | `expense /amt AMOUNT /date DATE /desc DESCRIPTION [/note ADDITIONAL_INFORMATION] [/cat CATEGORY]` <br> e.g., `expense /amt 20 /date 30-10-2023 /desc lunch /note pasta /cat food`                     |
| **Delete**        | `delete INDEX`<br> e.g., `delete 3`                                                                                                                                                                   |
| **List**          | `list`                                                                                                                                                                                                |
| **Filter**        | `filter CATEGORY`                                                                                                                                                                                     |
| **View**          | `view INDEX`                                                                                                                                                                                          |
| **Help**          | `help`                                                                                                                                                                                                |
| **Exit**          | `exit`                                                                                                                                                                                                |
