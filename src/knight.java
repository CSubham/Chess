import java.util.ArrayList;

public class knight extends piece {

    public knight(int id) {
        this.id = id;
    }

    @Override
    public ArrayList<coordinate> calculateMoves(board board) {

        // top right
        try {

            if (board.getEntityAtPos(position.getR() - 2, position.getC() + 1) != null) {

                int flagEntID = board.getEntityAtPos(position.getR() - 2, position.getC() + 1).getId() ;
                if (flagEntID > 0 && id < 0 || flagEntID < 0 && id > 0) {
                    validMoves.add(new coordinate(position.getR() - 2, position.getC() + 1));
                }

            }

        } catch (IndexOutOfBoundsException e) {

        }

        // top left
        try {

            if (board.getEntityAtPos(position.getR() - 2, position.getC() - 1) != null) {

                int flagEntID = board.getEntityAtPos(position.getR() - 2, position.getC() - 1).getId() ;
                if (flagEntID > 0 && id < 0 || flagEntID < 0 && id > 0) {
                    validMoves.add(new coordinate(position.getR() - 2, position.getC() - 1));
                }

            }

        } catch (IndexOutOfBoundsException e) {

        }

        // bottom right
        try {

            if (board.getEntityAtPos(position.getR() + 2, position.getC() + 1) != null) {

                int flagEntID = board.getEntityAtPos(position.getR() + 2, position.getC() + 1).getId() ;
                if (flagEntID > 0 && id < 0 || flagEntID < 0 && id > 0) {
                    validMoves.add(new coordinate(position.getR() + 2, position.getC() + 1));
                }

            }
        } catch (IndexOutOfBoundsException e) {

        }

        // bottom left
        try {

            if (board.getEntityAtPos(position.getR() + 2, position.getC() - 1) != null) {

                int flagEntID = board.getEntityAtPos(position.getR() + 2, position.getC() - 1).getId() ;
                if (flagEntID > 0 && id < 0 || flagEntID < 0 && id > 0) {
                    validMoves.add(new coordinate(position.getR() + 2, position.getC() - 1));
                }

            } 

        } catch (IndexOutOfBoundsException e) {

        }

        // left up
        try {

            if (board.getEntityAtPos(position.getR() - 1, position.getC() - 2) != null) {

                int flagEntID = board.getEntityAtPos(position.getR() - 1, position.getC() - 2).getId() ;
                if (flagEntID > 0 && id < 0 || flagEntID < 0 && id > 0) {
                    validMoves.add(new coordinate(position.getR() - 1, position.getC() - 2));
                }

            }

        } catch (IndexOutOfBoundsException e) {

        }

        // left down
        try {

            if (board.getEntityAtPos(position.getR() + 1, position.getC() - 2) != null) {

                int flagEntID = board.getEntityAtPos(position.getR() + 1, position.getC() - 2).getId() ;
                if (flagEntID > 0 && id < 0 || flagEntID < 0 && id > 0) {
                    validMoves.add(new coordinate(position.getR() + 1, position.getC() - 2));
                }

            } 

        } catch (IndexOutOfBoundsException e) {

        }

        // right up
        try {

            if (board.getEntityAtPos(position.getR() - 1, position.getC() + 2) != null) {

                int flagEntID = board.getEntityAtPos(position.getR() - 1, position.getC() + 2).getId() ;
                if (flagEntID > 0 && id < 0 || flagEntID < 0 && id > 0) {
                    validMoves.add(new coordinate(position.getR() - 1, position.getC() + 2));
                }

            } 
        } catch (IndexOutOfBoundsException e) {

        }

        // right down
        try {

            if (board.getEntityAtPos(position.getR() + 1, position.getC() + 2) != null) {

                int flagEntID = board.getEntityAtPos(position.getR() + 1, position.getC() + 2).getId() ;
                if (flagEntID > 0 && id < 0 || flagEntID < 0 && id > 0) {
                    validMoves.add(new coordinate(position.getR() + 1, position.getC() + 2));
                }

            }

        } catch (IndexOutOfBoundsException e) {

        }

        return validMoves;
    }
}