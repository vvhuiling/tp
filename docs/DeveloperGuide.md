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


### View transaction feature
In this section, I will describe the implementation of the "View Transaction" feature which allows users to 
view transaction details by specifying an index.
#### I. Architecture-Level Design
The "View Transaction" feature primarily involves the following components:

1. Parser: Responsible for interpreting user input and generating a ViewCommand object.

2. ViewCommand: A subclass of the Command class, created by the Parser to represent the "view" command.

3. Nuscents: The main application class that receives and executes commands. It invokes the execute() method of the ViewCommand.

4. TransactionList: A data structure to store and manage transactions.

5. Transaction: Represents individual transactions.

6. UI: Handles user interface and messaging.
#### II. Component-Level Design

1. Parser

The Parser class identifies the "view" command and extracts the taskIndex (transaction index) from the user's input.

2. ViewCommand

The ViewCommand object is created by the Parser. It encapsulates the user's request to view a specific transaction. This object is passed to the Nuscents class for execution.

3. Nuscents

In the Nuscents class, the execute() method of the ViewCommand is called, and the taskIndex is extracted from the command. It then calls the viewTransaction(taskIndex) method on the TransactionList.

4. TransactionList

The TransactionList contains a list of Transaction objects. The viewTransaction(taskIndex) method retrieves the specific Transaction object based on the taskIndex.

5. Transaction

The Transaction class represents an individual transaction, and it contains all the relevant details of a transaction.

6. UI

The UI class displays the transaction details using the UI.showTransactionViewMessage method, which receives the Transaction object as input and presents the detailed transaction information to the user.

#### III. Alternatives Considered
While the current design is deemed suitable for our application, we did consider alternative approaches, such as 
integrating the view transaction functionality directly within the Nuscents class without introducing a ViewCommand. 
However, we opted for the current design to promote a cleaner separation of concerns and to facilitate future expansions 
and modifications.

The following sequence diagram shows how the add transaction operation works:
<img src="images/ViewSequenceDiagram.png" width="600" />

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
