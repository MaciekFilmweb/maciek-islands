package maciek.islands;

import static maciek.islands.CoastlineFragment.Turn.FORWARD;
import static maciek.islands.CoastlineFragment.Turn.LEFT;
import static maciek.islands.CoastlineFragment.Turn.RIGHT;

import maciek.islands.CoastlineFragment.Turn;

/**
 * Follows consecutive coastline fragments.
 */
public class CoastlineFollower {

	private final WorldMap map;

	public CoastlineFollower(WorldMap map) {
		this.map = map;
	}

	/**
	 * Returns next coastline fragment.
	 */
	public CoastlineFragment follow(CoastlineFragment coastline) {
		if (!coastline.check(map)) {
			throw new IllegalArgumentException("Provided coastline fragment doesn't exist.");
		}
		Turn[] directions = new Turn[] { LEFT, FORWARD, RIGHT };
		for (Turn direction : directions) {
			CoastlineFragment next = coastline.next(direction);
			if (next.check(map)) {
				return next;
			}
		}
		throw new RuntimeException("Coastline unexpectedly ends.");
	}

}
