package seedu.nuscents.ui;

public class Messages {
    public static final String LINE = "-------------------------------------------------------------------------------";
    public static final String LOGO = " __   __  __   __   ____   _____ _____ __   __ ________   ____\n"
            + "|  \\ |  |  |  |  |/     / /   __|     |  \\ |  |__    __|/     /\n"
            + "|   \\|  |  |  |  |\\   __\\|   /  |   __|   \\|  |  |  |   \\   __\\\n"
            + "|       |  |  |  | \\__   |  |   |   __|       |  |  |    \\__   |\n"
            + "|       |  |__|  |/      |   \\__|     |       |  |  |   /      |\n"
            + "|__|\\___|________|______/ \\_____|_____|__|\\___|  |__|   |_____/\n";
    public static final String MESSAGE_EXIT = "Thank you for using NUScents. Hope to see you again soon!";
    public static final String HELP_MENU =
            "- `list` :" + System.lineSeparator() +
                    "    Show a list of all entries." + System.lineSeparator() +
                    "- `allowance /amt AMOUNT /date DATE /desc DESCRIPTION " +
                    "[/note ADDITIONAL_INFORMATION]` :" + System.lineSeparator() +
                    "    Add an allowance." + System.lineSeparator() +
                    "- `expense /amt AMOUNT /date DATE /desc DESCRIPTION " +
                    "[/note ADDITIONAL_INFORMATION]` :" + System.lineSeparator() +
                    "    Add an expense." + System.lineSeparator() +
                    "- `delete ENTRY_NUMBER` :" + System.lineSeparator() +
                    "    Delete an entry." + System.lineSeparator() +
                    "- `view ENTRY_NUMBER` :" + System.lineSeparator() +
                    "    View an entry detail." + System.lineSeparator() +
                    "- `exit` :" + System.lineSeparator() +
                    "    Exit the program.";
    public static final String MESSAGE_UNKNOWN = "OOPS!!! I'm sorry, but I don't know what that means :-(";
    public static final String MESSAGE_MARK = "Nice! I've marked this task as done:";
    public static final String MESSAGE_UNMARK = "OK, I've marked this task as not done yet:";
    public static final String MESSAGE_EMPTY_TODO = "OOPS!!! The description of a todo cannot be empty.";
    public static final String MESSAGE_EMPTY_ALLOWANCE = "OOPS!!! Invalid input format for adding an allowance.";
    public static final String MESSAGE_EMPTY_EXPENSE = "OOPS!!! Invalid input format for adding an expense.";
    public static final String MESSAGE_EMPTY_BY = "OOPS!!! The /by parameter of a deadline cannot be empty.";
    public static final String MESSAGE_EMPTY_EVENT = "OOPS!!! The description of an event cannot be empty.";
    public static final String MESSAGE_EMPTY_FROM = "OOPS!!! The /from parameter of an event cannot be empty.";
    public static final String MESSAGE_EMPTY_TO = "OOPS!!! The /to parameter of an event cannot be empty.";
    public static final String MESSAGE_INVALID_DATE = "OOPS!!! The format of the date is invalid.";
    public static final String MESSAGE_INVALID_INDEX = "OOPS!!! This is an invalid transaction index.";
    public static final String MESSAGE_INVALID_INDEX_ARGUMENTS = "OOPS!!! The input should consist only of digits.";
    public static final String MESSAGE_EMPTY_LIST = "You have not made any transactions!";
    public static final String MESSAGE_EMPTY_KEYWORD = "OOPS!!! The keyword of a find command cannot be empty.";
    public static final String MESSAGE_EMPTY_INDEX = "OOPS!!! The index of a delete/view command cannot be empty.";
    public static final String MESSAGE_FATAL_ERROR = "OOPS!!! Fatal error occurred...";
    public static final String MESSAGE_READ_ERROR = "OOPS!!! A problem occurred while reading the data file.";
}
