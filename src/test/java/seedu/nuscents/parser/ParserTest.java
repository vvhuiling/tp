package seedu.nuscents.parser;

import org.junit.jupiter.api.Test;
import seedu.nuscents.commands.AddCommand;
import seedu.nuscents.commands.Command;
import seedu.nuscents.data.Allowance;
import seedu.nuscents.data.Expense;
import seedu.nuscents.data.exception.NuscentsException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

public class ParserTest {

    @Test
    public void parseAllowance_validInput_success() throws NuscentsException {
        String arguments = "/amt 100 /date 15-10-2023 1500 /desc Birthday Gift /note From friends";
        Allowance allowance = Parser.parseAllowance(arguments);
        assertEquals("100", allowance.getAmount());
        assertEquals("Birthday Gift", allowance.getDescription());
        assertEquals("From friends", allowance.getAdditionalInfo());
        LocalDateTime expectedDate = LocalDateTime.parse("15-10-2023 1500", DateTimeFormatter.ofPattern("d-M-yyyy HHmm"));
        assertEquals(expectedDate, allowance.getDate());
    }

    @Test
    public void parseExpense_validInput_success() throws NuscentsException {
        String arguments = "/amt 50 /date 16-10-2023 1700 /desc Dinner /note Alone";
        Expense expense = Parser.parseExpense(arguments);
        assertEquals("50", expense.getAmount());
        assertEquals("Dinner", expense.getDescription());
        assertEquals("Alone", expense.getAdditionalInfo());
        LocalDateTime expectedDate = LocalDateTime.parse("16-10-2023 1700", DateTimeFormatter.ofPattern("d-M-yyyy HHmm"));
        assertEquals(expectedDate, expense.getDate());
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
        String input = "allowance /amt 100 /date 15/10/2023 1500 /desc Lunch";
        Exception exception = assertThrows(NuscentsException.class, () -> {
            Parser.parseCommand(input, null);
        });
        assertEquals("OOPS!!! The format of the date is invalid.", exception.getMessage());
    }

    @Test
    public void parseExpense_invalidDateTime_exceptionThrown() {
        String input = "expense /amt 50 /date 16.10.2023 1700 /desc Dinner";
        Exception exception = assertThrows(NuscentsException.class, () -> {
            Parser.parseCommand(input, null);
        });
        assertEquals("OOPS!!! The format of the date is invalid.", exception.getMessage());
    }
}