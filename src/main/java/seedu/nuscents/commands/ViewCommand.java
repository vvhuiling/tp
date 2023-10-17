package seedu.nuscents.commands;

import seedu.nuscents.data.TransactionList;
import seedu.nuscents.ui.Ui;

public class ViewCommand extends Command {
    private int taskIndex;

    public ViewCommand (int taskIndex) {
        this.taskIndex = taskIndex;
    }
    @Override
    public void execute(TransactionList tasks) {
        tasks.viewTransaction(taskIndex);
    }
}
