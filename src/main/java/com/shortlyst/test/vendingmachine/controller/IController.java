package com.shortlyst.test.vendingmachine.controller;

public interface IController {

	void reset();

    void selectShelf(int index);

    void insertCoin(int coin);

}
