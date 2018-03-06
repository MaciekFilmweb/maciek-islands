package maciek.islands.impl;

import lombok.RequiredArgsConstructor;
import maciek.islands.Field;

/**
 * Indicates if the searched coastline is a coastline of an inside lake or the island's outer coastline.
 * <p>
 * Also contains field chosen from all the coastline fields by {@linkplain CoastlineFieldConsumer} (e.g. most
 * bottom-left field).
 */
@RequiredArgsConstructor(staticName = "of")
public class CoastlineSearchResult {

	private final Field searchedField;

	private final boolean lake;

	/**
	 * Returns the field that was searched along coastline in this search.
	 */
	public Field getSearchedField() {
		return searchedField;
	}

	/**
	 * Returns {@code true} if the searched coastline turns out to be a coastline of lake inside an island. Returns
	 * {@code false} if coastline is an outer coastline of the island.
	 */
	public boolean isLake() {
		return lake;
	}

}
