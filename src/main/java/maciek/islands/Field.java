package maciek.islands;

import java.math.BigInteger;
import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

import lombok.Data;

@Data
public class Field {

	private final BigInteger x;

	private final BigInteger y;

	public static Field of(int x, int y) {
		return Field.of(BigInteger.valueOf(x), BigInteger.valueOf(y));
	}

	public static Field of(BigInteger x, BigInteger y) {
		return new Field(x, y);
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

	public List<Field> getNeighbouringFields() {
		Builder<Field> builder = ImmutableList.<Field>builder();

		if (!BigInteger.ZERO.equals(x)) {
			builder
			        .add(up().left())
			        .add(left());
		}
		if (!BigInteger.ZERO.equals(y)) {
			builder
			        .add(down())
			        .add(down().right());
		}
		if (!BigInteger.ZERO.equals(x) && !BigInteger.ZERO.equals(y)) {
			builder
			        .add(down().left());
		}
		return builder
		        .add(up())
		        .add(up().right())
		        .add(right())
		        .build();
	}

}
