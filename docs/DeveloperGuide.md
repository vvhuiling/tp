# Developer Guide

## Acknowledgements
{list here sources of all reused/adapted ideas, code, documentation, and third-party libraries -- include links to the original source as well}

## Design

### Architecture
The ***Architecture Diagram*** given above explains the high-level design of the App.
Given below is a quick overview of main components and how they interact with each other.

<img src="images/ArchitectureDiagram.png" width="300" />

**Main components of the architecture**

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

In addition to that, the list transaction feature further computes and displays the net balance amount based on the 
following formula (net balance = total allowance amount - total expense amount). The `showTransactionList()` method in 
the `Ui` class, it utilizes the float `netBalance` to store the net balance amount. When the `TransactionList` is
iterated to print the transactions, it does a simple calculation based on whether it is an allowance or expense, to add
or minus off respectively from the net balance.

### `helpCommand` Feature

#### I. Architecture-Level Design
The `helpCommand` feature serves as an informative component to assist users unfamiliar with the application commands. It integrates the following components:

1. **Parser**: Determines if the user input matches the `help` command.
2. **HelpCommand**: A subclass of the Command class. Represents the `help` command, and provides command details when executed.
3. **Nuscents**: The main application class that receives and executes commands. It invokes the `execute()` method of the `HelpCommand`.
4. **UI**: Manages user interface interactions, such as displaying the help menu.

#### II. Component-Level Design
1. **Parser**:  
   The `Parser` class recognizes the user's intention to access the help menu through the `help` keyword.

2. **HelpCommand**:  
   When the `Parser` identifies a `help` command, it instantiates a `HelpCommand` object. This object encapsulates the user's request to view the command instructions.

3. **Nuscents**:  
   Upon receiving the `HelpCommand` object, the `Nuscents` class triggers the `execute()` method of the `HelpCommand`.

4. **UI**:  
   The `UI` class is then responsible for fetching the `HELP_MENU` static string from the `HelpCommand` class and displaying it to the user. This ensures the user receives a comprehensive list of commands available in the application.

#### III. Alternatives Considered
Initially, we pondered over embedding the help details directly within the main application class, `Nuscents`. This would eliminate the need for a separate `HelpCommand` class. However, segregating the `HelpCommand` ensures better modularity, making future expansions or modifications seamless.

### `helpCommand` Usage Scenario

1. **Step 1**: The user launches the application. The initial screen appears.
2. **Step 2**: Unsure of the commands, the user inputs the `help` command.
3. **Step 3**: The application recognizes the command through the `Parser` and creates a `HelpCommand` object.
4. **Step 4**: The `Nuscents` class invokes the `execute()` method of the `HelpCommand`.
5. **Step 5**: The `UI` fetches the `HELP_MENU` string and displays the comprehensive list of commands to the user.


## Product scope

### Target user profile
SOC students at NUS who are tech-savvy, with limited allowance to monitor their finances and expense management
while balancing aspects of university-life, academics and social activities. SOC students are known to be familiar with 
CLI applications, which are often built to be efficient and clutter-free.

### Value proposition
{Describe the value proposition: what problem does it solve?}

## User Stories
Version | As a ... | I want to ... | So that I can ...
-----|--------------------|-----------------------------------------------------------|----------------------------------------------------------
v1.0 | new user | access a help command that lists all actions and examples | I can learn how to use the tracker effectively
v1.0 | university student | add my allowance| I can track how much I get every month
v1.0 | university student | add my expenses| I can keep track of my spending habits
v1.0 | university student | delete allowance entries| I can remove wrong entries
v1.0 | university student | delete expense entries| I can remove wrong entries
v1.0 | university student | view a list of all entries| I can view my all my income and expenses at a glance
v2.0 | university student | add details of income or expenses| I can know why I made that transaction
v2.0 | university student | enquire my net balance| I can see my net balance
v2.0 | university student | edit existing entries| I can correct wrong entries or make updates
v2.0 | university student | create a budget for my living expenses| I can ensure I have enough funds throughout the semester
v2.0 | university student | add details of income or expenses| I can see my expenses on different categories
v2.0 | university student | filter expenses based on categories| I can view my expense on a specific category
v2.0 | university student | filter income based on categories| I can view my income from a specific source
v2.0 | university student | filter expenses based on categories| I can view my expense on a specific category
v2.0 | university student | view details of income or expenses| I can have a better understanding of my financial habit

## Non-Functional Requirements
{Give non-functional requirements}

## Glossary
* *glossary item* - Definition

## Instructions for manual testing
{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}
