package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void shouldIllArgExceptNegativeInitialBalance() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    -2_000,
                    0,
                    10_000,
                    5
            );
        });
    }

    @Test
    public void shouldIllArgExceptNegativeMinBalance() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    2_000,
                    -1_000,
                    10_000,
                    5
            );
        });
    }


    @Test
    public void shouldIllArgExceptNegativeMaxBalance() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    2_000,
                    1_000,
                    -10_000,
                    5
            );
        });
    }

    @Test
    public void shouldIllArgExceptNegativeMaxBalanceIsLowerMinBalance() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    2_000,
                    12_000,
                    10_000,
                    5
            );
        });
    }


    @Test
    public void shouldIllArgExceptInitialBalanceIsLowerMinBalance() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    1_000,
                    2_000,
                    10_000,
                    5
            );
        });
    }

    @Test
    public void shouldIllArgExceptInitialBalanceIsMoreMaxBalance() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    11_000,
                    2_000,
                    10_000,
                    5
            );
        });
    }


    @Test
    public void shouldIllArgExceptRate() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    2_000,
                    0,
                    10_000,
                    -5
            );
        });
    }

    @Test
    public void shouldPayOverMinBalance() {

        SavingAccount account = new SavingAccount(
                2_000,
                0,
                10_000,
                5
        );
        account.pay(1_000);

        Assertions.assertEquals(1_000, account.getBalance());

    }

    @Test
    public void shouldPayLowerMinBalance() {

        SavingAccount account = new SavingAccount(
                2_000,
                0,
                10_000,
                5
        );
        account.pay(3_000);

        Assertions.assertEquals(2_000, account.getBalance());

    }

    @Test
    public void shouldNotPayIfAmountLessZero() {

        SavingAccount account = new SavingAccount(
                2_000,
                0,
                10_000,
                5
        );
        account.pay(-100);

        Assertions.assertEquals(2_000, account.getBalance());

    }

    @Test
    public void shouldNotPayIfBalanceLowerMinBalance() {

        SavingAccount account = new SavingAccount(
                2_100,
                2_000,
                10_000,
                5
        );
        account.pay(200);

        Assertions.assertEquals(2_100, account.getBalance());

    }


    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }

    @Test
    public void shouldNotAddIfAmountLessZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.add(-3_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldNotAddIf() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.add(9_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }


    @Test
    public void shouldCalcPercentYearChange() {
        SavingAccount account = new SavingAccount(
                1000,
                100,
                10_000,
                15
        );
        account.pay(800);
        account.yearChange();

        Assertions.assertEquals(30, account.yearChange());
    }

}
