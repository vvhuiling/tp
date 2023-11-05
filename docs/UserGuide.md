# User Guide 💰

## Table of Contents
- [Introduction](#introduction-)
- [Prerequisite](#prerequisite-)
- [Quick Start](#quick-start-)
- [Features](#features-)
   - [Viewing help: `help`](#viewing-help-help)
   - [Adding an allowance: `allowance`](#adding-an-allowance-allowance)
   - [Adding an expense: `expense`](#adding-an-expense-expense)
   - [Adding a budget: `budget`](#adding-a-budget-budget)
   - [Deleting an entry: `delete`](#deleting-an-entry-delete)
   - [Listing all entries: `list`](#listing-all-entries-list)
   - [Filtering entries by category: `filter`](#filtering-entries-by-category-filter)
   - [Viewing an entry: `view`](#viewing-an-entry-view)
   - [Editing an entry: `edit`](#editing-an-entry-edit)
   - [Exiting the program: `exit`](#exiting-the-program-exit)
- [FAQ](#faq-)
- [Command Summary](#command-summary-)

## Introduction 🏦

Welcome to 🪙NUScents🪙, the tailor-made financial tracker for SOC students at
NUS. It is optimized for use via a Command Line Interface (CLI) to offer a clutter-free
solution for our users to manage and monitor their financial activities.

## Prerequisite 💵
Make sure you have Java `11` or above installed on your system.

## Quick Start 💷

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

## Features 📊

- Words in UPPER_CASE are the parameters to be supplied by the user.
  e.g. in `allowance /amt AMOUNT`, `AMOUNT` is a parameter that can be used
  as `allowance /amt 1000`.
- Items in square brackets are optional.
  e.g. `allowance` can be used with or without `/note`.

### Viewing help: `help`
To view a list of all possible commands, a brief description of their
functionality and syntax.

Format: `help`

### Adding an allowance: `allowance`

To add a new allowance entry to the financial tracker, please adhere to the given format!  
Fields in square brackets "[ ]" can be omitted.   
Possible categories for allowance are:
- SALARY
- ALLOWANCE
- INVESTMENTS
- GIFTS
- NO_ALLOWANCE_CATEGORY

Format:
1) `allowance /amt AMOUNT /date DATE /desc DESCRIPTION [/note ADDITIONAL_INFORMATION] [/cat CATEGORY]`  
   e.g., `allowance /amt 200 /date 30-10-2023 /desc pocket money /note November /cat allowance`
2) `allowance /amt AMOUNT /date DATE /desc DESCRIPTION`  
   e.g., `allowance /amt 200 /date 30-10-2023 /desc pocket money`

### Adding an expense: `expense`

To add a new expense entry to the financial tracker, please adhere to the given format!
Fields in square brackets "[ ]" can be omitted.   
Possible categories for allowance are:
- FOOD
- ENTERTAINMENT
- TRANSPORTATION
- UTILITY
- RENT
- NO_EXPENSE_CATEGORY

Format:
1) `expense /amt AMOUNT /date DATE /desc DESCRIPTION [/note ADDITIONAL_INFORMATION] [/cat CATEGORY]`  
   e.g., `expense /amt 20 /date 30-10-2023 /desc lunch /note pasta /cat food`
2) `expense /amt AMOUNT /date DATE /desc DESCRIPTION`   
   e.g., `expense /amt 20 /date 30-10-2023 /desc lunch`

### Adding a budget: `budget`

To add a budget to your expenses.   
Note: The budget must be larger than 0 as it does not make sense to set budget as 0.

Format: `budget AMOUNT`  
e.g., `budget 200`

### Deleting an entry: `delete`

To delete an entry from the financial tracker, which can be either an allowance or an expense.

Format: `delete INDEX`  
e.g., `delete 3`

### Listing all entries: `list`

To list all entries in the financial tracker.

Format: `list`

### Filtering entries by category: `filter`

To filter entries in the financial tracker by category.
The current supported categories are:
- Allowance:
   - SALARY
   - ALLOWANCE
   - INVESTMENTS
   - GIFTS
   - NO_ALLOWANCE_CATEGORY
- Expenses:
   - FOOD
   - ENTERTAINMENT
   - TRANSPORTATION
   - UTILITY
   - RENT
   - NO_EXPENSE_CATEGORY

Format: `filter CATEGORY`  
e.g., `filter allowance`

### Viewing an entry: `view`

To view an entry in the financial tracker, which can be either an allowance or an expense.

Format: `view INDEX`  
e.g., `view 3`

### Editing an entry: `edit`

To edit an entry in the financial tracker, which can be either an allowance or an expense.

Format:
1) `edit INDEX allowance /amt AMOUNT /date DATE /desc DESCRIPTION [/note ADDITIONAL_INFORMATION] [/cat CATEGORY]`  
   e.g., `edit 3 allowance /amt 200 /date 30-10-2023 /desc pocket money /note November /cat allowance`
2) `edit INDEX expense /amt AMOUNT /date DATE /desc DESCRIPTION [/note ADDITIONAL_INFORMATION] [/cat CATEGORY]`  
   e.g., `edit 3 expense /amt 20 /date 30-10-2023 /desc lunch /note pasta /cat food`

### Exiting the program: `exit`

To exit the program.

Format: `exit`

## FAQ ❓

**Q**: How do I transfer my data to another computer?

**A**: There are 2 files used for storage, `./data/nuscents.txt` and `./data/hmac`. Copy both files over to the target
computer.

**Q**: What happens if I modify the storage file ?

**A**: The application is programmed to exit immediately if it detects that the storage file has been tampered with.
You will either need to revert the storage file back to the last known 'good state', or delete both the
`./data/nuscents.txt` and `./data/hmac` files and run the program again. Note that deleting the files will cause a loss
of previously stored data.

## Command Summary 💡

| Action            | Format, Examples                                                                                                                                                                                      |
|-------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Help**          | `help`                                                                                                                                                                                                |
| **Add Allowance** | `allowance /amt AMOUNT /date DATE /desc DESCRIPTION [/note ADDITIONAL_INFORMATION] [/cat CATEGORY]` <br> e.g., `allowance /amt 200 /date 30-10-2023 /desc pocket money /note November /cat allowance` |
| **Add Expense**   | `expense /amt AMOUNT /date DATE /desc DESCRIPTION [/note ADDITIONAL_INFORMATION] [/cat CATEGORY]` <br> e.g., `expense /amt 20 /date 30-10-2023 /desc lunch /note pasta /cat food`                     |
| **Add Budget**    | `budget AMOUNT`<br> e.g., `budget 200`                                                                                                                                                                |
| **Delete**        | `delete INDEX`<br> e.g., `delete 3`                                                                                                                                                                   |
| **List**          | `list`                                                                                                                                                                                                |
| **Filter**        | `filter CATEGORY`                                                                                                                                                                                     |
| **View**          | `view INDEX`                                                                                                                                                                                          |
| **Edit**          | `edit INDEX /amt AMOUNT /date DATE /desc DESCRIPTION [/note ADDITIONAL_INFORMATION] [/cat CATEGORY]` <br> e.g., `edit 2 /amt 200 /date 30-10-2023 /desc pocket money /note November /cat allowance`   |
| **Exit**          | `exit`                                                                                                                                                                                                |
