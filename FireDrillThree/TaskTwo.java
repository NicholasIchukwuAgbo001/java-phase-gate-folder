import java.util.Scanner;
import java.util.Arrays;

public class TaskTwo{
public static void main(String[] args){

Scanner userInputCollection = new Scanner(System.in);

int[] scores = new int[10];

for(int count = 0; count < 10; count++){
System.out.print("Enter score " + (count + 1) + ": ");
scores[count] = userInputCollection.nextInt();
 }

for(int counter = 0; counter < scores.length; counter++){
System.out.println(scores[counter]);
}

 }
}
