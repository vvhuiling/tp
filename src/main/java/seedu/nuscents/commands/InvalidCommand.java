package seedu.nuscents.commands;


import seedu.nuscents.data.TaskList;
import seedu.nuscents.data.exception.NuscentsException;

import static seedu.nuscents.ui.Messages.MESSAGE_UNKNOWN;

public class InvalidCommand extends Command {
    @Override
    public void execute(TaskList tasks) throws NuscentsException {
        throw new NuscentsException(MESSAGE_UNKNOWN);
    }
}
