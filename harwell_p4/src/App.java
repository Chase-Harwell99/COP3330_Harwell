import java.util.Scanner;

public class App {

    private static Scanner selection = new Scanner(System.in);

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
        System.out.println("1) Create a new list");
        System.out.println("2) Edit an existing list");
        System.out.println("3) Exit the program");

        return selection.nextInt();

    }
    private static void ListOperationMenu() {

        System.out.println("\n      List Operation Menu");
        System.out.println("-------------------------------\n");
        System.out.println("1) View current list");
        System.out.println("2) Add a new item");
        System.out.println("3) Edit an item");
        System.out.println("4) Remove an item from list");
        System.out.println("5) Mark an item as completed");
        System.out.println("6) Mark and item as uncompleted");
        System.out.println("7) Save list");
        System.out.println("8) Exit to main menu");

    }

    //makes a new list
    private static void NewList() {
        TaskList n = new TaskList();
        while(true) {
            ListOperationMenu();
            int choice = selection.nextInt();

            switch(choice) {
                case 1: n.getTaskList(); continue;
                case 2: n.processNewTask(); continue;
                case 3: n.editTaskItem(); continue;
                case 4: n.removeTask(); continue;
                case 5: n.markCompletedPrompt(); continue;
                case 6: n.markUncompletedPrompt(); continue;
                case 7: n.saveList(); continue;
                case 8: return;
            }
        }
    }

    //makes a new list and inputs previous tasks from input file
    private static void FileList() {
        System.out.println("Enter the name of the list (without .txt) you would like to load in:");
        selection.nextLine(); //clear input buffer
        String searchFile = (selection.nextLine() + ".txt");
        TaskList f = new TaskList();
        f.loadFile(searchFile);

        while(true) {
            ListOperationMenu();
            int choice = selection.nextInt();

            switch(choice) {
                case 1: f.getTaskList(); continue;
                case 2: f.processNewTask(); continue;
                case 3: f.editTaskItem(); continue;
                case 4: f.removeTask(); continue;
                case 5: f.markCompletedPrompt(); continue;
                case 6: f.markUncompletedPrompt(); continue;
                case 7: f.saveList(); continue;
                case 8: return;
            }
        }
    }
}
