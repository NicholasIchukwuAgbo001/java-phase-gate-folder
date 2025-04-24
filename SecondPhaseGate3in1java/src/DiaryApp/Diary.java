package DiaryApp;
import java.util.ArrayList;

public class Diary {
    private String username;
    private final String password;
    private boolean isLocked;
    ArrayList<Entry> entries = new ArrayList<Entry>();
    private int entryId;

    public Diary(String username, String password) {
        this.username = username;
        this.password = password;
        this.isLocked = true;
        this.entryId = 1;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void unlockDiary(String password) {
        if (password.equals(this.password)) {
            isLocked = false;
        }else {
            throw new RuntimeException("Wrong password");
        }
    }

    public void lockDiary() {
        isLocked = true;
    }

    public boolean isLocked() {
        return isLocked;
    }


    public void createEntry(String title, String body) {
        if (!isLocked) {
            Entry entry = new Entry(entryId, title, body);
            entries.add(entry);
            entryId++;
        } else {
            throw new RuntimeException("Diary is locked");
        }
    }

    public Entry findEntryById(int id) {
        if (!isLocked) {
            for (Entry entry : entries) {
                if (entry.getId() == id) {
                    return entry;
                }
            }
            throw new RuntimeException("Entry not found");
        } else {
            throw new RuntimeException("Diary is locked");
        }
    }

    public void deleteEntry(int id) {
        if(!isLocked) {
            entries.removeIf(entry -> entry.getId() == id);
        }else  {
            throw new RuntimeException("Diary is locked");
        }
    }


    public void updateEntry(int id, String title, String body) {
        if (!isLocked) {
            Entry entry = findEntryById(id);
            if (entry != null) {
                entry.setTitle(title);
                entry.setBody(body);
            } else {
                throw new RuntimeException("Entry not found");
            }
        } else {
            throw new RuntimeException("Diary is locked");
        }
    }

}
