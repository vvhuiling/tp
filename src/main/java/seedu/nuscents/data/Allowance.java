package seedu.nuscents.data;

import java.time.LocalDateTime;

public class Allowance extends Transaction {
    public Allowance(String amount, LocalDateTime date, String description, String additionalInfo) {
        super(amount, date, description, additionalInfo);
    }
}
