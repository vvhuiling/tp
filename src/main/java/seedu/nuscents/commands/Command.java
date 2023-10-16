package seedu.nuscents.commands;

import seedu.nuscents.data.TaskList;
import seedu.nuscents.data.exception.NuscentsException;

public abstract class Command {
    /**
     * Executes the command.
     */
    public abstract void execute(TaskList tasks) throws NuscentsException;
}
