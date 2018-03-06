package maciek.islands.impl;

import maciek.islands.Field;

/**
 * Sequence of fields used by {@linkplain Jeep} to search for islands.
 */
public interface FieldSearchingSequence {

	Field getFirstField();

	Field getNextField(Field previous);

	Field getFieldEncounteredLater(Field field1, Field field2);

}
