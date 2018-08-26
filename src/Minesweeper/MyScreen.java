package Minesweeper;
/**
 * Responsible of show the board on the screen
 * @author caladdd
 *
 */
public class MyScreen {
    
    /**
     * Responsible of show on the screen the initial board
     * @param board  Current board
     */
    public MyScreen(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                System.out.print(" "+board[i][j]);
            }
            System.out.println("");
        }
    }
    
    /**
     * Responsible of show the current state of the board
     * @param board  Current board
     */
    public void updateScreen(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                System.out.print(" "+board[i][j]);
            }
            System.out.println("");
        }
    }
    
    /**
     * Responsible of show the final board if you lose, with all the mines uncover
     * @param board  Current board
     * @param mines  Mines position
     */
    public void failedBoard(char[][] board, boolean[][] mines) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(mines[i][j])
                    System.out.print(" *");
                else
                    System.out.print(" "+board[i][j]);
            }
            System.out.println("");
        }
    }
    
    
}
