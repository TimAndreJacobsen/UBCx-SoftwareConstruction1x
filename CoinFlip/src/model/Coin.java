package model;

import java.util.Random;

public class Coin {

    private boolean isHeads;
    private int amountOfHeads;
    private int amountOfTails;

    // EFFECTS:  Instantiates a new Coin object and calls flip() to set initial value;
    public Coin() {
        flip();
    }

    // MODIFIES: this
    // EFFECTS:  flips the coin, setting isHeads to either true or false
    public void flip() {
        Random random = new Random();
        int toss = random.nextInt(2);
        if (toss == 0) {
            this.isHeads = false;
            amountOfTails++;
        } else if (toss == 1) {
            this.isHeads = true;
            amountOfHeads++;
        }
        System.out.println("Coin: " + this + " flipped: " + toString());
    }

    // EFFECTS:  returns true if coin is heads
    //           returns false is coin is tails
    public boolean checkStatus() {
        return this.isHeads;
    }

    // EFFECTS:  returns state of coin in String format: "heads" OR "tails"
    public String toString() {
        if (checkStatus()) { // could  just passed isheads straight into it, but checkstatus would be grey, unused and sad.
            return "heads";
        }
        return "tails";
    }

    // EFFECTS:  prints total amount of flips, amount of heads, amount of tails
    public void printStats() {
        System.out.println("Total Flips: " + (this.amountOfHeads + this.amountOfTails));
        System.out.println("Heads: " + amountOfHeads);
        System.out.println("Tails: " + amountOfTails);
    }
}
