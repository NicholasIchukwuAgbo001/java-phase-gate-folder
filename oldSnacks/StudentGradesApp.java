import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentGradesApp {

	public static void main(String[] args) {

	Scanner userInputCollection = new Scanner(System.in);

	System.out.println("How many students do you have?");
	int numStudents = userInputCollection.nextInt();

	System.out.println("How many subjects do they offer?");
	int numSubjects = userInputCollection.nextInt();

	double[][] grades = new double[(int)numStudents][(int)numSubjects];


	for (int rows = 0; rows < numStudents; rows++) {

	System.out.println("Entering score for student " + (rows + 1));

	for (int cols = 0; cols < numSubjects; cols++) {

	while (true) {

	try {

	System.out.print("Enter score for subject " + (cols + 1) + ": ");

	grades[rows][cols] = userInputCollection.nextDouble();

	if (grades[rows][cols] < 0 || grades[rows][cols] > 100) {

	System.out.println("Score must be between 0 to 100.");

	} else {

	break;

	}

	} catch (InputMismatchException e) {

	System.out.println("Invalid input. Please enter a score between 0 to 100.");

	userInputCollection.next();

	}

	}

	System.out.println("""
	Saving >>>>>>>>>>>>> 
	Saved Successfully
	""");

	}

	}



	System.out.println("===============================================================");

	System.out.print("STUDENT\t");

	for(int count = 0; count < numSubjects; count++){
	System.out.print("\tSUB" + (count + 1));
	}

	System.out.print("\tTOT\tAVE\n");

	System.out.println("===============================================================");

	

	for (int count = 0; count < numStudents; count++) {
	System.out.print("Student " + (count + 1) + ":\t");

	int total = 0;

	for (int counter = 0; counter < numSubjects; counter++) {

	System.out.print(grades[count][counter] + "\t");

	total += grades[count][counter];

	}

	double average = (double) total / numSubjects;

	System.out.printf("%d\t%.2f%n", total, average);

	}

	System.out.println("===============================================================");
	System.out.println("===============================================================");


     }
}