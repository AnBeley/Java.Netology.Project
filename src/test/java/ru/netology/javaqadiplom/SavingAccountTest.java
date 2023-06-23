package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test //не проходит
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

    @Test //не проходит
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


    @Test //не проходит
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

    @Test //не проходит
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


    @Test //не проходит
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

    @Test //не проходит
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


    @Test //проходит
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

    @Test //проходит
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

    @Test //не проходит
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


    @Test //не проходит
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

    @Test //проходит
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
