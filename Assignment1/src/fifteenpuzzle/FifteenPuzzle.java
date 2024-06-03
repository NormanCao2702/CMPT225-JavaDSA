package fifteenpuzzle;

import java.io.*;
import java.util.*;

public class FifteenPuzzle {
	public final static int UP = 0;
	public final static int DOWN = 1;
	public final static int LEFT = 2;
	public final static int RIGHT = 3;

	// size of board
	public final static int SIZE = 4;

	private int[][] board;

	/**
	 Bad board:
	 Duplicate number
	 Number larger than 15
	 **/
	private void checkBoard() throws BadBoardException{
		Set<Integer> seenValues = new HashSet<>();
		for(int row = 0; row < SIZE; row++){
			for(int col = 0; col < SIZE; col++){
				int value = this.board[row][col];
				if(value < 0 || value > 15) throw new BadBoardException("Value out of range: " + value);
				if (!seenValues.add(value)) throw new BadBoardException("Duplicate value found: " + value);
			}
		}
	}
	/**
	 * @param fileName 
	 * @throws FileNotFoundException if file not found
	 * @throws BadBoardException if the board is incorrectly formatted
	 * Reads a board from file and creates the board
	 */
	public FifteenPuzzle(String fileName) throws IOException, BadBoardException {
		// TODO implement me
		board = new int[SIZE][SIZE];
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			for(int row = 0; row < SIZE; row++){
				String line = br.readLine();
				if(line.length() != 11) throw new BadBoardException("Incorrect Line length in row"+ row);
				for (int col = 0; col < SIZE; col++){
					String part = line.substring(col * 3, col*3+2).trim();
					if(part.isEmpty()) board[row][col] = 0;
					else{
						try{
							board[row][col] = Integer.parseInt(part);
						} catch (NumberFormatException e){
							throw new BadBoardException("Invalid number format in tile [" + row + "]" + "[" + col + "]");
						}
					}
				}
			}
		}catch (FileNotFoundException e) {
			throw e;
		}
		catch (IOException e){
			throw new IOException("Error reading file: " + fileName, e);
		}
		checkBoard();
	}

	/**
	 * Get the number of the tile, and moves it to the specified direction
	 * 
	 * @throws IllegalMoveException if the move is illegal
	 */
	public void makeMove(int tile, int direction) throws IllegalMoveException {
		// TODO implement me
	}

	
	/**
	 * @return true if and only if the board is solved,
	 * i.e., the board has all tiles in their correct positions
	 */
	public boolean isSolved() {
		// TODO implement me
		return false;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		// TODO implement me
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (board[i][j] == 0) {
					sb.append("  "); // Two spaces for empty tile
				} else {
					sb.append(String.format("%2d", board[i][j]));// Format number with two spaces, if 1 digit add a space, 2 digit display as they are
				}
				if (j < SIZE - 1) {
					sb.append(" "); // Add space between numbers
				}
			}
			sb.append("\n"); // Add newline after each row
		}
		return sb.toString();
	}
}
