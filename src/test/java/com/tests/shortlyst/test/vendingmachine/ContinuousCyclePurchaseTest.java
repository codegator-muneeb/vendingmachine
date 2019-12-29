package com.tests.shortlyst.test.vendingmachine;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.shortlyst.test.vendingmachine.App;

import static org.junit.Assert.assertEquals;

public class ContinuousCyclePurchaseTest {

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
    public void continuousCyclePurchaseTest() {
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

        String command7_1_500 = "----------------------------------\n" +
                "[Input Amount]\n" +
                "\t500 JPY\n" +
                "[Change]\n" +
                "\t100 JPY Change\n" +
                "\t10 JPY Change\n" +
                "[Return Gate]\n" +
                "\tEmpty\n" +
                "[Items for sale]\n" +
                "\t1. Canned coffee 120 JPY Available for Purchase\n" +
                "\t2. Water PET bottle 100 JPY Out of Stock\n" +
                "\t3. Sport drinks 150 JPY Available for Purchase\n" +
                "[Outlet]\n" +
                "\tEmpty\n" +
                "----------------------------------";

        assertEquals(command7_1_500, app.processCommand("1 500"));

        String command8_2_1 = "----------------------------------\n" +
                "[Input Amount]\n" +
                "\t380 JPY\n" +
                "[Change]\n" +
                "\t100 JPY Change\n" +
                "\t10 JPY Change\n" +
                "[Return Gate]\n" +
                "\tEmpty\n" +
                "[Items for sale]\n" +
                "\t1. Canned coffee 120 JPY Available for Purchase\n" +
                "\t2. Water PET bottle 100 JPY Out of Stock\n" +
                "\t3. Sport drinks 150 JPY Available for Purchase\n" +
                "[Outlet]\n" +
                "\tCanned coffee\n" +
                "----------------------------------";

        assertEquals(command8_2_1, app.processCommand("2 1"));

        String command9_2_1 = "----------------------------------\n" +
                "[Input Amount]\n" +
                "\t260 JPY\n" +
                "[Change]\n" +
                "\t100 JPY Change\n" +
                "\t10 JPY Change\n" +
                "[Return Gate]\n" +
                "\tEmpty\n" +
                "[Items for sale]\n" +
                "\t1. Canned coffee 120 JPY Out of Stock\n" +
                "\t2. Water PET bottle 100 JPY Out of Stock\n" +
                "\t3. Sport drinks 150 JPY Available for Purchase\n" +
                "[Outlet]\n" +
                "\tCanned coffee\n" +
                "\tCanned coffee\n" +
                "----------------------------------";

        assertEquals(command9_2_1, app.processCommand("2 1"));

        String command10_2_3 = "----------------------------------\n" +
                "[Input Amount]\n" +
                "\t110 JPY\n" +
                "[Change]\n" +
                "\t100 JPY Change\n" +
                "\t10 JPY Change\n" +
                "[Return Gate]\n" +
                "\tEmpty\n" +
                "[Items for sale]\n" +
                "\t1. Canned coffee 120 JPY Out of Stock\n" +
                "\t2. Water PET bottle 100 JPY Out of Stock\n" +
                "\t3. Sport drinks 150 JPY \n" +
                "[Outlet]\n" +
                "\tCanned coffee\n" +
                "\tCanned coffee\n" +
                "\tSport drinks\n" +
                "----------------------------------";

        assertEquals(command10_2_3, app.processCommand("2 3"));

        String command11_3 = "Your change is being prepared (if any), you may now empty the Outlet\n" +
                "----------------------------------\n" +
                "[Input Amount]\n" +
                "\t110 JPY\n" +
                "[Change]\n" +
                "\t100 JPY Change\n" +
                "\t10 JPY Change\n" +
                "[Return Gate]\n" +
                "\t100 JPY\n" +
                "\t10 JPY\n" +
                "[Items for sale]\n" +
                "\t1. Canned coffee 120 JPY Out of Stock\n" +
                "\t2. Water PET bottle 100 JPY Out of Stock\n" +
                "\t3. Sport drinks 150 JPY \n" +
                "[Outlet]\n" +
                "\tCanned coffee\n" +
                "\tCanned coffee\n" +
                "\tSport drinks\n" +
                "----------------------------------";

        assertEquals(command11_3, app.processCommand("3"));

        String command12_4 = "Please collect your change in Return Gate\n" +
                "----------------------------------\n" +
                "[Input Amount]\n" +
                "\t0 JPY\n" +
                "[Change]\n" +
                "\t100 JPY Change\n" +
                "\t10 JPY Change\n" +
                "[Return Gate]\n" +
                "\t100 JPY\n" +
                "\t10 JPY\n" +
                "[Items for sale]\n" +
                "\t1. Canned coffee 120 JPY Out of Stock\n" +
                "\t2. Water PET bottle 100 JPY Out of Stock\n" +
                "\t3. Sport drinks 150 JPY \n" +
                "[Outlet]\n" +
                "\tCanned coffee\n" +
                "\tCanned coffee\n" +
                "\tSport drinks\n" +
                "----------------------------------";

        assertEquals(command12_4, app.processCommand("4"));

        String command13_5 = "Thank you for using our service\n" +
                "----------------------------------\n" +
                "[Input Amount]\n" +
                "\t0 JPY\n" +
                "[Change]\n" +
                "\t100 JPY Change\n" +
                "\t10 JPY Change\n" +
                "[Return Gate]\n" +
                "\tEmpty\n" +
                "[Items for sale]\n" +
                "\t1. Canned coffee 120 JPY Out of Stock\n" +
                "\t2. Water PET bottle 100 JPY Out of Stock\n" +
                "\t3. Sport drinks 150 JPY \n" +
                "[Outlet]\n" +
                "\tEmpty\n" +
                "----------------------------------";

        assertEquals(command13_5, app.processCommand("5"));
    }

}
