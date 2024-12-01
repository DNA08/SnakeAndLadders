package snakesandladders.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Dice {
	
	private int smallestNumber;
	private int largestNumber;
	
	public Dice(int noOfDice) {
		this.smallestNumber = noOfDice;
		this.largestNumber = noOfDice * 6;
	}

}
