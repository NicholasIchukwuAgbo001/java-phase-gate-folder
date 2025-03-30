public class TaskSix {

    public static void main(String[] args) {

    int result = 1;

    for (int count = 1; count <= 10; count++) {

     if (count % 4 == 0) {

    for (int counter = 0; counter < 5; counter++) {

     result *= count;

     System.out.print(result + " ");
      }
     }
   }

 

  }
}

