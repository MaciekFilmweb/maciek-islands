package maciek.islands.impl;

import maciek.islands.Field;

/**
 * Searches given island for particular field (e.g. bottom-right corner).
 */
public interface IslandFieldSearcher {

	Field search(Field anyIslandField);

}
