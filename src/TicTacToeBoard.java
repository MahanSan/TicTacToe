import java.util.stream.Stream;

public interface TicTacToeBoard {
    Boolean[][] board = new Boolean[3][3];

    default void display() {
        Stream.of(board).forEach(s -> {
            Stream.of(s).forEach(r -> System.out.print((r==null ? "-" : r ?'x': '0') + " | "));
            System.out.println("\n"+"__|___|___|");
        });
    }
}