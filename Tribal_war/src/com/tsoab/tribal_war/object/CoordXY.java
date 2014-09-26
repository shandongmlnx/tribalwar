package com.tsoab.tribal_war.object;

public class CoordXY {

	public static final float MXChangeParam = (float) (1.0 / Math.sqrt(2));
	public static final float NChangeParam = (float) (1.0 / (Math.sqrt(2)));

	public int x, y;

	public CoordXY() {
		this(0, 0);
	}

	public CoordXY(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public CoordMN getCoordMN() {
		return new CoordMN((int) (NChangeParam * (x - y)),
				(int) (MXChangeParam * (x + y)));
	}

	public boolean validCoord() {
		return (x >= 0 && y >= 0);
	}

	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
}
