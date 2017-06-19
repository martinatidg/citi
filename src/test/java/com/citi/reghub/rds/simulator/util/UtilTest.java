package com.citi.reghub.rds.simulator.util;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class UtilTest {
	//DataGenerator generator;
    @Before
    public void initProperties() {
       // generator = new DataGenerator("M2TR:30,M2PR:30,M2PO:40", "CEQ,CFI,F01,F02,F03,F04,F05,F06,F07,F08", 100, 60, 10);
    }

    @Test
	public void testGetTimeStr() {
    	long inputtime = 3_600_000;
    	String outStr = Util.getTimeStr(inputtime);
    	System.out.println(outStr + " 1: " + outStr);
    	String expectStr = "1 hours 0 minutes 0 seconds and 0 milliseconds.";
    	assertEquals(expectStr, outStr);

    	inputtime = 3_600_678;
    	outStr = Util.getTimeStr(inputtime);
    	System.out.println(outStr + " 2: " + outStr);
    	expectStr = "1 hours 0 minutes 0 seconds and 678 milliseconds.";
    	assertEquals(expectStr, outStr);

    	inputtime = 3_735_678;
    	outStr = Util.getTimeStr(inputtime);
    	System.out.println(outStr + " 3: " + outStr);
    	expectStr = "1 hours 2 minutes 15 seconds and 678 milliseconds.";
    	assertEquals(expectStr, outStr);

    	inputtime = 3_924_756;
    	outStr = Util.getTimeStr(inputtime);
    	System.out.println(outStr + " 3: " + outStr);
    	expectStr = "1 hours 5 minutes 24 seconds and 756 milliseconds.";
    	assertEquals(expectStr, outStr);
    }
}
