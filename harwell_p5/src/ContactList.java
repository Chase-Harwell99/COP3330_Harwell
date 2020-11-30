import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class ContactList {

    private static final Scanner selection = new Scanner(System.in);

    List<ContactItem> tasks;

    public ContactList() {
        tasks = new ArrayList<>();
    }

    public void add(ContactItem task) {
        tasks.add(task);
    }

    public int getSize() {
        return tasks.size();
    }

    public void save(String filename) {
        try(Formatter out = new Formatter(filename)) {
            for(int i=0;i < getSize(); i++) {
                ContactItem task = tasks.get(i);
                out.format("%s\n%s\n%s\n%s\n",task.getFirstName(), task.getLastName(), task.getPhone(),task.getEmail());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("The file could not be found...");
        }
    }

    protected ContactItem getCurrentItem(int index) {
        ContactItem currentTask;
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
                    System.out.printf("%d) Name: %s %s\nPhone: %s\nEmail: %s\n", j, getCurrentItem(j).getFirstName(), getCurrentItem(j).getLastName(), getCurrentItem(j).getPhone(), getCurrentItem(j).getEmail());
                    break;
                } catch(IndexOutOfBoundsException ex) {
                    System.out.println("Index is out of bounds");
                }
            }
        }
    }

    public ContactItem editListItem(int index, ContactItem task) {
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

    protected void getTaskList() {
        System.out.println("   Current Contacts   ");
        System.out.println("----------------------\n");
        getList();
    }

    protected void processNewTask(){
        ContactItem task = getNewTaskItem();
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


    private void storeNewTask(ContactItem task) {
        tasks.add(task);
    }

    private void processFileTaskItems(String first, String last, String phone, String email) {

        ContactItem task = null;

        task = new ContactItem(first, last, phone, email);

        tasks.add(task);
    }

    private ContactItem getNewTaskItem() {
        ContactItem task = null;
        while(true) {
            try {
                String first = getFirst();
                String last = getLast();
                String phone = getPhone();
                String email = getEmail();

                task = new ContactItem(first, last, phone, email);
                break;
            } catch (InvalidContactException ex) {
                System.out.println("One of the fields (first name, last name, phone number, or email) must have an input to create contact");
            } catch (InvalidNumberException ex) {
                System.out.println("A phone number must be in the format XXX-XXX-XXXX. Please input contact info again.");
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

    private String getFirst() {
        System.out.println("First Name: ");
        String first = selection.nextLine();
        return first;
    }

    private String getLast() {
        System.out.println("Last Name: ");
        return selection.nextLine();
    }

    private String getPhone() {
        System.out.println("Phone Number (XXX-XXX-XXXX): ");
        return selection.nextLine();
    }

    private String getEmail() {
        System.out.println("Email (x@y.z): ");
        return selection.nextLine();
    }

    protected void loadFile(String searchFile){
        ContactItem task = null;
        try(Scanner search = new Scanner(Paths.get(searchFile))) {

            while(search.hasNext()){
                processFileTaskItems(search.nextLine(), search.nextLine(), search.nextLine(), search.nextLine());
            }
        } catch(IOException | NoSuchElementException | IllegalStateException ex) {
            System.out.println("The file could not be found");
        }
    }
}
