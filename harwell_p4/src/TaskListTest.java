import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class TaskListTest {

    @Test
    public void addingTaskItemsIncreasesSize() {
        TaskItem task = new TaskItem("Task 1", "This is task 1", "2020-11-16", false);
        TaskList tasks = new TaskList();
        tasks.add(task);
        assertEquals(1, tasks.getSize());
    }

    @Test
    public void completingTaskItemChangesStatus() {
        TaskItem task = new TaskItem("Task 1", "This is task 1", "2020-11-16", false);
        TaskList tasks = new TaskList();
        tasks.add(task);
        tasks.markCompleted(0);
        assertEquals(true, task.getCompleted());

    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex() {
        TaskItem task = new TaskItem("Task 1", "This is task 1", "2020-11-16", false);
        TaskList tasks = new TaskList();
        tasks.add(task);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            tasks.markCompleted(1);
        });
    }

    @Test
    public void editingTaskItemChangesValues() {
        TaskItem task = new TaskItem("Task 1", "This is task 1", "2020-11-16", false);
        TaskItem newTask = new TaskItem("Task 1.1", "This is task 1.1", "2020-11-17", false);
        TaskList tasks = new TaskList();
        tasks.add(task);

        assertEquals(newTask, tasks.editListItem(0, newTask));

    }

    @Test
    public void editingTaskItemDescriptionChangesValue() {
        TaskItem task = new TaskItem("Task 1", "This is task 1", "2020-11-16", false);
        TaskItem updatedTask = new TaskItem("Task 1", "New Description", "2020-11-16", false);
        TaskList tasks = new TaskList();
        tasks.add(task);
        assertEquals(updatedTask.getDescription(), (tasks.editListItem(0, updatedTask)).getDescription());
    }

    @Test
    public void editingTaskDescriptionFailsWithInvalidIndex() {
        TaskItem task = new TaskItem("Task 1", "This is task 1", "2020-11-16", false);
        TaskItem updatedTask = new TaskItem("Task 1", "New Description", "2020-11-16", false);
        TaskList tasks = new TaskList();
        tasks.add(task);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            tasks.editListItem(1, updatedTask);
        });

    }

    @Test
    public void editingTaskDueDateChangesValue() {
        TaskItem task = new TaskItem("Task 1", "This is task 1", "2020-11-16", false);
        TaskItem updatedTask = new TaskItem("Task 1", "This is task 1", "2020-11-17", false);
        TaskList tasks = new TaskList();
        tasks.add(task);
        assertEquals(updatedTask.getDate(), (tasks.editListItem(0, updatedTask)).getDate());
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex() {
        TaskItem task = new TaskItem("Task 1", "This is task 1", "2020-11-16", false);
        TaskItem updatedTask = new TaskItem("Task 1", "This is task 1", "2020-11-17", false);
        TaskList tasks = new TaskList();
        tasks.add(task);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            tasks.editListItem(1, updatedTask);
        });
    }

    @Test
    public void editingTaskItemTitleChangesValue() {
        TaskItem task = new TaskItem("Task 1", "This is task 1", "2020-11-16", false);
        TaskItem updatedTask = new TaskItem("New Task", "This is task 1", "2020-11-16", false);
        TaskList tasks = new TaskList();
        tasks.add(task);
        assertEquals(updatedTask.getTitle(), (tasks.editListItem(0, updatedTask)).getTitle());
    }

    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex() {
        TaskItem task = new TaskItem("Task 1", "This is task 1", "2020-11-16", false);
        TaskItem updatedTask = new TaskItem("New Task", "This is task 1", "2020-11-16", false);
        TaskList tasks = new TaskList();
        tasks.add(task);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            tasks.editListItem(1, updatedTask);
        });
    }

    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex() {
        TaskItem task = new TaskItem("Task 1", "This is task 1", "2020-11-16", false);
        TaskList tasks = new TaskList();
        tasks.add(task);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            tasks.getCurrentItem(1);
        });
    }

    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex() {
        TaskItem task = new TaskItem("Task 1", "This is task 1", "2020-11-16", false);
        TaskList tasks = new TaskList();
        tasks.add(task);
        TaskItem getTask = tasks.getCurrentItem(0);
        assertEquals("This is task 1", getTask.getDescription());
    }

    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex() {
        TaskItem task = new TaskItem("Task 1", "This is task 1", "2020-11-16", false);
        TaskList tasks = new TaskList();
        tasks.add(task);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            tasks.getCurrentItem(1);
        });
    }

    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex() {
        TaskItem task = new TaskItem("Task 1", "This is task 1", "2020-11-16", false);
        TaskList tasks = new TaskList();
        tasks.add(task);
        TaskItem getTask = tasks.getCurrentItem(0);
        assertEquals("2020-11-16", getTask.getDate());
    }

    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex() {
        TaskItem task = new TaskItem("Task 1", "This is task 1", "2020-11-16", false);
        TaskList tasks = new TaskList();
        tasks.add(task);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            tasks.getCurrentItem(1);
        });
    }

    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex() {
        TaskItem task = new TaskItem("Task 1", "This is task 1", "2020-11-16", false);
        TaskList tasks = new TaskList();
        tasks.add(task);
        TaskItem getTask = tasks.getCurrentItem(0);
        assertEquals("Task 1", getTask.getTitle());
    }

    @Test
    public void newTaskListIsEmpty() {
        TaskList tasks = new TaskList();
        assertEquals(0,  tasks.getSize());

    }

    @Test
    public void removingTaskItemsDecreasesSize() {
        TaskItem task0 = new TaskItem("Task 1", "This is task 1", "2020-11-16", false);
        TaskList tasks = new TaskList();
        tasks.add(task0);
        tasks.removeListItem(0);
        assertEquals(0,tasks.getSize());
    }

    @Test
    public void removingTaskItemsFailsWithInvalidIndex() {
        TaskItem task = new TaskItem("Task 1", "This is task 1", "2020-11-16", false);
        TaskList tasks = new TaskList();
        tasks.add(task);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            tasks.removeListItem(1);
        });
    }

    @Test
    public void savedTaskListCanBeLoaded() {
        TaskList f = new TaskList();
        f.loadFile("output.txt");
        assertNotEquals(null, f);
    }

    @Test
    public void uncompletingTaskItemChangesStatus() {
        TaskItem task = new TaskItem("Task 1", "This is task 1", "2020-11-16", true);
        TaskList tasks = new TaskList();
        tasks.add(task);
        tasks.markUncompleted(0);
        assertEquals(false, task.getCompleted());
    }

    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex() {
        TaskItem task = new TaskItem("Task 1", "This is task 1", "2020-11-16", true);
        TaskList tasks = new TaskList();
        tasks.add(task);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            tasks.markUncompleted(1);
        });
    }
}