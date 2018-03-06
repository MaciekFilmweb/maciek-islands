package maciek.islands.impl;

import com.google.common.base.Objects;

import lombok.RequiredArgsConstructor;
import maciek.islands.OceanMap;

@RequiredArgsConstructor
public class CoastlineFieldSearcherImpl implements CoastlineFieldSearcher {

	private final CoastlineFollower follower;

	public static CoastlineFieldSearcherImpl create(OceanMap map) {
		return new CoastlineFieldSearcherImpl(new CoastlineFollower(map));
	}

	@Override
	public CoastlineSearchResult search(CoastlineFragment first, CoastlineFieldConsumer consumer) {
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
