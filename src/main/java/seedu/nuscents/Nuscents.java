package seedu.nuscents;

import java.util.Scanner;

public class Nuscents {
    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) {
        String logo = " __   __  __   __   ____   _____ _____ __   __ ________   ____\n"
                    + "|  \\ |  |  |  |  |/     / /   __|     |  \\ |  |__    __|/     /\n"
                    + "|   \\|  |  |  |  |\\   __\\|   /  |   __|   \\|  |  |  |   \\   __\\ \n"
                    + "|       |  |  |  | \\__   |  |   |   __|       |  |  |    \\__   |\n"
                    + "|       |  |__|  |/      |   \\__|     |       |  |  |   /      |\n"
                    + "|__|\\___|________|______/ \\_____|_____|__|\\___|  |__|   |_____/\n";
        System.out.println("Welcome to \n" + logo);
        System.out.println("What is your name?");

        Scanner in = new Scanner(System.in);
        System.out.println("Hello " + in.nextLine());
    }
}
