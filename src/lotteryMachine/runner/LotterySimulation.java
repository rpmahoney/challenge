package lotteryMachine.runner;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import lotteryMachine.POJOs.*;
import lotteryMachine.service.CustomerMethods;
import lotteryMachine.service.Reporting;
import lotteryMachine.service.TicketMethods;

/**
 * This program simulates a lottery machine.
 * Written as part of the NI&S Coding Challenge
 * @author ryanmahoney
 *
 */
public class LotterySimulation {
	public static int soldOutAttempts = 0;
	static int ticketID = 0;
	static Integer customerID = 0;
	static int totalTicketsRemaining;
	public static int ticketType;

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		/** Setting up lottery machine ticket counts for each ticket type */
		int pick3Remaining = 50;
		int pick4Remaining = 40;
		int pick5Remaining = 60;

		List<Ticket> pick3TicketList = new ArrayList<Ticket>();
		List<Ticket> pick4TicketList = new ArrayList<Ticket>();
		List<Ticket> pick5TicketList = new ArrayList<Ticket>();

		TreeMap<Integer, List<Ticket>> customerMap = new TreeMap<Integer, List<Ticket>>();

		while (pick3Remaining != 0 || pick4Remaining != 0 || pick5Remaining != 0) {
			totalTicketsRemaining = TicketMethods.getTotalTicketsRemaining(pick3Remaining, pick4Remaining,
					pick5Remaining);

			if (totalTicketsRemaining == 0) {
				break;
			}
			List<Ticket> customerTotalTicketList = new ArrayList<Ticket>();

			customerID += 1;
			Customer customer = new Customer(customerID, CustomerMethods.getCustomerTicketCount(totalTicketsRemaining));

			for (int i = 0; i < customer.getCustomerTicketCount(); i++) {
				ticketType = TicketMethods.pickTicketType(pick3Remaining, pick4Remaining, pick5Remaining);
				switch (ticketType) {
				case 1:
					ticketID += 1;
					pick3Remaining -= 1;
					Ticket pick3Ticket = new Ticket(ticketID, 3, TicketMethods.getPick3Ticket(),
							customer.getCustomerID());
					pick3TicketList.add(pick3Ticket);
					customerTotalTicketList.add(pick3Ticket);
					break;
				case 2:
					ticketID += 1;
					pick4Remaining -= 1;
					Ticket pick4Ticket = new Ticket(ticketID, 4, TicketMethods.getPick4Ticket(),
							customer.getCustomerID());
					pick4TicketList.add(pick4Ticket);
					customerTotalTicketList.add(pick4Ticket);
					break;
				case 3:
					ticketID += 1;
					pick5Remaining -= 1;
					Ticket pick5Ticket = new Ticket(ticketID, 5, TicketMethods.getPick5Ticket(),
							customer.getCustomerID());
					pick5TicketList.add(pick5Ticket);
					customerTotalTicketList.add(pick5Ticket);
					break;
				}
			}
			customerMap.put(customer.getCustomerID(), customerTotalTicketList);
		}
		Reporting.createLotteryReport(customerMap, pick3TicketList, pick4TicketList, pick5TicketList, soldOutAttempts);
	}

}
