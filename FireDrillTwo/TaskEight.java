import java.util.Scanner;

public class TaskEight{

public static void main(String[] args){

Scanner userInputCollection = new Scanner(System.in);

int sum = 0;
int userInput = 0;

for(int count = 1; count <= 10; count++){
System.out.print("Enter a number between 0 - 100: ");
userInput = userInputCollection.nextInt();

if(userInput < 0 || userInput > 100){
System.out.println("invalid, try again");
}else{
sum += userInput;
 }
}

System.out.println("Sum of valid numbers: " + sum);

  }

}