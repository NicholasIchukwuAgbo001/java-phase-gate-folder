package TicTacToeGame;

public class TicTacToe {
    private CurrentState[][] board;

    public TicTacToe() {
        board = new CurrentState[3][3];
        for (int rows = 0; rows < 3; rows++) {
            for (int cols = 0; cols < 3; cols++) {
                board[rows][cols] = CurrentState.EMPTY;
            }
        }
    }

    public void printBoard() {
        for (int rows = 0; rows < 3; rows++) {
            for (int cols = 0; cols < 3; cols++) {
                System.out.print(board[rows][cols] + " ");
            }
            System.out.println();
        }
    }

    public void moves(CurrentState symbols, int position) {

        if(position < 1 || position > 9 ) {
            throw new IllegalArgumentException("\nInvalid position\n");
        }

        int row = (position - 1) / 3;
        int col = (position - 1) % 3;

        if (symbols.equals(CurrentState.X)) {

            if(board[row][col] == CurrentState.EMPTY) {
                board[row][col] = CurrentState.X;
            }

        } else if (symbols.equals(CurrentState.O)) {

            if(board[row][col] == CurrentState.EMPTY) {
                board[row][col] = CurrentState.O;
            }

        }
    }

    public CurrentState[][] getBoard() {
        return board;
    }


    public CurrentState checkWinner() {
        for (int rows = 0; rows < 3; rows++) {
            if (board[rows][0] == board[rows][1] && board[rows][1] == board[rows][2] && board[rows][0] != CurrentState.EMPTY) {
                return board[rows][0];
            }
        }
        for (int cols = 0; cols < 3; cols++) {
            if (board[0][cols] == board[1][cols] && board[1][cols] == board[2][cols] && board[0][cols] != CurrentState.EMPTY) {
                return board[0][cols];
            }
        }
        for (int leftDiagonal = 0; leftDiagonal < 3; leftDiagonal++) {
            if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != CurrentState.EMPTY ) {
                return board[0][0];
            }
        }

        for (int rightDiagonal = 0; rightDiagonal < 3; rightDiagonal++) {
            if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != CurrentState.EMPTY ) {
                return board[0][2];
            }
        }

return CurrentState.EMPTY;

    }

    public CurrentState isFull(){
        if(board.length == 9){
            throw new RuntimeException("Is Full");
        }
        return CurrentState.EMPTY;
    }


}
