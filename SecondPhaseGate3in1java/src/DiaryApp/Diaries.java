package DiaryApp;
import java.util.ArrayList;

public class Diaries {
    private final ArrayList<Diary> diaries = new ArrayList<>();

    public void add(String username, String password) {
        Diary diary = new Diary(username, password);
        diaries.add(diary);
    }

    public Diary findByUsername(String username, String password) {
        for (Diary diary : diaries) {
            if (diary.getUsername().equals(username) && diary.getPassword().equals(password)) {
                return diary;
            }
        }
        throw new IllegalArgumentException("Invalid username or password");
    }

    public void delete(String username, String password) {
        diaries.removeIf(diary -> diary.getUsername().equals(username) && diary.getPassword().equals(password));
    }
}

