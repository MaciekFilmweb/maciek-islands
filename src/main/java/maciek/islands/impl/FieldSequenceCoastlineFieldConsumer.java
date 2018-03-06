package maciek.islands.impl;

import lombok.RequiredArgsConstructor;
import maciek.islands.Field;

/**
 * {@linkplain CoastlineFieldConsumer} that returns the field that would be encountered last by given
 * {@linkplain FieldSearchingSequence}.
 */
@RequiredArgsConstructor
public class FieldSequenceCoastlineFieldConsumer implements CoastlineFieldConsumer {

	private final FieldSearchingSequence sequence;

	private Field last = null;

	@Override
	public void accept(Field field) {
		if (last == null) {
			last = field;
		} else {
			last = sequence.getFieldEncounteredLater(last, field);
		}
	}

	@Override
	public Field getField() {
		return last;
	}

}