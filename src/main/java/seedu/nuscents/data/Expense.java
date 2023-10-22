package seedu.nuscents.data;

import java.util.Date;

public class Expense extends Transaction {
    public Expense(float amount, Date date, String description, String additionalInfo) {
        super(amount, date, description, additionalInfo);
    }
}
