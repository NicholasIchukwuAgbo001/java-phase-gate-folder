package PoliticalZones;

import java.util.Scanner;

public class PoliticalZoneMain {

    public static void main(String[] args) {

        Scanner UserInput = new Scanner(System.in);
        String state = "";

        while (true) {
            try {
                System.out.print("Enter a state: ");
                state = UserInput.nextLine();
                break;
            }catch (Exception e){
                System.out.println("Invalid Statexb ");
            }
        }
        if (state == null || state.isEmpty()) {
            System.out.println("Invalid state name");
        }else {

            System.out.println("Your political zone is: " + PoliticalZone.getZone(state));
        }

    }

}


