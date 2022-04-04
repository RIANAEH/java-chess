package chess.domain.position;

import chess.domain.Direction;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Position {

    private static final int FILE_INDEX = 0;
    private static final int ROW_INDEX = 1;

    private final Column column;
    private final Row row;

    public Position(final Column column, final Row row) {
        this.column = column;
        this.row = row;
    }

    public static Position create(final String position) {
        final Column column = Column.of(position.substring(FILE_INDEX, ROW_INDEX));
        final Row row = Row.of(position.substring(ROW_INDEX));
        return new Position(column, row);
    }

    public Position move(final Direction direction) {
        return new Position(direction.moveFile(column), direction.moveRow(row));
    }

    public boolean isSameRow(final Row row) {
        return row == this.row;
    }

    public boolean isSameColumn(final Column column) {
        return column == this.column;
    }

    public int calculateColumnDistance(final Position from) {
        return this.column.calculateDistance(from.column);
    }

    public int calculateRowDistance(final Position from) {
        return this.row.calculateDistance(from.row);
    }

    public static List<Position> toPieces() {
        final List<Position> positions = new ArrayList<>();
        for (Row row : Row.values()) {
            for (Column column : Column.values()) {
                positions.add(new Position(column, row));
            }
        }
        return positions;
    }

    public String getName() {
        return column.getName() + row.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return row == position.row && column == position.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
