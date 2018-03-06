package maciek.islands;

import java.math.BigInteger;

/**
 * <pre>
 * (0, 0), (0, 1), (1, 1), (1, 0), (0, 2), (1, 2), (2, 2), (2, 1), (2, 0), (0, 3), etc.
 * 
 * <pre>
 */
public class BottomRightSequence implements FieldSequence {

	@Override
	public Field getFieldEncounteredLater(Field field1, Field field2) {
		int absComparison = max(field1.getX(), field1.getY()).compareTo(max(field2.getX(), field2.getY()));
		if (absComparison > 0) {
			return field1;
		} else if (absComparison == 0) {
			int yComparison = field1.getY().compareTo(field2.getY());
			if (yComparison < 0) {
				return field1;
			} else if (yComparison == 0) {
				if (field1.getX().compareTo(field2.getX()) > 0) {
					return field1;
				}
			}
		}
		return field2;
	}

	@Override
	public Field getFirstField() {
		return Field.of(0, 0);
	}

	@Override
	public Field getNextField(Field previous) {
		if (previous.getY().equals(BigInteger.ZERO)) {
			return Field.of(BigInteger.ZERO, previous.getX().add(BigInteger.ONE));
		}
		if (previous.getX().compareTo(previous.getY()) >= 0) {
			return previous.down();
		}
		return previous.right();
	}

	private static BigInteger max(BigInteger n1, BigInteger n2) {
		if (n1.compareTo(n2) > 0) {
			return n1;
		}
		return n2;
	}

}
