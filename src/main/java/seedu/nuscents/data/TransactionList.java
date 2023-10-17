package seedu.nuscents.data;

import seedu.nuscents.ui.Ui;

import java.util.ArrayList;

import static seedu.nuscents.ui.Messages.LINE;

public class TransactionList {
    private ArrayList<Transaction> transactions;

    public TransactionList() {
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

    public void findTask(String keyword) {
        ArrayList<Transaction> results = new ArrayList<>();
        boolean isFound = false;
        for (Transaction transaction : transactions) {
            if (transaction.getDescription().contains(keyword.toLowerCase())) {
                isFound = true;
                results.add(transaction);
            }
        }
        System.out.println(LINE);
        if (isFound) {
            int resultCount = 1;
            System.out.println("Here are the matching tasks in your list:");
            for (Transaction transaction : results) {
                System.out.println(resultCount + ". " + transaction.getDescription());
            }
        } else {
            System.out.println("No matching tasks are found :/");
        }
        System.out.println(LINE);
    }

    public void viewTransaction(int transactionIndex) {
        Transaction transaction = transactions.get(transactionIndex-1);
        Ui.showTransactionViewMessage(transaction);
    }
}

