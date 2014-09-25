package com.tsoab.tribal_war.object;

public enum Direction {

	EAST(0), SOUTH(1), WEST(2), NORTH(3);
	
	public int position;

	private Direction(int position) {
		this.position = position;
	}
}
