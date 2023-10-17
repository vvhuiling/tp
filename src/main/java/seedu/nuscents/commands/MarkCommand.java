package seedu.nuscents.commands;

import seedu.nuscents.data.TransactionList;

public class MarkCommand extends Command {
    private int taskIndex;

    public MarkCommand (int taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public void execute(TransactionList tasks) {
        tasks.markTask(taskIndex);
    }
}
