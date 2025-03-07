import java.util.Scanner;

public class TaskSix{

public static void main(String[] args){

Scanner userInputCollection = new Scanner(System.in);

int sumOfEven = 0;
int userInput = 0;
int average = 0;

for(int count = 1; count <= 10; count++){
System.out.print("Enter a number: ");
userInput = userInputCollection.nextInt();

if(userInput % 2 == 0){
sumOfEven += count;
}
}

average = sumOfEven/ userInput;
System.out.print("Average: " + average);
  }

}