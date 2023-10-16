package seedu.nuscents.commands;


import seedu.nuscents.data.TaskList;
import seedu.nuscents.ui.Ui;

public class HelpCommand extends Command {
    @Override
    public void execute(TaskList tasks) {
        Ui.showHelpMenu();
    }
}
