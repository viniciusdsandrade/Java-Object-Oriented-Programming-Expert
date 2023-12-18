public class Video extends Lesson {

    private String url;
    private int seconds;

    public Video(String title, String url, int seconds) {
        super(title);

        if (seconds < 0) {
            throw new IllegalArgumentException("A duração do vídeo não pode ser negativa.");
        }

        this.url = url;
        this.seconds = seconds;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public int durationInMinutes() {
        return seconds;
    }
}