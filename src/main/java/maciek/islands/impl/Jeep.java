package maciek.islands.impl;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import com.google.common.base.Objects;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import maciek.islands.Field;
import maciek.islands.OceanMap;

/**
 * This is {@linkplain Jeep} (<i>"Rover"</i> would be a better name).
 * <p>
 * Jeep searches for islands following given {@linkplain FieldSearchingSequence}.
 * <p>
 * Jeep remembers single field from each visited island (<b>key field</b>), but only as long as it is possible to
 * encounter the same island again.
 * <p>
 * Jeep remembers number of visited islands.
 * <p>
 * Jeep also remembers current field of its {@linkplain FieldSearchingSequence} (<b>progress field</b>).
 * <p>
 * Here is exact algorithm performed by Jeep:
 * 
 * <pre>
 * 1. Jeep moves to next field of the sequence.
 * 2. If it is ocean go to step 1.
 * 3. If it is island find its key field.
 * 4. If jeep hasn't the island key field saved, saves it and increases the island counter.
 * 5. If it is the island key field removes it from saved island key fields.
 * 6. Go to step 1.
 * </pre>
 * 
 * To create island <b>key field</b> Jeep requires {@linkplain IslandFieldSearcher} which searches for the island's field
 * that is the field which is visited by {@linkplain FieldSearchingSequence} last.
 */
@Slf4j
@Builder
public class Jeep {

	private final FieldSearchingSequence sequence;

	private final IslandFieldSearcher islandKeyFieldSearch;

	private final OceanMap map;

	private final Set<Field> islandKeyFields = new HashSet<>();

	@Getter
	@Builder.Default
	private BigInteger islandsCount = BigInteger.ZERO;

	private Field currentField;

	public void searchNextField() {
		currentField = getNextField();
		if (!map.isLand(currentField)) {
			return;
		}
		Field keyField = islandKeyFieldSearch.search(currentField);
		if (!islandKeyFields.contains(keyField)) {
			islandKeyFields.add(keyField);
			islandsCount = islandsCount.add(BigInteger.ONE);
			logProgress();
		}
		if (Objects.equal(keyField, currentField)) {
			islandKeyFields.remove(keyField);
		}
	}

	public boolean isOnField(Field field) {
		return Objects.equal(currentField, field);
	}

	protected int getSavedIslandKeysCount() {
		return islandKeyFields.size();
	}

	private Field getNextField() {
		if (currentField == null) {
			return sequence.getFirstField();
		} else {
			return sequence.getNextField(currentField);
		}
	}

	private void logProgress() {
		if (islandsCount.mod(BigInteger.valueOf(10000)).equals(BigInteger.ZERO)) {
			log.info("Have found [{}] islands already. Have [{}] fields (island keys) saved. I'm currently on [{}].",
			        islandsCount, getSavedIslandKeysCount(), currentField);
		}
	}

}
