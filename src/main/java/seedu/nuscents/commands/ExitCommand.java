package seedu.nuscents.commands;

import seedu.nuscents.data.TaskList;
import seedu.nuscents.ui.Ui;

public class ExitCommand extends Command {
    @Override
    public void execute(TaskList tasks) {
        Ui.showGoodbyeMessage();
    }

    public static boolean isExit(Command command) {
        return command instanceof ExitCommand;
    }
}
