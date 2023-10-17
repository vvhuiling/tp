package seedu.nuscents.commands;

import seedu.nuscents.data.TransactionList;

public class UnmarkCommand extends Command {
    private int taskIndex;

    public UnmarkCommand (int taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public void execute(TransactionList tasks) {
        tasks.unMarkTask(taskIndex);
    }
}
