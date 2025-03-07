import java.util.Scanner;

public class TaskTen{

public static void main(String[] args){

Scanner userInputCollection = new Scanner(System.in);

int sum = 0;
int userInput = 0;
int average = 0;

for(int count = 1; count <= 10; count++){
System.out.print("Enter a number between 1 - 100: ");
userInput = userInputCollection.nextInt();

if(userInput < 1 || userInput > 100){
continue;
}else{
sum += userInput;
 }
}

average = sum/userInput;

System.out.println("Average of valid numbers: " + average);

  }

}