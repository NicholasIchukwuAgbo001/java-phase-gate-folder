
import java.util.Scanner;

public class CreditCardValidator {

    public static void main(String[] args) {

        Scanner userInputCollection = new Scanner(System.in);

    	String cardType = "";
	int cardnumber;

        System.out.print("Hello, kindly enter card deatils to verify: ");
        String creditCardNumber = userInputCollection.nextLine();

	cardnumber = Integer.parseInt(creditCardNumber);

	for(int count = 0; count < cardnumber; count++){

        if (creditCardNumber.startsWith("4")) {

            cardType = "Visa Card";

        } else if (creditCardNumber.startsWith("5")) {

            cardType = "Master Card";

        } else if (creditCardNumber.startsWith("37")) {

            cardType = "American Express Card";

        } else if (creditCardNumber.startsWith("6")) {

            cardType = "Discover Card";

        } else {

            cardType = "Unknown";
        }

     }

        System.out.println("Credit Card Type: " + cardType);
	System.out.println("Credit Card number: " + creditCardNumber);
        
  }

}