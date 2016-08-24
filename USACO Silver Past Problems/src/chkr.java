import java.io.*;
import java.util.Scanner;

public class chkr {

	static int[][] moves = new int[30 * 30][2];
	static int numOpponentsLeft;
	static boolean isGameFinished = false;
	static int[][] kingPos = new int[30*30][2];
	static int numKings = 0;
	static int numOpponents = 0;
	static int[][] opponentPos = new int[30*30][2];

	public static void main(String[] args) throws FileNotFoundException {

		// File i/o
		Scanner fileReader = new Scanner(new File("chkr.in.txt"));
		PrintStream fileWriter = new PrintStream(new File("chkr.out"));

		// Read in input 
		int n = fileReader.nextInt();
		String temp = "";
		// Stores the board (values won't change)
		char[][] board = new char[n][n];
		// Stores the board (values will change)
		numKings = 0;
		numOpponents = 0;
		for (int i = 0; i < n; i++) {
			temp = fileReader.next();
			for (int j = 0; j < n; j++) {
				board[i][j] = temp.charAt(j);
				if (board[i][j] == 'K') {
					kingPos[numKings][0] = i;
					kingPos[numKings][1] = j;
					numKings++;
				}
				if (board[i][j] == 'o') {
					opponentPos[numOpponents][0] = i;
					opponentPos[numOpponents][1] = j;
					numOpponents++;
				} 
			}
		}
				
		// Loop through each king and check if there's a way to end the game with that king
		for (int m = 0; m < numKings; m++) {
			// If the checkers game is finished, stop looping
			if (isGameFinished) {
				break;
			}
			// Retrieve the king_row and king_col from the array of king positions
			int king_row = kingPos[m][0];
			int king_col = kingPos[m][1];
			int curMoveIndex = 1;
			// Set moves[0][0] and moves[0][1] to the starting position of the king
			moves[0][0] = king_row;
			moves[0][1] = king_col;
			// Call the find winning strategy method
			findWinningStrategy(n, board, numOpponents, king_row, king_col,
					opponentPos, curMoveIndex, fileWriter, numOpponents);
		}
		// If, after calling the method for all kings, the game still isn't finished, output "impossible"
		if (! isGameFinished) {
			fileWriter.println("impossible");
		}
	}

	public static void findWinningStrategy(int n, char[][] boardChanging,
			int numOpponentsLeft, int king_row, int king_col, int[][] opponentPos,
			int currentMoveIndex, PrintStream fileWriter, int numOpponents) {
		// If the number of opponents left is 0, print out the values in the move array and stop looping
		if (numOpponentsLeft == 0) {
			if (! isGameFinished) {
				isGameFinished = true;
				for (int i = 0; i < currentMoveIndex; i++) {
					fileWriter.print((moves[i][0]+1) + " " + (moves[i][1] + 1));
					fileWriter.println();
				}
				System.exit(0);
			}
		} else {
			if (king_row > 1 && king_col > 1) {
				// Move up & left
				if (boardChanging[king_row - 1][king_col - 1] == 'o' && boardChanging[king_row - 2][king_col - 2] == '+') {
					boardChanging[king_row - 1][king_col - 1] = '+';
					boardChanging[king_row - 2][king_col - 2] = 'K';
					boardChanging[king_row][king_col] = '+';
				moves[currentMoveIndex][0] = king_row - 2;
				moves[currentMoveIndex][1] = king_col - 2;
				findWinningStrategy(n, boardChanging, numOpponentsLeft - 1, king_row - 2, king_col - 2,
						opponentPos, currentMoveIndex + 1, fileWriter, numOpponents);
				boardChanging[king_row - 1][king_col - 1] = 'o';
				boardChanging[king_row - 2][king_col - 2] = '+';
				boardChanging[king_row][king_col] = 'K';					
				}
			} 
			if (king_row > 1 && king_col < n - 2 && boardChanging[king_row - 2][king_col + 2] == '+') {
				// Move up and right
				if (boardChanging[king_row - 1][king_col + 1] == 'o') {
					boardChanging[king_row - 1][king_col + 1] = '+';
					boardChanging[king_row - 2][king_col + 2] = 'K';
					boardChanging[king_row][king_col] = '+';
				moves[currentMoveIndex][0] = king_row - 2;
				moves[currentMoveIndex][1] = king_col + 2;
				findWinningStrategy(n, boardChanging, numOpponentsLeft - 1, king_row - 2, king_col + 2,
						opponentPos, currentMoveIndex + 1, fileWriter, numOpponents);
				boardChanging[king_row - 1][king_col + 1] = 'o';
				boardChanging[king_row - 2][king_col + 2] = '+';
				boardChanging[king_row][king_col] = 'K';
				}
			} 
			if (king_row < n - 2 && king_col > 1 && boardChanging[king_row + 2][king_col - 2] == '+') {
				// Move down and left
				if (boardChanging[king_row + 1][king_col - 1] == 'o') {
					boardChanging[king_row + 1][king_col - 1] = '+';
					boardChanging[king_row + 2][king_col - 2] = 'K';
					boardChanging[king_row][king_col] = '+';
				moves[currentMoveIndex][0] = king_row + 2;
				moves[currentMoveIndex][1] = king_col - 2;
				findWinningStrategy(n, boardChanging, numOpponentsLeft - 1, king_row + 2, king_col - 2,
						opponentPos, currentMoveIndex + 1, fileWriter, numOpponents);
				boardChanging[king_row + 1][king_col - 1] = 'o';
				boardChanging[king_row + 2][king_col - 2] = '+';
				boardChanging[king_row][king_col] = 'K';
				}
			} 
			if (king_row < n - 2 && king_col < n - 2 && boardChanging[king_row + 2][king_col + 2] == '+') {
				// Move down and right
				if (boardChanging[king_row + 1][king_col + 1] == 'o') {
					boardChanging[king_row + 1][king_col + 1] = '+';
					boardChanging[king_row + 2][king_col + 2] = 'K';
					boardChanging[king_row][king_col] = '+';
				moves[currentMoveIndex][0] = king_row + 2;
				moves[currentMoveIndex][1] = king_col + 2;
				findWinningStrategy(n, boardChanging, numOpponentsLeft - 1, king_row + 2, king_col + 2,
						opponentPos, currentMoveIndex + 1, fileWriter, numOpponents);
				boardChanging[king_row + 1][king_col + 1] = 'o';
				boardChanging[king_row + 2][king_col + 2] = '+';
				boardChanging[king_row][king_col] = 'K';
				}
			}
		}
	}
}
