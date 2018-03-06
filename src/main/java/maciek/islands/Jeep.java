package maciek.islands;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import lombok.Builder;

/**
 * This is {@linkplain Jeep}.
 * <p>
 * Jeep searches for islands following given {@linkplain FieldSequence}.
 * <p>
 * Jeep remembers single field from each visited island (<b>key field</b>), but only as long as it is possible to
 * encounter the same island again.
 * <p>
 * Jeep remembers number of visited islands.
 * <p>
 * Jeep also remembers current field of its {@linkplain FieldSequence} (<b>progress field</b>).
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
 * To create island <b>key field</b> Jeep requires {@linkplain IslandFieldSearch} which searches for the island's field
 * that is the field which is visit by {@linkplain FieldSequence} last.
 */
@Builder
public class Jeep {

	private final FieldSequence sequence;

	private final IslandFieldSearch islandKeyFieldSearch;

	private final WorldMap map;

	private final Set<Field> islandKeyFields = new HashSet<>();

	private BigInteger islandsCounter;

	private Field currentField;

	public void searchNextField() {
		currentField = getNextField();
		if (!map.isLand(currentField)) {
			return;
		}
		Field keyField = islandKeyFieldSearch.search(currentField);
		if (!islandKeyFields.contains(keyField)) {
			islandKeyFields.add(keyField);
			islandsCounter = islandsCounter.add(BigInteger.ONE);
		}
	}

	private Field getNextField() {
		if (currentField == null) {
			return sequence.getFirstField();
		} else {
			return sequence.getNextField(currentField);
		}
	}

}
