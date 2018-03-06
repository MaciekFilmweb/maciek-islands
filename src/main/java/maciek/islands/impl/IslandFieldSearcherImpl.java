package maciek.islands.impl;

import lombok.Builder;
import maciek.islands.Field;
import maciek.islands.OceanMap;
import maciek.islands.impl.CoastlineFragment.Orientation;

/**
 * It starts from any field of given island and searches for the field of the island that would be encountered last by
 * given {@linkplain FieldSearchingSequence}.
 */
@Builder
public class IslandFieldSearcherImpl implements IslandFieldSearcher {

	private final OceanMap map;

	private final CoastlineFieldSearcher coastlineFieldSearch;

	private final FieldSearchingSequence sequence;

	public static IslandFieldSearcherImpl create(OceanMap map, FieldSearchingSequence fieldSequence) {
		return IslandFieldSearcherImpl.builder()
		        .map(map)
		        .coastlineFieldSearch(CoastlineFieldSearcherImpl.create(map))
		        .sequence(fieldSequence)
		        .build();
	}

	@Override
	public Field search(Field anyIslandField) {

		FieldSequenceCoastlineFieldConsumer consumer = new FieldSequenceCoastlineFieldConsumer(sequence);

		Field localBest = findLocalBest(anyIslandField);

		while (true) {
			CoastlineSearchResult result = coastlineFieldSearch
			        .search(CoastlineFragment.of(localBest, Orientation.LAND_ON_LEFT), consumer);

			if (!result.isLake()) {
				return result.getSearchedField();
			}

			localBest = findLocalBest(result.getSearchedField());
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
