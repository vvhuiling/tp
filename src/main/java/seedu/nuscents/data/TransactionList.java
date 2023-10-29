package seedu.nuscents.data;

import seedu.nuscents.data.transaction.Transaction;
import seedu.nuscents.data.transaction.TransactionCategory;
import seedu.nuscents.ui.Ui;

import java.util.ArrayList;


public class TransactionList {
    private ArrayList<Transaction> transactions;

    public TransactionList() {
        transactions = new ArrayList<Transaction>();
    }

    public TransactionList(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        Ui.showTransactionAddedMessage(transaction);
    }

    public void deleteTransaction(int transactionIndex) {
        Transaction transaction = transactions.get(transactionIndex-1);
        transactions.remove(transaction);
        Transaction.decreaseTransactionCountByOne();
        Ui.showTransactionRemovedMessage(transaction);
    }

    public void viewTransaction(int transactionIndex) {
        Transaction transaction = transactions.get(transactionIndex-1);
        Ui.showTransactionViewMessage(transaction);
    }

    public void filterTransaction(TransactionCategory category) {
        ArrayList<Transaction> filteredTransactions = new ArrayList<>();
        boolean isFound = false;

        for (Transaction transaction : transactions) {
            if (transaction.getCategory() == category) {
                filteredTransactions.add(transaction);
                isFound = true;
            }
        }

        if (isFound) {
            Ui.showFilterMessage(filteredTransactions, category);
            System.out.println("Filtered transactions in the category " + category + ":");
            int transactionCount = 1;
            for (Transaction transaction : filteredTransactions) {
                System.out.println(transactionCount + ". " + transaction.getDescription());
                transactionCount++;
            }
        } else {
            Ui.showFilterNotFoundMessage(category);
        }

    }

}

