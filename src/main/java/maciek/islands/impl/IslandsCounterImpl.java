package maciek.islands.impl;

import java.math.BigInteger;

import maciek.islands.Field;
import maciek.islands.IslandsCounter;
import maciek.islands.OceanMap;

public class IslandsCounterImpl implements IslandsCounter {

	private final Field limitField;

	/**
	 * @param limitField the field after encountering which the search stops
	 */
	public IslandsCounterImpl(Field limitField) {
		this.limitField = limitField;
	}

	@Override
	public BigInteger countIslands(OceanMap map) {
		
		FieldSearchingSequence sequence = new BottomRightFieldSearchingSequence();
		
		Jeep jeep = Jeep.builder()
				.map(map)
				.sequence(sequence)
				.islandKeyFieldSearch(IslandFieldSearchImpl.create(map, sequence))
				.build();
		
		while (!jeep.isOnField(limitField)) {
			jeep.searchNextField();
		}
		
		return jeep.getIslandsCount();
	}

}
