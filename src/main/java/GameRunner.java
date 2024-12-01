import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import snakesandladders.models.Player;

public class GameRunner {

	
	public static void main(String[] args) {
		GameController gameController = new GameController();
		List<Player>players = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the dimension of the board ");
		int dim = sc.nextInt();
		System.out.println("Enter the number of Players playing");
		int noOfPlayers = sc.nextInt();
		for(int i = 1; i <= noOfPlayers; i++) {
			System.out.println("Enter the name of Player:"+i);
			Player player = new Player(sc.next());
			players.add(player);
		}
		System.out.println("Enter the no of snakes and ladders respectively u want in the game");
		int noOfSnakes = sc.nextInt();
		int noOfLadders = sc.nextInt();
		System.out.println("Enter the no of dices");
		int noOfDice = sc.nextInt();
		gameController.createGame(players,dim,noOfSnakes,noOfLadders,noOfDice);
		
		gameController.startGame();
		
	}

}
