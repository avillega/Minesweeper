package Minesweeper;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

/**
 * Responsible of board control
 * @author caladdd
 *
 */
public class MyBoard{
    private int height, width, amMine, gFlag, flag, amountAvCell;
    private char [][] board;
    private boolean [][] mine;
    private MyScreen screen;
    private Minesweeper mw;

    /**
     * Assigns necessary values to the variables for board control
     * @param height  board height
     * @param width  board width
     * @param amMine  amount of mines
     */
    public MyBoard(int height, int width, int amMine) {
        this.mine = new boolean[height][width];
        this.board = new char[height][width];
        this.height=height;
        this.width=width;
        this.amMine=amMine;
        this.gFlag=amMine;
        this.flag=gFlag;
        this.amountAvCell = height*width;
        createBoard();
    }
    
    /**
     * Create board and put mines at random on it
     */
    private void createBoard(){
        Random rand = new Random();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                board[i][j] = '.';
            }
        }
        
        Set<Integer> nMine = new LinkedHashSet<Integer>();
        while (nMine.size() < amMine) {
            Integer next = rand.nextInt(height*width); 
            nMine.add(next);
            mine[(int)next/width][next%(width)] = true;
        }
        screen = new MyScreen(board);
        mw = new Minesweeper(amountAvCell);
    }
    
    /**
     * Finished the game if game over
     * @param x  coordinate X
     * @param y  coordinate Y
     * @param type  input type
     * @return  If game over
     */
    public boolean minesweeper(int x, int y, String type) {
        validateFlag(x, y, type);
        if(gFlag != 0) {
            return validateCell(x, y, type);
        }
        else {
            if(gFlag==flag) {
                System.out.println("Ganaste");
                return true;
            }
        }
        return false;
    }
    
    /**
     * Validate if a cell is available to put a flag
     * @param x  coordinate X
     * @param y  coordinate Y
     * @param type  input type
     */
    private void validateFlag(int x, int y, String type) {
        if(type.charAt(0) == 'M' && board[y][x] != 'P') {
            if(board[y][x]!='.') {
                System.out.println("Cell disabled, try again!");
            }
            else {
                flag--;
                board[y][x] = 'P';
                screen.updateScreen(board);
                if(mine[y][x])
                    gFlag--;
            }
        }
        else if (type.charAt(0) == 'M' && board[y][x] == 'P') {
            flag++;
            board[y][x] = '.';
            screen.updateScreen(board);
            if(mine[y][x])
                gFlag++;
        }
    }
    
    /**
     * Validate if a cell is available to be uncovered
     * @param x  coordinate X
     * @param y  coordinate Y
     * @param type  input type
     * @return  If win or lose
     */
    private boolean validateCell(int x, int y, String type) {
        if(type.charAt(0) == 'U' && !mine[y][x]) {
            if(board[y][x]!='.') {
                System.out.println("Cell disabled, try again!");
            }
            else {
                board = mw.eval(board, mine, x, y);
                screen.updateScreen(board);
                amountAvCell = mw.getAmountAvCell();
                if(amountAvCell == amMine) {
                    System.out.println("Ganaste");
                    return true;
                }
            }
        }
        else if (type.charAt(0) == 'U' && mine[y][x]) {
            screen.failedBoard(board, mine);
            System.out.println("Perdiste");
            return true;
        }
        return false;
    }
}

