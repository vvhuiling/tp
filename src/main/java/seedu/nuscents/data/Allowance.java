package seedu.nuscents.data;

import java.util.Date;

public class Allowance extends Transaction {
    public Allowance(String amount, Date date, String description, String additionalInfo) {
        super(amount, date, description, additionalInfo);
    }
}
