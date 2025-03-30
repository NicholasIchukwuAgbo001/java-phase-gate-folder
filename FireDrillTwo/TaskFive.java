import java.util.Scanner;

public class taskFive{
public static void main(String[] args){

Scanner userInputCollection = new Scanner(System.in);

double scores = 0;
double sum = 0;
double average = 0;

for(int count = 1; count <= 10; count++){
System.out.print("Enter Score" + (count) + ": ");
scores = userInputCollection.nextDouble();
if(scores % 2 == 0){
sum += scores;
}
}

System.out.println("Sum of even numbers: " + sum);
 }

}