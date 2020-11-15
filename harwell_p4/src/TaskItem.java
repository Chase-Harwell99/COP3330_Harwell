public class TaskItem {

    private String title;
    private String description;
    private String date;
    private boolean completed;

    public TaskItem(String title, String description, String date, boolean completed) {

        if(isValidTitle(title)) {
            this.title = title;
        } else {
            throw new InvalidTitleException("The title must be at least 1 character long. Please press enter and re-enter task info.");
        }

        if(isValidDate(date)) {
            this.date = date;
        } else {
            throw new InvalidDateException("The date must satisfy the format YYYY-MM-DD. Please press enter and re-enter task info.");
        }

        this.description = description;
        this.completed = completed;
    }

    protected boolean isValidTitle(String title) {

        return title.length() >=1;
    }

    protected boolean isValidDate(String date) {

        return date.matches("\\d{4}-\\d{2}-\\d{2}");
    }

    protected String getTitle() {
        return this.title;
    }

    protected String getDescription() {
        return this.description;
    }

    protected String getDate() {
        return this.date;
    }

    public Boolean getCompleted() {
        return this.completed;
    }

    public void setDescription(String d) {
        description = d;
    }

    public void setCompleted(boolean c) {
        completed = c;
    }
}
