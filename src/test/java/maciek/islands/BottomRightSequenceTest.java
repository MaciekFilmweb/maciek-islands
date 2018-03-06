package maciek.islands;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BottomRightSequenceTest {
	
	@Test
	public void testComparingFields() throws Exception {
		
		BottomRightSequence sequence = new BottomRightSequence();
		
		assertEquals(Field.of(1, 1), sequence.getFieldEncounteredLater(Field.of(0, 0), Field.of(1, 1)));
		assertEquals(Field.of(2, 0), sequence.getFieldEncounteredLater(Field.of(0, 2), Field.of(2, 0)));
		assertEquals(Field.of(2, 3), sequence.getFieldEncounteredLater(Field.of(1, 2), Field.of(2, 3)));
		assertEquals(Field.of(2, 3), sequence.getFieldEncounteredLater(Field.of(0, 3), Field.of(2, 3)));
		assertEquals(Field.of(4, 2), sequence.getFieldEncounteredLater(Field.of(4, 2), Field.of(4, 3)));
	}
	@Test
	public void testSequenceFields() {
		
		BottomRightSequence sequence = new BottomRightSequence();
		
		assertEquals(Field.of(0, 0), sequence.getFirstField());
		assertEquals(Field.of(0, 1), sequence.getNextField(Field.of(0, 0)));
		assertEquals(Field.of(1, 1), sequence.getNextField(Field.of(0, 1)));
		assertEquals(Field.of(1, 0), sequence.getNextField(Field.of(1, 1)));
		assertEquals(Field.of(0, 2), sequence.getNextField(Field.of(1, 0)));
		assertEquals(Field.of(1, 2), sequence.getNextField(Field.of(0, 2)));
		assertEquals(Field.of(2, 2), sequence.getNextField(Field.of(1, 2)));
		assertEquals(Field.of(2, 1), sequence.getNextField(Field.of(2, 2)));
		assertEquals(Field.of(2, 0), sequence.getNextField(Field.of(2, 1)));
		assertEquals(Field.of(0, 3), sequence.getNextField(Field.of(2, 0)));
		assertEquals(Field.of(3, 2), sequence.getNextField(Field.of(3, 3)));
		assertEquals(Field.of(3, 1), sequence.getNextField(Field.of(3, 2)));

	}

}
