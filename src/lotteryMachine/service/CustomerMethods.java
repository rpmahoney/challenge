package lotteryMachine.service;

import java.io.PrintWriter;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;

import lotteryMachine.POJOs.Ticket;

public class CustomerMethods {
	static int customerTicketCount;

	/**
	 * Retrieve the number of tickets the customer will purchase
	 * 
	 * @param ticketsRemaining
	 *            total number of tickets remaining in the lottery machine
	 * @return the number of tickets the customer will purchase
	 */
	public static int getCustomerTicketCount(int ticketsRemaining) {
		Random random = new Random();
		if (ticketsRemaining >= 5) {
			customerTicketCount = random.nextInt(5) + 1;
		} else {
			customerTicketCount = random.nextInt(ticketsRemaining) + 1;
		}
		return customerTicketCount;
	}

	/**
	 * Randomly select an integer between 1 and 3, inclusive
	 * 
	 * @return the type of lottery ticket the customer will purchase
	 */
	public static int getTicketType() {
		Random random = new Random();
		int ticketType = random.nextInt(3) + 1;
		return ticketType;
	}

	/**
	 * Part of the reporting. Returns all the customers and the tickets they
	 * purchased
	 * 
	 * @param customerMap
	 *            TreeMap of all customers and their ticket purchases
	 * @param report
	 *            Text file to export the results to
	 */
	public static void getCustomerTicketPurchases(TreeMap<Integer, List<Ticket>> customerMap, PrintWriter report) {
		for (int customer : customerMap.keySet()) {
			List<Ticket> ticket = customerMap.get(customer);
			report.println("Customer ID: " + customer);
			for (Ticket custTicket : ticket) {
				report.println("Ticket Type & Number: Pick " + custTicket.getTicketType() + " -- Number = "
						+ custTicket.getTicketNumber());
			}
		}
	}

}
