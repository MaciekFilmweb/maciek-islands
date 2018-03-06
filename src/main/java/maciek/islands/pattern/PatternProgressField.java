package maciek.islands.pattern;

import java.math.BigInteger;

import maciek.islands.Field;
import maciek.islands.Jeep;

/**
 * Field that indicates {@linkplain SearchPattern} progress.
 * 
 * @see Jeep
 */
public class PatternProgressField extends Field {

	public PatternProgressField(BigInteger x, BigInteger y) {
		super(x, y);
	}

}
