package com.tests.shortlyst.test.vendingmachine.domain;

import com.shortlyst.test.vendingmachine.services.ShelveService;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ShelveBoxTest {

    private ShelveService shelveBox;

    @Before
    public void setUp() throws Exception {
        shelveBox = new ShelveService();
    }

    @After
    public void tearDown() throws Exception {
        shelveBox = null;
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void negativeShelfIndex() {
        shelveBox.isEmptyAt(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void outOfBoundsShelfIndex() {
        shelveBox.addToShelf("Energy Drink", 120, 1);
        shelveBox.isEmptyAt(1);
    }

    /**
     * our shelves never empty, only the quantity, but physically is empty
     * */
    @Test
    public void shouldEmptyAfterUse() throws Exception {
        shelveBox.addToShelf("Energy Drink", 120, 1);
        shelveBox.addToShelf("Apple Juice", 110, 1);
        Assert.assertFalse(shelveBox.isEmpty());
        shelveBox.releaseItemFromIndex(0);
        Assert.assertFalse(shelveBox.isEmpty());
        shelveBox.releaseItemFromIndex(1);
        Assert.assertFalse(shelveBox.isEmpty());
    }

    @Test
    public void assertMatchAtIndex() {
        shelveBox.addToShelf("Energy Drink", 120, 1);
        shelveBox.addToShelf("Apple Juice", 110, 1);

        Assert.assertThat(shelveBox.getShelveFromIndex(0).getItem().getName(), CoreMatchers.is("Energy Drink"));
        Assert.assertThat(shelveBox.getShelveFromIndex(1).getItem().getName(), CoreMatchers.is("Apple Juice"));
    }

    @Test
    public void assertItemReleased() {

        shelveBox.addToShelf("Energy Drink", 120, 2);
        shelveBox.releaseItemFromIndex(0);

        int currentStock = shelveBox.getShelveFromIndex(0).getCount();

        Assert.assertEquals(1, currentStock);

        shelveBox.releaseItemFromIndex(0);

        int supposedNoStock = shelveBox.getShelveFromIndex(0).getCount();

        Assert.assertEquals(0, supposedNoStock);
    }

    @Test
    public void assertNullIfItemOutOfStock() {
        shelveBox.addToShelf("Energy Drink", 120, 0);
        Assert.assertNull(shelveBox.releaseItemFromIndex(0));
    }
}
