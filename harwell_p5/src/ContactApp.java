import java.util.Scanner;

public class ContactApp {

    private static final Scanner selection = new Scanner(System.in);

    public static void main(String[] args) {
        boolean menu = true;
        while(menu) {
            switch (MainMenu()) {
                case 1 -> {
                    NewList();
                }
                case 2 -> {
                    FileList();
                }
                case 3 -> {
                    menu = false;
                }
                default -> {
                    System.out.println("You entered an invalid choice. Please enter a valid choice.");
                    menu = true;
                }
            }
        }
    }

    private static int MainMenu() {
        System.out.println("       Main Menu         ");
        System.out.println("-----------------------\n");
        System.out.println("1) Create a new contact");
        System.out.println("2) Edit an existing list of contacts");
        System.out.println("3) Quit to main menu");

        return selection.nextInt();

    }
    private static void ListOperationMenu() {

        System.out.println("\n      List Operation Menu");
        System.out.println("-------------------------------\n");
        System.out.println("1) View current list");
        System.out.println("2) Add a new item");
        System.out.println("3) Edit an item");
        System.out.println("4) Remove an item from list");
        System.out.println("5) Save list");
        System.out.println("6) Quit to Contact Manager");

    }

    //makes a new list
    private static void NewList() {
        ContactList n = new ContactList();
        while(true) {
            ListOperationMenu();
            int choice = selection.nextInt();

            switch(choice) {
                case 1: n.getTaskList(); continue;
                case 2: n.processNewTask(); continue;
                case 3: n.editTaskItem(); continue;
                case 4: n.removeTask(); continue;
                case 5: n.saveList(); continue;
                case 6: return;
            }
        }
    }

    //makes a new list and inputs previous tasks from input file
    private static void FileList() {
        System.out.println("Enter the name of the list (without .txt) you would like to load in:");
        selection.nextLine(); //clear input buffer
        String searchFile = (selection.nextLine() + ".txt");
        ContactList f = new ContactList();
        f.loadFile(searchFile);

        while(true) {
            ListOperationMenu();
            int choice = selection.nextInt();

            switch(choice) {
                case 1: f.getTaskList(); continue;
                case 2: f.processNewTask(); continue;
                case 3: f.editTaskItem(); continue;
                case 4: f.removeTask(); continue;
                case 5: f.saveList(); continue;
                case 6: return;
            }
        }
    }
}
