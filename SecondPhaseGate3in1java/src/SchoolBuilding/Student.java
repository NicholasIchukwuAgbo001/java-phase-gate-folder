package SchoolBuilding;


public class Student{
    private String name;
    private String phoneNumber;
    private String cohortNumber;

    public Student(String name, String phoneNumber, String cohortNumber) {
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

    public String getCohortNumber() {
        return cohortNumber;
    }

    @Override
    public String toString() {
        return "\nName: " + name + ", Phone Number: " + phoneNumber + ", Cohort Number: " + cohortNumber + "\n";
    }
}