package maciek.islands.impl;

public interface CoastlineFieldSearcher {

	/**
	 * Performs analysis of coastline starting from provided {@linkplain CoastlineFragment}.
	 * <p>
	 * The analysis result is {@linkplain CoastlineSearchResult}.
	 * 
	 * @param consumer Chooses specific field from the coastline (e.g. right-bottom) 
	 */
	CoastlineSearchResult search(CoastlineFragment first, CoastlineFieldConsumer consumer);

}
