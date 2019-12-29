package com.tests.shortlyst.test.vendingmachine;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.shortlyst.test.vendingmachine.App;

import static org.junit.Assert.assertEquals;

public class OneCyclePurchaseTest {

    private App app;

    @Before
    public void setUp() throws Exception {
        app = new App();
    }

    @After
    public void tearDown() throws Exception {
        app = null;
    }

    @Test
    public void oneCyclePurchaseTest() {
        String command1_1_10 = "----------------------------------\n" +
                "[Input Amount]\n" +
                "\t10 JPY\n" +
                "[Change]\n" +
                "\t100 JPY Change\n" +
                "\t10 JPY Change\n" +
                "[Return Gate]\n" +
                "\tEmpty\n" +
                "[Items for sale]\n" +
                "\t1. Canned coffee 120 JPY \n" +
                "\t2. Water PET bottle 100 JPY Out of Stock\n" +
                "\t3. Sport drinks 150 JPY \n" +
                "[Outlet]\n" +
                "\tEmpty\n" +
                "----------------------------------";

        assertEquals(command1_1_10, app.processCommand("1 10"));

        String command2_1_10 = "----------------------------------\n" +
                "[Input Amount]\n" +
                "\t20 JPY\n" +
                "[Change]\n" +
                "\t100 JPY Change\n" +
                "\t10 JPY Change\n" +
                "[Return Gate]\n" +
                "\tEmpty\n" +
                "[Items for sale]\n" +
                "\t1. Canned coffee 120 JPY \n" +
                "\t2. Water PET bottle 100 JPY Out of Stock\n" +
                "\t3. Sport drinks 150 JPY \n" +
                "[Outlet]\n" +
                "\tEmpty\n" +
                "----------------------------------";

        assertEquals(command2_1_10, app.processCommand("1 10"));

        String command3_1_100 = "----------------------------------\n" +
                "[Input Amount]\n" +
                "\t120 JPY\n" +
                "[Change]\n" +
                "\t100 JPY Change\n" +
                "\t10 JPY Change\n" +
                "[Return Gate]\n" +
                "\tEmpty\n" +
                "[Items for sale]\n" +
                "\t1. Canned coffee 120 JPY Available for Purchase\n" +
                "\t2. Water PET bottle 100 JPY Out of Stock\n" +
                "\t3. Sport drinks 150 JPY \n" +
                "[Outlet]\n" +
                "\tEmpty\n" +
                "----------------------------------";

        assertEquals(command3_1_100, app.processCommand("1 100"));

        String command4_2_1 = "----------------------------------\n" +
                "[Input Amount]\n" +
                "\t0 JPY\n" +
                "[Change]\n" +
                "\t100 JPY Change\n" +
                "\t10 JPY Change\n" +
                "[Return Gate]\n" +
                "\tEmpty\n" +
                "[Items for sale]\n" +
                "\t1. Canned coffee 120 JPY \n" +
                "\t2. Water PET bottle 100 JPY Out of Stock\n" +
                "\t3. Sport drinks 150 JPY \n" +
                "[Outlet]\n" +
                "\tCanned coffee\n" +
                "----------------------------------";

        assertEquals(command4_2_1, app.processCommand("2 1"));

        String command5_3 = "Your change is being prepared (if any), you may now empty the Outlet\n" +
                "----------------------------------\n" +
                "[Input Amount]\n" +
                "\t0 JPY\n" +
                "[Change]\n" +
                "\t100 JPY Change\n" +
                "\t10 JPY Change\n" +
                "[Return Gate]\n" +
                "\tEmpty\n" +
                "[Items for sale]\n" +
                "\t1. Canned coffee 120 JPY \n" +
                "\t2. Water PET bottle 100 JPY Out of Stock\n" +
                "\t3. Sport drinks 150 JPY \n" +
                "[Outlet]\n" +
                "\tCanned coffee\n" +
                "----------------------------------";

        assertEquals(command5_3, app.processCommand("3"));

        String command6_4 = "Please collect your change in Return Gate\n" +
                "----------------------------------\n" +
                "[Input Amount]\n" +
                "\t0 JPY\n" +
                "[Change]\n" +
                "\t100 JPY Change\n" +
                "\t10 JPY Change\n" +
                "[Return Gate]\n" +
                "\tEmpty\n" +
                "[Items for sale]\n" +
                "\t1. Canned coffee 120 JPY \n" +
                "\t2. Water PET bottle 100 JPY Out of Stock\n" +
                "\t3. Sport drinks 150 JPY \n" +
                "[Outlet]\n" +
                "\tCanned coffee\n" +
                "----------------------------------";

        assertEquals(command6_4, app.processCommand("4"));

        String command7_5 = "Thank you for using our service\n" +
                "----------------------------------\n" +
                "[Input Amount]\n" +
                "\t0 JPY\n" +
                "[Change]\n" +
                "\t100 JPY Change\n" +
                "\t10 JPY Change\n" +
                "[Return Gate]\n" +
                "\tEmpty\n" +
                "[Items for sale]\n" +
                "\t1. Canned coffee 120 JPY \n" +
                "\t2. Water PET bottle 100 JPY Out of Stock\n" +
                "\t3. Sport drinks 150 JPY \n" +
                "[Outlet]\n" +
                "\tEmpty\n" +
                "----------------------------------";

        assertEquals(command7_5, app.processCommand("5"));
    }

}
