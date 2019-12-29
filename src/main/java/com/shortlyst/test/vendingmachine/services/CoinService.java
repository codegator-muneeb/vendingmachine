package com.shortlyst.test.vendingmachine.services;

import java.util.*;

public class CoinService {
	private final List<Integer> coins;
    private final ArrayList<Integer> change = new ArrayList<>();
    private int amount;
    private List<Integer> remainingCoins = new ArrayList<>();
    private boolean isChangeAvailable = false;
    private final int min10Coins = 9;
    private final int min100Coins = 4;
    private List<Integer> insertedCoin = new ArrayList<>();

    public CoinService(Collection<Integer> coinsAvailable, int totalAmount) {
        amount = totalAmount;
        coins = new ArrayList<>(coinsAvailable);
        Collections.sort(coins);
        Collections.reverse(coins);
        calculate();
    }

    public CoinService(Collection<Integer> coinsAvailable) {
        coins = new ArrayList<>(coinsAvailable);
        Collections.sort(coins);
        Collections.reverse(coins);
    }

    public boolean isChangeAvailable() {
        return isChangeAvailable;
    }

    public ArrayList<Integer> getChange() {
        return change;
    }

    public List<Integer> getRemainingCoins() {
        return remainingCoins;
    }

    private Integer getRemainingCoins(int defaultDenomination) {
        return Collections.frequency(coins, defaultDenomination);
    }

    public boolean check10limit() {
        return getRemainingCoins(10) < min10Coins ? false : true;
    }

    public boolean check100limit() {
        return getRemainingCoins(100) < min100Coins ? false : true;
    }

    private void calculate() {
        remainingCoins = new ArrayList<>();
        int target = amount;

        // if limit reached for 10 coin, stop immediately
        if (getRemainingCoins(10) < min10Coins) {
            isChangeAvailable = false;
            return;
        }

        // if limit reached for 500 coin, stop immediately
        if (getRemainingCoins(100) < min100Coins) {
            isChangeAvailable = false;
            return;
        }

        // calculate change and remaining coin
        for (Integer coin : coins) {
            if (coin <= target) {
                change.add(coin);
                target -= coin;
            } else {
                remainingCoins.add(coin);
            }
        }

        // determine if change is available
        isChangeAvailable = (target == 0);
        if (!isChangeAvailable) {
            remainingCoins = coins;
        }
    }

    public List<Integer> getInsertedCoin() {
        return insertedCoin;
    }

    public void setInsertedCoin(List<Integer> insertedCoin) {
        this.insertedCoin = insertedCoin;
    }
}
