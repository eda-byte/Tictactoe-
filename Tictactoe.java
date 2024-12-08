package tictactoe;
import java.util.Scanner;  
public class Tictactoe {

	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);  // Create a Scanner object
		char[][] arr=new char[3][3];
		 boolean gameOver = false;
		    char currentPlayer = 'X';

		    while (!gameOver) {
		    	 tabelle(arr);
		         playerMove(arr, currentPlayer);
		     if (checkWin(arr, currentPlayer)) {
	            tabelle(arr);
	            System.out.println("Player " + currentPlayer + " wins!");
	            gameOver = true;
	        } else if (isFull(arr)) {
	            tabelle(arr);
	            System.out.println("It's a draw!");
	            gameOver = true;
	        } else {
	            // Switch players
	            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
	        }
		    }
	    }
 /*Plan
 *  
 *  
 * Gewinnsituation Funktion
 * -----
 * wechsel:
 * bool atX=True;
 * char=X;
 * if !atX dann atO
 * gameOver is wenn alle full oder jmd gewinnt
 * 	wenn arr.length==9
 * while !gameOver

 * */	 
	
 
	
	 
	
	static void tabelle(char[][] arr) {
	    // code to be executed
		 
 
		System.out.println("  1    2    3 ");
		System.out.println( "  ------------");
		for(int i =0;i<arr.length;i++) {
			System.out.print(i+1);
			for(int j =0;j<arr[i].length;j++) {
				 

				System.out.print("| ");

				System.out.print(arr[i][j]+"  ");
				 
			}
			System.out.print("| ");
			System.out.println();
			System.out.println( "  ------------");
		}

	  }
	
	static boolean isFull(char[][] arr) {
		//returns true if all of the 
		 int EmptyCount = 0;

	        // Iterate through the array
	        for (int i = 0; i < 3; i++) {          // Fixed rows: 3
	            for (int j = 0; j < 3; j++) {      // Fixed columns: 3
	                // Check if the character is non-empty
	                if (arr[i][j] == '\0' || arr[i][j] == ' ') {
	                    EmptyCount++;
	                }
	            }
	        }

	        System.out.println("Number of  empty characters: " +  EmptyCount);
	        if(EmptyCount==0) {
	        	return true;
	        }
	        return false;
	        
	    }
	static void playerMove(char[][] arr, char player) {
	    Scanner sc = new Scanner(System.in);  // Create a Scanner object
	    boolean validMove=false;
	    
	    while(!validMove ){
            System.out.println("Player " + player + ", enter your move (row and column: e.g., 1 2): ");
            int row=sc.nextInt()-1;
            int col=sc.nextInt()-1;
            // Validate input
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && arr[row][col] == '\0') {
                arr[row][col] = player; // Place the move
                validMove = true;
            } else {
                System.out.println("Invalid move. Try again.");
            }
	    }
	}static boolean checkWin(char[][] arr, char player) {
	    // Check rows
	    for (int i = 0; i < 3; i++) {
	        if (arr[i][0] == player && arr[i][1] == player && arr[i][2] == player) {
	            return true;
	        }
	    }

	    // Check columns
	    for (int i = 0; i < 3; i++) {
	        if (arr[0][i] == player && arr[1][i] == player && arr[2][i] == player) {
	            return true;
	        }
	    }

	    // Check diagonals
	    if (arr[0][0] == player && arr[1][1] == player && arr[2][2] == player) {
	        return true;
	    }
	    if (arr[0][2] == player && arr[1][1] == player && arr[2][0] == player) {
	        return true;
	    }

	    return false;
	}
	}
	
	 
 
