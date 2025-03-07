import java.util.Scanner;

public class TaskOne {
public static void main(String[] args){

Scanner input = new Scanner(System.in);
double[] scores = new double[10];
double[] result = collectTenScore(scores);

}

public static double[] collectTenScore (double[] scores){

Scanner input = new Scanner(System.in);

for (int count = 0; count < 10; count++){
System.out.print("Enter a number: "": ");
double score = input.nextDouble();
scores[count] = score;
}
return scores;
}

}
