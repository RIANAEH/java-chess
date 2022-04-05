package chess.domain.game.state;

import chess.domain.board.Board;
import chess.domain.piece.Color;
import chess.domain.position.Position;

public interface State {

    State start();

    State end();

    State move(final Board board, final Position from, final Position to);

    State status();

    boolean isNotEnded();

    boolean isStarted();

    Color getTurn();
}
