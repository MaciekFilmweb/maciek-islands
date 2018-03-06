package maciek.islands.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import maciek.islands.Field;
import maciek.islands.impl.testutils.FormattedStringOceanMap;

public class JeepTest {
	
	@Test
	public void testClearingIslandKeys() throws Exception {
		
		FormattedStringOceanMap map = new FormattedStringOceanMap(
        		"______________\n" +
                "__xxxx__xxx___\n" +
                "_xx__xxx__x___\n" +
                "______________\n" +
                "__xx__x_x_x___\n" +
                "___xxx__x_xx__\n" +
                "___x_x_x___x__\n" +
                "___x_xxxxx_x__\n" +
                "___x_xxxxxxx__\n" +
                "______________\n" +
                "___xxxxxxxxx__\n" +
                "______________\n");
		
		BottomRightFieldSearchingSequence sequence = new BottomRightFieldSearchingSequence();
		
		Jeep jeep = Jeep.builder()
				.map(map)
				.sequence(new BottomRightFieldSearchingSequence())
				.islandKeyFieldSearch(IslandFieldSearcherImpl.create(map, sequence))
				.build();
		
		while (!jeep.isOnField(Field.of(100, 100))) {
			jeep.searchNextField();
		}
		
		assertEquals(0, jeep.getSavedIslandKeysCount());
		
	}

}
