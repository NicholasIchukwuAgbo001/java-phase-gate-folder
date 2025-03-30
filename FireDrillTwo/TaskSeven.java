import java.util.Scanner;

public class taskSeven{
public static void main(String[] args){

Scanner userInputCollection = new Scanner(System.in);

double scores = 0;
double sum = 0;
double average = 0;
int increment = 0;

for(int count = 1; count <= 10; count++){
System.out.print("Enter Score" + (count) + ": ");
scores = userInputCollection.nextDouble();
if(scores % 2 == 0){
sum += scores;
increment++;
}
}
average = sum/increment;
System.out.println("Sum of even numbers: " + sum);
System.out.println("Average of even numbers: " + average);
 }

}