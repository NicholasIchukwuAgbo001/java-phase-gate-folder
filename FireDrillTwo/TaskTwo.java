import java.util.Scanner;

public class TaskTwo{

public static void main(String[] args){

Scanner userInputCollection = new Scanner(System.in);

int sum = 0;
int userInput = 0;
int average = 0;

for(int count = 1; count <= 10; count++){
System.out.print("Enter a number: ");
userInput = userInputCollection.nextInt();
sum += userInput;
}

average = sum/userInput;
System.out.print("Average is: " + average);
  }

}