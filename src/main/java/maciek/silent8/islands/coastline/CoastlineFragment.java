package maciek.silent8.islands.coastline;

import static maciek.silent8.islands.coastline.CoastlineFragment.Direction.*;
import static maciek.silent8.islands.coastline.CoastlineFragment.Orientation.*;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import maciek.silent8.islands.Field;
import maciek.silent8.islands.WorldMap;

@Data
@RequiredArgsConstructor(staticName="of")
public class CoastlineFragment {
	
	private final Field land;
	
	private final Orientation orientation;
	
	public CoastlineFragment next(Direction direction) {
		
		if (orientation == LAND_ON_TOP && direction == FORWARD) {
			return new CoastlineFragment(land.left(), LAND_ON_TOP);
		}
		if (orientation == LAND_ON_TOP && direction == TURN_LEFT) {
			return new CoastlineFragment(land.down().left(), LAND_ON_LEFT);
		}
		if (orientation == LAND_ON_TOP && direction == TURN_RIGHT) {
			return new CoastlineFragment(land, LAND_ON_RIGHT);
		}
		
		if (orientation == LAND_ON_RIGHT && direction == FORWARD) {
			return new CoastlineFragment(land.up() , LAND_ON_RIGHT);
		}
		if (orientation == LAND_ON_RIGHT && direction == TURN_LEFT) {
			return new CoastlineFragment(land.up().left(), LAND_ON_TOP);
		}
		if (orientation == LAND_ON_RIGHT && direction == TURN_RIGHT) {
			return new CoastlineFragment(land, LAND_ON_BOTTOM);
		}
		
		if (orientation == LAND_ON_BOTTOM && direction == FORWARD) {
			return new CoastlineFragment(land.right() , LAND_ON_BOTTOM);
		}
		if (orientation == LAND_ON_BOTTOM && direction == TURN_LEFT) {
			return new CoastlineFragment(land.up().right(), LAND_ON_RIGHT);
		}
		if (orientation == LAND_ON_BOTTOM && direction == TURN_RIGHT) {
			return new CoastlineFragment(land, LAND_ON_LEFT);
		}
		
		if (orientation == LAND_ON_LEFT && direction == FORWARD) {
			return new CoastlineFragment(land.down() , LAND_ON_LEFT);
		}
		if (orientation == LAND_ON_LEFT && direction == TURN_LEFT) {
			return new CoastlineFragment(land.down().right(), LAND_ON_BOTTOM);
		}
		if (orientation == LAND_ON_LEFT && direction == TURN_RIGHT) {
			return new CoastlineFragment(land, LAND_ON_TOP);
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
		LAND_ON_TOP,
		LAND_ON_RIGHT,
		LAND_ON_BOTTOM,
		LAND_ON_LEFT;
	}
	
	public enum Direction {
		FORWARD,
		TURN_LEFT,
		TURN_RIGHT;
	}
	
}
