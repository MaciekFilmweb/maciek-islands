package maciek.islands;

import com.google.common.base.Objects;

import lombok.Builder;

@Builder
public class CoastlineFieldSearchImpl implements CoastlineFieldSearch {

	private final CoastlineFollower follower;

	private final CoastlineFieldConsumer consumer;

	public static CoastlineFieldSearchImpl create(WorldMap map, FieldSequence sequence) {
		return CoastlineFieldSearchImpl.builder()
		        .follower(new CoastlineFollower(map))
		        .consumer(new FieldSequenceFieldConsumer(sequence))
		        .build();
	}

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

}
