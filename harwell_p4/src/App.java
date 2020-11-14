import java.io.IOException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class App {

    private static Scanner selection = new Scanner(System.in);
    private TaskList tasks;

    public App() {
        tasks = new TaskList();
    }


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

    private static void NewList() {
        App n = new App();
        while(true) {
            ListOperationMenu();
            int choice = selection.nextInt();

            switch(choice) {
                case 1: n.getTaskList(); continue;
                case 2: n.processNewTask(); continue;
                case 3: n.editTaskItem(); continue;
                case 4: n.removeTask(); continue;
                case 5: n.markCompleted(); continue;
                case 6: n.markUncompleted(); continue;
                case 7: n.saveList(); continue;
                case 8: return;
            }
        }
    }

    private static void FileList() {
        System.out.println("Enter the name of the list (without .txt) you would like to load in:");
        selection.nextLine(); //clear input buffer
        String searchFile = (selection.nextLine() + ".txt");
        App f = new App();
        f.loadFile(searchFile);

        while(true) {
            ListOperationMenu();
            int choice = selection.nextInt();

            switch(choice) {
                case 1: f.getTaskList(); continue;
                case 2: f.processNewTask(); continue;
                case 3: f.editTaskItem(); continue;
                case 4: f.removeTask(); continue;
                case 5: f.markCompleted(); continue;
                case 6: f.markUncompleted(); continue;
                case 7: f.saveList(); continue;
                case 8: return;
            }
        }
    }

    private void getTaskList() {
        System.out.println("   Current Tasks   ");
        System.out.println("-------------------\n");
        tasks.getList();
    }

    private void getCompletedTaskList() {
        System.out.println("    Completed Tasks    ");
        System.out.println("-----------------------");
        tasks.getCompletedList();
    }

    private void getIncompleteTaskList() {
        System.out.println("    Incomplete Tasks    ");
        System.out.println("-----------------------");
        tasks.getIncompleteList();
    }

    private void processNewTask(){
        TaskItem task = getNewTaskItem();
        storeNewTask(task);
    }

    private void editTaskItem() {
        getTaskList();
        System.out.println("Enter the index of the task you would like to change.");
        int index = selection.nextInt();
        tasks.editListItem(index,getNewTaskItem());
        getTaskList();
    }

    private void removeTask() {
        getTaskList();
        System.out.println("Enter the index of the task you wish to remove from the list");
        int removeIndex = selection.nextInt();
        tasks.removeListItem(removeIndex);
        getTaskList();
    }

    private void markCompleted() {
        getIncompleteTaskList();
        System.out.println("Enter the index of the task you would like to mark as complete.");
        int completeIndex = selection.nextInt();
        tasks.markCompleted(completeIndex);
    }

    private void markUncompleted() {
        getCompletedTaskList();
        System.out.println("Enter the index of the task that you would like to unmark as completed.");
        int incompleteIndex = selection.nextInt();
        tasks.markUncompleted(incompleteIndex);
    }

    private void storeNewTask(TaskItem task) {
        tasks.add(task);
    }

    private void processFileTaskItems(String title, String description, String date) {

        TaskItem task = null;

        task = new TaskItem(title, description, date, false);

        tasks.add(task);
    }

    private TaskItem getNewTaskItem() {
        TaskItem task = null;
        while(true) {
            try {
                selection.nextLine(); //clear input buffer
                String title = getTitle();
                String description = getDescription();
                String date = getDate();

                task = new TaskItem(title, description, date, false);
                break;
            } catch (InvalidTitleException ex) {
                System.out.println("Titles must be at least 1 character in length. Please re-enter task info.");
            } catch (InvalidDateException ex) {
                System.out.println("All dates must follow the format YYYY-MM-DD. Please re-enter task info.");
            }
        }
        return task;
    }

    private void saveList() {
        selection.nextLine();
        System.out.println("What would you like to name your save file? Do not include .txt in your name.");
        String filename = (selection.nextLine() + ".txt");
        tasks.save(filename);
        System.out.printf("Your list was saved as %s\n\n", filename);

    }

    private String getTitle() {
        System.out.println("Task Title: ");
        return selection.nextLine();
    }

    private String getDescription() {
        System.out.println("Task Description: ");
        return selection.nextLine();
    }

    private String getDate() {
        System.out.println("Task Due Date (YYYY-MM-DD): ");
        return selection.nextLine();
    }

    private void loadFile(String searchFile){
        TaskItem task = null;
        try(Scanner search = new Scanner(Paths.get(searchFile))) {

            while(search.hasNext()){
                processFileTaskItems(search.nextLine(), search.nextLine(), search.nextLine());
            }
        } catch(IOException | NoSuchElementException | IllegalStateException ex) {
            System.out.println("The file could not be found");
        }

    }

}
