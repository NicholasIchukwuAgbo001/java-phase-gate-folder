import java.util.Scanner;

public class taskNine{
public static void main(String[] args){

Scanner userInputCollection = new Scanner(System.in);

double scores = 0;
double sum = 0;
double average = 0;
int increment = 0;

for(int count = 1; count <= 10; count++){
System.out.print("Enter Score (0 - 100) ->" + (count) + ": ");
scores = userInputCollection.nextDouble();
if(scores < 0 || scores > 100){
continue;
} else{
sum += scores;
 }
}

System.out.println("Sum of even numbers: " + sum);
 }

}