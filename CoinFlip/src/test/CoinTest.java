package test;

import model.Coin;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class CoinTest {
    Coin coin;

    @Before
    public void setup() {
        coin = new Coin();
    }

    @Test
    public void testFlip() {
        boolean canBeHead = false;
        boolean canBeTails = false;

        for (int i = 0; i < 100; i++) {
            coin.flip();
            if (coin.isHeads()) {
                canBeHead = true;
            }
            if (!coin.isHeads()) {
                canBeTails = true;
            }
        }
        assertTrue(canBeHead);
        assertTrue(canBeTails);
    }


}
