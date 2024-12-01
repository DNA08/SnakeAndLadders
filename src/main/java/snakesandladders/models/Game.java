package snakesandladders.models;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Game {
	private List<Player> players;
	private Board board;
	private Dice dice;
	private int lastPlayedBy;
	private Player winner;
	private GameStatus gameStatus; 
	
	public Game(List<Player>players, int dimension, int noOfSnakes, int noOfLadders, int noOfDice) {
		this.players = players;
		this.lastPlayedBy = 0;
		this.board = new Board(dimension,noOfSnakes,noOfLadders);
		this.dice = new Dice(noOfDice);
		this.gameStatus = GameStatus.IN_PROGRESS;
	}

}
