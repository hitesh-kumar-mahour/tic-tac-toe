package TTT;

public class Board {

	char board[][];
	char player1Symbol;
	char player2Symbol;
	final static int PLAYER1WON = 1;
	final static int PLAYER2WON = 2;
	final static int DRAW = 3;
	final static int INCOMPLETE = 4;

	public Board(char symbol1, char symbol2) {
		board = new char[3][3];
		player1Symbol = symbol1;
		player2Symbol = symbol2;
	}

	public int gameStatus() {

		for(int i = 0; i < 3; i++){
			if(board[i][0] != '\0' &&board[i][0] == board[i][1] && board[i][1] == board[i][2]){
				if(board[i][0] == player1Symbol){
					return PLAYER1WON;
				}
				else{
					return PLAYER2WON;
				}
			}
		}

		for(int i = 0; i < 3; i++){
			if(board[0][i] != '\0' &&board[0][i] == board[1][i] && board[1][i] == board[2][i]){
				if(board[0][i] == player1Symbol){
					return PLAYER1WON;
				}
				else{
					return PLAYER2WON;
				}
			}
		}
		if(board[0][0] != '\0' &&board[0][0] == board[1][1] && board[1][1] == board[2][2]){
			if(board[0][0] == player1Symbol){
				return PLAYER1WON;
			}
			else{
				return PLAYER2WON;
			}
		}

		if(board[0][2] != '\0' &&board[0][2] == board[1][1] && board[1][1] == board[2][0]){
			if(board[0][2] == player1Symbol){
				return PLAYER1WON;
			}
			else{
				return PLAYER2WON;
			}
		}

		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++ ){
				if(board[i][j] == '\0'){
					return INCOMPLETE;
				}
			}
		}

		return DRAW;
	}

	public void print(){
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++ ){
				char c = board[i][j];
				if(c == '\0'){
					System.out.print("| "+" "+" |");
				}
				else{
					System.out.print("| "+c+" |");
				}

			}
			System.out.println();
		}

	}

	public void move(char symbol, int x, int y) throws InvalidMoveException {
		if(x < 0 || x > 2 || y < 0 || y > 2 || board[x][y] != '\0'){
			throw new InvalidMoveException();
		}
		board[x][y] = symbol;
	}

}
