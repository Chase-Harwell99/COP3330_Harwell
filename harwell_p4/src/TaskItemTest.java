import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class TaskItemTest {


    @Test
    public void creatingTaskItemFailsWithInvalidDueDate() {
        Assertions.assertThrows(InvalidDateException.class,()-> {
            TaskItem task = new TaskItem("Task 1", "This is the first task", "11-16-2020",false);
        });
    }

    @Test
    public void creatingTaskItemFailsWithInvalidTitle() {

        Assertions.assertThrows(InvalidTitleException.class,()-> {
            TaskItem task = new TaskItem("", "This is the first task", "2020-11-16",false);
            assertEquals(null, task);
        });

    }

    @Test
    public void creatingTaskItemSucceedsWithValidDueDate() {
        TaskItem task = new TaskItem("Task 1", "This is the first task", "2020-11-16",false);
        assertNotEquals(null, task);
    }

    @Test
    public void creatingTaskItemSucceedsWithValidTitle() {
        TaskItem task = new TaskItem("Task 1", "This is the first task", "2020-11-16",false);
        assertNotEquals(null, task);
    }

    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate() {
        Assertions.assertThrows(InvalidDateException.class,()-> {
            TaskItem task = new TaskItem("Task 1", "This is the first task", "11-16-2020",false);
        });
    }

    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate() {
        TaskItem task = new TaskItem("Task 1", "This is the first task", "2020-11-16",false);
        assertEquals("2020-11-16", task.getDate());
    }

    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle() {
        Assertions.assertThrows(InvalidTitleException.class,()-> {
            TaskItem task = new TaskItem("", "This is the first task", "2020-11-16",false);
        });
    }

    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle() {
        TaskItem task = new TaskItem("Task 1", "This is the first task", "2020-11-16",false);
        assertEquals("Task 1", task.getTitle());
    }
}