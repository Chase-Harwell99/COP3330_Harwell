import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {

    @Test
    public void addingTaskItemsIncreasesSize() {
        TaskItem task = new TaskItem("Task 1", "This is task 1", "2020-11-16",false);
        TaskList tasks = new TaskList();
        tasks.add(task);
        assertEquals(1,tasks.getSize());
    }

    @Test
    public void completingTaskItemChangesStatus() {
        TaskItem task = new TaskItem("Task 1", "This is task 1", "2020-11-16",false);
        TaskList tasks = new TaskList();
        tasks.add(task);
        tasks.markCompleted(0);
        assertEquals(true, task.getCompleted());

    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex() {
        TaskItem task = new TaskItem("Task 1", "This is task 1", "2020-11-16",false);
        TaskList tasks = new TaskList();
        tasks.add(task);
        Assertions.assertThrows(IndexOutOfBoundsException.class,()-> {
            tasks.markCompleted(1);
        });
    }

    @Test
    public void editingTaskItemChangesValues() {
        TaskItem task = new TaskItem("Task 1", "This is task 1", "2020-11-16",false);
        TaskItem newTask = new TaskItem("Task 1.1", "This is task 1.1", "2020-11-17", false);
        TaskList tasks = new TaskList();
        tasks.add(task);
        assertEquals(newTask, tasks.editListItem(0, newTask));

    }

    @Test
    public void editingTaskItemDescriptionChangesValue() {
        TaskItem task = new TaskItem("Task 1", "This is task 1", "2020-11-16",false);
        TaskItem updatedTask = new TaskItem("Task 1", "New Description", "2020-11-16", false);
        TaskList tasks = new TaskList();
        tasks.add(task);
        assertEquals(updatedTask.getDescription(), (tasks.editListItem(0, updatedTask)).getDescription());
    }

    @Test
    public void editingTaskDescriptionFailsWithInvalidIndex() {
        TaskItem task = new TaskItem("Task 1", "This is task 1", "2020-11-16",false);
        TaskItem updatedTask = new TaskItem("Task 1", "New Description", "2020-11-16", false);
        TaskList tasks = new TaskList();
        tasks.add(task);
        Assertions.assertThrows(IndexOutOfBoundsException.class,()-> {
            tasks.editListItem(1,updatedTask);
        });

    }

    @Test
    public void editingTaskDueDateChangesValue() {
        TaskItem task = new TaskItem("Task 1", "This is task 1", "2020-11-16",false);
        TaskItem updatedTask = new TaskItem("New Title", "This is task 1", "2020-11-16", false);
        TaskList tasks = new TaskList();
        tasks.add(task);
        assertEquals(updatedTask.getTitle(), (tasks.editListItem(0, updatedTask)).getTitle());
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex() {
        TaskItem task = new TaskItem("Task 1", "This is task 1", "2020-11-16",false);
        TaskItem updatedTask = new TaskItem("New Title", "This is task 1", "2020-11-16", false);
        TaskList tasks = new TaskList();
        tasks.add(task);
        Assertions.assertThrows(IndexOutOfBoundsException.class,()-> {
            tasks.editListItem(1,updatedTask);
        });
    }
/*
    @Test
    public void editingTaskItemTitleChangesValue() {

    }

    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex() {

    }

    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex() {

    }

    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex() {

    }

    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex() {

    }

    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex() {

    }

    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex() {

    }

    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex() {

    }

    @Test
    public void newTaskListIsEmpty() {

    }

    @Test
    public void removingTaskItemsDecreasesSize() {

    }

    @Test
    public void removingTaskItemsFailsWithInvalidIndex() {

    }

    @Test
    public void savedTaskListCanBeLoaded() {

    }

    @Test
    public void uncompletingTaskItemChangesStatus() {

    }

    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex() {

    }
*/
}