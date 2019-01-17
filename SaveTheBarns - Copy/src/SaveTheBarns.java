/*this project takes inputs and shows what groups contributed
 *  main purpose decision statements
 *  Jake Christy 1/16/19
*/
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.text.*;
import java.text.DecimalFormat;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


	
public class SaveTheBarns {
		//Variables
		static String iString;
		static String iName, iAdd, iCity, iState, iZip, iParty;
		
		static String  iGender;
		static int   iExample, cZip;
		static double cState;
		static double iCon, iConTotal;
		static double cM=0, cF=0, cR=0, cD=0, cI=0, cT=0;
		static double cMD=0, cMR=0, cMI=0, cFD=0, cFR=0, cFI=0;
		static int cMCTR=0, cFCTR=0,cRCTR=0, cDCTR=0, cICTR=0, cTCTR=0;
		static int cMDCTR=0, cMRCTR=0, cMICTR=0, cFDCTR=0, cFRCTR=0, cFICTR=0;
		static double cMavg=0, cFavg=0, cDavg=0, cRavg=0, cIavg=0, cTavg=0;
		static double cMDavg=0, cMRavg=0, cMIavg=0, cFDavg=0, cFRavg=0, cFIavg=0;
		
		static Scanner myScanner;
		static NumberFormat nf;
		static boolean eof = false;
		static PrintWriter pw;
		static String error;
		
		static int cPeopleCtr = 0, iCaseCheck = 9;  //counter for number of orders
		static double cTotalCon = 0;   //accum. for total pay
		
		static String oM, oF, oR, oD, oI, oMD, oMR, oMI, oFD, oFR, oFI;
		static boolean valid = true;
		
		static Date iDate;
		static LocalDate userDate;
		static LocalDate today = LocalDate.now();
		static SimpleDateFormat dtf;
		
		public static void main(String[] args) {
			
			init();
			
			while(!eof) {
		
				calcs();
		
				output();
				
				input();
				
								
			}//while loop end
			
			totals();
			
			closing();
		
		} // main curly bracket

		public static void init( ) {
			
			 iDate = new Date();
			
			dtf = new SimpleDateFormat("MM/dd/yyyy");
			
			nf = NumberFormat.getCurrencyInstance(java.util.Locale.US);
		
			try {
				myScanner = new Scanner(new File("contributors5.dat"));
				myScanner.useDelimiter(System.getProperty("line.separator"));
			}//try end 
			catch (FileNotFoundException e1) {
				System.out.println("File error");
				System.exit(1);
			}//catch end
		
			try {
				pw = new PrintWriter(new File ("error.prt"));
			}//try end
			catch (FileNotFoundException e) {
				System.out.println("Output file error");
			}//catch end
			
						//do initial read
			input();
		} // init end

		public static void input( ) {
			valid = true;
			String record;
			
			if (myScanner.hasNext()) {
				record = myScanner.next();
				iName = record.substring(0,25);	//file position 1 - 25
				iAdd = record.substring(25,50);	//25 - 50
				iCity = record.substring(50,65);
				iState = record.substring(65,67);
				iZip = record.substring(67,72);
				iParty = record.substring(72,73);
				iGender = record.substring(73,74);	
				iString = record.substring(74,81);	//74-81
					
			}// if end
			else {
				eof=true;	//no more records so set eof to true
			}	
				
			
				if (iName.length() > 25 || iName.trim().length() < 1) {
					error = "Name length";
					
					valid = false;
				}	

				if (iAdd.length() > 25 || iAdd.trim().length() < 1) {
					error = "Address length";
					
					valid = false;
				}//if end
				
				if (iCity.length() > 15 || iCity.trim().length() < 1) {
					error = "City length";
					
					valid = false;
				}//if end
				
				if (iState.length() > 2 || iState.trim().length() < 1) {
					error = "State length";
					
					valid = false;
				}
				
					
				if (iZip.length() > 5 || iZip.trim().length() < 1) {
					error = "Zip length";
					
					valid = false;
				}
				try { 
					
					cZip = Integer.parseInt(iZip);
				
				}//try end
				catch (Exception e) {
			
					error = "zip cant be a letter";
					valid = false;
				}
				
					
				if (iParty.length() > 1 || iParty.trim().length() < 1) {
					error = "Party length";
					valid = false;
				}
				switch(iParty){
					case "D":
				
						break;
					case "R":
					
						break;
					case "I":
						
						break;
					default:
						error = "Party Not D,R, or I";
						valid = false;
						break;
				}	
				
				if (iGender.length() > 1 || iGender.trim().length() < 1) {
					error = "Gender length";
					valid = false;
				}
				
				switch(iGender){
				case "M":
			
					break;
				case "F":
				
					break;
				default:
					error = "Gender not M or F";
					valid = false;
					break;
			}		
				try { 
				
					iCon = Double.parseDouble(iString);
				
				}//try end
				catch (Exception e) {
			
					error = "Con not a double";
					valid = false;
				}
				
			if (iCon < 0.01 || iCon > 9999.99) {
				error = "Con. size wrong";
				valid = false;
			}
			
			if (valid == false) {
				pw.format("%20s%5s%25s%5s%25s%5s%15s%5s%2s%5s%5s%5s%1s%5s%1s%5s%9.2f%n", error, " ", iName, " ",iAdd," ",iCity," ",iState," ",iZip," ",iParty," ", iGender," ", iCon);
				input();	
			}
			}//end of input
	
		public static void calcs( ) {
				switch(iParty){
					case "D":
						cD=cD+iCon;
						cDCTR++;
						cDavg=cD/cDCTR;
						break;
					case "R":
						cR = cR + iCon;
						cRCTR++;
						cRavg=cR/cRCTR;
						break;
					default:
						cI = cI + iCon;
						cICTR++;
						cIavg=cI/cICTR;
						break;
				}// switch end
				
			if (iGender.equals("M")) {
				cM = cM + iCon;
				cMCTR++;
				cMavg = cM/cMCTR;
			}//if end
			else if (iGender.equals("F")) {
				cF = cF + iCon;
				cFCTR++;
				cFavg = cF/cFCTR;
			}// F if end
			if (iGender.equals("M") && iParty.equals("D")) {
				cMD = cMD + iCon;
				cMDCTR++;
				cMDavg = cMD/cMDCTR;
			}
			if (iGender.equals("M") && iParty.equals("R")) {
				cMR = cMR + iCon;
				cMRCTR++;
				cMRavg = cMR/cMRCTR;
			}
			if (iGender.equals("M") && iParty.equals("I")) {
				cMI = cMI + iCon;
				cMICTR++;
				cMIavg = cMI / cMICTR;
			}
			if (iGender.equals("F") && iParty.equals("D")) {
				cFD = cFD + iCon;
				cFDCTR++;
				cFDavg = cFD / cFDCTR;
			}
			if (iGender.equals("F") && iParty.equals("R")) {
				cFR = cFR + iCon;
				cFRCTR=cFRCTR+1;
				cFRavg = cFR / cFRCTR;
			}
			if (iGender.equals ("F") && iParty.equals("I")) {
				cFI = cFI + iCon;
				cFICTR++;
				cFIavg = cFI / cFICTR;
			}
			
			iConTotal = iConTotal + iCon;
			cTCTR++;
			cTavg = iConTotal / cTCTR;
			
		}//Calcs end
	
		public static void output( ) {
	
		}//output end
		
		public static void totals() {
			
			// line for looks
			for (int i=1; i<=100;i++) {
				System.out.print("_"); 
			}//pretty line end
			
			System.out.println(" ");
			
			System.out.format("%-7s%20s%7s%20s%7s%20s%n"," ", "Company Name"," ", "Report Name"," ","Date");
			
			System.out.println(" ");
			
			System.out.format("%-7s%20s%7s%20s%7s%20s%n"," ", "Jake Christy"," ", "Save The Barns"," ", dtf.format(iDate));
			
			for (int i=1; i<=100;i++) {
				System.out.print("-"); 
			}
			System.out.println(" ");
		
			System.out.format("%-20s%7s%20s%7s%20s%4s%20s%n", "Category"," ", "Count"," ","Contribution"," ","Average");
		
			System.out.format("%-20s%6s%19d%15s%9.2f%20s%9.2f%n", "Men"," ",cMCTR, " ", cM, " ", cMavg);
			System.out.format("%-20s%6s%19d%15s%9.2f%20s%9.2f%n", "Women"," ",cFCTR, " ", cF, " ", cFavg);
			System.out.format("%-20s%6s%19d%15s%9.2f%20s%9.2f%n", "Democrats"," ",cDCTR, " ", cD, " ", cDavg);
			System.out.format("%-20s%6s%19d%15s%9.2f%20s%9.2f%n", "Republicans"," ",cRCTR, " ", cR, " ", cRavg);
			System.out.format("%-20s%6s%19d%15s%9.2f%20s%9.2f%n", "Independents"," ",cICTR, " ", cI, " ", cIavg);
			System.out.format("%-20s%6s%19d%15s%9.2f%20s%9.2f%n", "Democratic Men"," ",cMDCTR, " ", cMD, " ", cMDavg);
			System.out.format("%-20s%6s%19d%15s%9.2f%20s%9.2f%n", "Republican Men"," ",cMRCTR, " ", cMR, " ", cMRavg);
			System.out.format("%-20s%6s%19d%15s%9.2f%20s%9.2f%n", "Independent Men"," ",cMICTR, " ", cMI, " ", cMIavg);
			System.out.format("%-20s%6s%19d%15s%9.2f%20s%9.2f%n", "Democratic Women"," ",cFDCTR, " ", cFD, " ", cFDavg);
			System.out.format("%-20s%6s%19d%15s%9.2f%20s%9.2f%n", "Republican Women"," ",cFRCTR, " ", cFR, " ", cFRavg);
			System.out.format("%-20s%6s%19d%15s%9.2f%20s%9.2f%n", "Independent Women"," ",cFICTR, " ", cFI, " ", cFIavg);
			System.out.println(" ");
			System.out.format("%-20s%6s%19d%15s%9.2f%20s%9.2f%n", "Overall"," ",cTCTR, " ", iConTotal, " ", cTavg);
			
		}//totals end
	
		public static void closing( ) {
			pw.close();
		}//closing end
} //final curly bracket