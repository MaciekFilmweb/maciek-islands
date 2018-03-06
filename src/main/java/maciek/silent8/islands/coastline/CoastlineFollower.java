package maciek.silent8.islands.coastline;

import static maciek.silent8.islands.coastline.CoastlineFragment.Direction.FORWARD;
import static maciek.silent8.islands.coastline.CoastlineFragment.Direction.TURN_LEFT;
import static maciek.silent8.islands.coastline.CoastlineFragment.Direction.TURN_RIGHT;

import java.util.function.Consumer;

import com.google.common.base.Objects;

import maciek.silent8.islands.Field;
import maciek.silent8.islands.WorldMap;
import maciek.silent8.islands.coastline.CoastlineFragment.Direction;

/**
 * It follows the shore of an island clockwise trying to find extreme fields.
 */
public class CoastlineFollower {

	private final WorldMap map;

	public CoastlineFollower(WorldMap map) {
		this.map = map;
	}

	public CoastlineFragment follow(CoastlineFragment coastline) {
		Direction[] directions = new Direction[] { TURN_LEFT, FORWARD, TURN_RIGHT };
		for (Direction direction : directions) {
			CoastlineFragment next = coastline.next(direction);
			if (next.check(map)) {
				return next;
			}
		}
		throw new RuntimeException("Coastline unexpectedly ends.");
	}

	public void search(CoastlineFragment first, Consumer<Field> search) {
		if (!first.check(map)) {
			throw new IllegalArgumentException("Provided coastline doesn't exist");
		}
		CoastlineFragment next = first;
		do {
			next = follow(next);
			search.accept(next.getLand());
		} while (!Objects.equal(next, first));
	}

}
