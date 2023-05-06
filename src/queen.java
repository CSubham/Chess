import java.util.ArrayList;

public class queen extends piece{

    public  queen(int id){
        this.id = id;
    }

    @Override
    public ArrayList<coordinate> calculateMoves(board board) {

        bishop bishop = new bishop(0);        
        rook rook = new rook(0);
        king king = new king(0);

        validMoves.addAll(bishop.calculateMoves(board));
        validMoves.addAll(rook.calculateMoves(board));
        validMoves.addAll(king.calculateMoves(board));

        bishop.clearStash();
        rook.clearStash();
        king.clearStash();

        return validMoves;
    }


    
}
