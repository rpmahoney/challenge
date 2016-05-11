package lotteryMachine.POJOs;

public class Ticket {
	int ticketID;
	int ticketType;
	String ticketNumber;
	int customerID;
	
	public Ticket(int ticketID, int ticketType, String ticketNumber, int customerID) {
		super();
		this.ticketID = ticketID;
		this.ticketType = ticketType;
		this.ticketNumber = ticketNumber;
		this.customerID = customerID;
	}
	
	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public int getTicketID() {
		return ticketID;
	}
	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}
	public int getTicketType() {
		return ticketType;
	}
	public void setTicketType(int ticketType) {
		this.ticketType = ticketType;
	}
	public String getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	@Override
	public String toString() {
		return "Ticket [ticketID=" + ticketID + ", ticketType=" + ticketType + ", ticketNumber=" + ticketNumber + "]";
	}
	
	
	
}
