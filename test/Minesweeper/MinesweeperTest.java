package Minesweeper;

import static org.junit.Assert.*;
import org.junit.Test;


public class MinesweeperTest {

	@Test
	public void testEval1() {
		Minesweeper minesweeper = new Minesweeper(16);
		char[][] initialBoard = {{'.','.','.','.'}, {'.','.','.','.'}, {'.','.','.','.'}, {'.','.','.','.'}};
		char[][] finalBoard = {{'1','.','.','.'}, {'.','.','.','.'}, {'.','.','.','.'}, {'.','.','.','.'}};
		boolean[][] mines = new boolean[4][4];
		mines[0][1] = true;
		mines[3][3] = true;
		mines[2][0] = true;
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				assertEquals(finalBoard[i][j], minesweeper.eval(initialBoard, mines, 0, 0)[i][j]);
			}
		}
	}
	
	@Test
	public void testEval2() {
		Minesweeper minesweeper = new Minesweeper(16);
		char[][] initialBoard = {{'.','.','.','.'}, {'.','.','.','.'}, {'.','.','.','.'}, {'.','.','.','.'}};
		char[][] finalBoard = {{'2','.','.','.'}, {'.','.','.','.'}, {'.','.','.','.'}, {'.','.','.','.'}};
		boolean[][] mines = new boolean[4][4];
		mines[0][1] = true;
		mines[1][1] = true;
		mines[3][1] = true;
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				assertEquals(finalBoard[i][j], minesweeper.eval(initialBoard, mines, 0, 0)[i][j]);
			}
		}
	}
	
	@Test
	public void testEval3() {
		Minesweeper minesweeper = new Minesweeper(16);
		char[][] initialBoard = {{'.','.','.','.'}, {'.','.','.','.'}, {'.','.','.','.'}, {'.','.','.','.'}};
		char[][] finalBoard = {{'-','-','1','.'}, {'-','-','1','.'}, {'1','1','3','.'}, {'.','.','.','.'}};
		boolean[][] mines = new boolean[4][4];
		mines[1][3] = true;
		mines[3][1] = true;
		mines[3][3] = true;
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				assertEquals(finalBoard[i][j], minesweeper.eval(initialBoard, mines, 0, 0)[i][j]);
			}
		}
	}
	
	@Test
	public void testEval4() {
		Minesweeper minesweeper = new Minesweeper(16);
		char[][] initialBoard = {{'1','.','.','.'}, {'.','.','.','.'}, {'1','2','.','.'}, {'-','1','.','.'}};
		char[][] finalBoard = {{'1','.','1','-'}, {'.','.','1','-'}, {'1','2','3','2'}, {'-','1','.','.'}};
		boolean[][] mines = new boolean[4][4];
		mines[1][1] = true;
		mines[3][2] = true;
		mines[3][3] = true;
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				assertEquals(finalBoard[i][j], minesweeper.eval(initialBoard, mines, 3, 0)[i][j]);
			}
		}
	}
	
	@Test
	public void testEval5() {
		Minesweeper minesweeper = new Minesweeper(16);
		char[][] initialBoard = {{'1','.','.','.'}, {'.','P','.','.'}, {'.','.','.','.'}, {'.','.','.','P'}};
		char[][] finalBoard = {{'1','.','1','-'}, {'.','P','2','1'}, {'.','.','.','.'}, {'.','.','.','P'}};
		boolean[][] mines = new boolean[4][4];
		mines[1][1] = true;
		mines[2][2] = true;
		mines[3][0] = true;
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				assertEquals(finalBoard[i][j], minesweeper.eval(initialBoard, mines, 3, 0)[i][j]);
			}
		}
	}

}
