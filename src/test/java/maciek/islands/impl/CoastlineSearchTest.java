package maciek.islands.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import maciek.islands.Field;
import maciek.islands.impl.BottomRightFieldSearchingSequence;
import maciek.islands.impl.CoastlineFieldSearcherImpl;
import maciek.islands.impl.CoastlineFragment;
import maciek.islands.impl.CoastlineSearchResult;
import maciek.islands.impl.CoastlineFragment.Orientation;
import maciek.islands.impl.testutils.FormattedStringOceanMap;

public class CoastlineSearchTest {

	@Test
	public void test() throws Exception {

		FormattedStringOceanMap map = new FormattedStringOceanMap(
		        		"_______\n" +
		                "_______\n" +
		                "_xx_xx_\n" +
		                "_x_x___\n" +
		                "_xxxx__\n" +
		                "_______\n");

		CoastlineFieldSearcherImpl search = CoastlineFieldSearcherImpl.create(map);

		CoastlineSearchResult result = search.search(
		        CoastlineFragment.of(Field.of(1, 1), Orientation.LAND_ON_RIGHT), createConsumer());

		assertEquals(Field.of(5, 3), result.getSearchedField());
		assertFalse(result.isLake());

	}

	@Test
	public void testLake() throws Exception {

		FormattedStringOceanMap map = new FormattedStringOceanMap(
		        		"_______\n" +
		                "_xxxxx_\n" +
		                "_x__xx_\n" +
		                "_x_x_x_\n" +
		                "_x___x_\n" +
		                "_xxxxx_\n");

		CoastlineFieldSearcherImpl search = CoastlineFieldSearcherImpl.create(map);

		CoastlineSearchResult result = search.search(
				CoastlineFragment.of(Field.of(1, 1), Orientation.LAND_ON_LEFT), createConsumer());

		assertEquals(Field.of(5, 1), result.getSearchedField());
		assertTrue(result.isLake());

	}

	private static FieldSequenceCoastlineFieldConsumer createConsumer() {
		return new FieldSequenceCoastlineFieldConsumer(new BottomRightFieldSearchingSequence());
	}

}
