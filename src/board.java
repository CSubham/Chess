
public class board {

    private piece board[][] = new piece[8][8];

    public void setPieces() {

        // int[] black_id = {-1,-2,-3,-4,-5,-6};
        // int[] white_id = {1,2,3,4,5,6};

        piece[] black_piece = { new rook(-4), new knight(-3), new bishop(-2), new queen(-5), new king(-6),
                new bishop(-2), new knight(-3), new rook(-4) };
        piece[] white_piece = { new rook(4), new knight(3), new bishop(2), new queen(5), new king(6), new bishop(2),
                new knight(3), new rook(4) };

        for (int i = 0; i < 8; i++) {
            pawn pawn_black = new pawn(-1);
            board[1][i] = pawn_black;
            board[0][i] = black_piece[i];

            pawn pawn_white = new pawn(1);
            board[6][i] = pawn_white;
            board[7][i] = white_piece[i];
        }
        // System.out.println(board);

    }

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
            // System.out.println("");
            // System.out.println(board);

        }
    }

    public void castle(int player, char direction) {
        System.out.println("reached");
        if (player == 1) {
            // 0 is white
            if (direction == '<' && board[0][0] != null && board[0][4] !=null) {
                
                if (board[0][0].getId() == -4 && board[0][4].getId() == -6) {

                    rook rook = (rook)getEntityAtPos(0,0);
                    king king = (king)getEntityAtPos(0,4);
                    if(rook.getHasMoved() == true || king.getHasMoved() == true)return;

                    

                    for (int i = 3; i >= 1; i--) {
                        if (board[0][i] != null) {
                            return;
                        }
                    }
                    //castle
                    board[0][4] = null;
                   // king king = new king(-6);
                    king.setHasMoved(true);
                    board[0][2] = king;


                    board[0][0] = null;
                    //rook rook = new rook(-4);
                    rook.setHasMoved(true);
                    board[0][3]= rook;
                }

            } else if((direction == '>' && board[0][4] != null && board[0][7] !=null)) {

                if (board[0][7].getId() == -4 && board[0][4].getId() == -6) {

                    rook rook = (rook)getEntityAtPos(0,7);
                    king king = (king)getEntityAtPos(0,4);
                    if(rook.getHasMoved() == true || king.getHasMoved() == true)return;

                    

                    for (int i = 5; i <= 6; i++) {
                        if (board[0][i] != null) {
                            return;
                        }
                    }
                    //castle
                    board[0][4] = null;
                   // king king = new king(-6);
                    king.setHasMoved(true);
                    board[0][6] = king;


                    board[0][7] = null;
                    //rook rook = new rook(-4);
                    rook.setHasMoved(true);
                    board[0][5]= rook;
                }



            }

        } else {
            // 1 is black
          
        }

    }
}
