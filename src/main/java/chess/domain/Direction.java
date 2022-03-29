package chess.domain;

import chess.domain.position.Column;
import chess.domain.position.Rank;
import java.util.Arrays;

public enum Direction {

    EAST(1, 0),
    WEST(-1, 0),
    NORTH(0, 1),
    SOUTH(0, -1),
    NORTH_EAST(1, 1),
    NORTH_WEST(-1, 1),
    SOUTH_EAST(1, -1),
    SOUTH_WEST(-1, -1),
    KNIGHT_EAST_LEFT(2, 1),
    KNIGHT_EAST_RIGHT(2, -1),
    KNIGHT_WEST_LEFT(-2, 1),
    KNIGHT_WEST_RIGHT(-2, -1),
    KNIGHT_NORTH_LEFT(-1, 2),
    KNIGHT_NORTH_RIGHT(1, 2),
    KNIGHT_SOUTH_LEFT(1, -2),
    KNIGHT_SOUTH_RIGHT(-1, -2),
    ;

    private final int columnDistance;
    private final int rankDistance;

    Direction(final int columDistance, final int rankDistance) {
        this.columnDistance = columDistance;
        this.rankDistance = rankDistance;
    }

    public static Direction of(final int columDistance, final int rankDistance) {
        return Arrays.stream(values())
                .filter(value -> isSameDirection(value, columDistance, rankDistance))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 이동할 수 없는 방향입니다."));
    }

    private static boolean isSameDirection(final Direction direction,
                                           final int columDistance,
                                           final int rankDistance) {
        return Math.atan2(direction.rankDistance, direction.columnDistance) == Math.atan2(rankDistance, columDistance);
    }

    public Column moveFile(final Column column) {
        return column.move(columnDistance);
    }

    public Rank moveRank(final Rank rank) {
        return rank.move(rankDistance);
    }
}
