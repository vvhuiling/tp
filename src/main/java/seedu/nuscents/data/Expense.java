package seedu.nuscents.data;

import java.time.LocalDateTime;

public class Expense extends Transaction {
    public Expense(String amount, LocalDateTime date, String description, String additionalInfo) {
        super(amount, date, description, additionalInfo);
    }
}
