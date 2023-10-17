package seedu.nuscents.data;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Represents a Transaction in the TransactionList
 */
public class Transaction {
    private static int count = 0;
    protected String amount;
    protected Date date;
    protected String description;
    protected String additionalInfo;

    public Transaction(String description) {
        this.description = description;
        count++;
    }

    public Transaction(String amount, Date date, String description) {
        this.amount = amount;
        this.date = date;
        this.description = description;
        count++;
    }

    public Transaction(String amount, Date date, String description, String additionalInfo) {
        this.amount = amount;
        this.date = date;
        this.description = description;
        this.additionalInfo = additionalInfo;
        count++;
    }

    public String getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public String getFormattedDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM, yyyy");
        return formatter.format(date);
    }

    public String getDescription() {
        return description;
    }
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public String toString() {
        return getAmount() + " | " + getFormattedDate() + " | " + getDescription() + " | " + getAdditionalInfo();
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
