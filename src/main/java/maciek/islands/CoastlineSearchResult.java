package maciek.islands;

import lombok.RequiredArgsConstructor;

/**
 * Indicates if the searched coastline is a coastline of an inside lake or the island's outer coastline. Also provides
 * the coastline searched field (e.g. most bottom-left field).
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
