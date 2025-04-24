package DiaryApp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiaryTest {

    private Diary diary;

    @BeforeEach
    public void setUp() {
        diary = new Diary("Nicodemus1122", "niko404");
    }

    @Test
    public void tesUnlockDiary() {
        diary.unlockDiary("niko404");
        assertFalse(diary.isLocked());
    }

    @Test
    public void tesLockDiary() {
        diary.unlockDiary("niko404");
        diary.lockDiary();
        assertTrue(diary.isLocked());
    }

    @Test
    public void testCreateEntry() {
        diary.unlockDiary("niko404");
        diary.createEntry("my first entry", "my first diary entry");
        Entry entry = diary.findEntryById(1);
        assertEquals(entry, diary.findEntryById(1));

    }

    @Test
    public void testCreateEntryWhenLocked() {
        assertThrows(RuntimeException.class, () -> diary.createEntry("my first entry", "my first diary entry"));
    }


    @Test
    public void testDeleteEntry() {
        diary.unlockDiary("niko404");
        diary.createEntry("my first entry", "my first diary entry");
        diary.deleteEntry(1);
        assertThrows(RuntimeException.class, () -> diary.findEntryById(1));
    }


    @Test
    public void testFindEntryById() {
        diary.unlockDiary("niko404");
        diary.createEntry("my first entry", "my first diary entry");
        diary.createEntry("my second entry", "my second diary entry");
        diary.createEntry("my third entry", "my third diary entry");
        Entry entry = diary.findEntryById(2);
        assertEquals(entry, diary.findEntryById(2));
    }

    @Test
    public void testFindEntryByIdException() {
        diary.unlockDiary("niko404");
        diary.createEntry("my first entry", "my first diary entry");
        diary.createEntry("my second entry", "my second diary entry");
        diary.createEntry("my third entry", "my third diary entry");
        assertThrows(RuntimeException.class, () -> diary.findEntryById(4));
    }

    @Test
    public void testUpdateEntry() {
        diary.unlockDiary("niko404");
        diary.createEntry("my first entry", "my first diary entry");
        diary.createEntry("my second entry", "my second diary entry");
        diary.updateEntry(1, "uploaded", "my uploaded diary entry");
        Entry entry = diary.findEntryById(1);
        assertEquals("uploaded", entry.getTitle());
        assertEquals("my uploaded diary entry", entry.getBody());
        assertEquals(entry, diary.findEntryById(1));
    }

    @Test
    public void testInvalidPassword() {
        assertThrows(RuntimeException.class, () -> diary.unlockDiary("niko"));
    }



}