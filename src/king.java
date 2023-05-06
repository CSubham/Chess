import java.util.ArrayList;

public class king extends piece {

    private boolean hasMoved = false;

    public king(int id) {
        this.id = id;
    }

    public void setHasMoved(boolean val){
        hasMoved = val;
    }

    public boolean getHasMoved(){
        return hasMoved;
    }

    @Override
    public ArrayList<coordinate> calculateMoves(board board) {

        // up
        try {
            if (board.getEntityAtPos(position.getR() - 1, position.getC()) != null) {

                int flagEntID = board.getEntityAtPos(position.getR() - 1, position.getC()).getId() * -1;
                if (flagEntID > 0 && id < 0 || flagEntID < 0 && id > 0) {
                    validMoves.add(new coordinate(position.getR() - 1, position.getC()));
                }

            } else {
                validMoves.add(new coordinate(position.getR() - 1, position.getC()));
            }

        } catch (IndexOutOfBoundsException e) {

        }

        // down
        try {
            if (board.getEntityAtPos(position.getR() + 1, position.getC()) != null) {

                int flagEntID = board.getEntityAtPos(position.getR() + 1, position.getC()).getId() * -1;
                if (flagEntID > 0 && id < 0 || flagEntID < 0 && id > 0) {
                    validMoves.add(new coordinate(position.getR() + 1, position.getC()));
                }

            } else {
                validMoves.add(new coordinate(position.getR() + 1, position.getC()));
            }

        } catch (IndexOutOfBoundsException e) {

        }

        // left
        try {
            if (board.getEntityAtPos(position.getR(), position.getC() - 1) != null) {

                int flagEntID = board.getEntityAtPos(position.getR(), position.getC() - 1).getId() * -1;
                if (flagEntID > 0 && id < 0 || flagEntID < 0 && id > 0) {
                    validMoves.add(new coordinate(position.getR(), position.getC() - 1));
                }

            } else {
                validMoves.add(new coordinate(position.getR(), position.getC() - 1));
            }

        } catch (IndexOutOfBoundsException e) {

        }

        // right
        try {
            if (board.getEntityAtPos(position.getR(), position.getC() + 1) != null) {

                int flagEntID = board.getEntityAtPos(position.getR(), position.getC() + 1).getId() * -1;
                if (flagEntID > 0 && id < 0 || flagEntID < 0 && id > 0) {
                    validMoves.add(new coordinate(position.getR(), position.getC() + 1));
                }

            } else {
                validMoves.add(new coordinate(position.getR(), position.getC() + 1));
            }

        } catch (IndexOutOfBoundsException e) {

        }

        // left vertical up
        try {
            if (board.getEntityAtPos(position.getR() - 1, position.getC() - 1) != null) {

                int flagEntID = board.getEntityAtPos(position.getR() - 1, position.getC() - 1).getId() * -1;
                if (flagEntID > 0 && id < 0 || flagEntID < 0 && id > 0) {
                    validMoves.add(new coordinate(position.getR() - 1, position.getC() - 1));
                }

            } else {
                validMoves.add(new coordinate(position.getR() - 1, position.getC() - 1));
            }

        } catch (IndexOutOfBoundsException e) {
        }
        // left vertical down
        try {
            if (board.getEntityAtPos(position.getR() + 1, position.getC() - 1) != null) {

                int flagEntID = board.getEntityAtPos(position.getR() + 1, position.getC() - 1).getId() * -1;
                if (flagEntID > 0 && id < 0 || flagEntID < 0 && id > 0) {
                    validMoves.add(new coordinate(position.getR() + 1, position.getC() - 1));
                }

            } else {
                validMoves.add(new coordinate(position.getR() + 1, position.getC() - 1));
            }

        } catch (IndexOutOfBoundsException e) {
        }
        // right vertical up
        try {
            if (board.getEntityAtPos(position.getR() - 1, position.getC() + 1) != null) {

                int flagEntID = board.getEntityAtPos(position.getR() - 1, position.getC() + 1).getId() * -1;
                if (flagEntID > 0 && id < 0 || flagEntID < 0 && id > 0) {
                    validMoves.add(new coordinate(position.getR() - 1, position.getC() + 1));
                }

            } else {
                validMoves.add(new coordinate(position.getR() - 1, position.getC() + 1));
            }

        } catch (IndexOutOfBoundsException e) {
        }
        // right vertical down
        try {
            if (board.getEntityAtPos(position.getR() + 1, position.getC() + 1) != null) {

                int flagEntID = board.getEntityAtPos(position.getR() + 1, position.getC() + 1).getId() * -1;
                if (flagEntID > 0 && id < 0 || flagEntID < 0 && id > 0) {
                    validMoves.add(new coordinate(position.getR() + 1, position.getC() + 1));
                }

            } else {
                validMoves.add(new coordinate(position.getR() + 1, position.getC() + 1));
            }
        } catch (IndexOutOfBoundsException e) {
        }

        return validMoves;

    }

}
