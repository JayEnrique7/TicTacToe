import java.util.Arrays;
import java.util.Scanner;
public class TicTacToe{
	public static void main(String[] args){
		
		TicTacToe myGame = new TicTacToe();
		myGame.displayBoard();
		int counter = 1;
		while(myGame.gameActive()){
			if(counter % 2 == 0)
			myGame.askPlayer('O');
			
			else
			myGame.askPlayer('X');
			counter++;

			
			myGame.displayBoard();
			myGame.checkForWinner();
	   }
       }
	
		private static char[][] gameBoard;
		private static boolean gameOnGoing = true;

		/**
		 * Det h�r �r Strukturen av spelet.
		 */
		public TicTacToe(){
			
			gameBoard = new char[3][3];
			for(int r=0; r < gameBoard.length; r++){
				Arrays.fill(gameBoard[r], ' ');
				}
			    } //kordination	
			
		/**
		 * Det h�r metoden kommer att anv�ndas till att bygga spelet
		 */
		public static void displayBoard(){
			
			for (int r=0; r < gameBoard.length; r++){
					for(int c=0; c < gameBoard.length; c++){
						System.out.print("\t" + gameBoard[r][c]);
					if(c == 0 || c == 1)
					   System.out.print("|");
					}
					if(r ==  0|| r == 1) 
					   System.out.println("\n---------------------------\n");
				    }	
			System.out.print("\n\n");
		}       //slut p� metoden displayboard

		/**
		 * Det h�r metod kommer k�ras "return true" s� l�nge spelet �r aktiv.
		 */
		public boolean gameActive(){
			return gameOnGoing;
			
		}

		/**
		 * Det h�r metoden fr�gar om spelaren ska v�lja row(rader) och culumn(kolumer)
		 * Det h�r metoden kommer att anropa makeMove varianten.
		 */
		public void askPlayer(char player){
			Scanner keyboard = new Scanner(System.in);
		    int r, c;
			do{
		      System.out.printf("Player %s's turn now, please enter a row "
		      		          + "between 1 to 3: ", player);
		                 r = keyboard.nextInt();
		      
		      System.out.printf("And a column between 1 to 3: ", player);
		                 c = keyboard.nextInt();
		      
			} 
			
			while(notValid(r,c));
			makeMove(player,r-1,c-1);
			
		    }// slut p� "askPlayer" metoden
		
		/*
		 * Det h�r metod ser upp vem som vinner p� rad och kolummur 
		 * och man f�r en "return true" (retunerade sanningen) om n�gon vinner
		 */
		public boolean checkForWinner(){
			for(int r=0; r < gameBoard.length; r++){
				
				//Om man vinner p� rad
				if(gameBoard[r][0] == gameBoard[r][1] && gameBoard[r][1] == gameBoard[r][2]
				&& gameBoard[r][0] != ' '){
					
					System.out.print("The winner is " + gameBoard[r][0]
							                      + "\n\nA new Game starting now\n");
					TicTacToe.eraseBoard();
					TicTacToe.displayBoard();
					gameOnGoing = true;
				}
			}
			/*loopen som s�ger till n�r du vinner eller n�r det blir lika.
			*Om man vinner p� rad eller kolumn
			*/
			for(int c=0; c < gameBoard.length; c++){
				
				if(gameBoard[0][c] == gameBoard[1][c] && gameBoard[1][c] == gameBoard[2][c]
				&& gameBoard[0][c] != ' '){
					
					System.out.print("The winner is " + gameBoard[0][c]
							                      + "\n\nA new Game starting now\n");
				TicTacToe.eraseBoard();
				TicTacToe.displayBoard();
				gameOnGoing = true;
			}
				if(gameBoard[2][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[0][2]
				&& gameBoard[0][2] != ' '){
					
					System.out.print("The winner is " + gameBoard[2][0]
							                      + "\n\nA new Game starting now\n");
				TicTacToe.eraseBoard();
				TicTacToe.displayBoard();
				gameOnGoing = true;
				}
				}
				
				//om man vinner diagonal.
				if(gameBoard[0][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][2] 
				&& gameBoard[0][0] != ' '){
					
					System.out.print("The winner is " + gameBoard[0][0]
							                      + "\n\nA new Game starting now\n");
				TicTacToe.eraseBoard();
				TicTacToe.displayBoard();
				gameOnGoing = true;
				}
				if(gameBoard[2][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[0][2] 
				&& gameBoard[0][2] != ' '){
					
					System.out.print("The winner is: " + gameBoard[1][1]
							                       + "\n\nA new Game starting now\n");			
				TicTacToe.eraseBoard();
				TicTacToe.displayBoard();
				gameOnGoing = true;
				}
				
				//om det �r lika
				if(gameBoard[0][0] != ' ' && gameBoard[0][1] != ' ' && gameBoard[0][2] != ' '
			    && gameBoard[1][0] != ' ' && gameBoard[1][1] != ' ' && gameBoard[1][2] != ' '
			    && gameBoard[2][0] != ' ' && gameBoard[2][1] != ' ' && gameBoard[2][2] != ' '){
					
					System.out.print("It's a Tie!!\nA new Game starting now\n");
					TicTacToe.eraseBoard();
					TicTacToe.displayBoard();
					gameOnGoing = true;
				}
				return false;
			    }
		
		 // Det h�r metod anv�nds med knap nr 1, 2, 3.
		 
		public boolean notValid(int r, int c){
			
		if(r > 3 || r < 1 || c > 3 || c < 1 || !isEmpty(r, c))
			return true;
		else
			return false;
		}
		/**
		 * Det h�r metoden registrerar om en position �r tom och returar true metoden
		 * om positionen �r tom,   
		 */
		public boolean isEmpty(int r, int c){
			if(gameBoard[r-1][c-1] == ' ')
				return true;{
					
				System.out.print("That position is taken, try again.\n");
				return false;
			}
		}
	    /**
	     * Det h�r metod kommer fungera om spelare r�kar trycka p� samma r�d "row" igen
	     * om det h�r, d� f�r det en return true. 
	     */
		public boolean makeMove(char player, int r, int c){
			
			  if(r>=0 && r <=2 && c >=0 && c <=2){
			  if(gameBoard[r][c] != ' ')
				  return true;
			  
			  else{
				gameBoard[r][c] = player;
				return true;
			  }
			  }
			  
			  else
			return false;
			  }
		
		//metoden f�r att rensa bort spelbordet.
       public static void eraseBoard(){ 
			
			for(int r = 0; r<gameBoard.length; r++){
		    for(int c = 0; c<gameBoard.length; c++){
		    	gameBoard[r][c] = ' ';
		    }
			}
            }
            }//processen �r klar