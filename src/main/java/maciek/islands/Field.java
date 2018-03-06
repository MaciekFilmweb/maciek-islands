package maciek.islands;

import java.math.BigInteger;

import lombok.Data;

@Data
public class Field {

	private final BigInteger x;

	private final BigInteger y;

	public static Field of(int x, int y) {
		return new Field(BigInteger.valueOf(x), BigInteger.valueOf(y));
	}

	public Field up() {
		return new Field(x, y.add(BigInteger.ONE));
	}

	public Field left() {
		return new Field(x.subtract(BigInteger.ONE), y);
	}

	public Field down() {
		return new Field(x, y.subtract(BigInteger.ONE));
	}

	public Field right() {
		return new Field(x.add(BigInteger.ONE), y);
	}

}
