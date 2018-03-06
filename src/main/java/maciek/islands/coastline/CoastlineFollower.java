package maciek.islands.coastline;

import static maciek.islands.coastline.CoastlineFragment.Turn.FORWARD;
import static maciek.islands.coastline.CoastlineFragment.Turn.LEFT;
import static maciek.islands.coastline.CoastlineFragment.Turn.RIGHT;

import maciek.islands.WorldMap;
import maciek.islands.coastline.CoastlineFragment.Turn;

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
