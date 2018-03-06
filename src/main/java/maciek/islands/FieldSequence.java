package maciek.islands;

/**
 * Sequence of fields used by {@linkplain Jeep} to search for islands. Each field is visited in specified order and is
 * visited once.
 */
public interface FieldSequence {

	Field getFieldEncounteredLater(Field field1, Field field2);

	Field getFirstField();

	Field getNextField(Field previous);

}
