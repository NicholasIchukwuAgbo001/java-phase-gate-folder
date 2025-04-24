package menstrualApp;
import java.util.Scanner;

public class MenstrualTrackerMain {

    public static void main(String[] args) {
        MenstrualTracker menstrualApp = new MenstrualTracker();
        Scanner userInputCollection = new Scanner(System.in);

        int cycleLength;
        int periodLength;

        while (true) {
            try {
                System.out.print("\nEnter your last menstrual period date (yyyy-MM-dd): ");
                String lastDate = userInputCollection.nextLine();
                menstrualApp.lastDate(lastDate);
                break;
            } catch (Exception e) {
                System.out.println("\nInvalid date entered. Please try again.");
            }
        }

        while(true) {
            try {
                System.out.print("\nEnter your main cycle length: ");
                String cycleLengthStr = userInputCollection.nextLine();
                if(!cycleLengthStr.matches("\\d+")) {
                    System.out.print("\nInvalid input. Please try again.: ");
                }else {
                    cycleLength = Integer.parseInt(cycleLengthStr);
                    menstrualApp.cycleLength(cycleLength);
                    break;
                }
            }catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }

        while(true) {
            try {
                System.out.print("\nEnter your main period length: ");
                String periodLengthStr = userInputCollection.nextLine();
                if(!periodLengthStr.matches("\\d+")) {
                    System.out.print("\nInvalid input. Please try again.: ");
                }else {
                    periodLength = Integer.parseInt(periodLengthStr);
                    menstrualApp.periodLength(periodLength);
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("\nYour ovulation date is: " + menstrualApp.calculateOvulationDate());
        System.out.println("Your fertile start date is: " + menstrualApp.calculateFertileStartDate());
        System.out.println("Your fertile end date is: " + menstrualApp.calculateFertileEndDate());
        System.out.println("Your next period date is: " + menstrualApp.predictNextPeriodDate());
        System.out.println("Your safe start date (BEFORE) is: " + menstrualApp.predictNextPeriodDate() + " to " + menstrualApp.safeStartDate());
        System.out.println("Your safe end date (AFTER) is: " + menstrualApp.safeEndDate() +  " to " + menstrualApp.safeEndDate2());
        System.out.println("Stay Safe Biko");
    }

}
