package maciek.islands.coastline;

import java.util.function.Consumer;

import maciek.islands.Field;

public interface CoastlineSearch {

	/**
	 * Performs analysis of coastline starting from provided {@linkplain CoastlineFragment}.
	 * <p>
	 * The analysis result is {@linkplain CoastlineSearchResult}.
	 */
	CoastlineSearchResult search(CoastlineFragment first);

	/**
	 * Chooses the searched field from the coastline all fields (e.g. most bottom-left field).
	 */
	public interface CoastlineFieldConsumer extends Consumer<Field> {

		/**
		 * Get the searched field.
		 */
		Field getField();

	}

}
