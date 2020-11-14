import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.ArrayList;
import java.util.List;

public class TaskList {

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
            //out.format("end");
        } catch (FileNotFoundException ex) {
            System.out.println("The file could not be found...");
        }
    }

    public void getList() {
        for(int j=0; j< getSize();j++) {
            TaskItem currentTask = tasks.get(j);
            System.out.printf("%d) [%s] %s: %s\n", j, currentTask.getDate(), currentTask.getTitle(), currentTask.getDescription());
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
        if(index>=0 && index <=getSize()) {
            tasks.set(index, task);
            return task;
        } else {
            throw new IndexOutOfBoundsException("Index does not exist");
        }
    }

    public void removeListItem(int index) {
        if(index>=0 && index<=getSize()) {
            tasks.remove(index);
        }
    }

    public void markCompleted(int index) {
        if(index>=0 && index<=getSize()) {
            TaskItem task = tasks.get(index);
            task.setCompleted(true);
            task.setDescription(task.getDescription() + " ----> [COMPLETED]");
        }
    }

    public void markUncompleted(int index) {
        if(index>=0 && index<=getSize()) {
            TaskItem task = tasks.get(index);
            task.setCompleted(false);
            task.setDescription(task.getDescription().replace(" ----> [COMPLETED]",""));
        }
    }

}
