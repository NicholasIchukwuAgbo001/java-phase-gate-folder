
import java.util.Arrays;
public class TaskFourUpword {

public static int[] taskFour(int[] arrays) {

  int[] result = new int[arrays.length / 2];

  int counter = 0;

  for (int count = 0; count < arrays.length; count++) {

  if (count % 2 == 0) {

   result[counter] = arrays[count];
   counter++;
        
    }
   }
return result;
    }



public static int[] taskFive(int[] arrays) {

  int[] result = new int[arrays.length / 2];

  int counter = 0;

  for (int count = 0; count < arrays.length; count++) {

  if (count % 2 != 0) {

   result[counter] = arrays[count];
   counter++;
        
    }
   }
return result;
    }



public static int taskSix(int[] arrays) {

 int sum = 0;

 for (int count = 0; count < arrays.length; count++) {
    
  if (count % 2 == 0) {
  sum += arrays[count];
  }
 }

 return sum;
  }



public static int taskSeven(int[] arrays) {

 int sum = 0;

 for (int count = 0; count < arrays.length; count++) {
    
  if (count % 2 != 0) {
  sum += arrays[count];
  }
 }

 return sum;
  }


public static int taskEight(int[] arrays) {

 int min = arrays[0];

 for (int count = 0; count < arrays.length; count++) {
    
  if (arrays[count] < min) {
  min += arrays[count];
  }
 }

 return min;
  }


public static int tast12(int[] arrays) {

int[] swapping = new int[arrays.length];

for(int count = 0; count < arrays.length; count++){


}

}




public static void main(String[] args) {

int[] arrays = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

System.out.println(Arrays.toString(taskFour(arrays)));

System.out.println(Arrays.toString(taskFive(arrays)));

System.out.println("Sum of Even numbers: " + taskSix(arrays));

System.out.println("Sum of Odd numbers: " + taskSeven(arrays));

System.out.println("Minimum: " + taskEight(arrays));

}


}



