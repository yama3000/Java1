import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

/* this program demonstrates major breaking
 * and sending to two different prt files.
 * It is a fundraiser for IHCC Majors */

/*I did both programs in one class and
 *  left the class name Fundraiser instead of
 *  SubtotalReport/SummaryReport via checklist */

public class Fundraiser {
	static String  iStudentID, iGender, iMajorCode, iString;
	static int hMajorCode;
	static String oMajorCode, oGender;
	static char c500response;
	static int   cMajorCtr=0, cMajorCode=1;
	static double iDon=0, cMajorDon=0;
	static double cInfo, cManu, cTran, cMale, cFemale, cOverall;
	static double  cMaleInfo, cMaleManu, cMaleTran;
	static double cFemaleInfo, cFemaleManu, cFemaleTran;
	static double  cTotalDon, cTotalAvg,  cGTDon;
	static int cGTCtr;
	
	static int cInfoCtr, cManuCtr, cTranCtr, cMaleCtr, cFemaleCtr, cOverallCtr;
	static int cMaleInfoCtr, cMaleManuCtr, cMaleTranCtr;
	static int cFemaleInfoCtr, cFemaleManuCtr, cFemaleTranCtr;
	static int cTotalStudents;
	
	static double cMaleAvg, cFemaleAvg;
	static double cInfoAvg, cManuAvg, cTranAvg;
	static double cMaleInfoAvg, cMaleManuAvg, cMaleTranAvg;
	static double cFemaleInfoAvg, cFemaleManuAvg, cFemaleTranAvg;
	
	
	static Scanner myScanner, newScanner;
	static NumberFormat nf;
	static boolean eof = false;
	static PrintWriter subpw;
	static PrintWriter sumpw;
	static String error;
	
	static Date iDate;
	static LocalDate userDate;
	static LocalDate today = LocalDate.now();
	static SimpleDateFormat dtf;
	
	
	public static void main(String[] args) {
		
		init();
		
		while(!eof) {
			if (cMajorCode != hMajorCode){
				major();
					
			}// hold if end
			
			
			calcs();
			output();
			input();		
						
						
			
		}//while !eof end
		
		closing();

	}// main end
	
	
	
	public static void init( ) {
		
		
		
		
		iDate = new Date();
		
		dtf = new SimpleDateFormat("MM/dd/yyyy");
		
		nf = NumberFormat.getCurrencyInstance(java.util.Locale.US);
		
		//open file
		try {
			myScanner = new Scanner(new File("IHCCFUND.dat"));
			myScanner.useDelimiter(System.getProperty("line.separator"));
		}//try end 
		catch (FileNotFoundException e1) {
			System.out.println("File error");
			System.exit(1);
		}//catch end
		
		try {
			subpw = new PrintWriter(new File ("subtotal.prt"));
		}//try end
		catch (FileNotFoundException e) {
			System.out.println("Output file error");
		}//catch end
		
		try {
			sumpw = new PrintWriter(new File ("summary.prt"));
		}//try end
		catch (FileNotFoundException e) {
			System.out.println("Output file error");
		}//catch end
		
	
		
		
		
		subpw.format("%-5s%22s%22s%22s%22s%22s%n"," ", "Indian Hills"," ", "Subtotal Report"," ",dtf.format(iDate));
		subpw.println(" ");
		subpw.format("%-20s%1s%20s%25s%20s%26s%20s%n", "StudentID"," ", "Gender"," ","Major"," ","Donation");
		for (int i=1; i<=132;i++) {
			subpw.print("_"); 
		}//pretty line end
		subpw.println(" ");
		subpw.println(" ");
		
		sumpw.format("%-5s%22s%22s%22s%22s%22s%n"," ", "Indian Hills"," ", "Summary Report"," ",dtf.format(iDate));
		for (int i=1; i<=132;i++) {
			sumpw.print("-");
		}//pretty line end
		sumpw.println(" ");
		
		sumpw.format("%-20s%8s%20s%28s%10s%26s%20s%n", "Category"," ", "Count"," ","Donation"," ","Average");
		
		
		// initial read
		input();
		hMajorCode = cMajorCode;
	}// init end
	
	public static void calcs( ) {
		
		cMajorDon = cMajorDon + iDon;
		cMajorCtr ++;
		cTotalStudents ++;
		cTotalDon += iDon;
		
		
		cMajorCode = Integer.parseInt(iMajorCode);
		
		
		
		if (cMajorCode == 1 || cMajorCode == 6 ||cMajorCode == 8 ||cMajorCode == 9 ||cMajorCode == 10 ) {
			cInfo = cInfo + iDon;
			cInfoCtr ++;
			if (iGender.equals("M")) {
				cMaleInfo += iDon;
				cMale += iDon;
				cMaleCtr ++;
				cMaleInfoCtr ++;
			}
			if (iGender.equals("F")) {
				cFemaleInfo += iDon;
				cFemale += iDon;
				cFemaleCtr ++;
				cFemaleInfoCtr ++;
			}
			
		}
		
		if (cMajorCode == 4 || cMajorCode == 5 ||cMajorCode == 7 ||cMajorCode == 11) {
			cManu = cManu + iDon;
			cManuCtr ++;
			if (iGender.equals("M")) {
				cMaleManu += iDon;
				cMale += iDon;
				cMaleCtr ++;
				cMaleManuCtr ++;
			}
			if (iGender.equals("F")) {
				cFemaleManu += iDon;
				cFemale += iDon;
				cFemaleCtr ++;
				cFemaleManuCtr ++;
			}
			
		}
		
		if (cMajorCode == 2 || cMajorCode == 3 ||cMajorCode == 12 ||cMajorCode == 13) {
			cTran = cTran + iDon;
			cTranCtr ++;
			if (iGender.equals("M")) {
				cMaleTran += iDon;
				cMale += iDon;
				cMaleCtr ++;
				cMaleTranCtr ++;
			}
			if (iGender.equals("F")) {
				cFemaleTran += iDon;
				cFemale += iDon;
				cFemaleCtr ++;
				cFemaleTranCtr ++;
			}
		}
		
		
		
		
	}// calcs end
	
	public static void output( ) {
		
		switch (iMajorCode) {
			case "01":
				oMajorCode = "COMPUTER SOFTWARE DEVELOPMENT";
				break;
			case "02":
				oMajorCode = "DIESEL POWER SYSTEMS TECHNOLOGY";
				break;
			case"03":
				oMajorCode = "AUTOMOTIVE TECHNOLOGY";
				break;
			case"04":
				oMajorCode = "LASER / ELECTRO-OPTICS TECHNOLOGY";
				break;
			case"05":
				oMajorCode = "ROBOTICS/AUTOMATION TECHNOLOGY";
				break;
			case"06":
				oMajorCode = "DIGITAL FORENSICS";
				break;
			case "07":
				oMajorCode = "MACHINE TECHNOLOGY";
				break;
			case "08":
				oMajorCode = "GEOSPATIAL TECHNOLOGY";
				break;
			case "09":
				oMajorCode = "ADMINISTRATIVE ASSISTANT";
				break;
			case "10":
				oMajorCode = "ACCOUNTING ASSISTANT";
				break;
			case "11":
				oMajorCode = "WELDING TECHNOLOGY";
				break;
			case "12":
				oMajorCode = "AUTOMOTIVE COLLISION TECHNOLOGY";
				break;
			default:
				oMajorCode = "AVAIATION PILOT TRAINING";
				break;
				
				
		}
				
		switch (iGender) {
		case "M":
			oGender = "Male";
			break;
		case"F":
			oGender = "Female";
			break;
		}
				
		
		// repeat once tested
		

		// line for looks
		
		subpw.format("%-10s%20s%10s%20s%40s%23s%9.2f%n", iStudentID," ", oGender," ",oMajorCode," ",iDon);
		
		
		
		
		
	}//output end
	
	public static void input( ) {
		
		String record;
		
		if (myScanner.hasNext()) {
			record = myScanner.next();
			iStudentID = record.substring(0,7);	//file position 1 - 25
			iGender = record.substring(7,8);	//25 - 50
			iMajorCode = record.substring(8,10);
			iString = record.substring(10,17);
			
			iDon = Double.parseDouble(iString);
			cMajorCode = Integer.parseInt(iMajorCode);
			
			
			
		}//if end
		else {
			eof=true;	//no more records so set eof to true
		}	
		
		if (iDon <= 500.00) {
			input();	
		}// 500 plus records end
		
	}// input end
	
	public static void GrandTotals( ) {
		
		cMaleAvg = cMale / cMaleCtr;
		cMaleAvg = Math.round(cMaleAvg*100.00)/100.00;
		
		cFemaleAvg = cFemale / cFemaleCtr;
		cFemaleAvg = Math.round(cFemaleAvg*100.00)/100.00;
		
		
		cInfoAvg = cInfo / cInfoCtr;
		cInfoAvg = Math.round(cInfoAvg*100.00)/100.00;
		
		cManuAvg = cManu / cManuCtr;
		cManuAvg = Math.round(cManuAvg*100.00)/100.00;
		
		cTranAvg = cTran / cTranCtr;
		cTranAvg = Math.round(cTranAvg*100.00)/100.00;
		
		
		cMaleInfoAvg = cMaleInfo / cMaleInfoCtr;
		cMaleInfoAvg = Math.round(cMaleInfoAvg*100.00)/100.00;
		
		cMaleManuAvg = cMaleManu / cMaleManuCtr;
		cMaleManuAvg = Math.round(cMaleManuAvg*100.00)/100.00;
		
		cMaleTranAvg = cMaleTran / cMaleTranCtr;
		cMaleTranAvg = Math.round(cMaleTranAvg*100.00)/100.00;
		
		cFemaleInfoAvg = cFemaleInfo / cFemaleInfoCtr;
		cFemaleInfoAvg = Math.round(cFemaleInfoAvg*100.00)/100.00;
		
		cFemaleManuAvg = cFemaleManu / cFemaleManuCtr;
		cFemaleManuAvg = Math.round(cFemaleManuAvg*100.00)/100.00;
		
		cFemaleTranAvg = cFemaleTran / cFemaleTranCtr;
		cFemaleTranAvg = Math.round(cFemaleTranAvg*100.00)/100.00;
		
		
		
		
		
		cTotalAvg = cTotalDon / cTotalStudents;
		
		//cMaleAvg = 1.12745;
		//Math.round(cMaleAvg);
		//do i need math.round ?????????
		
		for (int i=1; i<=132;i++) {
			sumpw.print("-");}
		sumpw.println(" ");
		
		sumpw.format("%-35s%2s%10d%30s%9.2f%37s%9.2f%n", "Male"," ",cMaleCtr, " ", cMale, " ", cMaleAvg);
		sumpw.format("%-35s%2s%10d%30s%9.2f%37s%9.2f%n", "Female"," ",cFemaleCtr, " ", cFemale, " ", cFemaleAvg);
		
		sumpw.format("%-35s%2s%10d%30s%9.2f%37s%9.2f%n", "Information Technology"," ",cInfoCtr, " ", cInfo, " ", cInfoAvg);
		sumpw.format("%-35s%2s%10d%30s%9.2f%37s%9.2f%n", "Manufacturing Technology"," ",cManuCtr, " ", cManu, " ", cManuAvg);
		sumpw.format("%-35s%2s%10d%30s%9.2f%37s%9.2f%n", "Transportain Technology"," ",cTranCtr, " ", cTran, " ", cTranAvg);
		
		sumpw.format("%-35s%2s%10d%30s%9.2f%37s%9.2f%n", "Male Information Technology"," ",cMaleInfoCtr, " ", cMaleInfo, " ", cMaleInfoAvg);
		sumpw.format("%-35s%2s%10d%30s%9.2f%37s%9.2f%n", "Female Information Technology"," ",cFemaleInfoCtr, " ", cFemaleInfo, " ", cFemaleInfoAvg);
		sumpw.format("%-35s%2s%10d%30s%9.2f%37s%9.2f%n", "Male Manufacturing Technology"," ",cMaleManuCtr, " ", cMaleManu, " ", cMaleManuAvg);
		sumpw.format("%-35s%2s%10d%30s%9.2f%37s%9.2f%n", "Female Manufacturing Technology"," ",cFemaleManuCtr, " ", cFemaleManu, " ", cFemaleManuAvg);
		sumpw.format("%-35s%2s%10d%30s%9.2f%37s%9.2f%n", "Male Trasportation Technology"," ",cMaleTranCtr, " ", cMaleTran, " ", cMaleTranAvg);
		sumpw.format("%-35s%2s%10d%30s%9.2f%37s%9.2f%n", "Female Transportation Technology"," ",cFemaleTranCtr, " ", cFemaleTran, " ", cFemaleTranAvg);
		
		
		for (int i=1; i<=132;i++) {
			sumpw.print("-");}
		sumpw.println(" ");
		sumpw.format("%-35s%2s%10d%30s%9.2f%37s%9.2f%n", "Overall"," ",cTotalStudents, " ", cTotalDon, " ", cTotalAvg);
		
		
		subpw.format("%-60s%40s%4s%10d%9s%9.2f%n", " ", "Grand Total", " ", cGTCtr, " ", cGTDon);
	}// grand totals
	
	public static void major() {
		subpw.println(" ");
		subpw.format("%-60s%40s%4s%10s%9s%9.2f%n", " ", oMajorCode, " ", cMajorCtr, " ", cMajorDon);
		subpw.println(" ");
		
		cGTCtr += cMajorCtr;
		cGTDon += cMajorDon;
		
		cMajorCtr = 0;
		cMajorDon = 0;
		
		hMajorCode = cMajorCode;
	}// major end
	
	public static void closing() {
		major();
		GrandTotals();
		subpw.close();
		sumpw.close();
	}// closing end

}// class end


