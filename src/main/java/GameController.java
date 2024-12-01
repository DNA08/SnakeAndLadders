import java.util.List;

import snakesandladders.models.Board;
import snakesandladders.models.Dice;
import snakesandladders.models.Game;
import snakesandladders.models.GameStatus;
import snakesandladders.models.Player;

public class GameController {

	Game game;
	public void createGame(List<Player> players, int dim, int noOfSnakes, int noOfLadders, int noOfDice) {
		this.game = new Game(players,dim,noOfSnakes,noOfLadders,noOfDice);
	}
	public void displayBoard() {
		int dim = this.game.getBoard().getDimension();
		int count = 1;
		for(int i = 1; i <= dim; i++) {
			for(int j = 1; j <= dim; j++) {
				System.out.print("| "+ count+" |");
				count++;
			}
			System.out.println();
		}
		
	}
	public void startGame() {
		
		while(game.getGameStatus().equals(GameStatus.IN_PROGRESS)) {
			displayBoard();
			int currentPlayerIndex = game.getLastPlayedBy() % game.getPlayers().size();
			Player currentPlayer = game.getPlayers().get(currentPlayerIndex);
			System.out.println("Player with name "+ currentPlayer.getName());
			rollDice(currentPlayer,game.getDice());
			checkSnakeOrLadderExistOnNewPosition(currentPlayer,game.getBoard());
			hasCurrentPlayerWon(currentPlayer,game.getBoard().getDimension());
			currentPlayerIndex++;
			this.game.setLastPlayedBy(currentPlayerIndex);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	private void hasCurrentPlayerWon(Player currentPlayer, int dimension) {
		if(currentPlayer.getPosition() >= dimension * dimension) {
			this.game.setGameStatus(GameStatus.COMPLETED);
			System.out.println(currentPlayer.getName()+" has won!!!!!!!!");
		}
		
	}
	private void checkSnakeOrLadderExistOnNewPosition(Player currentPlayer, Board board) {
		int position = currentPlayer.getPosition();
		if(board.getSnakesAndLadders().containsKey(position)) {
			int endPosition = board.getSnakesAndLadders().get(position);
			if(endPosition > position) {
				System.out.println(currentPlayer.getName()+"  found ladder at position "+position+" and now reached to "+endPosition);
			}else {
				System.out.println(currentPlayer.getName()+"  found snake at position "+position+" and now reached to "+endPosition);
			}
		}
		
	}
	public void rollDice(Player currentPlayer, Dice dice) {
		int minNumber = dice.getSmallestNumber();
		int maxNumber = dice.getLargestNumber();
		int oldPosition = currentPlayer.getPosition();
		int number = (int)(Math.random() * (maxNumber - minNumber)) + minNumber;
		int newPosition = currentPlayer.getPosition() + number;
		System.out.println(currentPlayer.getName()+"  rolled the dice and number came "+number);
		currentPlayer.setPosition(newPosition);
		System.out.println(currentPlayer.getName()+" came to the new positon "+newPosition+" earlier was on "+oldPosition);
	}

}
