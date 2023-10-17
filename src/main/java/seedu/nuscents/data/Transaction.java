package seedu.nuscents.data;

import java.time.LocalDateTime;

/**
 * Represents a Transaction in the TransactionList
 */
public class Transaction {
    private static int count = 0;
    protected boolean isMarked;
    protected String amount;
    protected LocalDateTime date;
    protected String description;
    protected String additionalInfo;

    public Transaction(String description) {
        this.description = description;
        count++;
    }

    public Transaction(String amount, LocalDateTime date, String description) {
        this.amount = amount;
        this.date = date;
        this.description = description;
        count++;
    }

    public Transaction(String amount, LocalDateTime date, String description, String additionalInfo) {
        this.amount = amount;
        this.date = date;
        this.description = description;
        this.additionalInfo = additionalInfo;
        count++;
    }

    public Transaction(String description, int setMark) {
        this.description = description;
        if (setMark == 1) {
            isMarked = true;
        } else if (setMark == 0) {
            isMarked = false;
        }
        count++;
    }

    public void markTask() {
        isMarked = true;
    }

    public void unMarkTask() {
        isMarked = false;
    }

    public boolean getTaskStatus() {
        return isMarked;
    }

    public String getDetails() {
        String mark;
        if (getTaskStatus()){
            mark = "X";
        } else {
            mark = " ";
        }
        return "[" + mark + "] " + description;
    }

    public String getAmount() {
        return amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public static int getTransactionCount() {
        return count;
    }

    /**
     * Decrease the task count by one when a task is deleted.
     */
    public static void decreaseTransactionCountByOne() {
        count--;
    }

}
