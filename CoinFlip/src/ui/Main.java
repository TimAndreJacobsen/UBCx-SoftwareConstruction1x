package ui;

import model.Coin;

public class Main {

    public static void main(String[] args) {
        Coin coin1 = new Coin();

        for (int i = 0; i < 100; i++) {
            coin1.flip();
        }

        coin1.printStats();
    }
}
