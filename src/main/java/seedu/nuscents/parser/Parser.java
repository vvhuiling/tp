package seedu.nuscents.parser;

import seedu.nuscents.commands.Command;
import seedu.nuscents.commands.ExitCommand;
import seedu.nuscents.commands.ListCommand;
import seedu.nuscents.commands.AddCommand;
import seedu.nuscents.commands.DeleteCommand;
import seedu.nuscents.commands.FindCommand;
import seedu.nuscents.commands.HelpCommand;
import seedu.nuscents.commands.InvalidCommand;


import seedu.nuscents.data.Transaction;
import seedu.nuscents.data.Allowance;
import seedu.nuscents.data.Expense;
import seedu.nuscents.data.exception.NuscentsException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static seedu.nuscents.commands.ListOfCommands.COMMAND_EXIT;
import static seedu.nuscents.commands.ListOfCommands.COMMAND_LIST;
import static seedu.nuscents.commands.ListOfCommands.COMMAND_ALLOWANCE;
import static seedu.nuscents.commands.ListOfCommands.COMMAND_EXPENSE;
import static seedu.nuscents.commands.ListOfCommands.COMMAND_DELETE;
import static seedu.nuscents.commands.ListOfCommands.COMMAND_FIND;
import static seedu.nuscents.commands.ListOfCommands.COMMAND_HELP;

import static seedu.nuscents.ui.Messages.MESSAGE_EMPTY_ALLOWANCE;
import static seedu.nuscents.ui.Messages.MESSAGE_EMPTY_EXPENSE;
import static seedu.nuscents.ui.Messages.MESSAGE_EMPTY_INDEX;
import static seedu.nuscents.ui.Messages.MESSAGE_EMPTY_KEYWORD;
import static seedu.nuscents.ui.Messages.MESSAGE_INVALID_DATE;
import static seedu.nuscents.ui.Messages.MESSAGE_INVALID_INDEX;

public class Parser {
    private static final String DATE_TIME_PATTERN1 = "\\d{1,2}-\\d{1,2}-\\d{4}\\s+\\d{4}"; // dd-mm-yyyy 1500
    private static final String DATE_TIME_PATTERN2 = "\\d{4}-\\d{1,2}-\\d{1,2}\\s+\\d{4}"; // yyyy-mm-dd 1500
    private static final String AMT_PATTERN = "/amt ([^/]+)";
    private static final String DATE_PATTERN = "/date ([^/]+)";
    private static final String DESC_PATTERN = "/desc ([^/]+)";
    private static final String NOTE_PATTERN = "/note ([^/]+)";

    public static <TaskList> Command parseCommand(String text, TaskList tasks) throws NuscentsException {
        String[] commandTypeAndArgs = text.split(" ", 2);
        String commandType = commandTypeAndArgs[0];
        String arguments;
        if (commandTypeAndArgs.length > 1) {
            arguments = commandTypeAndArgs[1];
        } else {
            arguments = null;
        }
        try {
            switch (commandType) {
            case COMMAND_EXIT:
                return new ExitCommand();
            case COMMAND_LIST:
                return new ListCommand();
            case COMMAND_ALLOWANCE:
                return new AddCommand(parseAllowance(arguments));
            case COMMAND_EXPENSE:
                return new AddCommand(parseExpense(arguments));
            case COMMAND_DELETE:
                return new DeleteCommand(parseTaskIndex(arguments));
            case COMMAND_FIND:
                return new FindCommand(parseFind(arguments));
            case COMMAND_HELP:
                return new HelpCommand();
            default:
                return new InvalidCommand();
            }
        } catch (NuscentsException e) {
            throw e;
        }
    }

    private static String dateTimePatternValidation(String date) throws NuscentsException {
        if (date.matches(DATE_TIME_PATTERN1)) {
            return "d-M-yyyy HHmm";
        } else if (date.matches(DATE_TIME_PATTERN2)) {
            return "yyyy-M-d HHmm";
        } else {
            throw new NuscentsException(MESSAGE_INVALID_DATE);
        }
    }

    private static LocalDateTime parseDate(String date, String format, DateTimeFormatter formatter)
            throws NuscentsException {
        String separator;
        if (format.contains("-")) {
            separator = "-";
        } else {
            separator = "/";
        }
        String[] dateMonthYear = date.split(separator);
        if (Integer.parseInt(dateMonthYear[1]) > 12) {
            throw new NuscentsException(MESSAGE_INVALID_DATE);
        }
        return LocalDateTime.parse(date, formatter);
    }

    /**
     * Parsers arguments in the context of adding an allowance.
     *
     * @param arguments full command argument string
     * @return a {@link Allowance} object
     * @throws NuscentsException If the description of the allowance is empty.
     */
    public static Allowance parseAllowance(String arguments) throws NuscentsException {
        if (arguments == null) {
            throw new NuscentsException(MESSAGE_EMPTY_ALLOWANCE);
        } else {
            String amount = extractValue(arguments, AMT_PATTERN, false);
            String date = extractValue(arguments, DATE_PATTERN, false);
            String description = extractValue(arguments, DESC_PATTERN, false);
            String additionalInformation = extractValue(arguments, NOTE_PATTERN, true);
            String format = dateTimePatternValidation(date);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
            LocalDateTime formattedDate = parseDate(date, format, formatter);
            return new Allowance(amount, formattedDate, description, additionalInformation);
        }
    }

    /**
     * Parsers arguments in the context of adding an expense.
     *
     * @param arguments full command argument string
     * @return a {@link Expense} object
     * @throws NuscentsException If the description of the allowance is empty.
     */
    public static Expense parseExpense(String arguments) throws NuscentsException {
        if (arguments == null) {
            throw new NuscentsException(MESSAGE_EMPTY_EXPENSE);
        } else {
            String amount = extractValue(arguments, AMT_PATTERN, false);
            String date = extractValue(arguments, DATE_PATTERN, false);
            String description = extractValue(arguments, DESC_PATTERN, false);
            String additionalInformation = extractValue(arguments, NOTE_PATTERN, true);
            String format = dateTimePatternValidation(date);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
            LocalDateTime formattedDate = parseDate(date, format, formatter);
            return new Expense(amount, formattedDate, description, additionalInformation);
        }
    }

    public static int parseTaskIndex(String arguments) throws IndexOutOfBoundsException,
            NuscentsException {
        if (arguments == null) {
            throw new NuscentsException(MESSAGE_EMPTY_INDEX);
        }
        int taskIndex = Integer.parseInt(arguments);
        if (taskIndex > Transaction.getTransactionCount() || taskIndex <= 0) {
            throw new IndexOutOfBoundsException(MESSAGE_INVALID_INDEX);
        }
        return taskIndex;
    }

    public static String parseFind(String arguments) throws NuscentsException {
        if (arguments == null) {
            throw new NuscentsException(MESSAGE_EMPTY_KEYWORD);
        } else {
            return arguments;
        }
    }

    private static String extractValue(String input, String pattern, boolean isOptional) throws NuscentsException {
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(pattern);
        java.util.regex.Matcher m = p.matcher(input);

        if (m.find()) {
            return m.group(1).trim();
        } else if (!isOptional) {
            throw new NuscentsException(MESSAGE_EMPTY_ALLOWANCE);
        }
        return "";
    }
}
