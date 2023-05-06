public class app{

    public static void main(String[] args) {
        
        game game = new game();
        game.initialise();

        while(true){
            game.print();
            game.takeInput();
        }
        




    }

}