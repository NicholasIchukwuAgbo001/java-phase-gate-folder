import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.*;



public class CheckOuts{
	
	public static void main(String[] args){

	Scanner userInput = new Scanner(System.in);

	ArrayList<String> goodsPurchase = new ArrayList<>();

	ArrayList<Integer> numberOfGoodsPurchase = new ArrayList<>(); 
	
	ArrayList<Double> pricePerUnit = new ArrayList<>();
	
	ArrayList<Double> total = new ArrayList<>();

	String customerName;
	String goods;
	int numberOfGoods;
	double price;
	String optional;
	double subTotal = 0;
	double discount;
	double discountAmount;
	double vat;
	double billTotal;
	double balance = 0;
	double amountPaid;
		
	System.out.print("Customer's Name?: ");
	customerName = userInput.nextLine();
	
	while(!customerName.matches("[a-zA-Z\\s]+")){
	System.out.print("Invalid name, try again: ");
	customerName = userInput.nextLine();
	}

      do{ 
	System.out.print("What did the customer buy?: ");
	goods = userInput.nextLine();
	
	while(!goods.matches("[a-zA-Z\\s]+")){
  	System.out.print("Invalid name, try again: ");
	goods = userInput.nextLine();
	}goodsPurchase.add(goods);

  while(true) {
    try {
        System.out.print("How many pieces?: ");
        numberOfGoods = userInput.nextInt();
        break;
        } catch (InputMismatchException e) {
        System.out.print("Invalid input. try again: ");
        userInput.next();
        }
	}
	while(numberOfGoods < 1){
        System.out.print("invalid, Try again: " );
        numberOfGoods = userInput.nextInt();
	}numberOfGoodsPurchase.add(numberOfGoods);

  while(true){
      try{
	System.out.print("How mush per unit?: ");
	price = userInput.nextDouble();
	break;
	}catch(InputMismatchException e){
	System.out.print("Invalid input, try again: ");
	userInput.next();
	}
	}	
	while(price < 1) {
        System.out.print("invalid Amount, try again: " );
        price = userInput.nextDouble();
	}pricePerUnit.add(price);

   	double totalAmount = numberOfGoods * price;
	total.add(totalAmount);
	subTotal += totalAmount;
  	
	System.out.print("Add more items? (Yes/No): ");
	optional = userInput.nextLine();
	optional = userInput.nextLine();
	
	while(!optional.equalsIgnoreCase("yes") && !optional.equalsIgnoreCase("no")){
	System.out.print("Invalid choice, kindly select (yes/no): ");
	optional = userInput.nextLine();
	
	  }

	} while (optional.equalsIgnoreCase("Yes"));
  
	if(optional.equalsIgnoreCase("No")){
	
	System.out.print("Cashier Name: ");
	String cashierName = userInput.nextLine();

	while(!cashierName.matches("[a-zA-Z\\s]+")){
	System.out.print("invalid name, kindly input ya name: ");
	cashierName = userInput.nextLine();
	}

  while(true){
      try{
	System.out.print("How mush discount will He get: ");
	discount = userInput.nextDouble();
	break;
	} catch(InputMismatchException e){
	System.out.print("Invalid Input, try again");
	userInput.next();
	}
	}
	while(discount < 0) {
        System.out.print("invalid, Try again: " );
        discount = userInput.nextInt();
	}

	System.out.print("""

	SEMICOLON STORES
	MAIN BRANCH
	LOCATION: Sabo, yaba lagos
	TEL: 0468348456
	DATE: 2-12-2024 8:46:14
	""");
	System.out.println("Cashier: " + cashierName);
	System.out.println("Customer's Name: " + customerName);
	System.out.println("""
	===================================================
		ITEMS	QTY	PRICE	TOTAL(NGN)
	===================================================
	""");

	discountAmount = (subTotal / 100) * discount;
	vat = subTotal * 0.175;
	billTotal = (subTotal + vat) - discountAmount;

	for(int counter = 0; counter < goodsPurchase.size(); counter++){
	System.out.printf("\t%s\t%d\t%.2f\t%.2f%n", goodsPurchase.get(counter), numberOfGoodsPurchase.get(counter),  pricePerUnit.get(counter),  total.get(counter));
	}

	System.out.println("""
	===================================================
	""");
	System.out.printf("\t\t\t%s%.2f%n", "Sub Total: ", subTotal);
	System.out.printf("\t\t\t%s%.2f%n", "Discount Amount: ", discountAmount);
	System.out.printf("\t\t\t%s%.2f%n", "VAT: ", vat);
	System.out.printf("\t\t\t%s%.2f%n", "Bill Total: ", billTotal);

	System.out.println("""
	===================================================
	""");
	System.out.printf("\t%s%.2f%n", "THIS IS NOT A RECIEPT KINDLY PAY: ", billTotal);
	System.out.println("""
	===================================================
	""");
  
   while(true){
       try{
	System.out.print("How much did the customer give you?: ");
	amountPaid = userInput.nextDouble();
	break;
	} catch(InputMismatchException e){
	System.out.print("invalid, try again");
	userInput.next();
	}
	}

	while(amountPaid < billTotal) {
        System.out.print("Please kindly pay the exact amount(" + billTotal + "):  " );
        amountPaid = userInput.nextDouble();
	}

	System.out.print("""

	SEMICOLON STORES
	MAIN BRANCH
	LOCATION: SABO, YABA LAGOS
	TEL: 0468348456
	Date: 28-Dec-22 8:48:11pm
	""");
	System.out.println("Cashier: " + cashierName);
	System.out.println("Customer's Name: " + customerName);
	System.out.println("""
	====================================================
		ITEMS	QTY	PRICE	TOTAL(NGN)
	====================================================
	""");

	discountAmount = subTotal * 0.075;
	vat = subTotal * 0.175;
	billTotal = (subTotal + vat) - discountAmount;
	balance = amountPaid - billTotal;


	for(int counter = 0; counter < goodsPurchase.size(); counter++){
	System.out.printf("\t%s\t%d\t%.2f\t%.2f%n", goodsPurchase.get(counter), numberOfGoodsPurchase.get(counter),  pricePerUnit.get(counter),  total.get(counter));
	}


	System.out.println("""
	====================================================
	""");
	System.out.printf("\t\t\t%s%.2f%n", "Sub Total: ", subTotal);
	System.out.printf("\t\t\t%s%.2f%n", "Discount Amount: ", discountAmount);
	System.out.printf("\t\t\t%s%.2f%n", "VAT: ", vat);
	System.out.printf("\t\t\t%s%.2f%n", "Bill Total: ", billTotal);
	System.out.printf("\t\t\t%s%.2f%n", "Amount Paid: ", amountPaid);
	System.out.printf("\t\t\t%s%.2f%n", "Balance: ",  balance);
	System.out.println("""
	===================================================

			THANK YOU FOR PATRONAGE
	===================================================
	""");


      }

    }

}