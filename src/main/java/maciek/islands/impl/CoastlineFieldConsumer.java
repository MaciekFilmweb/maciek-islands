package maciek.islands.impl;

import java.util.function.Consumer;

import maciek.islands.Field;

/**
 * Accepts all the coastline fields and chooses one (e.g. most bottom-left field).
 */
public interface CoastlineFieldConsumer extends Consumer<Field> {

	/**
	 * Returns chosen field.
	 */
	Field getField();

}