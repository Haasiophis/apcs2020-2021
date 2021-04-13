import java.util.Scanner;

public class Board {

	private Square[][] board;
	private int rows = 3;
	private int cols = 3;
	private boolean gameOver;
	// set up a blank 3x3 2d array of squares

	public Board() {
		board = new Square[rows][cols];
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				board[r][c] = new Square("");
			}
		}
	}

	// no need to put mines down since it's tictactoe

	// because i keep getting a nullpointerexception
	// wait it got fixed after adding the 2 for loops to the board class

	// checking for win
	public void checkBoard() {
//check to see if the board is full first
		int emptySquares = 0;
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (board[r][c].getSelected() == false) {
					emptySquares++;
				}
			}
		}
		if (emptySquares == 0) {
			gameOver = true;
			System.out.println("Game over!  Tie!");
		}

		// check all rows across.
		for (int r = 0; r < rows; r++) {
			if (board[r][0].toString() == (board[r][1].toString()) && board[r][1].toString() ==(board[r][2].toString())) {
				gameOver = true;
				
				if (board[r][0].toString() == "[O]" && gameOver == true) {
					System.out.println("Computer wins!");
				} else if (board[r][0].toString() == "[X]" && gameOver == true) {
					System.out.println("Player wins!");
				} else {// in case it's 3 blanks
					gameOver = false;
				}
			}

		}
		// check columns
		for (int c = 0; c < cols; c++) {
			if (board[0][c].toString() == (board[1][c].toString()) && board[1][c].toString() ==(board[2][c].toString())) {
				gameOver = true;
				
				if (board[0][c].toString() == "[O]" && gameOver == true) {
					System.out.println("Computer wins!");
				} else if (board[0][c].toString() == "[X]" && gameOver == true) {
					System.out.println("Player wins!");
				} else {// in case it's 3 blanks
					gameOver = false;
				}
			}

		}
		
		//check diagonally down-left
		if (board[0][0].toString() == (board[1][1].toString()) && board[1][1].toString() ==(board[2][2].toString())) {
			gameOver = true;
			
			if (board[0][0].toString() == "[O]" && gameOver == true) {
				System.out.println("Computer wins!");
			} else if (board[0][0].toString() == "[X]" && gameOver == true) {
				System.out.println("Player wins!");
			} else {// in case it's 3 blanks
				gameOver = false;
			}
		}

		//check diagonally down-right
		if (board[0][2].toString() == (board[1][1].toString()) && board[1][1].toString() ==(board[2][0].toString())) {
			gameOver = true;
			
			if (board[0][2].toString() == "[O]" && gameOver == true) {
				System.out.println("Computer wins!");
			} else if (board[0][2].toString() == "[X]" && gameOver == true) {
				System.out.println("Player wins!");
			} else {// in case it's 3 blanks
				gameOver = false;
			}
		}

	}
		
	public String toString() {
		String output = "";
		for (Square[] row : board) {
			for (Square square : row) {
				output += square.toString();
			}
			output += "\n"; // new line
		}
		return output;
	}

	// spit out the array through println magic
	public static void main(String[] args) {
		Scanner kboard = new Scanner(System.in);
		Board todaysGame = new Board();
		System.out.println(todaysGame);

		while (todaysGame.gameOver == false) {
			// player 1 turn
			todaysGame.checkBoard();
			System.out.println("Choose a square to place X");
			System.out.println("Choose a row (index):");
			int rowNum = kboard.nextInt();
			System.out.println("Choose a column (index): ");
			int colNum = kboard.nextInt();
			if (todaysGame.board[rowNum][colNum].getSelected() == true) {
				while (todaysGame.board[rowNum][colNum].getSelected() == true) {
					System.out.println("Area occupied!  Choose a new square");
					System.out.println("Choose a new square to place X");
					System.out.println("Choose a row (index):");
					rowNum = kboard.nextInt();
					System.out.println("Choose a column (index): ");
					colNum = kboard.nextInt();
					System.out.println(todaysGame);
				}
			}
			todaysGame.board[rowNum][colNum].addX();
			System.out.println(todaysGame);
			todaysGame.checkBoard();

			// print out the new thing

			// computer turn
			System.out.println("Computer turn");
			// random math pick a column, and then a row
			int rowNumBot = (int) (Math.random() * 3);
			int colNumBot = (int) (Math.random() * 3);
			while (todaysGame.board[rowNumBot][colNumBot].getSelected() == true) {
				rowNumBot = (int) (Math.random() * 3);
				colNumBot = (int) (Math.random() * 3);
			}
			todaysGame.board[rowNumBot][colNumBot].addO();
			System.out.println(todaysGame);
			todaysGame.checkBoard();

			// check to see if its already taken

			// if yes, try again. if no, place an O there.

		}
	}
}

// loop until won
// prompt player to choose a square to place X
// check for win (if the numbered squares contain the same value)
