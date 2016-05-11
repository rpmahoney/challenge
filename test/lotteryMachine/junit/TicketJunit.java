package lotteryMachine.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import lotteryMachine.service.TicketMethods;

public class TicketJunit {

	/**
	 * Test that the getPick3Ticket() method will return a three digit ticket
	 * number
	 */
	@Test
	public void testGetPick3Ticket() {
		String ticket = TicketMethods.getPick3Ticket();
		assertTrue(ticket.length() == 3);
	}

	/**
	 * Test that the getPick4Ticket() method will return a four digit ticket
	 * number
	 */
	@Test
	public void testGetPick4Ticket() {
		String ticket = TicketMethods.getPick4Ticket();
		assertTrue(ticket.length() == 4);
	}

	/**
	 * Test that the getPick5Ticket() method will return a five digit ticket
	 * number
	 */
	@Test
	public void testGetPick5Ticket() {
		String ticket = TicketMethods.getPick5Ticket();
		assertTrue(ticket.length() == 5);
	}

	/**
	 * Test that the pickTicketType() method will return number between 1 and 3
	 * (inclusive)
	 */
	@Test
	public void testPickTicketType() {
		int ticketType = TicketMethods.pickTicketType(1, 1, 1);
		assertTrue(1 <= ticketType && 3 >= ticketType);
	}

	/**
	 * Test that the getTotalTicketsRemaining() method sums each of the
	 * remaining ticket types
	 */
	@Test
	public void testGetTotalTicketsRemaining() {
		int ticketsRemaining = TicketMethods.getTotalTicketsRemaining(5, 10, 15);
		assertEquals(30, ticketsRemaining);
	}

}
