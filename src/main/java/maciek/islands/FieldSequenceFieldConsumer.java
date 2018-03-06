package maciek.islands;

import lombok.RequiredArgsConstructor;
import maciek.islands.CoastlineFieldSearch.CoastlineFieldConsumer;

/**
 * {@linkplain CoastlineFieldConsumer} that returns the field that would be encountered last when following given
 * {@linkplain FieldSequence}.
 */
@RequiredArgsConstructor
public class FieldSequenceFieldConsumer implements CoastlineFieldConsumer {

	private final FieldSequence sequence;

	private Field encounteredLastestWhenFollowingSequence = null;

	@Override
	public void accept(Field field) {
		if (encounteredLastestWhenFollowingSequence == null) {
			encounteredLastestWhenFollowingSequence = field;
		} else {
			encounteredLastestWhenFollowingSequence = sequence
			        .getFieldEncounteredLater(encounteredLastestWhenFollowingSequence, field);
		}
	}

	@Override
	public Field getField() {
		return encounteredLastestWhenFollowingSequence;
	}

}