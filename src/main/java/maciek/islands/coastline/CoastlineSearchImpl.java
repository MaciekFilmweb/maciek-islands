package maciek.islands.coastline;

import com.google.common.base.Objects;

import lombok.Builder;
import maciek.islands.Field;

@Builder
public class CoastlineSearchImpl implements CoastlineSearch {

	private final CoastlineFollower follower;

	private final CoastlineFieldConsumer consumer;

	@Override
	public CoastlineSearchResult search(CoastlineFragment first) {
		CoastlineFragment next = first;
		do {
			next = follower.follow(next);
			consumer.accept(next.getLand());
		} while (!Objects.equal(next, first));

		return CoastlineSearchResult.of(consumer.getField(), isLake(next));
	}

	private static boolean isLake(CoastlineFragment lastFragment) {
		if (lastFragment.getConvexity() == 4) {
			return false;
		}
		if (lastFragment.getConvexity() == -4) {
			return true;
		}
		throw new RuntimeException("Bug in convexity calculating logic!");
	}

	public static class MostBottomRightCoastlineFieldConsumer implements CoastlineFieldConsumer {

		private Field mostBottomRightField = null;

		@Override
		public void accept(Field field) {
			if (mostBottomRightField == null) {
				mostBottomRightField = field;
				return;
			}
			if (mostBottomRightField.getX().compareTo(field.getX()) < 0) {
				mostBottomRightField = field;
				return;
			}
			if (mostBottomRightField.getY().compareTo(field.getY()) > 0) {
				mostBottomRightField = field;
				return;
			}
		}

		@Override
		public Field getField() {
			return mostBottomRightField;
		}

	}

}
