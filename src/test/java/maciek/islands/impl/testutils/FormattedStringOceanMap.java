package maciek.islands.impl.testutils;

import java.util.HashSet;
import java.util.Set;

import maciek.islands.Field;
import maciek.islands.OceanMap;

public class FormattedStringOceanMap implements OceanMap {
	
	private Set<Field> lands = new HashSet<>();
	
	public FormattedStringOceanMap(String formattedString) {
		int y = formattedString.split("\n").length - 1;
		int x = 0;
		for (char ch : formattedString.toCharArray()) {
			if (ch == 'x') {
				lands.add(Field.of(x, y));
			}
			if (ch == '\n') {
				--y;
				x = 0;
			} else {
				++x;
			}
		}
	}

	@Override
	public boolean isLand(Field field) {
		return lands.contains(field);
	}

}
