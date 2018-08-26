package Minesweeper;
/**
 * Main Class
 * @author caladdd
 *
 */
public class Main {

    /**
     * Main class create an object for reading entries, then create an object for the main board
     */
    public static void main(String[] args) {
        boolean isGameOver = false;
        MyScanner scanner = new MyScanner();
        
        // Read initial input
        System.out.println("Enter the dimension of the board and the number of mines");
        int[] initialInput = scanner.initialInput();
        MyBoard board = new MyBoard(initialInput[0], initialInput[1], initialInput[2]);
        
        // Read standard input until you win or lose
        while(!isGameOver) {
            StandardInput in= scanner.standardInput(initialInput[0], initialInput[1]);
            isGameOver = board.minesweeper(in.coordinateX-1, in.coordinateY-1, in.typeOfInput);
        }
    }
}
