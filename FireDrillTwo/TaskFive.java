import java.util.Scanner;

public class TaskFive{

public static void main(String[] args){

Scanner userInputCollection = new Scanner(System.in);

int sumOfEven = 0;
int userInput = 0;

for(int count = 1; count <= 10; count++){
System.out.print("Enter a number: ");
userInput = userInputCollection.nextInt();

if(userInput % 2 == 0){
sumOfEven += count;
}
}

System.out.print("sum Of Even: " + sumOfEven);
  }

}