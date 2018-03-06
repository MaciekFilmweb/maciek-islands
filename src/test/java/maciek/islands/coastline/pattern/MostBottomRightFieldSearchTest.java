package maciek.islands.coastline.pattern;

import static org.junit.Assert.*;

import org.junit.Test;

import maciek.islands.Field;
import maciek.islands.coastline.CoastlineFollower;
import maciek.islands.coastline.CoastlineSearchImpl;
import maciek.islands.coastline.CoastlineSearchImpl.MostBottomRightCoastlineFieldConsumer;
import maciek.islands.pattern.MostBottomRightFieldSearch;
import maciek.islands.testutils.FormattedStringWorldMap;

public class MostBottomRightFieldSearchTest {
	
	@Test
	public void test1() throws Exception {
		
		FormattedStringWorldMap map = new FormattedStringWorldMap(
        		"______________\n" +
                "__xxxx__xxx___\n" +
                "_xx__xxx__x___\n" +
                "__x____xx_x___\n" +
                "__xx__x_x_x___\n" +
                "___xxx__x_xx__\n" +
                "___x_x_x___x__\n" +
                "___x_xxxxx_x__\n" +
                "___x_xxxxxxx__\n" +
                "___x__________\n" +
                "___xxxxxxxxx__\n" +
                "______________\n");
		
		MostBottomRightFieldSearch search = MostBottomRightFieldSearch.builder()
			.map(map)
			.bottomRightCoastlineFieldSearch(CoastlineSearchImpl.builder()
					.consumer(new MostBottomRightCoastlineFieldConsumer())
					.follower(new CoastlineFollower(map))
					.build())
			.build();
		
		assertEquals(Field.of(11, 1), search.search(Field.of(3, 10)));
	}
	
	@Test
	public void test2() throws Exception {
		
		FormattedStringWorldMap map = new FormattedStringWorldMap(
        		"______________\n" +
                "______________\n" +
                "__xxxxxxxxxx__\n" +
                "__x_x_x_x_x___\n" +
                "__xxxxxxx_xx__\n" +
                "____x__x___x__\n" +
                "xxx______x_x__\n" +
                "x_xxxxxxx_x___\n" +
                "x____x____x___\n" +
                "x____x____xx__\n" +
                "x____x________\n" +
                "xxxxxxxxxxxx_x\n");
		
		MostBottomRightFieldSearch search = MostBottomRightFieldSearch.builder()
			.map(map)
			.bottomRightCoastlineFieldSearch(CoastlineSearchImpl.builder()
					.consumer(new MostBottomRightCoastlineFieldConsumer())
					.follower(new CoastlineFollower(map))
					.build())
			.build();
		
		assertEquals(Field.of(11, 0), search.search(Field.of(6, 8)));
	}

}
