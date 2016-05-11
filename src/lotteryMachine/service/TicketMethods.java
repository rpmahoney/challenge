package lotteryMachine.service;

import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

import lotteryMachine.POJOs.Ticket;
import lotteryMachine.runner.LotterySimulation;

public class TicketMethods {

	/**
	 * Generate a random 3 digit lottery ticket
	 * 
	 * @return lottery pick 3 ticket
	 */
	public static String getPick3Ticket() {
		Random random = new Random();
		int a = random.nextInt(10);
		int b = random.nextInt(10);
		int c = random.nextInt(10);
		String ticketNumber = a + "" + b + "" + c;

		return ticketNumber;
	}

	/**
	 * Generate a random 4 digit lottery ticket
	 * 
	 * @return lottery pick 4 ticket
	 */
	public static String getPick4Ticket() {
		Random random = new Random();
		int a = random.nextInt(10);
		int b = random.nextInt(10);
		int c = random.nextInt(10);
		int d = random.nextInt(10);
		String ticketNumber = a + "" + b + "" + c + "" + d;

		return ticketNumber;
	}

	/**
	 * Generate a random 5 digit lottery ticket
	 * 
	 * @return lottery pick 5 ticket
	 */
	public static String getPick5Ticket() {
		Random random = new Random();
		int a = random.nextInt(10);
		int b = random.nextInt(10);
		int c = random.nextInt(10);
		int d = random.nextInt(10);
		int e = random.nextInt(10);
		String ticketNumber = a + "" + b + "" + c + "" + d + "" + e;

		return ticketNumber;
	}

	/**
	 * Pick a ticket type and check that there are still tickets remaining If
	 * some remain, the purchase a ticket If none remain, select a different
	 * ticket type and check again
	 * 
	 * @param pick3Remaining
	 *            number of pick 3 tickets remaining
	 * @param pick4Remaining
	 *            number of pick 4 tickets remaining
	 * @param pick5Remaining
	 *            number of pick 5 tickets remaining
	 * @return ticket type that the customer will purchase
	 */
	public static int pickTicketType(int pick3Remaining, int pick4Remaining, int pick5Remaining) {
		int ticketType = 0;
		boolean ticketTypeRemaining = false;
		while (!ticketTypeRemaining) {
			ticketType = CustomerMethods.getTicketType();
			if (ticketType == 1 && pick3Remaining >= 1) {
				ticketTypeRemaining = true;
			} else if (ticketType == 2 && pick4Remaining >= 1) {
				ticketTypeRemaining = true;
			} else if (ticketType == 3 && pick5Remaining >= 1) {
				ticketTypeRemaining = true;
			} else {
				LotterySimulation.soldOutAttempts += 1;
			}
		}
		return ticketType;
	}

	/**
	 * Pass in the list of tickets by type. Retrieve a random index between 0
	 * and the number of tickets in the list. Get the ticket that belongs at the
	 * randomly generated index as the winning ticket.
	 * 
	 * @param ticketList
	 *            all tickets from the lottery simulation
	 * @param report
	 */
	public static void ticketDrawing(List<Ticket> ticketList, PrintWriter report) {
		int poolSize = ticketList.size();
		Random random = new Random();
		int randomIndex = random.nextInt(poolSize);
		Ticket winningTicket = ticketList.get(randomIndex);
		report.println("Winning Ticket: " + winningTicket);
		int winningCustomer = winningTicket.getCustomerID();
		report.println("Winning Customer: " + winningCustomer);
	}

	/**
	 * Get the number of tickets remaining of all types
	 * 
	 * @param pick3Rem
	 *            number of pick 3 tickets remaining
	 * @param pick4Rem
	 *            number of pick 4 tickets remaining
	 * @param pick5Rem
	 *            number of pick 5 tickets remaining
	 * @return
	 */
	public static int getTotalTicketsRemaining(int pick3Rem, int pick4Rem, int pick5Rem) {
		return pick3Rem + pick4Rem + pick5Rem;
	}

}
