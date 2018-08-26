package Minesweeper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MinesweeperTest {

	/**
	 * Test method for {@link Minesweeper.Minesweeper#eval(char[][], boolean[][], int, int)}.
	 */
	@Test
	void testEval1() {
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
	void testEval2() {
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
	void testEval3() {
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
	void testEval4() {
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

}
