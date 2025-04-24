import java.util.Scanner;

public class CreditCardValidator {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        System.out.print("Enter your credit card number: ");

        String creditCardNumber = userInput.nextLine();

        if (isValidCreditCardNumber(creditCardNumber)) {

            System.out.println("Credit Card Type: " + getCardType(creditCardNumber));

            System.out.println("Credit Card Number: " + creditCardNumber);

	    System.out.println("Credit Card Validity Status: Valid" );

        } else {
	    System.out.println("Credit Card Type:  Invalid card");
            System.out.println("Credit Card Number: " + creditCardNumber);
            System.out.println("Credit Card Validity Status: Invalid" );
        }
    }



    public static boolean isValidCreditCardNumber(String creditCardNumber) {

        int sum = 0;

        for (int count = 0; count < creditCardNumber.length(); count++) {

        int num = Integer.parseInt(creditCardNumber.substring(count, count + 1));

        if (count % 2 == 0) {

        num *= 2;

        if (num > 9) {

        num -= 9;

        }

        }

       sum += num;

        }

        return (sum % 10 == 0);
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

