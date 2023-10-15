package seedu.nuscents.commands;

import seedu.nuscents.data.TaskList;

public class UnmarkCommand extends Command {
    private int taskIndex;

    public UnmarkCommand (int taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public void execute(TaskList tasks) {
        tasks.unMarkTask(taskIndex);
    }
}
