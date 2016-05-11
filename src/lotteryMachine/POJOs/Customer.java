package lotteryMachine.POJOs;

public class Customer {
	int customerTicketCount;
	int customerID;
	
	public Customer(int customerID, int customerTicketCount) {
		super();
		this.customerID = customerID;
		this.customerTicketCount = customerTicketCount;
	}

	public int getCustomerID() {
		return customerID;
	}
	
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	
	public int getCustomerTicketCount() {
		return customerTicketCount;
	}
	
	public void setCustomerTicketCount(int customerTicketCount) {
		this.customerTicketCount = customerTicketCount;
	}

}
