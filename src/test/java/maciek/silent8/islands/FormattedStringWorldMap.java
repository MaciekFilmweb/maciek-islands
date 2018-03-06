package maciek.silent8.islands;

import java.util.HashSet;
import java.util.Set;

public class FormattedStringWorldMap implements WorldMap {
	
	private Set<Field> lands = new HashSet<>();
	
	public FormattedStringWorldMap(String formattedString) {
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
