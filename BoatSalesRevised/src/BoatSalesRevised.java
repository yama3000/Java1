
//this project takes input data and displays boat receipt revised with loops 

import java.text.NumberFormat;
import java.util.Scanner;
import java.text.*;
import java.text.DecimalFormat;
import java.util.*;
	
public class BoatSalesRevised {
		//Variables
		static String iString;
		static String iBoatCost, iQty, cBoatType, iAccType;
		
		static char  iBoatType;
		static int cAccType, cQty, i, c;
		static double cBoatCost, cPrepCost;
		static double cMarkUpCost, cMarkUpCost2, cSubTotal, cAccCost, cMarkup, cTax, cTax2, cTotalSales;
		static double cGrandTotalSales, zBoatType;
		
		static Scanner myScanner;
		static NumberFormat nf;
		
		static char inputAgain = 'Y';
		static int cOrderCtr = 0;   //counter for number of orders
		static double cGTSales = 0;   //accum. for total pay
		
		static String oBoatLiteral, oAccLiteral, oBoatCost, oAccCost, oPrepCost;
		static String oMarkUpCost, oSubTotal, oTax, oTotalSales, oGTSales, oOrderCtr;
		static boolean valid;
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub

			init();
			while (inputAgain == 'Y') {
				input();
		
				calcs();
		
				output();
		
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
			//ask user to enter
			cBoatType = myScanner.nextLine().toUpperCase();
			//grab input change, change to uppercase
			while (cBoatType.trim().length() < 1 || cBoatType.trim().length() > 1) {
			// trim length to 1, then check if variable is at one
				System.out.print(" input must be one letter, re-Enter boat type:");
				//prompt to try again
				cBoatType = myScanner.next().toUpperCase();
				//grab input again
				}//while end
			//while loops until user enters a correct letter one variable long
			
			//inputAgain = myScanner.next().toUpperCase().charAt(0);
			//zBoatType = 9;
			while (zBoatType != 10){
				switch(cBoatType){
					case "B":
						oBoatLiteral = "Bass";
						cMarkup = 0.33;
						zBoatType = 10;
						break;
					case "P":
						oBoatLiteral = "Pontoon";
						cMarkup = 0.25;
						zBoatType = 10;
						break;
					case "S":
						oBoatLiteral = "Ski";
						cMarkup = 0.425;
						zBoatType = 10;
						break;
					case "C":
						oBoatLiteral = "Canoe";
						cMarkup = 0.20;
						zBoatType = 10;
						break;
					default:
						zBoatType = 9;
						System.out.println("wrong, must be B, P, S, or C.");
						System.out.print("Enter boat type:");
						cBoatType = myScanner.next().toUpperCase();
						break;
					
			
				}// switch end
			}//while end
		
		
			do {
				valid = true;			
				try {
					System.out.print("Enter Accessory type:");
					iString = myScanner.next();
					//get accessory type char
					cAccType = Integer.parseInt(iString);
					if ( cAccType < 1 || cAccType > 3) {
						System.out.println("must be 1 thru 3 try again");
					valid = false;
					} //if end
				}//try end
				 
				catch (Exception e) {
					System.out.println("must be an integer try again");
					valid = false;
					} //catch end
			
			}while (!valid); 
		
		
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
			
			do {
				valid = true;			
				try {
					System.out.print("Enter Quantity:");
					iString = myScanner.next();
					//get quantity type char
					cQty = Integer.parseInt(iString);
					if( cQty < 1 || cQty > 25) {
						System.out.println("must be 1 thru 25 try again");
					valid = false;
					} //if end
				}//try end
				 
				catch (Exception e) {
					System.out.println("must be an integer try again");
					valid = false;
					} //catch end
			
			}while (valid != true); 
			
			do {
				valid = true;			
				try {
					System.out.print("Enter Boat Cost:");
					iString = myScanner.next();
					//get boat cost 
					cBoatCost = Double.parseDouble(iString);
					// and turn into double
					if( cBoatCost < 2500.00 || cBoatCost > 150000.00) {
						System.out.println("must be 2500.00 thru 150000.00 try again");
					valid = false;
					} //if end
				}//try end
				 
				catch (Exception e) {
					System.out.println("must be a double try again");
					valid = false;
					} //catch end
			
			}while (valid != true); 
			
			do {
				valid = true;			
				try {
					System.out.print("Enter Prep Cost:");
					iString = myScanner.next();
					//get prep cost 
					cPrepCost = Double.parseDouble(iString);
					// and turn into double
					if( cPrepCost < 100.00 || cPrepCost > 9999.99) {
						System.out.println("must be 100.00 thru 9999.99 try again");
					valid = false;
					} //if end
				}//try end
				 
				catch (Exception e) {
					System.out.println("must be a double try again");
					valid = false;
					} //catch end
			
			}while (valid != true); 
			
			
			
			}//end of input
	
		public static void calcs( ) {
			cMarkUpCost = cBoatCost*cMarkup;
			cMarkUpCost2 = Math.round(cMarkUpCost * 100.00)/100.00;
			
			cSubTotal = (cBoatCost + cAccCost + cPrepCost+cMarkUpCost)*cQty;
			
			cTax = cSubTotal * 0.06;
			cTax2 = Math.round(cTax*100.0)/100.0;
			
			cTotalSales=cSubTotal+cTax2;
			
			cOrderCtr = cOrderCtr + 1;
			cGTSales=cGTSales + cTotalSales;
			
		}//Calcs end
	
	
	
		public static void output( ) {
			// line for looks
			for (int i=1; i<=47;i++) {
				System.out.print("_"); 
			}
			
			System.out.println(" ");
			System.out.println(" ");
		
			oBoatCost =nf.format(cBoatCost);
			oAccCost = nf.format(cAccCost);
			oPrepCost = nf.format(cPrepCost);
			oMarkUpCost = nf.format(cMarkUpCost2);
			oSubTotal = nf.format(cSubTotal);
			oTax = nf.format(cTax2);
			oTotalSales =nf.format(cTotalSales);
			
			
			System.out.format("%-20s%7s%20s%n", "Boat Type:"," ", oBoatLiteral);
			System.out.format("%-20s%7s%20s%n", "Accesory Type:"," ", oAccLiteral);
			System.out.format("%-20s%7s%20s%n", "Quantity:"," ", cQty);
			System.out.format("%-20s%7s%20s%n", "Boat cost:"," ", oBoatCost);
			System.out.format("%-20s%7s%20s%n", "Accesory Cost:"," ", oAccCost);
			System.out.format("%-20s%7s%20s%n", "Prep Cost:"," ", oPrepCost);
			System.out.format("%-20s%7s%20s%n", "Mark Up Cost:"," ", oMarkUpCost);
			System.out.println("                     ");
			System.out.format("%-20s%7s%20s%n", "Subtotal Cost:"," ", oSubTotal);
			System.out.format("%-20s%7s%20s%n", "Tax Cost:"," ", oTax);
			System.out.println("                      ");
			System.out.format("%-20s%7s%20s%n", "Total Sales:"," ", oTotalSales);
			
			System.out.println("-----------------------------------------------");
			
		}//output end
	
		public static void closing( ) {
			
			oGTSales = nf.format(cGTSales);
			//oOrderCtr = format(cOrderCtr);
			
			System.out.format("%-20s%7s%20d%n", "Total Orders:"," ", cOrderCtr);
			System.out.format("%-20s%7s%20s%n", "Grand total Sales:"," ", oGTSales);
		}//closing end

} //final curly bracket

	
	
	
