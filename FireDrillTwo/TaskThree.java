import java.util.Scanner;

public class taskThree{
public static void main(String[] args){

Scanner userInputCollection = new Scanner(System.in);

double scores = 0;
double sum = 0;
double average = 0;

for(int count = 1; count <= 10; count++){
System.out.print("Enter Score" + (count) + ": ");
scores = userInputCollection.nextDouble();
sum += scores;
average = sum/count;
}
System.out.println("Sum: " + sum);
System.out.println("Average: " + average);
 }

}