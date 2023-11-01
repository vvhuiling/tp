package seedu.nuscents.commands;

import seedu.nuscents.data.TransactionList;
import seedu.nuscents.data.exception.NuscentsException;
import seedu.nuscents.data.transaction.Allowance;
import seedu.nuscents.data.transaction.Expense;
import seedu.nuscents.ui.Ui;

public class EditCommand extends Command {
    int index;
    private Expense expense;
    private Allowance allowance;
    
    public EditCommand(Expense expense, int index) {
        this.expense = expense;
        this.index = index;
    }
    public EditCommand(Allowance allowance, int index) {
        this.allowance = allowance;
        this.index = index;
    }
    
    @Override
    public void execute(TransactionList transactionList) throws NuscentsException {
        if (expense == null && allowance == null) {
            throw new NuscentsException("Please enter either an expense or allowance to edit");
        } else if (expense != null) {
            transactionList.editTransation(this.index,this.expense);
        } else{
            transactionList.editTransation(this.index,this.allowance);
        }
        Ui.showTransactionList(transactionList);

    }
}
