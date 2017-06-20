package com.citi.reghub.rds.simulator.util;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class UtilTest {

    @Test
	public void testGetTimeStr() {
    	long inputtime = 3_600_000;
    	String outStr = Util.getTimeStr(inputtime);
    	String expectStr = "1 hours 0 minutes 0 seconds and 0 milliseconds.";
    	assertEquals(expectStr, outStr);

    	inputtime = 3_600_678;
    	outStr = Util.getTimeStr(inputtime);
    	expectStr = "1 hours 0 minutes 0 seconds and 678 milliseconds.";
    	assertEquals(expectStr, outStr);

    	inputtime = 3_735_678;
    	outStr = Util.getTimeStr(inputtime);
    	expectStr = "1 hours 2 minutes 15 seconds and 678 milliseconds.";
    	assertEquals(expectStr, outStr);

    	inputtime = 3_924_756;
    	outStr = Util.getTimeStr(inputtime);
    	expectStr = "1 hours 5 minutes 24 seconds and 756 milliseconds.";
    	assertEquals(expectStr, outStr);
    }
}
