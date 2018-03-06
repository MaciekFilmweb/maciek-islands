package maciek.islands;

import lombok.Builder;
import maciek.islands.CoastlineFragment.Orientation;

/**
 * It starts from any field of given island and searches for the field of the island that would be encountered last if
 * following given {@linkplain FieldSequence}.
 * <p>
 * It requires {@linkplain CoastlineFieldSearch} that can find coastline field that would be encountered latest.
 */
@Builder
public class IslandFieldSearchImpl implements IslandFieldSearch {

	private final WorldMap map;

	private final CoastlineFieldSearch coastlineFieldSearch;

	private final FieldSequence sequence;

	public static IslandFieldSearchImpl create(WorldMap map, FieldSequence fieldSequence) {
		return IslandFieldSearchImpl.builder()
		        .map(map)
		        .coastlineFieldSearch(CoastlineFieldSearchImpl.builder()
		                .consumer(new FieldSequenceFieldConsumer(fieldSequence))
		                .follower(new CoastlineFollower(map))
		                .build())
		        .sequence(fieldSequence)
		        .build();
	}

	@Override
	public Field search(Field anyIslandField) {

		Field localBottomRight = findLocalBest(anyIslandField);

		while (true) {
			CoastlineSearchResult result = coastlineFieldSearch
			        .search(CoastlineFragment.of(localBottomRight, Orientation.LAND_ON_LEFT));

			if (!result.isLake()) {
				return result.getSearchedField();
			}

			localBottomRight = findLocalBest(result.getSearchedField());
		}
	}

	private Field findLocalBest(Field field) {
		Field previous = field;
		while (true) {
			Field next = getNextField(previous);
			if (next == null) {
				return previous;
			}
			previous = next;
		}
	}

	private Field getNextField(Field field) {
		for (Field neighbouringField : field.getNeighbouringFields()) {
			if (map.isLand(neighbouringField)
			        && sequence.getFieldEncounteredLater(field, neighbouringField).equals(neighbouringField)) {
				return neighbouringField;
			}
		}
		return null;
	}

}
