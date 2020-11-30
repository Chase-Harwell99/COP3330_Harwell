import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class TaskItemTest {


    @Test
    public void constructorFailsWithInvalidDueDate() {
        Assertions.assertThrows(InvalidDateException.class,()-> {
            new TaskItem("Task 1", "This is the first task", "11-16-2020",false);
        });
    }

    @Test
    public void constructorFailsWithInvalidTitle() {
        Assertions.assertThrows(InvalidTitleException.class,()-> {
            new TaskItem("", "This is the first task", "2020-11-16",false);
        });
    }

    @Test
    public void constructorSucceedsWithValidDueDate() {
        TaskItem task = new TaskItem("Task 1", "This is the first task", "2020-11-16",false);
        assertEquals("Task 1", task.getTitle());
        assertEquals("This is the first task", task.getDescription());
        assertEquals("2020-11-16", task.getDate());
    }

    @Test
    public void constructorSucceedsWithValidTitle() {
        TaskItem task = new TaskItem("Task 1", "This is the first task", "2020-11-16",false);
        assertEquals("Task 1", task.getTitle());
        assertEquals("This is the first task", task.getDescription());
        assertEquals("2020-11-16", task.getDate());
    }

    @Test
    public void editingDescriptionSucceedsWithExpectedValue() {
        TaskItem task = new TaskItem("Task 1", "This is the first task", "2020-11-16",false);
        task.setDescription("This is task 1.1");
        assertEquals("This is task 1.1", task.getDescription());
    }

    @Test
    public void editingDueDateFailsWithInvalidDateFormat() {
        TaskItem task = new TaskItem("Task 1", "This is the first task", "2020-11-16",false);
        String newDate = "12-13-2020";
        assertThrows(InvalidDateException.class,()-> {
            TaskItem updatedTask = new TaskItem(task.getTitle(), task.getDescription(), newDate,false);
            assertEquals("Task 1", updatedTask.getTitle());
            assertEquals("This is the first task", updatedTask.getDescription());
        });
    }

    @Test
    public void editingDueDateSucceedsWithExpectedValue() {
        TaskItem task = new TaskItem("Task 1", "This is the first task", "2020-11-16",false);
        task.setDate("2020-12-03");
        assertEquals("2020-12-03", task.getDate());
    }

    @Test
    public void editingTitleFailsWithEmptyString() {
        TaskItem task = new TaskItem("Task 1", "This is the first task", "2020-11-16",false);
        Assertions.assertThrows(InvalidTitleException.class,()-> {
            task.setTitle("");
        });
    }

    @Test
    public void editingTitleSucceedsWithExpectedValue() {
        TaskItem task = new TaskItem("Task 1", "This is the first task", "2020-11-16",false);
        task.setTitle("Task 1.1");
        assertEquals("Task 1.1", task.getTitle());
    }
}