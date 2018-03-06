package maciek.silent8.islands;

import java.math.BigInteger;

/**
 * <ol>
 * <li>Field to which given island is mapped.
 * <li>The last field of an island to encounter when following {@linkplain SearchPattern}.
 * </ol>
 */
public class IslandKeyField extends Field {

	public IslandKeyField(BigInteger x, BigInteger y) {
		super(x, y);
	}
	
}
