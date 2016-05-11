package lotteryMachine.service;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.TreeMap;

import lotteryMachine.POJOs.Ticket;

public class Reporting {

	/**
	 * Create the lottery machine report
	 * 
	 * @param customerMap
	 *            TreeMap of the customers and their tickets
	 * @param pick3TicketList
	 *            list of all pick 3 tickets purchased
	 * @param pick4TicketList
	 *            list of all pick 4 tickets purchased
	 * @param pick5TicketList
	 *            list of all pick 5 tickets purchased
	 * @param soldOutAttempts
	 *            number of times a customer attempted to purchase a sold out
	 *            ticket
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */
	public static void createLotteryReport(TreeMap<Integer, List<Ticket>> customerMap, List<Ticket> pick3TicketList,
			List<Ticket> pick4TicketList, List<Ticket> pick5TicketList, int soldOutAttempts)
			throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter report = new PrintWriter("lottery-report.txt", "UTF-8");
		report.println("Number of customers: " + customerMap.size());

		CustomerMethods.getCustomerTicketPurchases(customerMap, report);

		report.println("");
		report.println("Number of attempts to purchase sold out tickets: " + soldOutAttempts);
		report.println("");
		report.println("--------------PICK 3 WINNER--------------");
		TicketMethods.ticketDrawing(pick3TicketList, report);
		report.println("--------------PICK 4 WINNER--------------");
		TicketMethods.ticketDrawing(pick4TicketList, report);
		report.println("--------------PICK 5 WINNER--------------");
		TicketMethods.ticketDrawing(pick5TicketList, report);
		report.close();

	}

}
