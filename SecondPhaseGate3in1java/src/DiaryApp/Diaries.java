package DiaryApp;
import java.util.ArrayList;

public class Diaries {

    public ArrayList<Diary> diaries = new ArrayList<>();

    public void add(String username, String password) {
        Diary diary = new Diary(username, password);
        diaries.add(diary);
    }



        public void findByUsername(String username) {
            for (Diary diary : diaries) {
                if (diary.getUsername().equals(username)) {
                    return;
                }
            }
            throw new IllegalArgumentException("Username not found");
        }



    public void delete(String userName, String password) {
        diaries.removeIf(diary -> diary.getUsername().equals(userName) && diary.getPassword().equals(password));
    }


}
