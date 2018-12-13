import java.text.*;
import java.util.*;

public class BoatSales {
	//Variables
	static String iString;
	static String iBoatCost, iQty, cBoatType, iAccType;
	
	static char  iBoatType;
	static int cAccType, cQty;
	
	static double cBoatCost, cPrepCost;
	static double cMarkUpCost, cSubTotal, cAccCost, cMarkup, cTax, cTotalSales;
	static double cGrandTotalSales;
	
	static Scanner myScanner;
	static NumberFormat nf;
	
	static char inputAgain = 'Y';
	static int cOrderCtr = 0;   //counter for number of orders
	static double cGTSales = 0;   //accum. for total pay
	
	static String oBoatLiteral, oAccLiteral, oBoatCost, oAccCost, oPrepCost;
	static String oMarkUpCost, oSubTotal, oTax, oTotalSales, oGTSales, oOrderCtr;
	
public static void main(String[] args) {
		// TODO Auto-generated method stub

	init();
	while (inputAgain == 'Y') {
		input();
	
		calcs();
	
		output();
	
		cOrderCtr = cOrderCtr + 1;
		cGTSales = cGTSales + cTotalSales;
	
	
		System.out.print("Do you want to place another order ? :");
		inputAgain = myScanner.next().toUpperCase().charAt(0);
		//ask if the want to do another order
		System.out.println("                     ");
	}//while loop end
	
	closing();
	
	} // main curly bracket

public static void init( ) {
	myScanner = new Scanner(System.in);
	
	myScanner.useDelimiter(System.getProperty("line.separator"));
	
	nf = NumberFormat.getCurrencyInstance(java.util.Locale.US);
} // init end

public static void input( ) {
	
	System.out.print("Enter boat type:");
	iBoatType = myScanner.next().toUpperCase().charAt(0);
	//get boat type char
	
	switch(iBoatType){
		case 'B':
			oBoatLiteral = "bass";
			cMarkup = 0.33;
			break;
		case 'P':
			oBoatLiteral = "Pontoon";
			cMarkup = 0.25;
			break;
		case 'S':
			oBoatLiteral = "Ski";
			cMarkup = 0.425;
			break;
		case 'C':
			oBoatLiteral = "Canoe";
			cMarkup = 0.20;
			break;
		default:
			oBoatLiteral = "Ski";
			cMarkup = 0.33;
			System.out.println("Not a valid option default to Ski");
			break;
	}// switch end
	
	
	try {
		System.out.print("Enter Accessory type:");
		iString = myScanner.next();
		//get accessory type char
		cAccType = Integer.parseInt(iString);
		if( cAccType < 1 || cAccType > 3) {
			System.out.println("acc default to 1");
			cAccType = 1;
		} //if end
	}
	catch (Exception e) {
		System.out.println("accessory must be integer 1-3 default to 1");
		cAccType =1;
	}
	
	
	switch(cAccType){
		case 1:
			oAccLiteral = "Electronics";
			cAccCost = 5415.30;
			break;
		case 2:
			oAccLiteral = "Ski Package";
			cAccCost = 3980.00;
			break;
		case 3:
			oAccLiteral = "Fishing Package";
			cAccCost = 345.45;
			break;
		default:
			oAccLiteral = "Electronics";
			cAccCost = 5415.30;
		break;
	}// switch end
	
	try {
		System.out.print("Enter Quantity:");
		iString = myScanner.next();
		//get quantity 
		cQty = Integer.parseInt(iString);
		//convert to integer
		if( cQty < 1 || cQty > 25) {
		System.out.println("Quantity default to 1");
		cQty = 1;
		} //if end
	} // try end
	
	catch (Exception e) {
		System.out.println("Quantity must be integer 1-25, Quantity default to 1");
		cQty =1;
	} //catch end
	
	try {
		System.out.print("Enter boat cost:");
		iString = myScanner.next();
		//get boat cost
		cBoatCost = Double.parseDouble(iString);
		//convert to Double
		if( cBoatCost < 2500.00 || cBoatCost > 150000.00) {
		System.out.println("Boat cost default to 25,000");
		cBoatCost = 25000.00;
		} //if end
	} //try end
	
	catch (Exception e) {
		System.out.println("boat cost must be double default to $25000.00");
		cBoatCost =25000.00;
	} //catch end
	
	try {
		System.out.print("Enter Prep cost:");
		iString = myScanner.next();
		//get boat cost
		cPrepCost = Double.parseDouble(iString);
		//convert to Double
		if( cPrepCost < 100.00 || cPrepCost > 9999.99) {
		System.out.println("prep cost default to 5,000");
		cPrepCost = 5000.00;
		}
	}
	
	catch (Exception e) {
		System.out.println("prep cost must be double default to 5000.00");
		cPrepCost =5000.00;
	}
	
	}//end of input

public static void calcs( ) {
	cMarkUpCost = cBoatCost*cMarkup;
	cSubTotal = (cBoatCost + cAccCost + cPrepCost+cMarkUpCost)*cQty;
	cTax = cSubTotal * 0.06;
	cTotalSales=cSubTotal+cTax;
	
	
}//Calcs end



public static void output( ) {

	//space line for looks
	System.out.println("                            ");
	
	//OUTPUT boat literal
	System.out.println("Boat type: " + oBoatLiteral);
	
	//OUTPUT boat literal
	System.out.println("Accesory Type: " + oAccLiteral);
	
	//output quantity
	System.out.println("Quantity: " + cQty);
	
	//output boat cost
	oBoatCost =nf.format(cBoatCost);
	System.out.println("Boat Cost: " + oBoatCost);
	
	//accessory cost
	oAccCost = nf.format(cAccCost);
	System.out.println("Accesory Cost: " + oAccCost);

	//Prep cost
	oPrepCost = nf.format(cPrepCost);
	System.out.println("Prep Cost: " + oPrepCost);
	
	//Mark up amount
	oMarkUpCost = nf.format(cMarkUpCost);
	System.out.println("Mark up Cost: " + oMarkUpCost);
	
	//subtotal
	oSubTotal = nf.format(cSubTotal);
	System.out.println("Subtotal Cost: " + oSubTotal);
	
	//tax output
	oTax = nf.format(cTax);
	System.out.println("Tax Cost: " + oTax);
	
	//totalSales
	oTotalSales = nf.format(cTotalSales);
	System.out.println("Total Sales: " + oTotalSales);
	
	System.out.println("                     ");
	
}//output end

public static void closing( ) {
	
	
	System.out.println("Total orders: " + cOrderCtr);
	
	oGTSales = nf.format(cGTSales);
	System.out.println("Grand Total Sales: " + oGTSales);
}

} //final curly bracket
