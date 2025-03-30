import java.util.Scanner;

public class taskOne{
public static void main(String[] args){

Scanner userInputCollection = new Scanner(System.in);

double scores = 0;
double sum = 0;

for(int count = 1; count <= 10; count++){
System.out.print("Enter Score" + (count) + ": ");
scores = userInputCollection.nextDouble();
sum += scores;
}


System.out.print("Sum: " + sum);
 }

}