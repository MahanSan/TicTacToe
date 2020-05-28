public class TicTacToeLogic implements TicTacToeBoard {
    private Boolean isPlaceable(int x, int y) {
        try {
            return board[x][y] == null;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Incorrect position passed!!!!");
        }
        return false;
    }

    public boolean placeTheCard(Player player, int x, int y) {
        boolean returnValue = isPlaceable(x, y);
        if (returnValue) {
            board[x][y] = player.getPlayerValue() == 'x';
            player.incrementMovesCount();
        }
        return returnValue;
    }

    private boolean checkIfHorizontal() {
        boolean orSummation;
        boolean andSummation;
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != null && board[i][1] !=null && board[i][2] !=null) {
                orSummation = board[i][0] | board[i][1] | board[i][2] ;
                andSummation = board[i][0] & board[i][1] & board[i][2] ;
                if(orSummation == andSummation)
                    return true;
            }
        }
        return false;
    }

    private boolean checkIfVertical() {
        boolean orSummation;
        boolean andSummation;
        for (int i = 0; i < 3; i++) {
            if (board[0][i] != null && board[1][i] !=null && board[2][i] !=null) {
                orSummation = board[0][i] | board[1][i] | board[2][i] ;
                andSummation = board[0][i] & board[1][i] & board[2][i] ;
                if(orSummation == andSummation)
                    return true;
            }
        }
        return false;
    }

    private boolean checkIfDiagonal() {
        boolean orSummation;
        boolean andSummation;
            if (board[0][0] != null && board[1][1] !=null && board[2][2] !=null) {
                orSummation = board[0][0] | board[1][1] | board[2][2] ;
                andSummation = board[0][0] & board[1][1] & board[2][2] ;
                if(orSummation == andSummation)
                    return true;
            }
            if (board[0][2] != null && board[1][1] !=null && board[2][0] !=null) {
                orSummation = board[0][2] | board[1][1] | board[2][0] ;
                andSummation = board[0][2] & board[1][1] & board[2][0] ;
                return orSummation == andSummation;
            }
        return false;
    }

    public boolean checkIfWin() {
        return (checkIfDiagonal() || checkIfHorizontal() || checkIfVertical());
    }
}
