package seedu.nuscents.commands;

import seedu.nuscents.data.Task;
import seedu.nuscents.data.TaskList;

public class AddCommand extends Command {
    private Task task;

    public AddCommand(Task task) {
        this.task = task;
    }

    @Override
    public void execute(TaskList tasks) {
        tasks.addTask(task);
    }
}
