public class TaskItem {

    private String title;
    private String description;
    private String date;
    private boolean completed;

    public TaskItem(String title, String description, String date, boolean completed) {

        if(isValidTitle(title)) {
            this.title = title;
        } else {
            throw new InvalidTitleException("The title must be at least 1 character long. Please try again.");
        }

        if(isValidDescription(description)) {
            this.description = description;
        } else {
            throw new InvalidDescriptionException("The description must be at least 0 characters long");
        }

        if(isValidDate(date)) {
            this.date = date;
        } else {
            throw new InvalidDateException("The date must fit the format YYYY-MM-DD. Please re-enter the date");
        }

        this.completed = completed;
    }

    private boolean isValidTitle(String title) {
        return title.length() >=1;
    }

    private boolean isValidDescription(String description) {
        return description.length() >= 0;
    }

    private boolean isValidDate(String date) {
        return date.matches("\\d{4}-\\d{2}-\\d{2}");
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String d) {
        description = d;
    }

    public void setCompleted(boolean c) {
        completed = c;
    }

    public String getDate() {
        return this.date;
    }

    public Boolean getCompleted() {
        return this.completed;
    }

    class InvalidTitleException extends IllegalArgumentException {
        public InvalidTitleException(String message) {
            super(message);
        }
    }

    class InvalidDescriptionException extends IllegalArgumentException {
        public InvalidDescriptionException(String message) {
            super(message);
        }
    }

    class InvalidDateException extends IllegalArgumentException {
        public InvalidDateException(String message) {
            super(message);
        }
    }
}
