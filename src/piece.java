import java.util.ArrayList;

public abstract class piece {

    protected int id;

    protected coordinate position = new coordinate();
    
    protected ArrayList<coordinate> validMoves = new ArrayList<>();

    public abstract ArrayList<coordinate> calculateMoves(board board);

    public  int getId(){
        return id;
    }

    public void clearStash(){
        validMoves.clear();

    }

    public coordinate getCoordinate() {
        return position;
    }

    public void setCoordinate(int r , int c ){
        position.setR(r);
        position.setC(c);
    }

    

    
}
