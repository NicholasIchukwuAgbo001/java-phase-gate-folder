package PoliticalZones;

import java.util.Scanner;

import static PoliticalZones.PoliticalZone.getZone;

public class PoliticalZoneMain {

    public static void main(String[] args) {

        Scanner UserInput = new Scanner(System.in);

        System.out.print("Enter a state: ");
        String state = UserInput.nextLine();

        PoliticalZone zone = getZone(state);

        if (zone == null) {

            System.out.println("Invalid state name");

        }else {

            System.out.println("Your political zone is " + zone);
        }

    }

}


