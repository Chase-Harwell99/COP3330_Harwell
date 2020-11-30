import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class TaskList {

    private static final Scanner selection = new Scanner(System.in);

    List<TaskItem> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public void add(TaskItem task) {
        tasks.add(task);
    }

    public int getSize() {
        return tasks.size();
    }

    public void save(String filename) {
        try(Formatter out = new Formatter(filename)) {
            for(int i=0;i < getSize(); i++) {
                TaskItem task = tasks.get(i);
                out.format("%s\n%s\n%s\n",task.getTitle(), task.getDescription(), task.getDate());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("The file could not be found...");
        }
    }

    protected TaskItem getCurrentItem(int index) {
        TaskItem currentTask;
        if(index >=0 && index <= getSize()) {
            currentTask = tasks.get(index);
        } else {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        return currentTask;
    }

    public void getList() {
        for(int j=0; j < getSize();j++) {
            while(true) {
                try{
                    getCurrentItem(j);
                    System.out.printf("%d) [%s] %s: %s\n", j, getCurrentItem(j).getDate(), getCurrentItem(j).getTitle(), getCurrentItem(j).getDescription());
                    break;
                } catch(IndexOutOfBoundsException ex) {
                    System.out.println("Index is out of bounds");
                }
            }
        }
    }

    public void getCompletedList() {
        for(int m=0; m<getSize();m++) {
            TaskItem currentTask = tasks.get(m);
            if(currentTask.getCompleted()) {
                System.out.printf("%d) [%s] %s: %s\n", m, currentTask.getDate(), currentTask.getTitle(), currentTask.getDescription());
            }
        }
    }

    public void getIncompleteList() {
        for(int m=0; m<getSize();m++) {
            TaskItem currentTask = tasks.get(m);
            if(!currentTask.getCompleted()) {
                System.out.printf("%d) [%s] %s: %s\n", m, currentTask.getDate(), currentTask.getTitle(), currentTask.getDescription());
            }
        }
    }

    public TaskItem editListItem(int index, TaskItem task) {
        if(index>=0 && index<getSize()) {
            tasks.set(index, task);
            return task;
        } else if(getSize() == 0){
            throw new ListIsEmptyException("List is empty");
        } else {
            throw new IndexOutOfBoundsException("Index does not exist");
        }
    }

    public void removeListItem(int index) {
        if(index>=0 && index<getSize()) {
            tasks.remove(index);
        } else if(getSize() == 0){
            throw new ListIsEmptyException("List is empty");
        } else {
            throw new IndexOutOfBoundsException("Index does not exist");
        }
    }

    public void markCompleted(int index) {
        if(index>=0 && index<getSize()) {
            TaskItem task = tasks.get(index);

            if(!task.getCompleted()) {
                task.setCompleted(true);
                task.setDescription(task.getDescription() + " ----> [COMPLETED]");
            }

        } else if(getSize() == 0){
            throw new ListIsEmptyException("List is empty");
        } else {
            throw new IndexOutOfBoundsException("Index does not exist");
        }
    }

    public void markUncompleted(int index) {

        if(index>=0 && index<getSize()) {
            TaskItem task = tasks.get(index);

            if(task.getCompleted()) {
                task.setCompleted(false);
                task.setDescription(task.getDescription().replace(" ----> [COMPLETED]",""));
            }

        } else if(getSize() == 0){
            throw new ListIsEmptyException("List is empty");
        } else {
            throw new IndexOutOfBoundsException("Index does not exist");
        }
    }

    protected void getTaskList() {
        System.out.println("   Current Tasks   ");
        System.out.println("-------------------\n");
        getList();
    }

    private void getCompletedTaskListPrompt() {
        System.out.println("    Completed Tasks    ");
        System.out.println("-----------------------");
        getCompletedList();
    }

    private void getIncompleteTaskListPrompt() {
        System.out.println("    Incomplete Tasks    ");
        System.out.println("-----------------------");
        getIncompleteList();
    }

    protected void processNewTask(){
        TaskItem task = getNewTaskItem();
        storeNewTask(task);
    }

    protected void editTaskItem() {

        while(true)  {
            try{
                getTaskList();
                System.out.println("Enter the index of the task you would like to change.");
                int index = selection.nextInt();
                selection.nextLine(); //clear buffer for editing
                editListItem(index,getNewTaskItem());
                getTaskList();
                break;
            } catch (ListIsEmptyException ex) {
                System.out.println("List is empty. Please add an item before you attempt to edit the list...\n");
                break;
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("Index does not exist. Please try editing item again...\n");
            }
        }
    }

    protected void removeTask() {

        while(true) {
            try {
                getTaskList();
                System.out.println("Enter the index of the task you wish to remove from the list");
                int removeIndex = selection.nextInt();
                selection.nextLine();
                removeListItem(removeIndex);
                getTaskList();
                break;
            } catch (ListIsEmptyException ex) {
                System.out.println("List is empty. Removing an item is impossible. Please try again...\n");
                break;
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("Index does not exist. Please try removing item again...\n");
            }
        }
    }

    protected void markCompletedPrompt() {

        while(true){
            try{
                getIncompleteTaskListPrompt();
                System.out.println("Enter the index of the task you would like to mark as complete.");
                int completeIndex = selection.nextInt();
                selection.nextLine();
                markCompleted(completeIndex);
                break;
            } catch (ListIsEmptyException ex) {
                System.out.println("List is empty. Please add an item before you attempt to complete it...\n");
                break;
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("Index does not exist. Please try marking item as completed again...\n");
            }
        }
    }

    protected void markUncompletedPrompt() {

        while(true) {
            try{
                getCompletedTaskListPrompt();
                System.out.println("Enter the index of the task that you would like to unmark as completed.");
                int incompleteIndex = selection.nextInt();
                selection.nextLine();
                markUncompleted(incompleteIndex);
                break;
            } catch (ListIsEmptyException ex) {
                System.out.println("List is empty. Please add an item before you attempt to uncomplete it...\n");
                break;
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("Index does not exist. Please try unmark item as completed again...\n");
            }
        }
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

    protected void saveList() {
        System.out.println("What would you like to name your save file? Do not include .txt in your name.");
        String filename = (selection.nextLine() + ".txt");
        save(filename);
        System.out.printf("Your list was saved as %s\n\n", filename);

    }

    private String getTitle() {
        System.out.println("Task Title: ");
        String title = selection.nextLine();
        return title;
    }

    private String getDescription() {
        System.out.println("Task Description: ");
        return selection.nextLine();
    }

    private String getDate() {
        System.out.println("Task Due Date (YYYY-MM-DD): ");
        return selection.nextLine();
    }

    protected void loadFile(String searchFile){
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
