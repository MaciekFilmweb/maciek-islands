package maciek.islands.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import maciek.islands.Field;
import maciek.islands.impl.BottomRightFieldSearchingSequence;
import maciek.islands.impl.IslandFieldSearchImpl;
import maciek.islands.impl.testutils.FormattedStringOceanMap;

public class BottomRightFieldSearchTest {
	
	@Test
	public void test1() throws Exception {
		
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
		
		IslandFieldSearchImpl search = IslandFieldSearchImpl.create(map, new BottomRightFieldSearchingSequence());
		
		assertEquals(Field.of(11, 3), search.search(Field.of(3, 4)));
		assertEquals(Field.of(10, 9), search.search(Field.of(1, 9)));
	}
	
	@Test
	public void test2() throws Exception {
		
		FormattedStringOceanMap map = new FormattedStringOceanMap(
        		"______________\n" +
                "______________\n" +
                "__xxxxxxxxxx__\n" +
                "__x_x_x_x_x___\n" +
                "__xxxxxxx_xx__\n" +
                "____x__x___x__\n" +
                "xxx______x_x__\n" +
                "x_xxxxxxx_x___\n" +
                "x____x____x___\n" +
                "x____x____xx__\n" +
                "x____x________\n" +
                "xxxxxxxxxxxx_x\n");
		
		IslandFieldSearchImpl search = IslandFieldSearchImpl.create(map, new BottomRightFieldSearchingSequence());
		
		assertEquals(Field.of(11, 0), search.search(Field.of(6, 8)));
	}
	
	@Test
	public void test3() throws Exception {
		
		FormattedStringOceanMap map = new FormattedStringOceanMap(
        		"______________\n" +
                "__xx__________\n" +
                "__xx__________\n" +
                "______________\n" +
                "______________\n" +
                "____xxx_______\n" +
                "____xxx_______\n" +
                "______________\n" +
                "______________\n" +
                "________xxx___\n" +
                "________xxx___\n" +
                "______________\n");
		
		IslandFieldSearchImpl search = IslandFieldSearchImpl.create(map, new BottomRightFieldSearchingSequence());
		
		assertEquals(Field.of(6, 5), search.search(Field.of(4, 6)));
	}
	
	@Test
	public void test4() throws Exception {
		
		FormattedStringOceanMap map = new FormattedStringOceanMap(
        		"______________\n" +
                "__xxxxxxxxxx__\n" +
                "_____xx____x__\n" +
                "_____x_____x__\n" +
                "_____x_____x__\n" +
                "_____xxxxxxx__\n" +
                "___________x__\n" +
                "___________x__\n" +
                "___________x__\n" +
                "___________x__\n" +
                "___________x__\n" +
                "___________x__\n");
		
		IslandFieldSearchImpl search = IslandFieldSearchImpl.create(map, new BottomRightFieldSearchingSequence());
		
		assertEquals(Field.of(11, 0), search.search(Field.of(6, 9)));
	}

}
