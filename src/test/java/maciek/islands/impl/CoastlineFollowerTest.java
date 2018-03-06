package maciek.islands.impl;

import static maciek.islands.impl.CoastlineFragment.Orientation.LAND_ON_BOTTOM;
import static maciek.islands.impl.CoastlineFragment.Orientation.LAND_ON_LEFT;
import static maciek.islands.impl.CoastlineFragment.Orientation.LAND_ON_RIGHT;
import static maciek.islands.impl.CoastlineFragment.Orientation.LAND_ON_TOP;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import maciek.islands.Field;
import maciek.islands.impl.CoastlineFollower;
import maciek.islands.impl.CoastlineFragment;
import maciek.islands.impl.testutils.ExpectedCoastlineFragmentsBuilder;
import maciek.islands.impl.testutils.FormattedStringOceanMap;

public class CoastlineFollowerTest {

	@Test
	public void testSimpleCase() throws Exception {

		FormattedStringOceanMap map = new FormattedStringOceanMap(
		        		"ooooooo\n" +
		                "oooxooo\n" +
		                "oooxooo\n" +
		                "oooxooo\n" +
		                "ooooooo\n" +
		                "ooooooo\n");

		CoastlineFollower follower = new CoastlineFollower(map);

		CoastlineFragment coastline = CoastlineFragment.of(Field.of(3, 3), LAND_ON_RIGHT);

		List<CoastlineFragment> expectedCoastlineFragments = new ExpectedCoastlineFragmentsBuilder()
		        .add(Field.of(3, 4), 0, LAND_ON_RIGHT)
		        .add(Field.of(3, 4), 1, LAND_ON_BOTTOM)
		        .add(Field.of(3, 4), 2, LAND_ON_LEFT)
		        .add(Field.of(3, 3), 2, LAND_ON_LEFT)
		        .add(Field.of(3, 2), 2, LAND_ON_LEFT)
		        .add(Field.of(3, 2), 3, LAND_ON_TOP)
		        .add(Field.of(3, 2), 4, LAND_ON_RIGHT)
		        .add(Field.of(3, 3), 4, LAND_ON_RIGHT)
		        .add(Field.of(3, 4), 4, LAND_ON_RIGHT)
		        .build();

		for (CoastlineFragment expectedCoastline : expectedCoastlineFragments) {
			assertEquals(expectedCoastline, coastline = follower.follow(coastline));
		}

	}

	@Test
	public void testComplexCase() throws Exception {

		FormattedStringOceanMap map = new FormattedStringOceanMap(
		        		"_______\n" +
		                "_______\n" +
		                "_xx_xx_\n" +
		                "_x_x___\n" +
		                "_xxxxx_\n" +
		                "______x\n");

		CoastlineFollower follower = new CoastlineFollower(map);

		CoastlineFragment coastline = CoastlineFragment.of(Field.of(1, 1), LAND_ON_RIGHT);

		List<CoastlineFragment> expectedCoastlineFragments = new ExpectedCoastlineFragmentsBuilder()
		        .add(Field.of(1, 2), 0, LAND_ON_RIGHT)
		        .add(Field.of(1, 3), 0, LAND_ON_RIGHT)
		        .add(Field.of(1, 3), 1, LAND_ON_BOTTOM)
		        .add(Field.of(2, 3), 1, LAND_ON_BOTTOM)
		        .add(Field.of(2, 3), 2, LAND_ON_LEFT)
		        .add(Field.of(3, 2), 1, LAND_ON_BOTTOM)
		        .add(Field.of(4, 3), 0, LAND_ON_RIGHT)
		        .add(Field.of(4, 3), 1, LAND_ON_BOTTOM)
		        .add(Field.of(5, 3), 1, LAND_ON_BOTTOM)
		        .add(Field.of(5, 3), 2, LAND_ON_LEFT)
		        .add(Field.of(5, 3), 3, LAND_ON_TOP)
		        .add(Field.of(4, 3), 3, LAND_ON_TOP)
		        .add(Field.of(3, 2), 2, LAND_ON_LEFT)
		        .add(Field.of(4, 1), 1, LAND_ON_BOTTOM)
		        .add(Field.of(5, 1), 1, LAND_ON_BOTTOM)
		        .add(Field.of(5, 1), 2, LAND_ON_LEFT)
		        .add(Field.of(6, 0), 1, LAND_ON_BOTTOM)
		        .add(Field.of(6, 0), 2, LAND_ON_LEFT)
		        .add(Field.of(6, 0), 3, LAND_ON_TOP)
		        .add(Field.of(6, 0), 4, LAND_ON_RIGHT)
		        .add(Field.of(5, 1), 3, LAND_ON_TOP)
		        .add(Field.of(4, 1), 3, LAND_ON_TOP)
		        .add(Field.of(3, 1), 3, LAND_ON_TOP)
		        .add(Field.of(2, 1), 3, LAND_ON_TOP)
		        .add(Field.of(1, 1), 3, LAND_ON_TOP)
		        .add(Field.of(1, 1), 4, LAND_ON_RIGHT)
		        .add(Field.of(1, 2), 4, LAND_ON_RIGHT)
		        .build();

		for (CoastlineFragment expectedCoastline : expectedCoastlineFragments) {
			assertEquals(expectedCoastline, coastline = follower.follow(coastline));
		}

	}

}
