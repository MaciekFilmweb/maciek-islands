package maciek.silent8.islands.coastline;

import static maciek.silent8.islands.coastline.CoastlineFragment.Orientation.LAND_ON_BOTTOM;
import static maciek.silent8.islands.coastline.CoastlineFragment.Orientation.LAND_ON_LEFT;
import static maciek.silent8.islands.coastline.CoastlineFragment.Orientation.LAND_ON_RIGHT;
import static maciek.silent8.islands.coastline.CoastlineFragment.Orientation.LAND_ON_TOP;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

import maciek.silent8.islands.Field;
import maciek.silent8.islands.FormattedStringWorldMap;
import maciek.silent8.islands.coastline.CoastlineFragment.Orientation;

public class CoastLineFollowerTest {

	@Test
	public void testSimpleCase() throws Exception {

		FormattedStringWorldMap map = new FormattedStringWorldMap(
		        "ooooooo\n" +
		                "oooxooo\n" +
		                "oooxooo\n" +
		                "oooxooo\n" +
		                "ooooooo\n" +
		                "ooooooo\n");

		CoastlineFollower follower = new CoastlineFollower(map);

		CoastlineFragment coastline = CoastlineFragment.of(Field.of(3, 3), LAND_ON_RIGHT);

		List<CoastlineFragment> expectedCoastlineFragments = new ExpectedCoastlineFragmentsBuilder()
		        .add(Field.of(3, 4), LAND_ON_RIGHT)
		        .add(Field.of(3, 4), LAND_ON_BOTTOM)
		        .add(Field.of(3, 4), LAND_ON_LEFT)
		        .add(Field.of(3, 3), LAND_ON_LEFT)
		        .add(Field.of(3, 2), LAND_ON_LEFT)
		        .add(Field.of(3, 2), LAND_ON_TOP)
		        .add(Field.of(3, 2), LAND_ON_RIGHT)
		        .add(Field.of(3, 3), LAND_ON_RIGHT)
		        .add(Field.of(3, 4), LAND_ON_RIGHT)
		        .build();

		for (CoastlineFragment expectedCoastline : expectedCoastlineFragments) {
			assertEquals(expectedCoastline, coastline = follower.follow(coastline));
		}

	}

	@Test
	public void testComplexCase() throws Exception {

		FormattedStringWorldMap map = new FormattedStringWorldMap(
		        "_______\n" +
		                "_______\n" +
		                "_xx_xx_\n" +
		                "_x_x___\n" +
		                "_xxxxx_\n" +
		                "______x\n");

		CoastlineFollower follower = new CoastlineFollower(map);

		CoastlineFragment coastline = CoastlineFragment.of(Field.of(1, 1), LAND_ON_RIGHT);

		List<CoastlineFragment> expectedCoastlineFragments = new ExpectedCoastlineFragmentsBuilder()
		        .add(Field.of(1, 2), LAND_ON_RIGHT)
		        .add(Field.of(1, 3), LAND_ON_RIGHT)
		        .add(Field.of(1, 3), LAND_ON_BOTTOM)
		        .add(Field.of(2, 3), LAND_ON_BOTTOM)
		        .add(Field.of(2, 3), LAND_ON_LEFT)
		        .add(Field.of(3, 2), LAND_ON_BOTTOM)
		        .add(Field.of(4, 3), LAND_ON_RIGHT)
		        .add(Field.of(4, 3), LAND_ON_BOTTOM)
		        .add(Field.of(5, 3), LAND_ON_BOTTOM)
		        .add(Field.of(5, 3), LAND_ON_LEFT)
		        .add(Field.of(5, 3), LAND_ON_TOP)
		        .add(Field.of(4, 3), LAND_ON_TOP)
		        .add(Field.of(3, 2), LAND_ON_LEFT)
		        .add(Field.of(4, 1), LAND_ON_BOTTOM)
		        .add(Field.of(5, 1), LAND_ON_BOTTOM)
		        .add(Field.of(5, 1), LAND_ON_LEFT)
		        .add(Field.of(6, 0), LAND_ON_BOTTOM)
		        .add(Field.of(6, 0), LAND_ON_LEFT)
		        .add(Field.of(6, 0), LAND_ON_TOP)
		        .add(Field.of(6, 0), LAND_ON_RIGHT)
		        .add(Field.of(5, 1), LAND_ON_TOP)
		        .add(Field.of(4, 1), LAND_ON_TOP)
		        .add(Field.of(3, 1), LAND_ON_TOP)
		        .add(Field.of(2, 1), LAND_ON_TOP)
		        .add(Field.of(1, 1), LAND_ON_TOP)
		        .add(Field.of(1, 1), LAND_ON_RIGHT)
		        .add(Field.of(1, 2), LAND_ON_RIGHT)
		        .build();

		for (CoastlineFragment expectedCoastline : expectedCoastlineFragments) {
			assertEquals(expectedCoastline, coastline = follower.follow(coastline));
		}

	}

	@Test
	public void testSearching() throws Exception {

		FormattedStringWorldMap map = new FormattedStringWorldMap(
		        "_______\n" +
		                "_______\n" +
		                "_xx_xx_\n" +
		                "_x_x___\n" +
		                "_xxxxx_\n" +
		                "___x__x\n");

		MostBottomRightFieldSearch search = new MostBottomRightFieldSearch();

		new CoastlineFollower(map).search(CoastlineFragment.of(Field.of(1, 1), LAND_ON_RIGHT), search);

		assertEquals(Field.of(6, 0), search.getMostBottomRightField());

	}

	private static class ExpectedCoastlineFragmentsBuilder {

		private Builder<CoastlineFragment> builder = ImmutableList.<CoastlineFragment>builder();

		public ExpectedCoastlineFragmentsBuilder add(Field field, Orientation orientation) {
			builder.add(CoastlineFragment.of(field, orientation));
			return this;
		}

		public List<CoastlineFragment> build() {
			return builder.build();
		}
	}

}
