import java.util.*;
// Kevin Haro Tic Tac Toe 6/30/2015
public class ticTacToe{
	public static int row,col;
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		char[][] gameBoard = new char[3][3];
		char turn = 'x';
		
		for(int i=0;i<3;i++){
			for(int g=0;g<3;g++){
				gameBoard[i][g] = '_';
				
			}
		}
		print(gameBoard);
		play(sc,gameBoard,turn);
		
		
		
	}
	public static void print(char[][] gameBoard){
		for(int i=0;i<3;i++){
			System.out.println();
			for(int g=0;g<3;g++){
				if(g == 0)
					System.out.print("| ");
				System.out.print(gameBoard[i][g] + " | ");
				
			}
		}
		System.out.println();
		
	}
	public static void play(Scanner sc,char[][]gameBoard,char turn){
		boolean running = true;
		while(running){
			System.out.println("Please enter row and column number:");
			row = sc.nextInt();
			col = sc.nextInt();
			gameBoard[row][col] = turn;
			if(champion(row,col,gameBoard)){
				running = false;
				System.out.println("Winner: " + turn);
			}
				
			print(gameBoard);
			if (turn =='x')
				turn = 'o';
			else
				turn ='x';
		}
		
		
	}
	public static boolean champion(int x, int ui,char[][]gameBoard){
		
				if(gameBoard[0][ui] == gameBoard[1][ui]
					&& gameBoard[0][ui] == gameBoard[2][ui])
					return true;
				if(gameBoard[x][0] == gameBoard[x][1]
					&& gameBoard[x][0] == gameBoard[x][2])
					return true;
				
				if (gameBoard[0][0] == gameBoard[1][1] && gameBoard[0][0] == gameBoard[2][2]
					&& gameBoard[1][1] != '_')
					return true;
				if (gameBoard[0][2] == gameBoard[1][1] && gameBoard[0][2] == gameBoard[2][0]
					&& gameBoard[1][1] != '_')
					return true;
				return false;
		
		
	}
	
}