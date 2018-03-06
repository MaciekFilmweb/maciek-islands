package maciek.islands;

import static maciek.islands.CoastlineFragment.Orientation.LAND_ON_BOTTOM;
import static maciek.islands.CoastlineFragment.Orientation.LAND_ON_LEFT;
import static maciek.islands.CoastlineFragment.Orientation.LAND_ON_RIGHT;
import static maciek.islands.CoastlineFragment.Orientation.LAND_ON_TOP;
import static maciek.islands.CoastlineFragment.Turn.FORWARD;
import static maciek.islands.CoastlineFragment.Turn.LEFT;
import static maciek.islands.CoastlineFragment.Turn.RIGHT;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor(staticName = "of")
@EqualsAndHashCode(exclude="convexity")
public class CoastlineFragment {

	private final Field land;

	private final Orientation orientation;

	private final int convexity;

	public static CoastlineFragment of(Field land, Orientation orientation) {
		return CoastlineFragment.of(land, orientation, 0);
	}

	public CoastlineFragment next(Turn turn) {

		if (orientation == LAND_ON_TOP && turn == FORWARD) {
			return new CoastlineFragment(land.left(), LAND_ON_TOP, convexity);
		}
		if (orientation == LAND_ON_TOP && turn == LEFT) {
			return new CoastlineFragment(land.down().left(), LAND_ON_LEFT, convexity - 1);
		}
		if (orientation == LAND_ON_TOP && turn == RIGHT) {
			return new CoastlineFragment(land, LAND_ON_RIGHT, convexity + 1);
		}

		if (orientation == LAND_ON_RIGHT && turn == FORWARD) {
			return new CoastlineFragment(land.up(), LAND_ON_RIGHT, convexity);
		}
		if (orientation == LAND_ON_RIGHT && turn == LEFT) {
			return new CoastlineFragment(land.up().left(), LAND_ON_TOP, convexity - 1);
		}
		if (orientation == LAND_ON_RIGHT && turn == RIGHT) {
			return new CoastlineFragment(land, LAND_ON_BOTTOM, convexity + 1);
		}

		if (orientation == LAND_ON_BOTTOM && turn == FORWARD) {
			return new CoastlineFragment(land.right(), LAND_ON_BOTTOM, convexity);
		}
		if (orientation == LAND_ON_BOTTOM && turn == LEFT) {
			return new CoastlineFragment(land.up().right(), LAND_ON_RIGHT, convexity - 1);
		}
		if (orientation == LAND_ON_BOTTOM && turn == RIGHT) {
			return new CoastlineFragment(land, LAND_ON_LEFT, convexity + 1);
		}

		if (orientation == LAND_ON_LEFT && turn == FORWARD) {
			return new CoastlineFragment(land.down(), LAND_ON_LEFT, convexity);
		}
		if (orientation == LAND_ON_LEFT && turn == LEFT) {
			return new CoastlineFragment(land.down().right(), LAND_ON_BOTTOM, convexity - 1);
		}
		if (orientation == LAND_ON_LEFT && turn == RIGHT) {

			return new CoastlineFragment(land, LAND_ON_TOP, convexity + 1);
		}

		throw new RuntimeException();
	}

	public boolean check(WorldMap map) {

		if (orientation == LAND_ON_TOP) {
			return map.isLand(land) && !map.isLand(land.down());
		}
		if (orientation == LAND_ON_RIGHT) {
			return map.isLand(land) && !map.isLand(land.left());
		}
		if (orientation == LAND_ON_BOTTOM) {
			return map.isLand(land) && !map.isLand(land.up());
		}
		if (orientation == LAND_ON_LEFT) {
			return map.isLand(land) && !map.isLand(land.right());
		}

		throw new RuntimeException();
	}

	public enum Orientation {
		LAND_ON_TOP, LAND_ON_RIGHT, LAND_ON_BOTTOM, LAND_ON_LEFT;
	}

	public enum Turn {
		FORWARD, LEFT, RIGHT;
	}

}
