package seedu.nuscents.storage;

import seedu.nuscents.data.Task;
import seedu.nuscents.data.TaskList;
import seedu.nuscents.data.Todo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.Scanner;


public class Storage {
    private String filePath;

    public Storage (String filePath) {
        this.filePath = filePath;
    }

    /**
     * Reads data from the storage file and return it.
     * @return an arraylist of tasks
     * @throws FileNotFoundException If the storage file does not exist.
     */
    public ArrayList<Task> readDataFromFile() throws FileNotFoundException {
        ArrayList<Task> tasks = new ArrayList<>();
        File file = new File(filePath);
        taskDecoder(file, tasks);
        return tasks;
    }

    /**
     * Decodes the storage data file and store it into the arraylist of tasks.
     * @param file storage data file
     * @param tasks arraylist of tasks
     * @throws FileNotFoundException If the storage data file does not exist.
     */
    private static void taskDecoder(File file, ArrayList<Task> tasks) throws FileNotFoundException {
        Scanner data = new Scanner(file);
        while (data.hasNext()) {
            String taskDetails = data.nextLine();
            char taskType = taskDetails.charAt(0);
            String[] descriptions = taskDetails.split("[|]");
            int isMarked = Integer.parseInt(descriptions[1].trim());
            switch (taskType) {
            case 'T':
                tasks.add(new Todo(descriptions[2].trim(), isMarked));
                break;

            default:
                break;
            }
        }
    }

    /**
     * Writes the data to the storage file.
     * Creates a new file if the file does not exist.
     * @param taskList list of tasks
     * @throws IOException If there were errors converting and/or storing the data to the file.
     */
    public void writeToFile(TaskList taskList) throws IOException {
        File file = new File(filePath);
        FileWriter fw = new FileWriter(file);
        ArrayList<Task> tasks = taskList.getTasks();
        for (Task task : tasks) {
            int markedIndex = encodeTaskStatus(task.getTaskStatus());
            String output = toString(task, markedIndex);
            fw.write(output);
            fw.write("\n");
        }
        fw.close();
    }

    /**
     * Encode task status to integers to be stored in the storage data file.
     * A task marked as done is stored as 1, while a task marked as not done is stored as 0.
     * @param isMarked boolean to indicate if the task is marked as done
     * @return integer indicator of the task status
     */
    private static int encodeTaskStatus(boolean isMarked) {
        if (isMarked) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Converts the task details to a String to be stored in the storage data file.
     * @param task task being converted to String
     * @param markedIndex integer indicator of the task status
     * @return a String object to be stored in the storage data file
     */
    private static String toString(Task task, int markedIndex) {
        if (task instanceof Todo) {
            return "T | " + markedIndex + " | " + task.getDescription();
        } else {
            return null;
        }
    }
}

