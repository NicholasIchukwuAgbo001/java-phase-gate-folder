import java.util.Scanner;

public class TaskFour{

public static void main(String[] args){

Scanner userInputCollection = new Scanner(System.in);

int sum = 0;
int userInput = 0;

for(int count = 1; count <= 10; count++){
System.out.print("Enter a number: ");
userInput = userInputCollection.nextInt();

if(count % 2 == 0){
sum += userInput;
}
}

System.out.print("sum of index (2,4,6,8,10): " + sum);
  }

}