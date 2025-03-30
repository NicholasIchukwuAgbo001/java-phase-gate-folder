import java.util.Scanner;

public class taskEight{
public static void main(String[] args){

Scanner userInputCollection = new Scanner(System.in);

double scores = 0;
double sum = 0;
double average = 0;
int increment = 0;

for(int count = 1; count <= 10; count++){
System.out.print("Enter Score (0 - 100) ->" + (count) + ": ");
scores = userInputCollection.nextDouble();
if(scores < 0 || scores > 100){System.out.print("invalid number, enter number between (0 - 100)");
} else{
sum += scores;
 }
}

System.out.println("Sum of even numbers: " + sum);
System.out.println("Average of even numbers: " + average);
 }

}