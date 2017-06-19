package com.citi.reghub.rds.simulator.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.citi.reghub.rds.simulator.domain.Entity;

public class DataGeneratorTest {
	DataGenerator generator;
    @Before
    public void initProperties() {
        generator = new DataGenerator("M2TR:30,M2PR:30,M2PO:40", "CEQ,CFI,F01,F02,F03,F04,F05,F06,F07,F08", 100, 60, 10, 25);
    }

    @Test
	public void testGetTotalRecordNum() {
    	assertEquals(generator.getTotalRecordNum(), 100);
	}
    
    @Test
	public void testGetIntervalTime() {
    	assertEquals(generator.getIntervalTime(), 0);	// the current version is always 0
	}

    @Test
	public void testGetBaseEntity() {
    	assertNotNull(generator.getOneEntity());
	}

    @Test
	public void testGetBatchEntity() {
    	List<Entity> ents = generator.getBatchEntity();
    	assertNotNull(ents);
    	assertEquals(ents.size(), 10);
	}
}
