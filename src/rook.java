import java.util.ArrayList;

public class rook extends piece {

    public rook(int id) {
        this.id = id;
    }

    private boolean hasMoved = false;


    public void setHasMoved(boolean val){
        hasMoved = val;
    }

    public boolean getHasMoved(){
        return hasMoved;
    }


    @Override
    public ArrayList<coordinate> calculateMoves(board board) {

        up(board);
        down(board);
        left(board);
        right(board);

        return validMoves;

    }

    private void up(board board) {
        int r = position.getR();
        int c = position.getC();

        while (true) {
            try {
                if (board.getEntityAtPos(r - 1, c) != null) {

                    int flagEntID = board.getEntityAtPos(r - 1, c).getId() ;
                    if (flagEntID > 0 && id < 0 || flagEntID < 0 && id > 0) {
                        validMoves.add(new coordinate(r - 1, c));
                        
                    }
                    break;
                } else {
                    validMoves.add(new coordinate(r - 1, c));
                    r--;
                }

            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }

    }

    private void down(board board) {

        int r = position.getR();
        int c = position.getC();

        while (true) {
            try {
                if (board.getEntityAtPos(r + 1, c) != null) {

                    int flagEntID = board.getEntityAtPos(r + 1, c).getId() ;
                    if (flagEntID > 0 && id < 0 || flagEntID < 0 && id > 0) {
                        validMoves.add(new coordinate(r + 1, c));
                    }
                    break;
                } else {
                    validMoves.add(new coordinate(r + 1, c));
                    r++;
                }

            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }

    }

    private void left(board board) {

        int r = position.getR();
        int c = position.getC();

        while (true) {
            try {
                if (board.getEntityAtPos(r, c - 1) != null) {

                    int flagEntID = board.getEntityAtPos(r, c - 1).getId() ;
                    if (flagEntID > 0 && id < 0 || flagEntID < 0 && id > 0) {
                        validMoves.add(new coordinate(r, c - 1));
                    }
                    break;
                } else {
                    validMoves.add(new coordinate(r, c - 1));
                    c--;
                }

            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }

    }

    private void right(board board) {
        int r = position.getR();
        int c = position.getC();

        while (true) {
            try {
                if (board.getEntityAtPos(r, c + 1) != null) {

                    int flagEntID = board.getEntityAtPos(r, c + 1).getId() ;
                    if (flagEntID > 0 && id < 0 || flagEntID < 0 && id > 0) {
                        validMoves.add(new coordinate(r, c + 1));
                    }
                    break;

                } else {
                    validMoves.add(new coordinate(r, c + 1));
                    c++;
                }

            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }
    }

}
