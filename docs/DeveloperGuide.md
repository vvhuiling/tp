# Developer Guide

## Acknowledgements

{list here sources of all reused/adapted ideas, code, documentation, and third-party libraries -- include links to the original source as well}

## Design


## **Implementation**

### Add transaction feature

The add transaction feature is facilitated by the `Parser` class which parses user input and creates a `Expense` or
`Allowance` object which extends from the `Transaction` class. The created `Transaction` object will be stored in a 
`TransactionList`.

Given below is an example usage scenario and how the add transaction mechanism behaves at each step.

Step 1. The user launches the application for the first time. The `TransactionList` will be initialized.

Step 2. The user executes `expense /amt 20 /date 24-10-2023 /desc Lunch /note Pasta /cat Food` command to create a
transaction. The `expense` command calls `Parser#parseExpense()` to create an `Expense` object. The 
`AddCommand#execute()` is then called to store the `Expense` object in the `TransactionList`.

The following sequence diagram shows how the add transaction operation works:

<img src="images/AddTransactionSequenceDiagram.png" width="600" />

### List transactions feature

The list transaction feature is facilitated by the `Parser` class which parses user input and creates a new
`ListCommand` object. The `ListCommand` object will get all the transactions in the `TransactionList` and display them 
to the user.

Given below is the example usage scenario and how the list transaction mechanism behaves at each step.

Step 1. The user launches the application. The `TransactionList` will be initialized with the transactions stored in 
the `nuscents.txt` file. If the file is empty or does not exist, the `TransactionList` will be empty. 

Step 2. The user executes `list` command to list the transactions. The `list` command calls `ListCommand#execute()`, 
which gets the transactions from the `TransactionList` and displays them to the user.

The following sequence diagram shows how the list transaction operation works:

<img src="images/ListTransactionSequenceDiagram.png" width="600" />


## Product scope
### Target user profile

{Describe the target user profile}

### Value proposition

{Describe the value proposition: what problem does it solve?}

## User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|new user|see usage instructions|refer to them when I forget how to use the application|
|v2.0|user|find a to-do item by name|locate a to-do without having to go through the entire list|

## Non-Functional Requirements

{Give non-functional requirements}

## Glossary

* *glossary item* - Definition

## Instructions for manual testing

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}
