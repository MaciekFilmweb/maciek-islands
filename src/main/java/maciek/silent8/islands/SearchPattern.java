package maciek.silent8.islands;

/**
 * Pattern of consecutive fields {@linkplain Jeep} is using to search for islands.
 * <p>
 * It has following characteristics:
 * <ol>
 * <li>It is iterative.
 * <li>It's progress is represented by {@linkplain PatternProgressField}.
 * <li>It's encapsulates strategy for determining {@linkplain IslandKeyField}.
 * </ol>
 * 
 * @see Jeep
 */
public interface SearchPattern {

	PatternProgressField getStartingField();

	PatternProgressField getNextField(PatternProgressField previous);
	
	IslandKeyField getIslandKeyField(Field anyIslandField);

	boolean canIslandBeEncounteredAgain(PatternProgressField progress, IslandKeyField islandsKeyField);

}
