package seedu.nuscents.commands;

import seedu.nuscents.data.TransactionList;

public class FindCommand extends Command {
    private String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(TransactionList tasks) {
        tasks.findTask(keyword);
    }
}
