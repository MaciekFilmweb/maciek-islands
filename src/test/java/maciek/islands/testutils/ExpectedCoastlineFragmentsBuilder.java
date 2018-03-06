package maciek.islands.testutils;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

import maciek.islands.CoastlineFragment;
import maciek.islands.CoastlineFragment.Orientation;
import maciek.islands.Field;

public class ExpectedCoastlineFragmentsBuilder {

	private Builder<CoastlineFragment> builder = ImmutableList.<CoastlineFragment>builder();

	public ExpectedCoastlineFragmentsBuilder add(Field field, int convexity, Orientation orientation) {
		builder.add(CoastlineFragment.of(field, orientation, convexity));
		return this;
	}

	public List<CoastlineFragment> build() {
		return builder.build();
	}
}