/*santa helper program
*
*/


import java.text.*;
import java.util.*;

public class SantasHelper {
	
	//declare variables
	static String iString;
	static String iFirstName, iLastName;
	static String iFirstToyName, iSecondToyName;
	static String iFirstToyPrice, iSecondToyPrice;
	
	static double cFirstToyPrice, cSecondToyPrice;
	static String oFirstToyPrice, oSecondToyPrice;
	static double cTax, cSubTotal, cTotalBill;
	static String oTax, oSubTotal, oTotalBill;
	static Scanner myScanner;
	static NumberFormat nf;

public static void main(String[] args) {
		// TODO Auto-generated method stub
	//call INIT, INPUT, CALCS, OUTPUT
	init();
	
	input();
	
	calcs();
	
	output();
	
	System.out.println("We wish you a merry Christmas!");

	}

public static void init() {
	//set scanner to the console
	myScanner = new Scanner(System.in);
	
	myScanner.useDelimiter(System.getProperty("line.separator"));
	//SETS UP US CURRENCY 
	nf = NumberFormat.getCurrencyInstance(java.util.Locale.US);
	}

public static void input() {
	//prompt FIRSTNAME, LASTNAME, TOY NAMES AND PRICES
	System.out.print("Enter first name:");
	iFirstName = myScanner.next();
	
	System.out.print("Enter last name:");
	iLastName = myScanner.next();
	
	System.out.print("Enter first toy's name:");
	iFirstToyName = myScanner.next();
	
	
	//CHECKS TOY PRICE IS A DOUBLE
	try {
		System.out.print("Enter first toy price:");
		iString = myScanner.next();
		//CONVERTS TO DOUBLE
		cFirstToyPrice = Double.parseDouble(iString);
		
	}
	catch (Exception e) {
		System.out.println("price must be a double");
		cFirstToyPrice =0;
	}
	
	System.out.print("Enter second toy's name:");
	iSecondToyName = myScanner.next();
	
	//CHECKS TOY PRICE IS A DOUBLE
	try {
		System.out.print("Enter second toy price:");
		iString = myScanner.next();
		cSecondToyPrice = Double.parseDouble(iString);
		
	}
	catch (Exception e) {
		System.out.println("price must be a double");
		cSecondToyPrice =0; }
	}
public static void calcs() {
		//CALCULATIONS
		cSubTotal = cFirstToyPrice + cSecondToyPrice;
		cTax = cSubTotal * 0.07;
		cTotalBill = cSubTotal + cTax;
		}
//FORMAT AND OUTPUT
public static void output() {
//OUTPUT NAME
	System.out.println("Name: " + iFirstName + ","+ iLastName);
	
//TOY NAME 1
	System.out.println(" first Toy Name:" + iFirstToyName);
	
//OUTPUT 1ST TOY PRICE
	oFirstToyPrice = nf.format(cFirstToyPrice);
	System.out.println("1st toy price: " + oFirstToyPrice);
	
//TOY NAME 2
	System.out.println(" SECOND Toy Name:" + iSecondToyName);
	
//OUTPUT 2ND TOY PRICE
	oSecondToyPrice =nf.format(cSecondToyPrice);
	System.out.println("2nd toy price: " + oSecondToyPrice);
	
//OUTPUT SUBTOTAL
	oSubTotal =nf.format(cSubTotal);
	System.out.println("subtotal: " + oSubTotal);
	
//OUTPUT TAX	
	oTax =nf.format(cTax);
	System.out.println("tax: " + oTax);
	
//OUTPUT TOTAL BILL	
	oTotalBill =nf.format(cTotalBill);
	System.out.println("Total " + oTotalBill);	

}

}
