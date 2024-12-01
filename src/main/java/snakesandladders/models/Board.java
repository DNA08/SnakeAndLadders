package snakesandladders.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Board {
	
	private int dimension;
	private List<Integer> cells;
	private Map<Integer,Integer>snakesAndLadders;
	
	public Board(int dimesnion, int noOfSnakes, int noOfLadders) {
		this.dimension = dimesnion;
		cells = new ArrayList<>();
		snakesAndLadders = new HashMap<>();
		for(int i = 0; i <= dimesnion * dimesnion; i++) {
			cells.add(i);
		}
		int maxCellForSnakeAndLadder = dimesnion * dimesnion - 1;
		int minCellForSnakeAndLadder = 1;
		while(noOfSnakes > 0) {
			int start = (int)(Math.random() * (maxCellForSnakeAndLadder - minCellForSnakeAndLadder)) + minCellForSnakeAndLadder;
			int end = (int)(Math.random() * (start - minCellForSnakeAndLadder)) + minCellForSnakeAndLadder;
			if(!snakesAndLadders.containsKey(start) && !snakesAndLadders.containsKey(end)) {
				snakesAndLadders.put(start, end);
				noOfSnakes--;
			}
		}
		while(noOfLadders > 0) {
			int start = (int)(Math.random() * (maxCellForSnakeAndLadder - minCellForSnakeAndLadder)) + minCellForSnakeAndLadder;
			int end = (int)(Math.random() * (start - minCellForSnakeAndLadder)) + minCellForSnakeAndLadder;
			if(!snakesAndLadders.containsKey(start) && !snakesAndLadders.containsKey(end)) {
				snakesAndLadders.put(end, start);
				noOfLadders--;
			}
		}
	}
}
