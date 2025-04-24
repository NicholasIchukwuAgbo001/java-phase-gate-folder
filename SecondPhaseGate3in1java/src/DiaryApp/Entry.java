package DiaryApp;

public class Entry {
    private String title;
    private String body;
    private final int id;

    public Entry(int id, String title, String body) {
        this.body = body;
        this.title = title;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getId() {
        return id;
    }
}
