import java.util.Scanner;

public class POS {
private String posID = "1";
private String itemNumber;
private int transactionID;
private double transactionTotal;
private String paymentType;
private double netCash;
private double netCard;
Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		POS login = new POS(); //create object for this login

		System.out.println("Sale"); //for sales
		login.transactionSale(login);

		System.out.println("Return"); //for returns
		login.transactionSale(login);

		System.out.println("Close Station"); //for closing
		login.closeStation(login);
		System.out.println("End of Day"); //for EOD
		login.endOfDay(login);


	}

public POS(){ //default constructor
	transactionID = 1;
	transactionTotal = 0;
	paymentType = "cash";
	netCash = 0;
	netCard = 0;
}

public void transactionSale(POS login){
	while(login.transactionID !=0){
		while (!"0".equals(login.itemNumber)){
		System.out.print("Input item number, or 0 to cancel: ");
		login.itemNumber = input.nextLine(); //input the hypothetical SKU/barcode number
		login.transactionTotal +=1.00; //just gonna say every item is $1.00, this is a cheap zoo today
		}
		login.transactionID++;
		System.out.print("Payment Type? ");
		login.paymentType = input.nextLine();
		System.out.print("Print receipt? Y or N");
		String receipt = input.nextLine();
		if("Y".equals(receipt)){
			login.printReceipt(login, "Sale"); //this sends to method to print the receipt
		}
		if(login.paymentType == "cash"){
			login.netCash += login.transactionTotal; // for the EOD report
			itemNumber =""; //learned the hard way you have to reset the value.
			break;
		}
		else{
			login.netCard += login.transactionTotal;
			itemNumber ="";
			break;
		}
		}

}
public void transactionReturn(POS login){ //this is just a reverse repeat of the sale method.
	while(login.transactionID !=0){
		while (!"0".equals(login.itemNumber)){
		System.out.print("Input item number, or 0 to cancel: ");
		login.itemNumber = input.nextLine(); //input the hypothetical SKU/barcode number
		login.transactionTotal -=1.00; //just gonna say every item is $1.00, this is a cheap zoo today
		}

		System.out.print("Payment Type? ");
		login.paymentType = input.nextLine();
		System.out.print("Print receipt? Y or N");
		String receipt = input.nextLine();
		if("Y".equals(receipt)){
			login.printReceipt(login, "Return");
		}
		if(login.paymentType == "cash"){
			login.netCash -= login.transactionTotal;
			itemNumber ="";
		}
		else{
			login.netCard -= login.transactionTotal;
			itemNumber ="";
		}
	}
}

private String generateReceipt(POS login, String type){
	String receipt = "Total: " + transactionTotal + "\nPayment Type: " + paymentType +
			"\nThanks for coming to the Brevard Zoo! Have a nice day!";
	return receipt;

}
public void printReceipt(POS login, String type){
	System.out.println(login.generateReceipt(login, type));

}
public void closeStation(POS login){ //rinse and repeat of receipt method
	System.out.println(closeStationReportGenerate(login));
}
private String closeStationReportGenerate(POS login){
	String report = "POS ID" + posID + "Total Cash: " + netCash + "\nTotal Card: " + netCard;
	return report;

}
public void viewCloseReport(){
	//popup window for viewing report.
}

public void closeStationReportPrint(){
	//print report to device
}
public void endOfDay(POS login){ //rinse and repeat of receipt method
	System.out.println(EODReportGenerate(login));
}
private String EODReportGenerate(POS login){
	String report = "Total Cash: " + netCash + "\nTotal Card: " + netCard;
	return report;
}
public void viewEOD(){
	//popup window for viewing report.
}
public void EODReportPrint(){
	//print report to device
}

//end of class!
}
