package seedu.nuscents.parser;

import seedu.nuscents.commands.*;
import seedu.nuscents.data.Task;
import seedu.nuscents.data.Todo;
import seedu.nuscents.data.exception.NuscentsException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static seedu.nuscents.commands.ListOfCommands.COMMAND_BYE;
import static seedu.nuscents.commands.ListOfCommands.COMMAND_LIST;
import static seedu.nuscents.commands.ListOfCommands.COMMAND_MARK;
import static seedu.nuscents.commands.ListOfCommands.COMMAND_UNMARK;
import static seedu.nuscents.commands.ListOfCommands.COMMAND_TODO;
import static seedu.nuscents.commands.ListOfCommands.COMMAND_DELETE;
import static seedu.nuscents.commands.ListOfCommands.COMMAND_FIND;
import static seedu.nuscents.commands.ListOfCommands.COMMAND_HELP;

import static seedu.nuscents.ui.Messages.MESSAGE_INVALID_INDEX;
import static seedu.nuscents.ui.Messages.MESSAGE_INVALID_DATE;
import static seedu.nuscents.ui.Messages.MESSAGE_EMPTY_TODO;
import static seedu.nuscents.ui.Messages.MESSAGE_EMPTY_INDEX;
import static seedu.nuscents.ui.Messages.MESSAGE_EMPTY_KEYWORD;

public class Parser {
    private static final String DATE_TIME_PATTERN1 = "\\d{1,2}/\\d{1,2}/\\d{4}\\s+\\d{4}"; // dd/mm/yyyy 1500
    private static final String DATE_TIME_PATTERN2 = "\\d{4}/\\d{1,2}/\\d{1,2}\\s+\\d{4}"; // yyyy/mm/dd 1500
    private static final String DATE_TIME_PATTERN3 = "\\d{1,2}-\\d{1,2}-\\d{4}\\s+\\d{4}"; // dd-mm-yyyy 1500
    private static final String DATE_TIME_PATTERN4 = "\\d{4}-\\d{1,2}-\\d{1,2}\\s+\\d{4}"; // yyyy-mm-dd 1500

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
            switch (commandType){
            case COMMAND_BYE:
                return new ExitCommand();
            case COMMAND_LIST:
                return new ListCommand();
            case COMMAND_MARK:
                return new MarkCommand(parseTaskIndex(arguments));
            case COMMAND_UNMARK:
                return new UnmarkCommand(parseTaskIndex(arguments));
            case COMMAND_TODO:
                return new AddCommand(parseTodo(arguments));
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
            return "d/M/yyyy HHmm";
        } else if (date.matches(DATE_TIME_PATTERN2)) {
            return "yyyy/M/d HHmm";
        } else if (date.matches(DATE_TIME_PATTERN3)) {
            return "d-M-yyyy HHmm";
        } else if (date.matches(DATE_TIME_PATTERN4)) {
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

    public static Todo parseTodo(String arguments) throws NuscentsException {
        if (arguments == null) {
            throw new NuscentsException(MESSAGE_EMPTY_TODO);
        } else {
            return new Todo(arguments);
        }
    }

    public static int parseTaskIndex(String arguments) throws IndexOutOfBoundsException,
            NuscentsException {
        if (arguments == null) {
            throw new NuscentsException(MESSAGE_EMPTY_INDEX);
        }
        int taskIndex = Integer.parseInt(arguments);
        if (taskIndex > Task.getTaskCount() || taskIndex <= 0) {
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
}

