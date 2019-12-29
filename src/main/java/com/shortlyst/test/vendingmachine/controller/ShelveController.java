package com.shortlyst.test.vendingmachine.controller;

import java.util.*;

import com.shortlyst.test.vendingmachine.entities.Item;
import com.shortlyst.test.vendingmachine.entities.Shelve;
import com.shortlyst.test.vendingmachine.services.ShelveService;

public class ShelveController implements IController {

	private ShelveService shelveService = new ShelveService();
    private int totalCurrentHoldAmount = 0;
    private List<Integer> insertedCoin = new ArrayList<>();
    private List<Item> selectedItem = new ArrayList<>();

    public ShelveController init() {
        shelveService.addToShelf("Canned coffee", 120, 3);
        shelveService.addToShelf("Water PET bottle", 100, 0);
        shelveService.addToShelf("Sport drinks", 150, 5);
        return this;
    }

    public Item getItemFromIndex(int index) throws IndexOutOfBoundsException {
        return shelveService.getItemFromIndex(index);
    }

    public Shelve getShelveFromIndex(int index) throws IndexOutOfBoundsException {
        return this.shelveService.getShelveFromIndex(index);
    }

    public LinkedList<Shelve> getAvailableItem() {
        return shelveService.getAvailableItem();
    }

    public int getTotalHoldAmount() {
        int totalHoldPrice = 0;
        for (Item Item : selectedItem) {
            totalHoldPrice += Item.getPrice();
        }
        return sumInsertedCoin() - totalHoldPrice;
    }

    public int getTotalCurrentHoldAmount() {
        return sumInsertedCoin() - getTotalHoldAmount();
    }

    private Integer sumInsertedCoin() {
        return insertedCoin.stream().mapToInt(a -> a).sum();
    }

    public boolean canProceed() {
        return sumInsertedCoin() >= getTotalCurrentHoldAmount();
    }

    public void removeFromContainer() {
        selectedItem.remove(selectedItem.size()-1);
    }

    public List<Item> getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(List<Item> selectedItem) {
        this.selectedItem = selectedItem;
    }

    public List<Integer> getInsertedCoin() {
        return insertedCoin;
    }

    public void setInsertedCoin(List<Integer> insertedCoin) {
        this.insertedCoin = insertedCoin;
    }

    public void releaseIfProceed(int index) {
        shelveService.releaseItemFromIndex(index);
    }

    @Override
    public void reset() {
        totalCurrentHoldAmount = 0;
        insertedCoin = new ArrayList<>();
        selectedItem = new ArrayList<>();
    }

    @Override
    public void selectShelf(int index) {
        selectedItem.add(getItemFromIndex(index));
        selectedItem.forEach(Item -> totalCurrentHoldAmount += Item.getPrice());
    }

    @Override
    public void insertCoin(int coin) {
        insertedCoin.add(coin);
    }

    public void test() {
        System.out.println("anuan");
    }
}
