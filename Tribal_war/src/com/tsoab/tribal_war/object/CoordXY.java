package com.tsoab.tribal_war.object;

public class CoordXY {

	public int x, y;

	public CoordXY() {
		this(0, 0);
	}

	public CoordXY(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public CoordXY(double x, double y) {
		this((int) x, (int) y);
	}
}
