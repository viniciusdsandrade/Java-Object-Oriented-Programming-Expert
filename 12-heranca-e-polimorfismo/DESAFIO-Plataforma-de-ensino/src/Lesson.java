public abstract class Lesson {

    private String title;

    public Lesson(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract int durationInMinutes();
}