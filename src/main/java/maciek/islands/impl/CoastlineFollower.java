package maciek.islands.impl;

import static maciek.islands.impl.CoastlineFragment.Turn.FORWARD;
import static maciek.islands.impl.CoastlineFragment.Turn.LEFT;
import static maciek.islands.impl.CoastlineFragment.Turn.RIGHT;

import maciek.islands.OceanMap;
import maciek.islands.impl.CoastlineFragment.Turn;

/**
 * Follows consecutive coastline fragments.
 */
public class CoastlineFollower {

	private final OceanMap map;

	public CoastlineFollower(OceanMap map) {
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
