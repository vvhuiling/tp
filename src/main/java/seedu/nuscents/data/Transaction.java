package seedu.nuscents.data;

/**
 * Represents a Transaction in the TransactionList
 */
public class Transaction {
    private static int count = 0;
    protected boolean isMarked;
    protected String description;

    public Transaction(String description) {
        this.description = description;
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

    public String getDescription() {
        return description;
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
