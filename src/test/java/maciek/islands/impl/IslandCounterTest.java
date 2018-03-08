package maciek.islands.impl;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import java.security.MessageDigest;

import org.junit.Ignore;
import org.junit.Test;

import maciek.islands.Field;
import maciek.islands.OceanMap;
import maciek.islands.impl.testutils.FormattedStringOceanMap;

public class IslandCounterTest {

	@Test
	public void test1() throws Exception {

		FormattedStringOceanMap map = new FormattedStringOceanMap(
						"______________\n" +
		                "__xxxxxxxxxx__\n" +
		                "__x_xx_____x__\n" +
		                "__x__xx____x__\n" +
		                "_xx________x__\n" +
		                "_x____________\n" +
		                "_x___x_____x__\n" +
		                "_x__x______x__\n" +
		                "_xxx_______x__\n" +
		                "__xxxxxxxxxx__\n" +
		                "______________\n" +
		                "______________\n");

		assertEquals(BigInteger.valueOf(1), new IslandsCounterImpl(Field.of(100, 100)).countIslands(map));
	}

	@Test
	public void test2() throws Exception {

		FormattedStringOceanMap map = new FormattedStringOceanMap(
						"xxxxxxxxxxxxxx\n" +
		                "xxxxxxxxxxxxxx\n" +
		                "xxxxxxxxxxxxxx\n" +
		                "x____________x\n" +
		                "x_xxxxxxxxxx_x\n" +
		                "x_xx______xx_x\n" +
		                "x_xx___x__xx_x\n" +
		                "x_xx______xx_x\n" +
		                "x_xxxxxxxxxx_x\n" +
		                "x____________x\n" +
		                "xxxxxxxxxxxxxx\n" +
		                "xxxxxxxxxxxxxx\n");

		assertEquals(BigInteger.valueOf(3), new IslandsCounterImpl(Field.of(100, 100)).countIslands(map));
	}

	@Test
	public void test3() throws Exception {

		FormattedStringOceanMap map = new FormattedStringOceanMap(
						"_____________x\n" +
		                "__xxxx__xxx_x_\n" +
		                "_xx__xxx__xx__\n" +
		                "______________\n" +
		                "__xxxxxxxxx___\n" +
		                "___xx_____xx__\n" +
		                "___x_x_x___x__\n" +
		                "___x_x___x_x__\n" +
		                "_xxx_xxxxxxx__\n" +
		                "_x____________\n" +
		                "___xxxxxxxxx__\n" +
		                "______________\n");

		assertEquals(BigInteger.valueOf(4), new IslandsCounterImpl(Field.of(100, 100)).countIslands(map));
	}

	@Test
	public void test4() throws Exception {

		FormattedStringOceanMap map = new FormattedStringOceanMap(
		        		"x__x__x__x__xx\n" +
		                "__x__x___x__x_\n" +
		                "_______x______\n" +
		                "__x__x____x___\n" +
		                "_______x______\n" +
		                "__x_x______x__\n" +
		                "___x__x_______\n" +
		                "_________xxx__\n");

		assertEquals(BigInteger.valueOf(14), new IslandsCounterImpl(Field.of(100, 100)).countIslands(map));
	}

	@Ignore
	@Test
	public void loadTest() {
		
		OceanMap map = new OceanMap() {
			
			@Override
			public boolean isLand(Field field) {
				
				byte[] md5;
				try {
					md5 = MessageDigest.getInstance("MD5").digest(("" + field.getX() + field.getY()).getBytes());
					int sum = 0;
					for (byte b : md5) {
						sum += b;
					}
					return sum % 3 == 0;
				} catch (Exception e) {
				}
				return false;
			}
			
		};
		
		assertEquals(BigInteger.valueOf(900149), new IslandsCounterImpl(Field.of(5000, 5000)).countIslands(map));

	}

}
