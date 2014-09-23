package com.tsoab.tribal_war.object;

public enum ActionState {
	STAND(0), MOVE(1), ATK(2), DEATH(3);
	
	public int position;
	
	private ActionState(int position) {
		this.position = position;
	}
}
