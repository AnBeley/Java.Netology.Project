package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void zeroRateException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    0,
                    5_000,
                    0
            );
        });
    }

    @Test
    public void negativeRateException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    0,
                    5_000,
                    -1
            );
        });
    }

    @Test
    public void negativeCreditLimitException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    0,
                    -5_000,
                    15
            );
        });
    }

    @Test
    public void negativeInitialBalanceException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    -100,
                    5_000,
                    15
            );
        });
    }

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                100,
                5_000,
                15
        );

        account.add(5_000);

        Assertions.assertEquals(5_100, account.getBalance());
    }

    @Test
    public void shouldNotAddZeroToBalance() {
        CreditAccount account = new CreditAccount(
                10,
                5_000,
                15
        );

        account.add(0);

        Assertions.assertEquals(10, account.getBalance());
    }

    @Test
    public void shouldNotAddNegativeToBalance() {
        CreditAccount account = new CreditAccount(
                10,
                5_000,
                15
        );

        account.add(-100);

        Assertions.assertEquals(10, account.getBalance());
    }

    @Test
    public void shouldPayInLimit() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.pay(6_000);

        Assertions.assertEquals(-5_000, account.getBalance());
    }

    @Test
    public void shouldPayIfAmountSmallerInitialBalance() {
        CreditAccount account = new CreditAccount(
                8_000,
                5_000,
                15
        );

        account.pay(2_000);

        Assertions.assertEquals(6_000, account.getBalance());
    }

    @Test
    public void shouldNotPayBeyondLimit() {
        CreditAccount account = new CreditAccount(
                10,
                5_000,
                15
        );

        account.pay(6_000);

        Assertions.assertEquals(10, account.getBalance());
    }

    @Test
    public void shouldNotPayNegative() {
        CreditAccount account = new CreditAccount(
                10,
                5_000,
                15
        );

        account.pay(-6_000);

        Assertions.assertEquals(10, account.getBalance());
    }

    @Test
    public void shouldNotCalcRate() {
        CreditAccount account = new CreditAccount(
                10,
                5_000,
                15
        );

        account.yearChange();

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void shouldCalcRate() {
        CreditAccount account = new CreditAccount(
                200,
                5_000,
                15
        );
        account.pay(400);
        account.yearChange();

        Assertions.assertEquals(-30, account.yearChange());
    }
}
