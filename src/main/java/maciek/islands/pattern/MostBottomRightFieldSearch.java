package maciek.islands.pattern;

import lombok.Builder;
import maciek.islands.Field;
import maciek.islands.WorldMap;
import maciek.islands.coastline.CoastlineFragment;
import maciek.islands.coastline.CoastlineFragment.Orientation;
import maciek.islands.coastline.CoastlineSearch;
import maciek.islands.coastline.CoastlineSearchResult;

@Builder
public class MostBottomRightFieldSearch implements IslandFieldSearch {

	private final WorldMap map;

	private final CoastlineSearch bottomRightCoastlineFieldSearch;

	@Override
	public Field search(Field anyIslandField) {

		Field localBottomRight = findLocalBottomRightField(anyIslandField);
		
		while (true) {
			CoastlineSearchResult result = bottomRightCoastlineFieldSearch
			        .search(CoastlineFragment.of(localBottomRight, Orientation.LAND_ON_LEFT));
			
			if (!result.isLake()) {
				return result.getSearchedField();
			}
			
			localBottomRight = findLocalBottomRightField(result.getSearchedField());
		}
	}

	private Field findLocalBottomRightField(Field field) {
		while (true) {
			if (map.isLand(field.down())) {
				field = field.down();
				continue;
			}
			if (map.isLand(field.right())) {
				field = field.right();
				continue;
			}
			return field;
		}
	}

}
