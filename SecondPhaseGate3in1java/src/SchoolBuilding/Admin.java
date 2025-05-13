package SchoolBuilding;

import java.util.ArrayList;

public class Admin extends Person {
    private ArrayList<Student> students;
    private ArrayList<Facilitator> facilitators;

    public Admin(String name) {
        super(name);
        this.students = new ArrayList<>();
        this.facilitators = new ArrayList<>();
    }


    public void addStudent(Student student) {
        boolean studentExists = false;
        for (Student studentHolder : students) {
            boolean checkPhone = studentHolder.getPhoneNumber().equals(student.getPhoneNumber());
            if (checkPhone) {
                studentExists = true;
                break;
            }
        }
        if (!studentExists) {
            students.add(student);
        } else {
            throw new RuntimeException("Student already exists");
        }
    }


    public void removeStudent(Student student) {
        boolean studentFound = false;
        for (int count = 0; count < students.size(); count++) {
            boolean checkName = students.get(count).getName().equalsIgnoreCase(student.getName());
            boolean checkPhone = students.get(count).getPhoneNumber().equals(student.getPhoneNumber());
            boolean checkCohort = students.get(count).getCohortNumber().equals(student.getCohortNumber());
            if (checkName && checkPhone && checkCohort) {
                students.remove(count);
                studentFound = true;
                break;
            }
        }
        if (!studentFound) {
            throw new RuntimeException("Student does not exist");
        }
    }


    public void addFacilitator(Facilitator facilitator) {
        if(this.facilitators.contains(facilitator)) {
            throw new RuntimeException("Facilitator already exists");
        }else {
            facilitators.add(facilitator);
        }
    }

    public void removeFacilitator(Facilitator facilitator) {
        boolean facilitatorFound = false;
        for (Facilitator facilitatorHolder : facilitators) {
            boolean checkName = facilitatorHolder.getFacilitatorName().equalsIgnoreCase(facilitator.getFacilitatorName());
            boolean checkLanguage = facilitatorHolder.getLanguageTaking().equals(facilitator.getLanguageTaking());
            if (checkName && checkLanguage) {
                facilitators.remove(facilitatorHolder);
                facilitatorFound = true;
                break;
            }
        }
        if (!facilitatorFound) {
            throw new RuntimeException("Facilitator does not exist");
        }
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Facilitator> getFacilitators() {
        return facilitators;
    }


}

