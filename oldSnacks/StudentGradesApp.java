import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentGradesApp {

	public static void main(String[] args) {

	Scanner userInputCollection = new Scanner(System.in);

	int numbersOfStudents;
	int numbersOfSubjects;



	while(true){
	try{

	System.out.print("\nHow many students do you have?: ");
	String student = userInputCollection.nextLine();
	while (student.isEmpty()) {
	System.out.print("Please enter a value. Empty spaces are not allowed: ");
	student = userInputCollection.nextLine();
	}

	numbersOfStudents = Integer.parseInt(student);

	if (numbersOfStudents <= 0) {
	System.out.println("Invalid Input, Number of students must be a positive integer.");
	} else{
	break;
	}

	}catch (InputMismatchException e){
	System.out.println("Invalid input, try again.\n");
	userInputCollection.next();
	}
	}



	while(true){
	try{

	System.out.print("\nHow many subjects do they offer?: ");
	String subject = userInputCollection.nextLine();
	while (subject.isEmpty()) {
	System.out.print("Please enter a value. Empty spaces are not allowed: ");
	subject = userInputCollection.nextLine();
	}

	numbersOfSubjects = Integer.parseInt(subject);

	if (numbersOfSubjects <= 0) {
	System.out.println("Invalid Input, Number of subjects must be a positive integer.");
	} else{
	break;
	}

	}catch (InputMismatchException e){
	System.out.println("Invalid input, try again.\n");
	userInputCollection.next();
	}
	}



	double[][] grades = new double[(int)numbersOfStudents][(int)numbersOfSubjects];



	for (int rows = 0; rows < numbersOfStudents; rows++) {

	System.out.println("\nEntering score for student " + (rows + 1));

	for (int cols = 0; cols < numbersOfSubjects; cols++) {

	while (true) {

	try {

	System.out.print("Enter score for subject " + (cols + 1) + ": ");
	
	grades[rows][cols] = userInputCollection.nextDouble();

	if (grades[rows][cols] < 0 || grades[rows][cols] > 100) {

	System.out.println("Inavlid input, Score must be between 0 to 100.\n");

	} else {

	break;

	}

	} catch (InputMismatchException e) {

	System.out.println("Invalid input. Please enter a score between 0 to 100\n.");

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

	for(int count = 0; count < numbersOfSubjects; count++){
	System.out.print("\tSUB" + (count + 1));
	}

	System.out.print("\tTOT\tAVE\n");

	System.out.println("===============================================================");

	

	for (int count = 0; count < numbersOfStudents; count++) {
	System.out.print("Student " + (count + 1) + ":\t");

	int total = 0;

	for (int counter = 0; counter < numbersOfSubjects; counter++) {

	System.out.print(grades[count][counter] + "\t");

	total += grades[count][counter];

	}

	double average = (double) total / numbersOfSubjects;

	System.out.printf("%d\t%.2f%n", total, average);

	}

	System.out.println("===============================================================");
	System.out.println("===============================================================");


     }
}