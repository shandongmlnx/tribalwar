package com.tsoab.tribal_war.object;

public class CoordXY {

	public static final float MXChangeParam = (float) (1.0 / Math.sqrt(2));
	public static final float NChangeParam = (float) (1.0 / (Math.sqrt(2) * 2));

	public float x, y;

	public CoordXY() {
		this(0, 0);
	}

	public CoordXY(float x, float y) {
		super();
		this.x = x;
		this.y = y;
	}

	public CoordMN getCoordMN() {
		return new CoordMN(MXChangeParam * (x - y), NChangeParam * (x + y));
	}

	public boolean validCoord() {
		return (x >= 0 && y >= 0);
	}
}
