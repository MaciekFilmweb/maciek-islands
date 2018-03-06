package maciek.silent8.islands;

import java.math.BigInteger;
import java.util.Set;

/**
 * This is Jeep.
 * <p>
 * Jeep searches for islands following given pattern.
 * <p>
 * Jeep remembers single field from each visited island ({@linkplain IslandKeyField}), but only as long as it is
 * possible to encounter the same island again.
 * <p>
 * Jeep also remembers number of visited islands and the field that represents its own progress
 * ({@linkplain PatternProgressField}}).
 * <p>
 * Here is exact algorithm performing by Jeep:
 * 
 * <pre>
 * 1. Jeep moves to next field according to the pattern.
 * 2. If it is ocean go to step 1.
 * 3. If it is island find its key field.
 * 4. If jeep hasn't the island key field saved, saves it and increases the island counter.
 * 5. If it is the island key field removes it from saved fields.
 * 6. Go to step 1.
 * </pre>
 */
public class Jeep {
	
	private final SearchPattern pattern;
	
	private PatternProgressField progressField;
	
	private Set<IslandKeyField> islandsThatCanBeEncounteredAgain;
	
	private BigInteger islandsCounter;
	
	public Jeep(SearchPattern pattern) {
		this.pattern = pattern;
		this.progressField = pattern.getStartingField();
	}
	
	public void searchNextField() {

	}
	
	
}
