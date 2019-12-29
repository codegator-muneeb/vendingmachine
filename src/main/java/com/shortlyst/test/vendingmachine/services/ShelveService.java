package com.shortlyst.test.vendingmachine.services;

import java.util.*;

import com.shortlyst.test.vendingmachine.entities.Item;
import com.shortlyst.test.vendingmachine.entities.Shelve;

public class ShelveService {

    private final LinkedList<Shelve> shelves = new LinkedList<>();

    public ShelveService addToShelf(String name, int price, int quantity) {
        Shelve newShelf = new Shelve(new Item(name, price), quantity);
        shelves.add(newShelf);
        return this;
    }

    /**
     * checks if shelves are empty, completely
     */
    public Boolean isEmpty() {
        return shelves.isEmpty();
    }

    public Boolean isEmptyAt(int index) throws IndexOutOfBoundsException {
        return shelves.get(index) != null;
    }

    /**
     * release a product, if already empty, return null. Also reduce the count
     */
    public Item releaseItemFromIndex(int index) throws IndexOutOfBoundsException {
        Integer ItemQuantity = shelves.get(index).getCount();
        if (ItemQuantity == 0) {
            return null;
        }

        shelves.get(index).setCount(ItemQuantity - 1);
        return shelves.get(index).getItem();
    }

    public Integer getPriceAtIndex(int index) throws IndexOutOfBoundsException {
        Item isProduct = getItemFromIndex(index);
        if (isProduct != null) {
            return isProduct.getPrice();
        }
        throw new IndexOutOfBoundsException();
    }

    /**
     * returns the item in a shelve
     **/
    public Item getItemFromIndex(int index) throws IndexOutOfBoundsException {
        return shelves.get(index).getItem();
    }

    /**
     * Returns the Shelve Object at given index
     **/
    public Shelve getShelveFromIndex(int index) throws IndexOutOfBoundsException {
        return shelves.get(index);
    }

    public LinkedList<Shelve> getAvailableItem() {
        return shelves;
    }

}
