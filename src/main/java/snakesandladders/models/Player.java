package snakesandladders.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Player {
	private String name;
	private int position;

	public Player(String name) {
		super();
		this.name = name;
		this.position = 0;
	}
	
}
