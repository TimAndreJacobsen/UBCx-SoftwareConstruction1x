package test;

import model.Ferry;
import model.FerryOwner;
import model.Passenger;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;


public class PassengerTest {

    private Passenger testPassenger;
    private Ferry ferry;
    private Date date;
    private int ticketPrice;

    @Before
    public void setUp() {
        ticketPrice = 10;
        testPassenger = new Passenger("Bruce Wayne");
        date = new Date();
        ferry = new Ferry("destination",date , ticketPrice);
    }

    @Test
    public void testPassengerConstructor() {
        assertEquals(testPassenger.getName(), "Bruce Wayne");
        assertEquals(testPassenger.getFerryCard().getOwner(), testPassenger);
    }

    @Test
    public void testPassengerConstructorRushHour() {
        // SETUP:
        int passengerMoney = 20; // tickets are 10
        int passengersAmount = 100;

        List<Passenger> passengers = new ArrayList<>();
        for (int i = 0; i < passengersAmount; i++) {
            passengers.add(new Passenger("name" + i));
        }
        for (Passenger p : passengers) {
            p.getFerryCard().setBalance(passengerMoney);
            assertEquals(p.getFerryCard().getBalance() , passengerMoney);
        }
        //TEST:
        for (Passenger p : passengers) {
            p.getFerryCard().buyTicket(ferry);
            assertEquals(p.getFerryCard().getBalance() , passengerMoney - ticketPrice);
            p.getFerryCard().topUp(ticketPrice); // price of ticket defined in constructor
            assertEquals(p.getFerryCard().getBalance() , passengerMoney);
        }
    }

    @Test
    public void testOwnersWallet() {
        FerryOwner owner = new FerryOwner("Ferry Owner", ferry);
        // SETUP:
        testPassengerConstructorRushHour(); // generates passengers that buy tickets
        // TEST:

    }

    @Test
    public void testPassengerChangeName() {
        testPassenger.setName("Batman");
        assertEquals("Batman",testPassenger.getName());
    }

}