import java.util.ArrayList;

public class bishop extends piece {

    public bishop(int id) {
        this.id = id;
    }

    @Override
    public ArrayList<coordinate> calculateMoves(board board) {

        leftVerticalUp(board);
        leftVerticalDown(board);
        rightVerticalUp(board);
        rightVerticalDown(board);
        return validMoves;

    }

    // left vertical up
    private void leftVerticalUp(board board) {
        int r = position.getR();
        int c = position.getC();

        while (true) {
            try {
                if (board.getEntityAtPos(r - 1, c - 1) != null) {

                    int flagEntID = board.getEntityAtPos(r - 1, c - 1).getId();
                    if (flagEntID > 0 && id < 0 || flagEntID < 0 && id > 0) {
                        validMoves.add(new coordinate(r - 1, c - 1));
                    }
                    break;

                } else {
                    validMoves.add(new coordinate(r - 1, c - 1));
                    r--;
                    c--;

                }

            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }

    }

    private void leftVerticalDown(board board) {
        int r = position.getR();
        int c = position.getC();

        while (true) {
            try {
                if (board.getEntityAtPos(r + 1, c - 1) != null) {

                    int flagEntID = board.getEntityAtPos(r + 1, c - 1).getId();
                    if (flagEntID > 0 && id < 0 || flagEntID < 0 && id > 0) {
                        validMoves.add(new coordinate(r + 1, c - 1));
                    }
                    break;

                } else {
                    validMoves.add(new coordinate(r + 1, c - 1));
                    r++;
                    c--;
                }

            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }

    }

    private void rightVerticalUp(board board) {
        int r = position.getR();
        int c = position.getC();

        while (true) {
            try {
                if (board.getEntityAtPos(r - 1, c + 1) != null) {

                    int flagEntID = board.getEntityAtPos(r - 1, c + 1).getId();
                    if (flagEntID > 0 && id < 0 || flagEntID < 0 && id > 0) {
                        validMoves.add(new coordinate(r - 1, c + 1));
                    }
                    break;

                } else {
                    validMoves.add(new coordinate(r - 1, c + 1));
                    r--;
                    c++;
                }

            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }

    }

    private void rightVerticalDown(board board) {
        int r = position.getR();
        int c = position.getC();

        while (true) {
            try {
                if (board.getEntityAtPos(r + 1, c + 1) != null) {

                    int flagEntID = board.getEntityAtPos(r + 1, c + 1).getId();
                    if (flagEntID > 0 && id < 0 || flagEntID < 0 && id > 0) {
                        validMoves.add(new coordinate(r + 1, c + 1));
                    }
                    break;

                } else {
                    validMoves.add(new coordinate(r + 1, c + 1));
                    r++;
                    c++;
                }
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }

    }

}
