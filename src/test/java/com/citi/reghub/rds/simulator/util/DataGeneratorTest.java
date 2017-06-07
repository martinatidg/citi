package com.citi.reghub.rds.simulator.util;

import org.junit.Before;
import org.junit.Test;

import com.citi.reghub.rds.simulator.domain.Entity;

import static org.mockito.Mockito.*;

import java.util.List;

import static org.junit.Assert.*;

public class DataGeneratorTest {
	DataGenerator generator;
    @Before
    public void initProperties() {
        EntityProperties properties = mock(EntityProperties.class);
        when(properties.getTotal()).thenReturn(100);
        when(properties.getStreams()).thenReturn("M2TR:30,M2PR:30,M2PO:40");
        when(properties.getFlows()).thenReturn("CEQ,CFI,F01,F02,F03,F04,F05,F06,F07,F08");
        when(properties.getTimeframe()).thenReturn(60);
        when(properties.getBatchSize()).thenReturn(10);

        generator = new DataGenerator(properties);
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
