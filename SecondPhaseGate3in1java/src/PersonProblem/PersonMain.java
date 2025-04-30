package PersonProblem;
import java.util.Scanner;

public class PersonMain {
    public static void main(String[] args) {

        Scanner userInputCollection = new Scanner(System.in);

        while (true) {
            System.out.print("""
                    \n1. Add problems
                    2. Solve problem
                    3. Solved problems
                    4. Unsolved problem
                    5. Exit...
                    """);

            System.out.print("Please enter your choice: ");
            int choice = userInputCollection.nextInt();

            if (choice == 1) {
                System.out.println("\nEnter Your Name: ");
                String name = userInputCollection.next();

                System.out.println("Enter your problem type: ");
                String problemType = userInputCollection.next();
            }else if (choice == 2) {
                System.out.println("\nEnter problem type: ");
            } else if (choice == 3) {
                System.out.println("\nview solved problems: ");
            }else if (choice == 4) {
                System.out.println("\nview unsolved problems: ");
            }else if (choice == 5) {
                System.out.println("\nExiting..");
                break;
            }else{
                System.out.println("\nInvalid choice.");
            }
        }


    }
}
