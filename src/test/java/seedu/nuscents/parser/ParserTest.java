package seedu.nuscents.parser;

import org.junit.jupiter.api.Test;
import seedu.nuscents.data.Transaction;
import seedu.nuscents.data.Allowance;
import seedu.nuscents.data.Expense;
import seedu.nuscents.data.exception.NuscentsException;
import seedu.nuscents.commands.Command;
import seedu.nuscents.commands.HelpCommand;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParserTest {

    @Test
    public void parseAllowance_validInput_success() throws NuscentsException, ParseException {
        String arguments = "/amt 100 /date 15-10-2023 /desc Birthday Gift /note From friends";
        Allowance allowance = Parser.parseAllowance(arguments);
        assertEquals(100.0, allowance.getAmount());
        SimpleDateFormat formatter = new SimpleDateFormat("d-M-yyyy");
        String formattedDate = formatter.format(allowance.getDate());
        assertEquals("15-10-2023", formattedDate);
        assertEquals("Birthday Gift", allowance.getDescription());
        assertEquals("From friends", allowance.getAdditionalInfo());
    }

    @Test
    public void parseExpense_validInput_success() throws NuscentsException, ParseException {
        String arguments = "/amt 50 /date 16-10-2023 /desc Dinner /note Alone";
        Expense expense = Parser.parseExpense(arguments);
        assertEquals(50.0, expense.getAmount());
        SimpleDateFormat formatter = new SimpleDateFormat("d-M-yyyy");
        String formattedDate = formatter.format(expense.getDate());
        assertEquals("16-10-2023", formattedDate);
        assertEquals("Dinner", expense.getDescription());
        assertEquals("Alone", expense.getAdditionalInfo());
    }

    @Test
    public void parseAllowance_missingArguments_exceptionThrown() {
        String input = "allowance /amt 100 /desc Pocket Money";
        Exception exception = assertThrows(NuscentsException.class, () -> {
            Parser.parseCommand(input, null);
        });
        assertEquals("OOPS!!! Invalid input format for adding an allowance.", exception.getMessage());
    }

    @Test
    public void parseExpense_missingArguments_exceptionThrown() {
        String input = "expense /amt 50 /desc Dinner";
        Exception exception = assertThrows(NuscentsException.class, () -> {
            Parser.parseCommand(input, null);
        });
        assertEquals("OOPS!!! Invalid input format for adding an expense.", exception.getMessage());
    }

    @Test
    public void parseAllowance_invalidDateTime_exceptionThrown() {
        String input = "allowance /amt 100 /date 15/10/2023 /desc Lunch";
        Exception exception = assertThrows(NuscentsException.class, () -> {
            Parser.parseCommand(input, null);
        });
        assertEquals("OOPS!!! The format of the date is invalid.", exception.getMessage());
    }

    @Test
    public void parseExpense_invalidDateTime_exceptionThrown() {
        String input = "expense /amt 50 /date 16.10.2023 /desc Dinner";
        Exception exception = assertThrows(NuscentsException.class, () -> {
            Parser.parseCommand(input, null);
        });
        assertEquals("OOPS!!! The format of the date is invalid.", exception.getMessage());
    }

    @Test
    public void parseTaskIndex_validInput_success() throws NuscentsException, IndexOutOfBoundsException {
        String input = "1";
        Transaction transaction = new Transaction("test description");
        assertEquals(1, Parser.parseTaskIndex(input));
    }

    @Test
    public void parseTaskIndex_outOfBoundsIndex_exceptionThrown() {
        String input = "-6";
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            Parser.parseTaskIndex(input);
        });
        assertEquals("OOPS!!! This is an invalid transaction index.", exception.getMessage());
    }

    @Test
    public void parseTaskIndex_invalidArgument_exceptionThrown() {
        String input = "InvalidArgument";
        Exception exception = assertThrows(NuscentsException.class, () -> {
            Parser.parseTaskIndex(input);
        });
        assertEquals("OOPS!!! The input should consist only of digits.", exception.getMessage());
    }

    @Test
    public void parseTaskIndex_emptyArgument_exceptionThrown() {
        String input = null;
        Exception exception = assertThrows(NuscentsException.class, () -> {
            Parser.parseTaskIndex(input);
        });
        assertEquals("OOPS!!! The index of a delete/view command cannot be empty.", exception.getMessage());
    }

    @Test
    public void parseCommand_helpCommandWithCorrectInput_returnsHelpCommand() throws Exception {
        Command result = Parser.parseCommand("help", null);
        assertTrue(result instanceof HelpCommand);
    }

    @Test
    public void parseCommand_helpCommandWithIncorrectInput_throwsException() {
        Exception exceptionWithSpace = assertThrows(NuscentsException.class, () -> {
            Parser.parseCommand("help ", null);
        });
        assertEquals("OOPS!!! The correct format is 'help' alone.", exceptionWithSpace.getMessage());

        Exception exceptionWithExtraChars = assertThrows(NuscentsException.class, () -> {
            Parser.parseCommand("help extra", null);
        });
        assertEquals("OOPS!!! The correct format is 'help' alone.", exceptionWithExtraChars.getMessage());
    }
}
