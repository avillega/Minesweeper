package Minesweeper;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Execute the algorithm for Minesweeper
 * @author caladdd
 *
 */
public class Minesweeper {
    private int amountAvCell;
    
    /**
     * Assign value of amount available cells
     * @param amountCell
     */
    public Minesweeper(int amountCell) {
        this.amountAvCell= amountCell;
    }
    
    /**
     * Get amount available cells
     * @return  amount available cells
     */
    public int getAmountAvCell() {
        return amountAvCell;
    }
    
    /**
     * Check if the cell is available to be uncovered
     * @param board  Current board
     * @param mine  Mines position
     * @param x  Coordinate X
     * @param y  Coordinate Y
     * @return  Updated board
     */
    public char[][] eval(char[][] board, boolean[][] mine, int x, int y){
        if (board[y][x] != '.') {
            return board;
        }
        else {
            board = checkMines(board, mine, x, y);
        }
        return  board;
    }
    
    /**
     * Auxiliary method
     * @param board  Current board
     * @param mines  Mines position
     * @param x  Coordinate X
     * @param y  Coordinate Y
     * @return  Updated board
     */
    private char [][] checkMines(char[][] board, boolean[][]mines, int x, int y) {
        int maxX = board[0].length, maxY = board.length;
        checkNeighbors(board, mines, maxX, maxY, x, y);
        
        return board;
    
    }
    
    /**
     * Check if the cell has nearby mines
     * @param board  Current board
     * @param mines  Mines position
     * @param sizex  width board
     * @param sizey  height board
     * @param x  Coordinate X
     * @param y  Coordinate Y
     */
    private void checkNeighbors(char[][] board, boolean[][]mines, int sizex, int sizey, int x, int y) {
        boolean[][] visited = new boolean[sizey][sizex];
        LinkedList<MyIntPair> queue = new LinkedList<MyIntPair>();
        MyIntPair tempPair = new MyIntPair(x, y);
        queue.push(tempPair);
        
        //BFS
        while (queue.size() != 0)
        {
            // Count mines neighboring
            tempPair = queue.pop();
            Iterator<MyIntPair> i = getNeighbors(sizex, sizey, tempPair.x, tempPair.y).iterator();
            int cont = 0;
            while (i.hasNext()){
                MyIntPair nePair = i.next();
                if(mines[nePair.y][nePair.x])
                    cont++;
            }
            i = getNeighbors(sizex, sizey, tempPair.x, tempPair.y).iterator();
            // if mines equal to zero execute the algorithm, else set that cell with the number of neighboring mines
            if(cont == 0) {
                while (i.hasNext()){
                    MyIntPair nePair = i.next();
                    if (!visited[nePair.y][nePair.x])
                    {
                        if(board[nePair.y][nePair.x] == '.' || board[nePair.y][nePair.x] == 'P'){
                            visited[nePair.y][nePair.x] = true;
                            queue.push(nePair);
                        }
                    }
                }
                if(board[tempPair.y][tempPair.x] != 'P') {
                    board[tempPair.y][tempPair.x] = '-';
                    this.amountAvCell--;
                }
            }
            else {
                if(board[tempPair.y][tempPair.x] != 'P') {
                    board[tempPair.y][tempPair.x] = (char)(cont+'0');
                    this.amountAvCell--;
                }
            }
                
        }
    }
    
    /**
     * Save neighboring coordinates
     * @param sizex  width board
     * @param sizey  height board
     * @param x  Coordinate X
     * @param y  Coordinate Y
     * @return  List of neighboring coordinates
     */
    private LinkedList<MyIntPair> getNeighbors(int sizeX, int sizeY, int x, int y){
        LinkedList<MyIntPair> neighbour = new LinkedList<MyIntPair>();
        MyIntPair intPair;
        intPair = new MyIntPair(0,0);
        if(x-1 >= 0) {
            if(y-1 >= 0) {
                intPair = new MyIntPair(x-1,y-1);
                neighbour.add(intPair);
            }
            if(y+1 < sizeY) {
                intPair = new MyIntPair(x-1,y+1);
                neighbour.add(intPair);
            }
            intPair = new MyIntPair(x-1,y);
            neighbour.add(intPair);
            
        }
        if(x+1 < sizeX) {
            if(y-1 >= 0) {
                intPair = new MyIntPair(x+1,y-1);
                neighbour.add(intPair);
            }
            if(y+1 < sizeY) {
                intPair = new MyIntPair(x+1,y+1);
                neighbour.add(intPair);
            }
            intPair = new MyIntPair(x+1,y);
            neighbour.add(intPair);
        }
        if(y-1 >= 0) {
            intPair = new MyIntPair(x,y-1);
            neighbour.add(intPair);
        }
        if(y+1 < sizeY) {
            intPair = new MyIntPair(x,y+1);
            neighbour.add(intPair);
        }
        
        return neighbour;
    }

}
