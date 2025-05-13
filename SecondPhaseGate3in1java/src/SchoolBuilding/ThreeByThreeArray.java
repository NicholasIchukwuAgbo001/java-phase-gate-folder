package SchoolBuilding;

public class ThreeByThreeArray {

    public static void markPoint(boolean[][] array){
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                if (array[row][col]){
                    System.out.print("  1  ");
                }else {
                    System.out.print("  0  ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        boolean[][] array = {
                {true, false, true},
                {false, true, true},
                {true, true, true}
               };
         markPoint(array);

    }


}
