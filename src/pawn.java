 import java.util.ArrayList;

public class pawn extends piece {

    private boolean hasMoved = false;
    private int flag = 0;

    public pawn(int id) {
        this.id = id;
    }

    @Override
    public void setCoordinate(int r, int c) {
        if (flag >= 2) {
            hasMoved = true;
        }

        position.setR(r);
        position.setC(c);
        flag++;

    }

    @Override
    public ArrayList<coordinate> calculateMoves(board board) {

        // up
        if (id > 0) {
            try {
                if (board.getEntityAtPos(position.getR() - 1, position.getC()) == null) {
                    validMoves.add(new coordinate(position.getR() - 1, position.getC()));
                    if (!hasMoved) {
                        if (board.getEntityAtPos(position.getR() - 2, position.getC()) == null) {
                            validMoves.add(new coordinate(position.getR() - 2, position.getC()));
                        }
                    }
                }
            } catch (IndexOutOfBoundsException e) {
            }

            // left vertical up
            try {
                // System.out.println("vertical up");
                if (board.getEntityAtPos(position.getR() - 1, position.getC() - 1) != null) {
                    // System.out.println("vertical up if passed");
                    int flagEntID = board.getEntityAtPos(position.getR() - 1, position.getC() - 1).getId();
                    // System.out.println(flagEntID);

                    if (flagEntID > 0 && id < 0 || flagEntID < 0 && id > 0) {

                        // System.out.println("pawn move added ");
                        validMoves.add(new coordinate(position.getR() - 1, position.getC() - 1));
                    }

                }
            } catch (IndexOutOfBoundsException e) {
            }

            // right vertical up
            try {
                if (board.getEntityAtPos(position.getR() - 1, position.getC() + 1) != null) {
                    int flagEntID = board.getEntityAtPos(position.getR() - 1, position.getC() + 1).getId();

                    if (flagEntID > 0 && id < 0 || flagEntID < 0 && id > 0) {
                        System.out.println("pawn move added ");
                        validMoves.add(new coordinate(position.getR() - 1, position.getC() + 1));
                    }

                }
            } catch (IndexOutOfBoundsException e) {
            }
        }else{
            //down
            try {
                if (board.getEntityAtPos(position.getR() + 1, position.getC()) == null) {
                    validMoves.add(new coordinate(position.getR() + 1, position.getC()));
                    if (!hasMoved) {
                        if (board.getEntityAtPos(position.getR() + 2, position.getC()) == null) {
                            validMoves.add(new coordinate(position.getR() + 2, position.getC()));
                        }
                    }
                }
            } catch (IndexOutOfBoundsException e) {
            }

            // left vertical down
            try {
                // System.out.println("vertical up");
                if (board.getEntityAtPos(position.getR() + 1, position.getC() - 1) != null) {
                    // System.out.println("vertical up if passed");
                    int flagEntID = board.getEntityAtPos(position.getR() + 1, position.getC() - 1).getId();
                    // System.out.println(flagEntID);

                    if (flagEntID > 0 && id < 0 || flagEntID < 0 && id > 0) {

                        // System.out.println("pawn move added ");
                        validMoves.add(new coordinate(position.getR() + 1, position.getC() - 1));
                    }

                }
            } catch (IndexOutOfBoundsException e) {
            }

            // right vertical down
            try {
                if (board.getEntityAtPos(position.getR() + 1, position.getC() + 1) != null) {
                    int flagEntID = board.getEntityAtPos(position.getR() + 1, position.getC() + 1).getId();

                    if (flagEntID > 0 && id < 0 || flagEntID < 0 && id > 0) {
                        System.out.println("pawn move added ");
                        validMoves.add(new coordinate(position.getR() + 1, position.getC() + 1));
                    }

                }
            } catch (IndexOutOfBoundsException e) {
            }

        }

        return validMoves;

    }

}
