package maciek.islands;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import maciek.islands.CoastlineFragment.Orientation;
import maciek.islands.testutils.FormattedStringWorldMap;

public class CoastlineSearchTest {

	@Test
	public void test() throws Exception {

		FormattedStringWorldMap map = new FormattedStringWorldMap(
		        		"_______\n" +
		                "_______\n" +
		                "_xx_xx_\n" +
		                "_x_x___\n" +
		                "_xxxx__\n" +
		                "_______\n");

		CoastlineFieldSearchImpl search = CoastlineFieldSearchImpl.create(map, new BottomRightSequence());

		CoastlineSearchResult result = search.search(CoastlineFragment.of(Field.of(1, 1), Orientation.LAND_ON_RIGHT));

		assertEquals(Field.of(5, 3), result.getSearchedField());
		assertFalse(result.isLake());

	}
	
	@Test
	public void testLake() throws Exception {

		FormattedStringWorldMap map = new FormattedStringWorldMap(
		        		"_______\n" +
		                "_xxxxx_\n" +
		                "_x__xx_\n" +
		                "_x_x_x_\n" +
		                "_x___x_\n" +
		                "_xxxxx_\n");

		CoastlineFieldSearchImpl search = CoastlineFieldSearchImpl.create(map, new BottomRightSequence());
		
		CoastlineSearchResult result = search.search(CoastlineFragment.of(Field.of(1, 1), Orientation.LAND_ON_LEFT));

		assertEquals(Field.of(5, 1), result.getSearchedField());
		assertTrue(result.isLake());

	}

}
