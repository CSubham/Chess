
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class game {
    // change the value to a negative value when white has played,
    // it will also help in avoiding player playing opponents pieces

    int active_player = 0;
    private Scanner scanner = new Scanner(System.in);
    private board board = new board();

    public game() {
    }

    public void initialise() {
        // take the player names or anything you need before
        // starting the game

        board.setPieces();
    }

    public void print() {
        board.print();
    }

    public void takeInput() throws InputMismatchException, NumberFormatException {

        
        // to castle left or right
        // <k or k>

        String[] turn = { "White's turn >>>", "Black's turn >>>" };
        System.out.print(turn[active_player]);
        String input = scanner.nextLine();
        

        try {

            int initial_column = input.charAt(0) - 97;
            int r1 = Integer.parseInt(input.charAt(1) + "");
            int initial_row = (r1 - 8) * -1;

            int final_column = input.charAt(2) - 97;
            int r2 = Integer.parseInt(input.charAt(3) + "");
            int final_row = (r2 - 8) * -1;

            coordinate initial = new coordinate(initial_row, initial_column);
            coordinate eventual = new coordinate(final_row, final_column);

            System.out.println("Initial: " + initial_row + "," + initial_column);
            System.out.println("Final: " + final_row + "," + final_column);

            makeMove(initial, eventual);

        } catch (NumberFormatException e) {
            if(input.charAt(0) == '<' && input.charAt(1)=='k' 
            || input.charAt(1) == '>' && input.charAt(0)=='k' ){

                board.castle(active_player, '<');
            }
           

        }

    }

    private boolean makeMove(coordinate initial_pos, coordinate final_pos) {
        // changes has to be made here when you add castling and en passaunt
        // clean the array

        try {
            piece piece = board.getEntityAtPos(initial_pos.getR(), initial_pos.getC());         
            if(piece.getId()>0 && active_player == 1 || piece.getId()<0 && active_player == 0){
            
                return false;
            }

            board.getEntityAtPos(initial_pos.getR(), initial_pos.getC()).setCoordinate(initial_pos.getR(),
                    initial_pos.getC());
            ArrayList<coordinate> valid_moves = board.getEntityAtPos(initial_pos.getR(), initial_pos.getC())
                    .calculateMoves(board);
                
            // junkie
            System.out.println("Size of validMoves array :" + valid_moves.size());
            for (coordinate coordinate : valid_moves) {
                System.out.println("TBC :" + final_pos.getR() + "," + final_pos.getC());
                System.out.println("  :" + coordinate.getR() + "," + coordinate.getC());

            }

            if (contains(valid_moves, final_pos)) {
                System.out.println("reached");
                board.addEntityAtPos(final_pos.getR(), final_pos.getC(), piece);

                // so the function can keep track of pieces won and calculate the points
                // to be implemented
                board.removeEntityAtPos(initial_pos.getR(), initial_pos.getC());

                board.getEntityAtPos(final_pos.getR(), final_pos.getC()).setCoordinate(final_pos.getR(),
                        final_pos.getC());
                board.getEntityAtPos(final_pos.getR(), final_pos.getC()).clearStash();

                // update active player
                active_player = (active_player == 0) ? 1 : 0;

                return true;
            } else {
                board.getEntityAtPos(initial_pos.getR(), initial_pos.getC()).clearStash();

            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid move made!");

        } catch (NullPointerException e) {
        }
        return false;
    }

    private boolean contains(ArrayList<coordinate> array, coordinate target_pos) {

        for (coordinate c : array) {
            if (c.getR() == target_pos.getR() && c.getC() == target_pos.getC()) {
                System.out.println(
                        "contains(): Returning true for r:" + c.getR() + "" + c.getC() + " " + target_pos.getR() + ""
                                + target_pos.getC());
                return true;
            }
        }
        System.out.println("contains() : no match found");
        return false;

    }

}
