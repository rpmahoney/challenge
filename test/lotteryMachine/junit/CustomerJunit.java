package lotteryMachine.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import lotteryMachine.service.CustomerMethods;

public class CustomerJunit {

	/**
	 * Test that the getCustomerTicketCount() method will return a number
	 * between 1 and 5 (inclusive)
	 */
	@Test
	public void testGetCustomerTicketCount() {
		int ticketCount = CustomerMethods.getCustomerTicketCount(10);
		assertTrue(1 <= ticketCount && 5 >= ticketCount);
	}

	/**
	 * Test that the getTicketType() method will return a number between 1 and 3
	 * (inclusive)
	 */
	@Test
	public void testGetTicketType() {
		int ticketType = CustomerMethods.getTicketType();
		assertTrue(1 <= ticketType && 3 >= ticketType);
	}

}
