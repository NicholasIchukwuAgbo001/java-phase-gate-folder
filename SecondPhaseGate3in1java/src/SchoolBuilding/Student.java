package SchoolBuilding;


public class Student extends Person {
    private String name;
    private String phoneNumber;
    private CohortNumber cohortNumber;

    public Student(String name, String phoneNumber, CohortNumber cohortNumber) {
        super(name);
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.cohortNumber = cohortNumber;
    }

    public  String getName(){
        return name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public CohortNumber getCohortNumber() {
        return cohortNumber;
    }

    @Override
    public String toString() {
        return "\nName: " + name + ", Phone Number: " + phoneNumber + ", Cohort Number: " + cohortNumber + "\n";
    }
}