To run the Program: 
Save and double click LotteryMachine.jar

Results: 
The results of the program will be written to a .txt file called lottery-report.txt. The file will be saved in the same place where the jar is located. This text file will be overwritten with new results every time the jar is executed.

I've included a zip file of the source code so you can see the code behind the program, called LotteryMachine.zip. If you prefer, you can also run the test from the IDE of your choice by unzipping the contents and running the LotterySimulation.java class (found here: src/LotteryMachine/runner)

My Approach:
I found that there were two entities/objects that needed to be created for this challenge: tickets and customers. I started by creating two POJOs to represent each of them and give them the properties they each needed. Customers would have an ID and a number of tickets they would want to purchase. Tickets would have an ID, type (pick 3, 4, or 5), number, and the customer ID that owns it. These are found in the LotteryMachine.POJO package.

I then created two service classes that would hold all the methods for each of the POJOs, called CustomerMethods and TicketMethods. Inside these classes you will find the methods that interact with tickets and customers throughout the simulation. These are found in the LotteryMachine.service package

Finally there is the main method that runs the simulation. This is found in LotterySimulation.java class in the LotteryMachine.runner package.

The program starts by initializing everything it will need to run. This includes the number of tickets that each type starts with, lists to hold the purchased tickets in, and a hash map to hold the customer and the ticket(s) they purchased. It also initializes other variables to track things for the report, such as the number of attempts to buy a sold out ticket.

From there the program will begin checking that there are still tickets remaining. If tickets remain it creates a new customer and generates the number of tickets they would like to purchase between 1 and 5 (unless less than 5 tickets remain, in which case it will set the upper bound at the number remaining).
Once the customer knows how many tickets they want, they randomly select which type of ticket to purchase. If that ticket is sold out, they will do another random selection while also incrementing the attempts to buy a sold out ticket by 1. The program continues this loop until there are no more tickets remaining of any type.

Once all tickets are sold, the program will select three winners, one for each ticket type. The selection is done by passing each ticket list through a ticket drawing method. The method receives a list of tickets and then selects a random index based on the list size. Once we know the winning ticket, we are able to gather the ticket number and the ID of the customer who purchased it.

The Reporting.java class holds the method to create the summary report. It's found in the LotteryMachine.service package.

There is also a source folder called "test" which holds the JUnit tests I've written to test my methods
I've used Javadocs inside the code to further explain each method.
