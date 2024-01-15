
public class board {

    private piece board[][] = new piece[8][8];

   

    public piece getEntityAtPos(int r, int c) throws IndexOutOfBoundsException {
        return board[r][c];
    }

    public void addEntityAtPos(int r, int c, piece piece) throws IndexOutOfBoundsException {

        board[r][c] = piece;
    }

    public void removeEntityAtPos(int r, int c) throws IndexOutOfBoundsException {
        board[r][c] = null;
    }

    public void print() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    System.out.print("  _");
                    continue;

                }
                if (board[i][j].id < 0) {
                    System.out.print(" " + board[i][j].id);
                    continue;
                } else {
                    System.out.print("  " + board[i][j].id);
                }
            }
            System.out.println();
           

        }
    }


   
}
