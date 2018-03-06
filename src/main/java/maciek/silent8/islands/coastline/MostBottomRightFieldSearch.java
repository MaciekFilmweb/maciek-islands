package maciek.silent8.islands.coastline;

import java.util.function.Consumer;

import maciek.silent8.islands.Field;

public class MostBottomRightFieldSearch implements Consumer<Field> {

	private Field mostBottomRightField = null;

	@Override
	public void accept(Field field) {
		if (mostBottomRightField == null) {
			mostBottomRightField = field;
			return;
		}
		if (mostBottomRightField.getX().compareTo(field.getX()) < 0) {
			mostBottomRightField = field;
			return;
		}
		if (mostBottomRightField.getY().compareTo(field.getY()) > 0) {
			mostBottomRightField = field;
			return;
		}
	}

	public Field getMostBottomRightField() {
		return mostBottomRightField;
	}

}
