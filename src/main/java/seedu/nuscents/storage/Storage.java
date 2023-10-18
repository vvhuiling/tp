package seedu.nuscents.storage;

import seedu.nuscents.data.Allowance;
import seedu.nuscents.data.Expense;
import seedu.nuscents.data.Transaction;
import seedu.nuscents.data.TransactionList;
import seedu.nuscents.ui.Ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Storage {
    private static final Logger logger = Logger.getLogger(Storage.class.getName());
    private String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public String getPath() {
        return filePath;
    }

    /**
     * Reads data from the storage file and return it.
     *
     * @return an arraylist of tasks
     * @throws FileNotFoundException If the storage file does not exist.
     */
    public ArrayList<Transaction> readDataFromFile() throws FileNotFoundException, ParseException {
        ArrayList<Transaction> transactions = new ArrayList<>();
        File file = new File(filePath);
        logger.log(Level.INFO, "Creating a File object to read data from file");
        try {
            transactionDecoder(file, transactions);
        } catch (ParseException e) {
            logger.log(Level.WARNING, "Something went wrong when reading data from file");
            Ui.showLine();
            System.out.println("Something went wrong: " + e.getMessage());
            Ui.showLine();
        }
        logger.log(Level.INFO, "All data successfully loaded");
        return transactions;
    }

    /**
     * Decodes the storage data file and store it into the arraylist of tasks.
     *
     * @param file storage data file
     * @param transactions arraylist of tasks
     * @throws FileNotFoundException If the storage data file does not exist.
     */
    private static void transactionDecoder(File file, ArrayList<Transaction> transactions)
            throws FileNotFoundException, ParseException {
        Scanner data = new Scanner(file);
        while (data.hasNext()) {
            String transactionDetails = data.nextLine();
            char transactionType = transactionDetails.charAt(0);
            String[] columns;
            String amount = "";
            Date date;
            String description = "";
            String note = "";
            SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM, yyyy");
            switch (transactionType) {
            case 'A':
                columns = transactionDetails.split("\\s*\\|\\s*");
                amount = columns[1];
                date = formatter.parse(columns[2]);
                description = columns[3];
                note = "";
                if (columns.length > 4) {
                    note = columns[4];
                }
                transactions.add(new Allowance(amount, date, description, note));
                break;

            case 'E':
                columns = transactionDetails.split("\\s*\\|\\s*");
                amount = columns[1];
                date = formatter.parse(columns[2]);
                description = columns[3];
                note = "";
                if (columns.length > 4) {
                    note = columns[4];
                }
                transactions.add(new Expense(amount, date, description, note));
                break;

            default:
                break;
            }
        }
    }

    /**
     * Writes the data to the storage file.
     * Creates a new file if the file does not exist.
     *
     * @param transactionList list of tasks
     * @throws IOException If there were errors converting and/or storing the data to the file.
     */
    public void writeToFile(TransactionList transactionList) throws IOException {
        File file = new File(filePath);
        FileWriter fw = new FileWriter(file);
        logger.log(Level.INFO, "Creating a File object to write data to file");
        ArrayList<Transaction> transactions = transactionList.getTransactions();
        for (Transaction transaction : transactions) {
            logger.log(Level.INFO, "Converting info to storage format");
            String output = toStorageFormat(transaction);
            fw.write(output);
            fw.write("\n");
        }
        logger.log(Level.INFO, "Transaction data successfully stored");
        fw.close();
    }

    private static String toStorageFormat(Transaction transaction) {
        if (transaction instanceof Allowance) {
            return "A" + " | " + transaction.toString();

        } else if (transaction instanceof Expense) {
            return "E" + " | " + transaction.toString();

        } else {
            logger.log(Level.WARNING, "Invalid transaction format");
            return null;
        }
    }
}

