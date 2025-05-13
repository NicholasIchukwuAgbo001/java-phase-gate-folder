package SchoolBuilding;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminTest {

    Admin admin = new Admin("Mr Chibuzor");

    @Test
    public void testAddStudent() {
        Student student1 = new Student("Niko", "07058705863", CohortNumber.C24);
        Student student2 = new Student("John", "09058705863", CohortNumber.C23);
        admin.addStudent(student1);
        admin.addStudent(student2);
        assertEquals(student1, admin.getStudents().getFirst());
        assertEquals(2, admin.getStudents().size());
        assertTrue(admin.getStudents().contains(student1));
    }

    @Test
    public void testAddSameStudentTwice_ThrowException() {
        Student student1 = new Student("John", "09058705863", CohortNumber.C21);
        admin.addStudent(student1);
        assertThrows(RuntimeException.class, () -> admin.addStudent(student1));
    }

    @Test
    public void testRemoveStudent() {
        Student student1 = new Student("Niko", "07058705863", CohortNumber.C26);
        Student student2 = new Student("John", "09058705863", CohortNumber.C21);
        Student student3 = new Student("Moses", "08058705863", CohortNumber.C24);
        admin.addStudent(student1);
        admin.addStudent(student2);
        admin.addStudent(student3);
        admin.removeStudent(student1);
        assertEquals(2, admin.getStudents().size());
        assertFalse(admin.getStudents().contains(student1));
    }

    @Test
    public void testRemoveStudentOutSideList_ThrowException() {
        Student student1 = new Student("Niko", "07058705863", CohortNumber.C24);
        Student student2 = new Student("John", "09058705863", CohortNumber.C24);
        admin.addStudent(student1);
        admin.addStudent(student2);
        admin.removeStudent(student1);
        assertThrows(RuntimeException.class, () -> admin.removeStudent(student1));
    }

    @Test
    public void testAddFacilitator() {
        Facilitator facilitator1 = new Facilitator("Miss Jenny", LanguageType.JAVA);
        Facilitator facilitator2 = new Facilitator("Mr Sikiru", LanguageType.PYTHON);
        admin.addFacilitator(facilitator1);
        admin.addFacilitator(facilitator2);
        assertEquals(facilitator1, admin.getFacilitators().getFirst());
        assertEquals(2, admin.getFacilitators().size());
        assertTrue(admin.getFacilitators().contains(facilitator2));
    }

    @Test
    public void testAddSameFacilitatorTwice_ThrowException() {
        Facilitator facilitator1 = new Facilitator("Miss Jenny", LanguageType.JAVA);
        admin.addFacilitator(facilitator1);
        assertThrows(RuntimeException.class, () -> admin.addFacilitator(facilitator1));
    }

    @Test
    public void testRemoveFacilitator() {
        Facilitator facilitator1 = new Facilitator("Miss Jenny", LanguageType.JAVA);
        Facilitator facilitator2 = new Facilitator("Mr Sikiru", LanguageType.PYTHON);
        Facilitator facilitator3 = new Facilitator("Mr Chinedu", LanguageType.JAVASCRIPT);
        Facilitator facilitator4 = new Facilitator("Mr FM", LanguageType.JAVA);
        admin.addFacilitator(facilitator1);
        admin.addFacilitator(facilitator2);
        admin.addFacilitator(facilitator3);
        admin.addFacilitator(facilitator4);
        admin.removeFacilitator(facilitator2);
        assertEquals(3, admin.getFacilitators().size());
        assertFalse(admin.getFacilitators().contains(facilitator2));
    }

    @Test
    public void testRemoveFacilitatorOutSideList_ThrowException() {
        Facilitator facilitator1 = new Facilitator("Miss Jenny", LanguageType.JAVA);
        Facilitator facilitator2 = new Facilitator("Mr Sikiru", LanguageType.PYTHON);
        admin.addFacilitator(facilitator1);
        admin.addFacilitator(facilitator2);
        admin.removeFacilitator(facilitator1);
        assertThrows(RuntimeException.class, () -> admin.removeFacilitator(facilitator1));
    }

}