package SchoolBuilding;
import java.util.Scanner;

public class AdminMain {

    public static void main(String[] args) {
        Scanner userInputCollection = new Scanner(System.in);

        Admin admin = new Admin("Mr Chibuzor");

        System.out.println("Welcome Semicolon portal");

        String studentName;
        String  studentPhoneNumber;
        CohortNumber studentCohortNumber;
        String facilitatorName;
        LanguageType languageName;

        while (true) {
            System.out.println("""
                    \n1. Add Student
                    2. View Student
                    3. Remove Student
                    4. Add Facilitator
                    5. View Facilitator
                    6. Remove Facilitator
                    7. Exit....
                    """);

            int choice;

            while (true) {
                try {
                    System.out.print("Enter your choice: ");
                    String choiceStr = userInputCollection.nextLine();
                    choice = Integer.parseInt(choiceStr);
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

            if (choice == 1) {
                while (true) {
                    try {
                        System.out.print("\nEnter Student Name: ");
                        studentName = userInputCollection.nextLine();
                        validateName(studentName);
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }

                while (true) {
                    try {
                        System.out.print("\nEnter Student Phone Number: ");
                        studentPhoneNumber = userInputCollection.nextLine();
                        validateNigerianPhoneNumber(studentPhoneNumber);
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }

                while (true) {
                    try {
                        System.out.print("\nEnter Student Cohort Number (C24, C21..etc): ");
                        studentCohortNumber = CohortNumber.valueOf(userInputCollection.nextLine());
                        validateCohortNumber(String.valueOf(studentCohortNumber));
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }

                try {
                    Student student = new Student(studentName, studentPhoneNumber, studentCohortNumber);
                    admin.addStudent(student);
                    System.out.println("\nStudent has been added!");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }else if (choice == 2) {
                System.out.print("\nStudents: ");
                System.out.println(admin.getStudents());
            } else if (choice == 3) {
                while (true) {
                    try {
                        System.out.print("\nEnter Student Name: ");
                        studentName = userInputCollection.nextLine();
                        validateName(studentName);
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }

                while (true) {
                    try {
                        System.out.print("\nEnter Student Phone Number: ");
                        studentPhoneNumber = userInputCollection.nextLine();
                        validateNigerianPhoneNumber(studentPhoneNumber);
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }

                while (true) {
                    try {
                        System.out.print("\nEnter Student Cohort Number (C24, C21..etc): ");
                        studentCohortNumber = CohortNumber.valueOf(userInputCollection.nextLine());
                        validateCohortNumber(String.valueOf(studentCohortNumber));
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }

                try {
                    Student student = new Student(studentName, studentPhoneNumber, studentCohortNumber);
                    admin.removeStudent(student);
                    System.out.println("\nStudent has been removed!");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            } else if (choice == 4) {
                while (true) {
                    try {
                        System.out.print("\nEnter Facilitator Name: ");
                        facilitatorName = userInputCollection.nextLine();
                        validateName(facilitatorName);
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }

                while (true) {
                    try {
                        System.out.print("\nEnter Language HE/SHE Take's, must capital letter(JAVA): ");
                        languageName = LanguageType.valueOf(userInputCollection.nextLine());
                        validateName(String.valueOf(languageName));
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }

                try {
                    Facilitator facilitator = new Facilitator(facilitatorName, languageName);
                    admin.addFacilitator(facilitator);
                    System.out.println("\nFacilitator has been added!");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }else if (choice == 5) {
                System.out.print("\nFacilitators: ");
                System.out.println(admin.getFacilitators());
            } else if (choice == 6) {
                while (true) {
                    try {
                        System.out.print("\nEnter Facilitator Name: ");
                        facilitatorName = userInputCollection.nextLine();
                        validateName(facilitatorName);
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }

                while (true) {
                    try {
                        System.out.print("\nEnter Language HE/SHE Take's, must capital letter(JAVA): ");
                        languageName = LanguageType.valueOf(userInputCollection.nextLine());
                        validateName(String.valueOf(languageName));
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }

                try {
                    Facilitator facilitator = new Facilitator(facilitatorName, languageName);
                    admin.removeFacilitator(facilitator);
                    System.out.println("\nFacilitator has been removed!");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if (choice == 7) {
                System.out.println("\nExiting The Application...");
                System.out.println("Bye...");
                break;
            }else{
                System.out.println("Invalid choice!");
            }




        }

    }


private static void validateName(String name) {
    if (!name.matches("^[A-Za-z\\s]+")) {
        throw new IllegalArgumentException("Invalid Student Name!");
    }
        if(name.isBlank()) {
        throw new IllegalArgumentException("Invalid Student Name!");
    }
}


private static void validateNigerianPhoneNumber(String phoneNumber) {
    String regex = "^\\+?234\\d{10}$|^0\\d{10}$";
    if (!phoneNumber.matches(regex)) {
        throw new IllegalArgumentException("Invalid Phone Number, Only Nigeria Country Phone Numbers are supported!");
    }
}

private static void validateCohortNumber(String cohortNumber) {
    if (!cohortNumber.matches("^[0-9A-Za-z\\s]+")) {
        throw new IllegalArgumentException("Invalid Student Cohort Number!");
    }
 }

}
