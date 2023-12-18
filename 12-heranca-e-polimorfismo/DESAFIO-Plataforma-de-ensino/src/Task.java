public class Task extends Lesson {

    private String description;
    private int questionCount;

    public Task(String title, String description, int questionCount) {
        super(title);

        if (questionCount < 0) {
            throw new IllegalArgumentException("A quantidade de questões não pode ser negativa.");
        }

        this.description = description;
        this.questionCount = questionCount;
    }

    public String getDescription() {
        return description;
    }

    public int getQuestionCount() {
        return questionCount;
    }

    @Override
    public int durationInMinutes() {
        return this.getQuestionCount() * 5 * 60;
    }
}