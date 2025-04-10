import java.util.Scanner;

public class CreditCardValidator {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        System.out.print("Enter your credit card number: ");

        String creditCardNumber = userInput.nextLine();

        if (isValidCreditCardNumber(creditCardNumber)) {

            System.out.println("Credit Card Type: " + getCardType(creditCardNumber));

            System.out.println("Credit Card Number: " + creditCardNumber);

        } else {
            System.out.println("Invalid credit card number.");
        }
    }


    public static boolean isValidCreditCardNumber(String creditCardNumber) {

        if (creditCardNumber.length() < 13 || creditCardNumber.length() > 16) {

            return false;
        }

        return true;
    }



    public static String getCardType(String creditCardNumber) {

        if (creditCardNumber.startsWith("4")) {

            return "Visa Card";

        } else if (creditCardNumber.startsWith("5")) {

            return "Master Card";

        } else if (creditCardNumber.startsWith("37")) {

            return "American Express Card";

        } else if (creditCardNumber.startsWith("6")) {

            return "Discover Card";

        } else {
            return "Unknown";
        }
    }

}

