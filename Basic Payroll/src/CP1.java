
import java.text.*;
import java.util.*;

public class CP1 {
	
	//declare variables
	static String iString;
	static String iFirstName, iLastName;
	static int cHours;
	static double cRate;
	static double cPay;
	static String oPay;
	static Scanner myScanner;
	static NumberFormat nf;
	
	public static void main(String[] args) {
		
	//call init()
	init();
	
	input();
	
	calcs();
	
	output();
	
	System.out.println("prorgram end!");
	}
		
	public static void init() { 
		myScanner = new Scanner(System.in);
		
		myScanner.useDelimiter(System.getProperty("line.separator"));
		
		nf = NumberFormat.getCurrencyInstance(java.util.Locale.US);
	}
		
	public static void input() {
		//prompt firstname
		System.out.print("Enter first name:");
		iFirstName = myScanner.next();
		
		System.out.print("Enter last name:");
		iLastName = myScanner.next();
		
		System.out.print("Enter hours:");
		iString = myScanner.next();
		cHours = Integer.parseInt(iString);
		
		//prompt, input and convert rate
		System.out.print("Enter rate:");
		iString = myScanner.next();
		cRate = Double.parseDouble(iString);
	}
		
	public static void calcs() {
		
		cPay= cHours * cRate;
		}
	
	
	public static void output() {
		System.out.println("Name: " + iLastName + ","+ iFirstName);
		
		oPay =nf.format(cPay);
		System.out.println("Pay is: " + oPay);
	}}
	
	//public static void closing() {
	
	