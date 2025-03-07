import java.util.Scanner;

public class TaskOne{

public static void main(String[] args){

Scanner userInput = new Scanner(System.in);

int sum = 0;
int input = 0;

for(int counter = 1; counter <= 10; counter++){
System.out.print("Enter a number: ");
input = userInput.nextInt();
sum += input;
}

System.out.print("Sum is: " + sum);
  }

}